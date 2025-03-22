package com.Buyuklyan.journalBuy.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "firstname") // Исправлено название таблицы
public class Firstname { // Исправлено название класса

    @Id
    @Column(name = "firstname_id") // Исправлено название столбца
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Исправлено GenerateValue на GeneratedValue
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    // Конструктор с параметром
    public Firstname(String name) { this.name = name;
    }

    // Конструктор по умолчанию (необходим для JPA)
    public Firstname() {}

    // Геттеры и сеттеры
    public Long getId() { return id;
    }

    public void setId(Long id) { this.id = id;
    }

    public String getName() { return name;
    }

    public void setName(String name) { this.name = name;
    }
}