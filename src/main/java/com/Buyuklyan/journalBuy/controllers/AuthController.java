package com.Buyuklyan.journalBuy.controllers;

import com.Buyuklyan.journalBuy.domain.User;
import com.Buyuklyan.journalBuy.domain.entity.*;
import com.Buyuklyan.journalBuy.domain.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private FamilyService familyService;
    @Autowired
    private FirstnameService firstnameService;
    @Autowired
    private SecondnameService secondnameService;

    @GetMapping("/login")
    public String login() {
        return "login"; // название шаблона
    }

    @GetMapping("/registration")
    public String register() {
        return "registration"; // название шаблона для регистрации
    }

    @PostMapping("/registration")
    public String registerUser(User user,
                               @RequestParam String lastname,
                               @RequestParam String firstname,
                               @RequestParam String secondname, Model model) {
        if (lastname.equals("") || firstname.equals("") || secondname.equals("")) {
            model.addAttribute("message", "Должны быть указаны Фамилия, Имя и Отчество");
            return "registration";
        }

        User userFromDB = userService.registerUser(user.getUsername(), user.getPassword());

        Family family = familyService.save(lastname);
        Firstname firstname1 = firstnameService.save(firstname);
        Secondname secondname1 = secondnameService.save(secondname);
        Student student = studentService.save(family, firstname1, secondname1, userFromDB);

        model.addAttribute("message", "Ваш аккаунт был успешно создан.");
        return "registrationSuccess";
    }
}