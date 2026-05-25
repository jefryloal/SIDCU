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
@Table(name = "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrera")
    private Long idcarrera;

    @Column(nullable = false, unique = true, length = 60)
    private String nombre;

    @Column(length = 30)
    private String area;

    // Relación: una Carrera puede ser ofrecida por muchas Universidades
    @OneToMany(mappedBy = "carrera")
    private List<UniversidadCarrera> universidades;

     // ──── Constructor ──────────────────────────────────────────────────
    public Carrera() {
        this.universidades = new ArrayList<>();
    }

    public Carrera(String nombre, String area) {
        this.nombre = nombre;
        this.area = area;
        this.universidades = new ArrayList<>();
    }

    // ──── Métodos ──────────────────────────────────────────────────────

    /**
     * Muestra la información detallada de la carrera.
     */
    public void mostrarInfo() {
        System.out.println("=== Información de Carrera ===");
        System.out.println("Nombre   : " + nombre);
        System.out.println("Área     : " + area);
    }

    // ──── Getters y Setters ────────────────────────────────────────────
    public Long getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Long idcarrera) {
        this.idcarrera = idcarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<UniversidadCarrera> getUniversidades() {
        return universidades;
    }

    public void setUniversidades(List<UniversidadCarrera> universidades) {
        this.universidades = universidades;
    }

    @Override
    public String toString() {
        return "Carrera{id=" + id + ", nombre='" + nombre + "', area='" + area + "'}";
    }
}
