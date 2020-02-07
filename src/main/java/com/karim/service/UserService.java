package com.karim.service;

import com.karim.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public void createUser(User user);
    public List<User> getAll();
    public List<User> getByName();
    public User findByEmail(String email);
}
