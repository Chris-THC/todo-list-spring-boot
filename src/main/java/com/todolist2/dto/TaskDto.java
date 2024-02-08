package com.todolist2.dto;

import com.todolist2.entity.Task;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TaskDto {
    private Integer idTask;
    private String title;
    private String description;
    private Integer isDone;
    private Date date;
    private Integer idUser;

    public static TaskDto build(final Task taskBody) {
        return TaskDto.builder()
                .idTask(taskBody.getIdTask())
                .title(taskBody.getTitle())
                .description(taskBody.getDescription())
                .isDone(taskBody.getIsDone())
                .date(taskBody.getDate())
                .idUser(taskBody.getIdUser().getIdUser())  // Corregido a getId()
                .build();
    }

}
