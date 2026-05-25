package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String area;
    private int duracion; // en semestres
    private String tipo; // Ej: "Pregrado", "Técnico", "Tecnólogo"

     // ──── Constructor ──────────────────────────────────────────────────
    public Carrera(int id, String nombre, String area, int duracion, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.area = area;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    // ──── Métodos ──────────────────────────────────────────────────────

    /**
     * Muestra la información detallada de la carrera.
     */
    public void mostrarInfo() {
        System.out.println("=== Información de Carrera ===");
        System.out.println("Nombre   : " + nombre);
        System.out.println("Área     : " + area);
        System.out.println("Duración : " + duracion + " semestres");
        System.out.println("Tipo     : " + tipo);
    }

    // ──── Getters y Setters ────────────────────────────────────────────
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Carrera{id=" + id + ", nombre='" + nombre + "', area='" + area
                + "', duracion=" + duracion + ", tipo='" + tipo + "'}";
    }
}
