package com.todolist2.dto;

import com.todolist2.entity.Task;
import com.todolist2.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserDto {
    private Integer idUser;
    private String name;
    private String password;
    private String email;
    private List<Task> tasks = new ArrayList<>();

    public static UserDto build(final User userBody){
        return UserDto.builder()
                .idUser(userBody.getIdUser())
                .name(userBody.getName())
                .password(userBody.getPassword())
                .email(userBody.getEmail())
                .tasks(userBody.getTasks())
                .build();
    }
}
