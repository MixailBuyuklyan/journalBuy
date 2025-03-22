package com.Buyuklyan.journalBuy.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "family") // Название таблицы в базе данных
public class Family {
    @Id
    @Column(name = "family_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    // Конструктор с параметром
    public Family(String name) {this.name = name;
    }

    // Конструктор по умолчанию (необходим для JPA)
    public Family() {}

    // Геттеры и сеттеры
    public Long getId() {return id;
    }

    public void setId(Long id) {this.id = id;
    }

    public String getName() {return name;
    }

    public void setName(String name) {this.name = name;
    }
}