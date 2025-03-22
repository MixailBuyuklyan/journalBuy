package com.Buyuklyan.journalBuy.controllers;

import com.Buyuklyan.journalBuy.domain.entity.Student;
import com.Buyuklyan.journalBuy.domain.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "main";
    }

    @GetMapping("/student")
    @PreAuthorize("hasAuthority('STUDENT')")
    public String student(Model model) {
        Iterable<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "main";
    }

//    @PostMapping("/add")
//    public String add(@RequestParam String fio, @RequestParam String groupp, Model model) {
//        Student student = new Student(fio, groupp);
//        studentRepo.save(student);
//        Iterable<Student> students = studentRepo.findAll();
//        model.addAttribute("students", students);
//        return "main";
//    }

    @PostMapping("filter")
    public String filter(
            @RequestParam(required = false) Long familyId,
            @RequestParam(required = false) Long firstnameId,
            @RequestParam(required = false) Long secondnameId,
            Model model
    ) {
        Iterable<Student> students;

        // Если переданы все три ID
        if (familyId != null && firstnameId != null && secondnameId != null) {
            Student student = studentRepo.findByFamily_IdAndFirstname_IdAndSecondname_Id(
                    familyId, firstnameId, secondnameId
            );
            students = student != null ? List.of(student) : Collections.emptyList();
        } else {
            students = studentRepo.findAll();
        }

        model.addAttribute("students", students);
        return "main";
    }
}