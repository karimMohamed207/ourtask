package com.karim.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private long id ;

    private String date ;

    @NotNull
    private String startTime ;

    @NotNull
    private String endTime ;

    @NotNull
    private String description ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_Task")
    private User user ;

    public Task(){}

    public Task( String date, @NotNull String startTime, @NotNull String endTime, @NotNull String description, User user) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
