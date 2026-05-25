package com.example.repository;

import java.util.List;
import java.util.Optional;

import com.example.Estudiante;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EstudianteRepository extends GenericRepositoryImpl<Estudiante, Long> {
    public EstudianteRepository(EntityManager em) {
        super(em, Estudiante.class);
    }

    /**
     * Busca un estudiante por su documento único.
     */
    public Optional<Estudiante> findByDocumento(String documento) {
        try {
            Query query = em.createQuery("FROM Estudiante WHERE documento = :documento", Estudiante.class);
            query.setParameter("documento", documento);
            Estudiante result = (Estudiante) query.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Obtiene todos los estudiantes de una ciudad específica.
     */
    public List<Estudiante> findByCiudad(String ciudad) {
        Query query = em.createQuery("FROM Estudiante WHERE ciudad = :ciudad", Estudiante.class);
        query.setParameter("ciudad", ciudad);
        return query.getResultList();
    }

    /**
     * Cuenta la cantidad de estudiantes por ciudad.
     */
    public long countByCiudad(String ciudad) {
        Query query = em.createQuery("SELECT COUNT(*) FROM Estudiante WHERE ciudad = :ciudad");
        query.setParameter("ciudad", ciudad);
        return (Long) query.getSingleResult();
    }

    /**
     * Obtiene todos los estudiantes agrupados por ciudad.
     */
    public List<Object[]> countEstudiantesPorCiudad() {
        Query query = em.createQuery("SELECT ciudad, COUNT(*) FROM Estudiante GROUP BY ciudad");
        return query.getResultList();
    }
}
