package com.example.repository;

import java.util.List;
import java.util.Optional;

import com.example.Carrera;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class CarreraRepository extends GenericRepositoryImpl<Carrera, Long> {
    public CarreraRepository(EntityManager em) {
        super(em, Carrera.class);
    }

    /**
     * Busca una carrera por su nombre único.
     */
    public Optional<Carrera> findByNombre(String nombre) {
        try {
            Query query = em.createQuery("FROM Carrera WHERE nombre = :nombre", Carrera.class);
            query.setParameter("nombre", nombre);
            Carrera result = (Carrera) query.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Obtiene todas las carreras de un área específica.
     */
    public List<Carrera> findByArea(String area) {
        Query query = em.createQuery("FROM Carrera WHERE area = :area", Carrera.class);
        query.setParameter("area", area);
        return query.getResultList();
    }

    /**
     * Obtiene la cantidad de estudiantes interesados en cada carrera.
     */
    public List<Object[]> countEstudiantesPorCarrera() {
        Query query = em.createQuery(
            "SELECT c.nombre, COUNT(*) FROM Interes i " +
            "INNER JOIN i.carrera c GROUP BY c.nombre"
        );
        return query.getResultList();
    }
}
