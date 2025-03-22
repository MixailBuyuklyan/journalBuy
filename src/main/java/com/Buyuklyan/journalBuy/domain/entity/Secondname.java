package com.Buyuklyan.journalBuy.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "secondname") // Название таблицы в базе данных
public class Secondname {

    @Id
    @Column(name = "secondname_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    // Конструктор с параметром
    public Secondname(String name) { this.name = name;
    }

    // Конструктор по умолчанию (необходим для JPA)
    public Secondname() {}

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