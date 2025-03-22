package com.Buyuklyan.journalBuy.domain.services;

import com.Buyuklyan.journalBuy.domain.entity.Family;
import com.Buyuklyan.journalBuy.domain.repository.FamilyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepo familyRepository;

    public Family save(String family) {
        Family familyFromDB = familyRepository.findByName(family);
        if (familyFromDB == null) {
            familyFromDB = familyRepository.save(new Family(family));
        }
        return familyFromDB;
    }

    public Family findByName(String family) {
        return familyRepository.findByName(family);
    }
}