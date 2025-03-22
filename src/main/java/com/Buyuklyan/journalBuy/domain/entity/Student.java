package com.Buyuklyan.journalBuy.domain.entity;

import com.Buyuklyan.journalBuy.domain.User;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Исправлено GenerateValue на GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "family_id")
    private Family family;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "firstname_id") // Исправлено fistname_id на firstname_id
    private Firstname firstname;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "secondname_id")
    private Secondname secondname;

    @OneToOne
    @JoinColumn(name = "usr_id")
    private User studentuser;



    // Конструктор с параметрами
    public Student(Family family, Firstname firstname, Secondname secondname, User studentuser) {
        this.family = family;
        this.firstname = firstname; // Исправлено fistname на firstname
        this.secondname = secondname;
        this.studentuser = studentuser;
    }

    // Конструктор по умолчанию (необходим для JPA)
    public Student() {}

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) { // Исправлено long на Long
        this.id = id;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Firstname getFirstname() {
        return firstname;
    }

    public void setFirstname(Firstname firstname) {
        this.firstname = firstname;
    }

    public Secondname getSecondname() {
        return secondname;
    }

    public void setSecondname(Secondname secondname) {
        this.secondname = secondname;
    }

    public User getStudentuser() {
        return studentuser;
    }

    public void setStudentuser(User studentuser) {
        this.studentuser = studentuser;
    }
}

