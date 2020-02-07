package com.karim.service.Impl;

import com.karim.DataBase.UserRepository;
import com.karim.model.User;
import com.karim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserService {

    @Autowired
    private UserRepository userRepository ;


    @Override
    public void createUser(User user) {
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getByName() {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
