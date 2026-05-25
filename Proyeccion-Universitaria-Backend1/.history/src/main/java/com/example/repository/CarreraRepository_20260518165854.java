package com.example.repository;

import com.example.Carrera;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;

public class CarreraRepository extends GenericRepositoryImpl<Client, Long> {
    public CarreraRepository(EntityManager em) {
        super(em, Client.class);
    }
}
