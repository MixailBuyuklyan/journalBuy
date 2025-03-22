package com.Buyuklyan.journalBuy.domain.services;

import com.Buyuklyan.journalBuy.domain.entity.Secondname;
import com.Buyuklyan.journalBuy.domain.repository.SecondnameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondnameService {

    @Autowired
    private SecondnameRepo secondnameRepository;

    public Secondname save(String secondname) {
        Secondname secondnameFromDB = secondnameRepository.findByName(secondname);
        if (secondnameFromDB == null) {
            secondnameFromDB = secondnameRepository.save(new Secondname(secondname));
        }
        return secondnameFromDB;
    }

    public Secondname findByName(String secondname) {
        return secondnameRepository.findByName(secondname);
    }
}
