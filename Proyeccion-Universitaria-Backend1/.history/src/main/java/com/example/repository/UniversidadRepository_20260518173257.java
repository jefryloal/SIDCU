package com.example.repository;

import java.util.List;
import java.util.Optional;

import com.example.Universidad;
import com.example.repository.impl.GenericRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class UniversidadRepository extends GenericRepositoryImpl<Universidad, Long> {
    public UniversidadRepository(EntityManager em) {
        super(em, Universidad.class);
    }

    /**
     * Busca una universidad por su nombre único.
     */
    public Optional<Universidad> findByNombre(String nombre) {
        try {
            Query query = em.createQuery("FROM Universidad WHERE nombre = :nombre", Universidad.class);
            query.setParameter("nombre", nombre);
            Universidad result = (Universidad) query.getSingleResult();
            return Optional.of(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Obtiene todas las universidades de una ciudad específica.
     */
    public List<Universidad> findByCiudad(String ciudad) {
        Query query = em.createQuery("FROM Universidad WHERE ciudad = :ciudad", Universidad.class);
        query.setParameter("ciudad", ciudad);
        return query.getResultList();
    }

    /**
     * Obtiene las universidades que ofrecen más de una carrera.
     */
    public List<Object[]> findUniversidadesConMultipleCarreras() {
        Query query = em.createQuery(
            "SELECT u.nombre, COUNT(*) FROM UniversidadCarrera uc " +
            "INNER JOIN uc.universidad u GROUP BY u.nombre HAVING COUNT(*) > 1"
        );
        return query.getResultList();
    }
}
