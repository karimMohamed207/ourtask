package com.karim.service.Impl;

import com.karim.DataBase.TaskRepository;
import com.karim.model.Task;
import com.karim.model.User;
import com.karim.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service

public class TaskServicesImpl implements TaskService {

    @Autowired
        private TaskRepository taskRepository ;

    @Override
    public void addTask(Task task , User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
