package com.Buyuklyan.journalBuy.domain.services;

import com.Buyuklyan.journalBuy.domain.User;
import com.Buyuklyan.journalBuy.domain.entity.*;
import com.Buyuklyan.journalBuy.domain.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private FamilyService familyService;

    public Student save(Family family, Firstname firstname, Secondname secondname, User studentuser) {
        Student studentFromDB = studentRepository
                .findByFamily_IdAndFirstname_IdAndSecondname_Id(
                        family.getId(), firstname.getId(), secondname.getId());

        if (studentFromDB == null) {
            Student student = new Student(family, firstname, secondname, studentuser);
            studentFromDB = studentRepository.save(student);
        }
        return studentFromDB;
    }
}