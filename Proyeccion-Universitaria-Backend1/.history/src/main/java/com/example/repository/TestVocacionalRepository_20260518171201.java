package com.example.repository;

import com.example.Estudiante;
import com.example.repository.impl.GenericRepositoryImpl;

import jakarta.persistence.EntityManager;

public class TestVocacionalRepository extends GenericRepositoryImpl<Estudiante, Long> {
    public TestRepository(EntityManager em) {
        super(em, Estudiante.class); {

}
