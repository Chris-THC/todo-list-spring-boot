package com.todolist2.service;

import com.todolist2.dto.UserDto;
import com.todolist2.entity.User;
import com.todolist2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        final List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(UserDto::build).toList();
    }

    public UserDto getUserById(final Integer idUser) {
        User userById = userRepository.findById(idUser).orElse(null);
        return UserDto.build(userById);
    }

    public UserDto createUser(final User userInfo) {
        final User newUserCreate = new User(userInfo);
        userRepository.save(newUserCreate);
        return UserDto.build(newUserCreate);
    }

    public void deleteUser(final Integer idUser) {
        userRepository.deleteById(idUser);
    }

    public UserDto updateAUser(final User userData, final int idUser) {
        final User userToUpdate = userRepository.findById(idUser).orElse(null);
        userToUpdate.UpdateUser(userData);
        userRepository.save(userToUpdate);
        return UserDto.build(userToUpdate);
    }

    public UserDto updateAUserXD(final User userData, final int idUser) {
        // Verificar si el usuario existe
        if (!userRepository.existsById(idUser)) {
            // Manejar el caso en que el usuario no existe
            throw new RuntimeException("Usuario no encontrado con id: " + idUser);
        }

        // Obtener el usuario a actualizar
        final User userToUpdate = userRepository.findById(idUser).orElseThrow();

        // Validar la entrada del usuario
        if (userData != null) {
            // Actualizar los datos del usuario
            userToUpdate.UpdateUser(userData);

            // Guardar los cambios en la base de datos
            userRepository.save(userToUpdate);

            // Devolver el usuario actualizado
            return UserDto.build(userToUpdate);
        } else {
            // Manejar el caso en que los datos del usuario son nulos
            throw new IllegalArgumentException("Los datos del usuario no pueden ser nulos");
        }
    }

}
