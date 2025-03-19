package com.Buyuklyan.journalBuy.controllers;


import com.Buyuklyan.journalBuy.domain.entity.Student;
import com.Buyuklyan.journalBuy.domain.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping
    public String main(Model model){
        Iterable<Student> students= studentRepo.findAll();
        model.addAttribute("students",students);
        return "main";

    }

}