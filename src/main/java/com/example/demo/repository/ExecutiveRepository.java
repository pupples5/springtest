package com.example.demo.repository;

import com.example.demo.model.Executive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutiveRepository extends JpaRepository<Executive, Long> {


    Executive findByExecutiveId(String ExecutiveId);
}
