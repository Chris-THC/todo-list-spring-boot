package com.todolist2.controller;

import com.todolist2.dto.TaskDto;
import com.todolist2.dto.UserDto;
import com.todolist2.entity.Task;
import com.todolist2.entity.User;
import com.todolist2.service.TaskService;
import com.todolist2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/")
    public List<TaskDto> getAllTask() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{idTask}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("idTask") final int idTask) {
        TaskDto taskById = taskService.getTaskById(idTask);
        return ResponseEntity.ok().body(taskById);
    }

    @PostMapping("/")
    public ResponseEntity<TaskDto> saveTask(@RequestBody Task taskBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskBody));
    }

    @DeleteMapping("/{idTask}")
    public ResponseEntity<TaskDto> deleteUserById(@PathVariable("idTask") final int idTask) {
        taskService.deleteTask(idTask);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{idTask}")
    public ResponseEntity<TaskDto> updateUserById(@RequestBody Task dataTask, @PathVariable("idTask") final int idTask) {
        taskService.updateTask(dataTask, idTask);
        return ResponseEntity.ok().build();
    }
}
