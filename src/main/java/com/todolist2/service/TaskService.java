package com.todolist2.service;

import com.todolist2.dto.TaskDto;
import com.todolist2.entity.Task;
import com.todolist2.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<TaskDto> getAllTasks(){
        final List<Task> taskList = taskRepository.findAll();
        return taskList.stream().map(TaskDto::build).toList();
    }

    public TaskDto getTaskById(final int idTask){
        Task taskById = taskRepository.findById(idTask).orElse(null);
        return TaskDto.build(taskById);
    }

    public TaskDto createTask(final Task taskInfo){
        final Task newTask = new Task(taskInfo);
        taskRepository.save(newTask);
        return TaskDto.build(newTask);
    }

    public void deleteTask(final Integer idTask){
        taskRepository.deleteById(idTask);
    }

    public TaskDto updateTask(final Task taskData, final int idTask){
        final Task taskToUpdate = taskRepository.findById(idTask).orElse(null);
        taskToUpdate.UpdateTask(taskData);
        taskRepository.save(taskToUpdate);
        return TaskDto.build(taskToUpdate);
    }

}
