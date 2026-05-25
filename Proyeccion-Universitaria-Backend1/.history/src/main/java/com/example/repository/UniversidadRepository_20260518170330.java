package com.example.repository;

import com.example.Universidad;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;

public class UniversidadRepository extends GenericRepositoryImpl<Employee, Long> {
    public UniversidadRepository(EntityManager em) {
        super(em, Universidad.class);
    }
}
