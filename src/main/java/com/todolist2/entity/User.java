package com.todolist2.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "idUser", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public User(final User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.tasks = user.getTasks();
        this.role = user.getRole();
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }


    public void UpdateUser(final User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
    }

}
