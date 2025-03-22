package com.Buyuklyan.journalBuy.domain.repository;


import com.Buyuklyan.journalBuy.domain.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepo extends JpaRepository<Family, Long> {
    Family findByName(String name); // Исправлено family на name для согласованности
}