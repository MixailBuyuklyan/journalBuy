package com.Buyuklyan.journalBuy.domain.repository;

import com.Buyuklyan.journalBuy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
