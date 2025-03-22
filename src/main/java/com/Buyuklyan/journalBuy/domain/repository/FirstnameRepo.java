package com.Buyuklyan.journalBuy.domain.repository;

import com.Buyuklyan.journalBuy.domain.entity.Firstname;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstnameRepo extends JpaRepository<Firstname, Long> {
    Firstname findByName(String name); // Исправлено firstname на name для согласованности
}
