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
            // Crear estudiante
            Estudiante estudiante = new Estudiante("1001234567", "Ana Torres", "Medellín");
            estudianteRepo.save(estudiante);
            System.out.println("✓ Estudiante creado: " + estudiante.getNombre());

            // Crear carrera
            Carrera carrera = new Carrera("Ingenieria de Sistemas", "Tecnologia");
            carreraRepo.save(carrera);
            System.out.println("✓ Carrera creada: " + carrera.getNombre());

            // Crear universidad
            Universidad universidad = new Universidad("Universidad Nacional", "Bogota");
            universidadRepo.save(universidad);
            System.out.println("✓ Universidad creada: " + universidad.getNombre());

            // Ver todos
            System.out.println("\n--- Estudiantes registrados ---");
            estudianteRepo.findAll().forEach(e -> System.out.println(e.toString()));

            System.out.println("\n--- Carreras registradas ---");
            carreraRepo.findAll().forEach(c -> System.out.println(c.toString()));

            System.out.println("\n--- Universidades registradas ---");
            universidadRepo.findAll().forEach(u -> System.out.println(u.toString()));

        } finally {
            JpaUtil.close();
        }
    }
}
        String area = scanner.nextLine();

        Carrera carrera = new Carrera(nombre, area);
        carreraRepo.save(carrera);
        System.out.println("✓ Carrera creada exitosamente.");
    }

    private static void verCarrera() {
        System.out.print("Ingrese ID de la carrera: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Optional<Carrera> carrera = carreraRepo.findById(id);
        if (carrera.isPresent()) {
            Carrera c = carrera.get();
            System.out.println("\n--- INFORMACIÓN DE LA CARRERA ---");
            System.out.println("ID: " + c.getId());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Área: " + c.getArea());
        } else {
            System.out.println("❌ Carrera no encontrada.");
        }
    }

    private static void verTodasCarreras() {
        List<Carrera> carreras = carreraRepo.findAll();
        if (carreras.isEmpty()) {
            System.out.println("❌ No hay carreras registradas.");
        } else {
            System.out.println("\n--- LISTA DE CARRERAS ---");
            for (Carrera c : carreras) {
                System.out.println("ID: " + c.getId() + " | " + c.getNombre() + " | " + c.getArea());
            }
        }
    }

    private static void actualizarCarrera() {
        System.out.print("Ingrese ID de la carrera: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Optional<Carrera> carrera = carreraRepo.findById(id);
        if (carrera.isPresent()) {
            Carrera c = carrera.get();
            System.out.print("Nuevo nombre (actual: " + c.getNombre() + "): ");
            c.setNombre(scanner.nextLine());
            System.out.print("Nueva área (actual: " + c.getArea() + "): ");
            c.setArea(scanner.nextLine());
            carreraRepo.update(c);
            System.out.println("✓ Carrera actualizada exitosamente.");
        } else {
            System.out.println("❌ Carrera no encontrada.");
        }
    }

    private static void eliminarCarrera() {
        System.out.print("Ingrese ID de la carrera: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Optional<Carrera> carrera = carreraRepo.findById(id);
        if (carrera.isPresent()) {
            carreraRepo.delete(carrera.get());
            System.out.println("✓ Carrera eliminada exitosamente.");
        } else {
            System.out.println("❌ Carrera no encontrada.");
        }
    }

    // ══════════════════════════════════════════════════════════════════════════════
    // MENÚ UNIVERSIDADES
    // ══════════════════════════════════════════════════════════════════════════════
    private static void menuUniversidades() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- GESTIONAR UNIVERSIDADES ---");
            System.out.println("1. Crear universidad");
            System.out.println("2. Ver universidad por ID");
            System.out.println("3. Ver todas las universidades");
            System.out.println("4. Actualizar universidad");
            System.out.println("5. Eliminar universidad");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> crearUniversidad();
                case 2 -> verUniversidad();
                case 3 -> verTodasUniversidades();
                case 4 -> actualizarUniversidad();
                case 5 -> eliminarUniversidad();
                case 0 -> exit = true;
                default -> System.out.println("❌ Opción no válida.");
            }
        }
    }

    private static void crearUniversidad() {
        System.out.print("Ingrese nombre de la universidad: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese ciudad: ");
        String ciudad = scanner.nextLine();

        Universidad universidad = new Universidad(nombre, ciudad);
        universidadRepo.save(universidad);
        System.out.println("✓ Universidad creada exitosamente.");
    }

    private static void verUniversidad() {
        System.out.print("Ingrese ID de la universidad: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Optional<Universidad> universidad = universidadRepo.findById(id);
        if (universidad.isPresent()) {
            Universidad u = universidad.get();
            System.out.println("\n--- INFORMACIÓN DE LA UNIVERSIDAD ---");
            System.out.println("ID: " + u.getId());
            System.out.println("Nombre: " + u.getNombre());
            System.out.println("Ciudad: " + u.getCiudad());
        } else {
            System.out.println("❌ Universidad no encontrada.");
        }
    }

    private static void verTodasUniversidades() {
        List<Universidad> universidades = universidadRepo.findAll();
        if (universidades.isEmpty()) {
            System.out.println("❌ No hay universidades registradas.");
        } else {
            System.out.println("\n--- LISTA DE UNIVERSIDADES ---");
            for (Universidad u : universidades) {
                System.out.println("ID: " + u.getId() + " | " + u.getNombre() + " | " + u.getCiudad());
            }
        }
    }

    private static void actualizarUniversidad() {
        System.out.print("Ingrese ID de la universidad: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Optional<Universidad> universidad = universidadRepo.findById(id);
        if (universidad.isPresent()) {
            Universidad u = universidad.get();
            System.out.print("Nuevo nombre (actual: " + u.getNombre() + "): ");
            u.setNombre(scanner.nextLine());
            System.out.print("Nueva ciudad (actual: " + u.getCiudad() + "): ");
            u.setCiudad(scanner.nextLine());
            universidadRepo.update(u);
            System.out.println("✓ Universidad actualizada exitosamente.");
        } else {
            System.out.println("❌ Universidad no encontrada.");
        }
    }

    private static void eliminarUniversidad() {
        System.out.print("Ingrese ID de la universidad: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Optional<Universidad> universidad = universidadRepo.findById(id);
        if (universidad.isPresent()) {
            universidadRepo.delete(universidad.get());
            System.out.println("✓ Universidad eliminada exitosamente.");
        } else {
            System.out.println("❌ Universidad no encontrada.");
        }
    }

    // ══════════════════════════════════════════════════════════════════════════════
    // MENÚ INTERESES
    // ══════════════════════════════════════════════════════════════════════════════
    private static void menuIntereses() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- GESTIONAR INTERESES ---");
            System.out.println("1. Registrar interés (estudiante-carrera)");
            System.out.println("2. Ver interés por ID");
            System.out.println("3. Ver todos los intereses");
            System.out.println("4. Eliminar interés");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> registrarInteres();
                case 2 -> verInteres();
                case 3 -> verTodosIntereses();
                case 4 -> eliminarInteres();
                case 0 -> exit = true;
                default -> System.out.println("❌ Opción no válida.");
            }
        }
    }

    private static void registrarInteres() {
        System.out.print("Ingrese ID del estudiante: ");
        Long idEstudiante = scanner.nextLong();
        System.out.print("Ingrese ID de la carrera: ");
        Long idCarrera = scanner.nextLong();
        scanner.nextLine();

        Optional<Estudiante> estudiante = estudianteRepo.findById(idEstudiante);
        Optional<Carrera> carrera = carreraRepo.findById(idCarrera);

        if (estudiante.isPresent() && carrera.isPresent()) {
            Interes interes = new Interes(estudiante.get(), carrera.get());
            interesRepo.save(interes);
            System.out.println("✓ Interés registrado exitosamente.");
        } else {
            System.out.println("❌ Estudiante o carrera no encontrados.");
        }
    }

    private static void verInteres() {
        System.out.print("Ingrese ID del interés: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Optional<Interes> interes = interesRepo.findById(id);
        if (interes.isPresent()) {
            Interes i = interes.get();
            System.out.println("\n--- INFORMACIÓN DEL INTERÉS ---");
            System.out.println("ID: " + i.getId());
            System.out.println("Estudiante: " + i.getEstudiante().getNombre());
            System.out.println("Carrera: " + i.getCarrera().getNombre());
            System.out.println("Fecha: " + i.getFechaInteres());
        } else {
            System.out.println("❌ Interés no encontrado.");
        }
    }

    private static void verTodosIntereses() {
        List<Interes> intereses = interesRepo.findAll();
        if (intereses.isEmpty()) {
            System.out.println("❌ No hay intereses registrados.");
        } else {
            System.out.println("\n--- LISTA DE INTERESES ---");
            for (Interes i : intereses) {
                System.out.println("ID: " + i.getId() + " | " + i.getEstudiante().getNombre() + 
                                   " -> " + i.getCarrera().getNombre() + " | " + i.getFechaInteres());
            }
        }
    }

    private static void eliminarInteres() {
        System.out.print("Ingrese ID del interés: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Optional<Interes> interes = interesRepo.findById(id);
        if (interes.isPresent()) {
            interesRepo.delete(interes.get());
            System.out.println("✓ Interés eliminado exitosamente.");
        } else {
            System.out.println("❌ Interés no encontrado.");
        }
    }
}