package com.Buyuklyan.journalBuy.controllers;

import com.Buyuklyan.journalBuy.domain.Role;
import com.Buyuklyan.journalBuy.domain.User;
import com.Buyuklyan.journalBuy.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findALl());
        return "userlist";
    }




    @GetMapping("/{user}") // Используйте явное имя переменной
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "useredit"; // Исправлен регистр названия шаблона
    }

    @PostMapping("/{userId}") // Добавлен явный путь с userId
    public String userSave(
            @PathVariable("userId") User user,
            @RequestParam String username,
            @RequestParam List<String> roles) {
        user.setUsername(username);
        user.getRoles().clear();
        for (String roleName : roles) {
            user.getRoles().add(Role.valueOf(roleName));
        }
        userService.save(user);
        return "redirect:/admin";
    }
}