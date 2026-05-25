package com.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "universidades")
public class Universidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     // ──── Atributos ────────────────────────────────────────────────────
    @Column(nullable = false, unique = true, length = 80)
    private String nombre;

    @Column(length = 30)
    private String ciudad;

    // Relación: una Universidad ofrece muchas Carreras
    @OneToMany(mappedBy = "universidad")
    private List<UniversidadCarrera> carreras;

    // Relación: muchos estudiantes están interesados en esta universidad
    @OneToMany(mappedBy = "universidad")
    private List<InteresUniversidad> interesesEstudiantes;

    // ──── Constructor ──────────────────────────────────────────────────
    public Universidad() {
        this.carreras = new ArrayList<>();
        this.interesesEstudiantes = new ArrayList<>();
    }

    public Universidad(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.carreras = new ArrayList<>();
        this.interesesEstudiantes = new ArrayList<>();
    }

    // ──── Métodos ──────────────────────────────────────────────────────

    /**
     * Agrega una carrera al catálogo que ofrece esta universidad.
     *
     * @param carrera la carrera a agregar
     */
    public void ofrecerCarrera(Carrera carrera) {
        UniversidadCarrera uc = new UniversidadCarrera(this, carrera);
        carreras.add(uc);
        System.out.println(nombre + " ahora ofrece la carrera: " + carrera.getNombre());
    }

    // ──── Getters y Setters ────────────────────────────────────────────
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<UniversidadCarrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<UniversidadCarrera> carreras) {
        this.carreras = carreras;
    }

    public List<InteresUniversidad> getInteresesEstudiantes() {
        return interesesEstudiantes;
    }

    public void setInteresesEstudiantes(List<InteresUniversidad> interesesEstudiantes) {
        this.interesesEstudiantes = interesesEstudiantes;
    }

    @Override
    public String toString() {
        return "Universidad{id=" + id + ", nombre='" + nombre + "', ciudad='" + ciudad + "'}";
    }
}
        this.interesesEstudiantes = interesesEstudiantes;
    

    @Override
    public String toString() {
        return "Universidad{id=" + id + ", nombre='" + nombre + "', ciudad='" + ciudad + "', tipo='" + tipo + "'}";
    }
}
