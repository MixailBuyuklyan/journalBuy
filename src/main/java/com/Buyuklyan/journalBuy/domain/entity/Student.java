package com.Buyuklyan.journalBuy.domain.entity;

import jakarta.persistence.*;


@Entity

@Table(name = "student")

public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    public Student() {
        this.name = "безымянный";

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
