package com.example.repository;

import com.example.Universidad;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;

public class EmployeeRepository extends GenericRepositoryImpl<Employee, Long> {
    public EmployeeRepository(EntityManager em) {
        super(em, Universidad.class);
    }
}
