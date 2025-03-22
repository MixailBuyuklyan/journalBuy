package com.Buyuklyan.journalBuy.domain.repository;

import com.Buyuklyan.journalBuy.domain.entity.Secondname;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondnameRepo extends JpaRepository<Secondname, Long> {
    Secondname findByName(String name); // Исправлено secondname на name для согласованности
}