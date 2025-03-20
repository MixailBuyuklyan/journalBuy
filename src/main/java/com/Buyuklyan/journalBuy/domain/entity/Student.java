package com.Buyuklyan.journalBuy.domain.entity;

import jakarta.persistence.*;


@Entity

@Table(name = "student")

public class Student {
    @Id
    @Column(name="student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name", length = 100)
    private String name;

    @Column(name = "namegroup", length = 100)
    private String namegroup;

    // Конструктор с параметрами
    public Student(String name, String namegroup) {
        this.name = name;
        this.namegroup = namegroup;
    }

    // Конструктор по умолчанию
    public Student() {
        this.name = "6eзымянный";
    }

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(long id) {
        this.id = id;
    }

    // Геттер для name
    public String getName() {
        return name;
    }

    // Сеттер для name
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для namegroup
    public String getNamegroup() {
        return namegroup;
    }

    // Сеттер для namegroup
    public void setNamegroup(String namegroup) {
        this.namegroup = namegroup;
    }
}

