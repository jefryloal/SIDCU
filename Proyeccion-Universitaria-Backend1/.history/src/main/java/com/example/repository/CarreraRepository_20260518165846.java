package com.example.repository;

import com.example.Client;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;

public class CarreraRepository extends GenericRepositoryImpl<Client, Long> {
    public CaRepository(EntityManager em) {
        super(em, Client.class);
    }
}
