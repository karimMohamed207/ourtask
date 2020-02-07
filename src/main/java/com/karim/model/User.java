package com.karim.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class User {

    @Id
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email ;

    @NotEmpty
    private String name ;

    @NotEmpty
    private String password ;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Task> tasks ;


    private String role ;

    public User(@Email @NotEmpty String email, @NotEmpty String name, @NotEmpty String password) {
        this.email = email;
        this.name = name;
        this.password = password;

    }

    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
