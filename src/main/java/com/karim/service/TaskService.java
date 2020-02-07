package com.karim.service;

import com.karim.model.Task;
import com.karim.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    public void addTask(Task task , User user);
    public List<Task> getAll();
}
