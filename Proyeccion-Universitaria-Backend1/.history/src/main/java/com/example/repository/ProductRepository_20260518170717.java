package com.example.repository;

import com.example.Estudiante;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;

public class ProductRepository extends GenericRepositoryImpl<Product, Long> {
    public EstudianteRepository(EntityManager em) {
        super(em, Estudiante.class);
    }
}
