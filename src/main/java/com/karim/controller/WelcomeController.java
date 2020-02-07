package com.karim.controller;

import com.karim.model.Task;
import com.karim.model.User;
import com.karim.service.TaskService;
import com.karim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @Autowired
    private UserService userService ;
    @Autowired
    private TaskService taskService ;


    @GetMapping
    public String welcome(){
        return "home";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("register")
    public String registerPage(Model model){
        model.addAttribute("user" , new User());
        return "register";
    }

    @PostMapping("register")
    public String register(@ModelAttribute("user") @Valid User user , Model model , HttpSession session , BindingResult result){
        if (result.hasErrors()){
            return "redirect:/register";
        }
        if (userService.findByEmail(user.getEmail()) != null){
            return "register";
        }
       // session.setAttribute("user" , user);
        userService.createUser(user);
        return "home";
    }

    @GetMapping("users")
    public String getUsers(Model model){
        model.addAttribute("users" , userService.getAll());
        return "users";
    }

    @GetMapping("task/{email}")
    public String task(@PathVariable("email") String email , Model model , HttpSession session){
        session.setAttribute("user" , email);
        model.addAttribute("task" , new Task());
        return "task";
    }

    @GetMapping("tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks" , taskService.getAll());
        return "tasks";
    }

    @PostMapping("addTask")
    public String addTask(@ModelAttribute("task") @Valid Task task , BindingResult result , Model model , HttpSession session){
        if (result.hasErrors()){
            return "task";
        }
        String email = (String) session.getAttribute("user");
        taskService.addTask(task,userService.findByEmail(email));
        return "redirect:/tasks";
    }

    @GetMapping("profile/{email}")
    public String profilePage(@PathVariable("email") String email , Model model){
        User user = userService.findByEmail(email);
        if (user != null) {
            model.addAttribute("user", user);
            return "profile";
        }
        return "home";
    }

}
