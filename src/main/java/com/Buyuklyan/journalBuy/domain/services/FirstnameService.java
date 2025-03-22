package com.Buyuklyan.journalBuy.domain.services;

import com.Buyuklyan.journalBuy.domain.entity.Firstname;
import com.Buyuklyan.journalBuy.domain.repository.FirstnameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstnameService {

    @Autowired
    private FirstnameRepo firstnameRepository;

    public Firstname save(String firstname) {
        Firstname firstnameFromDB = firstnameRepository.findByName(firstname);
        if (firstnameFromDB == null) {
            firstnameFromDB = firstnameRepository.save(new Firstname(firstname));
        }
        return firstnameFromDB;
    }

    public Firstname findByName(String firstname) {
        return firstnameRepository.findByName(firstname);
    }
}
