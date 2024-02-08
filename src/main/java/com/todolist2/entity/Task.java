package com.todolist2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    private Integer idTask;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_done")
    private Integer isDone;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User idUser;


    public Task(final Task taskBody) {
        this.title = taskBody.getTitle();
        this.description = taskBody.getDescription();
        this.isDone = taskBody.getIsDone();
        this.date = taskBody.getDate();
        this.idUser = taskBody.getIdUser();
    }

    public void UpdateTask(final Task taskBody) {
        this.title = taskBody.getTitle();
        this.description = taskBody.getDescription();
        this.isDone = taskBody.getIsDone();
        this.date = taskBody.getDate();
        this.idUser = taskBody.getIdUser();
    }
}