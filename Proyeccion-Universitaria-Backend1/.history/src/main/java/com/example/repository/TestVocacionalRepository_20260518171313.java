package com.example.repository;

import com.example.TestVocacional;
import com.example.TestVocacional;
import com.example.repository.impl.GenericRepositoryImpl;

import jakarta.persistence.EntityManager;

public class TestVocacionalRepository extends GenericRepositoryImpl<TestVocacional, Long> {
    public TestVocacionalRepository(EntityManager em) {
        super(em, TestVocacional.class);
        {

        }
    }
}