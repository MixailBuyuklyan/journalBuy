package com.Buyuklyan.journalBuy.controllers;

import com.Buyuklyan.journalBuy.domain.User;
import com.Buyuklyan.journalBuy.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login"; // название шаблона
    }

    @GetMapping("/registration")
    public String register() {
        return "registration"; // название шаблона для регистрации
    }

    @PostMapping("/registration")
    public String registerUser(User user, Model model) {
        userService.registerUser(user.getUsername(), user.getPassword());
        return "redirect:/registrationSuccess"; // Перенаправление на страницу успеха
    }

    @GetMapping("/registrationSuccess")
    public String registerSuccess() {
        return "registrationSuccess"; // Вернуть страницу успеха регистрации
    }
}