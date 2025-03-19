package com.Buyuklyan.journalBuy.domain.repository;

import com.Buyuklyan.journalBuy.domain.entity.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepo extends CrudRepository<Student, Long> {
}
