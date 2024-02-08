package com.todolist2.controller;

import com.todolist2.dto.UserDto;
import com.todolist2.entity.User;
import com.todolist2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("idUser") final int idUser) {
        UserDto userById = userService.getUserById(idUser);
        return ResponseEntity.ok().body(userById);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> saveUser(@RequestBody User userBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userBody));

    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<UserDto> deleteUserById(@PathVariable("idUser") final int idUser) {
        userService.deleteUser(idUser);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{idUser}")
    public ResponseEntity<UserDto> updateUserById(@RequestBody User dataUser, @PathVariable("idUser") final int idUser) {
        userService.updateAUser(dataUser, idUser);
        return ResponseEntity.ok().build();
    }
}
