package com.example;

import com.example.repository.EstudianteRepository;
import com.example.repository.CarreraRepository;
import com.example.repository.UniversidadRepository;
import com.example.repository.InteresRepository;
import com.example.repository.InteresUniversidadRepository;
import com.example.repository.UniversidadCarreraRepository;
import com.example.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        
        EstudianteRepository estudianteRepo = new EstudianteRepository(em);
        CarreraRepository carreraRepo = new CarreraRepository(em);
        UniversidadRepository universidadRepo = new UniversidadRepository(em);
        InteresRepository interesRepo = new InteresRepository(em);
        InteresUniversidadRepository interesUniRepo = new InteresUniversidadRepository(em);
        UniversidadCarreraRepository uniCarreraRepo = new UniversidadCarreraRepository(em);

        try {
            System.out.println("===== PRUEBAS DE INSERSIÓN =====\n");

            // Crear estudiantes
            Estudiante e1 = new Estudiante("1001234567", "Ana Torres", "Medellín");
            Estudiante e2 = new Estudiante("1009876543", "Carlos López", "Bogotá");
            Estudiante e3 = new Estudiante("1012349876", "Sofia Ramirez", "Cali");
            
            estudianteRepo.save(e1);
            estudianteRepo.save(e2);
            estudianteRepo.save(e3);
            System.out.println("✓ 3 estudiantes creados");

            // Crear carreras
            Carrera c1 = new Carrera("Ingenieria de Sistemas", "Tecnologia");
            Carrera c2 = new Carrera("Medicina", "Salud");
            Carrera c3 = new Carrera("Derecho", "Sociales");
            
            carreraRepo.save(c1);
            carreraRepo.save(c2);
            carreraRepo.save(c3);
            System.out.println("✓ 3 carreras creadas");

            // Crear universidades
            Universidad u1 = new Universidad("Universidad Nacional", "Bogota");
            Universidad u2 = new Universidad("Universidad de Antioquia", "Medellin");
            Universidad u3 = new Universidad("Universidad del Valle", "Cali");
            
            universidadRepo.save(u1);
            universidadRepo.save(u2);
            universidadRepo.save(u3);
            System.out.println("✓ 3 universidades creadas");

            // Crear intereses (estudiante-carrera)
            Interes int1 = new Interes(1L, 1L);
            Interes int2 = new Interes(2L, 2L);
            Interes int3 = new Interes(3L, 3L);
            
            interesRepo.save(int1);
            interesRepo.save(int2);
            interesRepo.save(int3);
            System.out.println("✓ 3 intereses en carreras creados");

            // Crear intereses universidad
            InteresUniversidad iu1 = new InteresUniversidad(1L, 1L);
            InteresUniversidad iu2 = new InteresUniversidad(2L, 2L);
            InteresUniversidad iu3 = new InteresUniversidad(3L, 3L);
            
            interesUniRepo.save(iu1);
            interesUniRepo.save(iu2);
            interesUniRepo.save(iu3);
            System.out.println("✓ 3 intereses en universidades creados");

            // Crear relaciones universidad-carrera
            UniversidadCarrera uc1 = new UniversidadCarrera(1L, 1L);
            UniversidadCarrera uc2 = new UniversidadCarrera(2L, 2L);
            UniversidadCarrera uc3 = new UniversidadCarrera(3L, 3L);
            
            uniCarreraRepo.save(uc1);
            uniCarreraRepo.save(uc2);
            uniCarreraRepo.save(uc3);
            System.out.println("✓ 3 relaciones universidad-carrera creadas");

            System.out.println("\n===== PRUEBAS DE LECTURA =====\n");

            // Listar estudiantes
            System.out.println("Estudiantes:");
            estudianteRepo.findAll().forEach(e -> System.out.println("  - " + e.getNombre() + " (" + e.getDocumento() + ")"));

            // Listar carreras
            System.out.println("\nCarreras:");
            carreraRepo.findAll().forEach(c -> System.out.println("  - " + c.getNombre() + " (" + c.getArea() + ")"));

            // Listar universidades
            System.out.println("\nUniversidades:");
            universidadRepo.findAll().forEach(u -> System.out.println("  - " + u.getNombre() + " (" + u.getCiudad() + ")"));

            // Buscar por ID
            System.out.println("\n===== PRUEBAS DE BÚSQUEDA =====\n");
            var est = estudianteRepo.findById(1L);
            if (est.isPresent()) {
                System.out.println("✓ Estudiante encontrado: " + est.get().getNombre());
            }

            var carr = carreraRepo.findById(1L);
            if (carr.isPresent()) {
                System.out.println("✓ Carrera encontrada: " + carr.get().getNombre());
            }

            System.out.println("\n===== TODAS LAS PRUEBAS COMPLETADAS EXITOSAMENTE =====");

        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            JpaUtil.close();
        }
    }
}