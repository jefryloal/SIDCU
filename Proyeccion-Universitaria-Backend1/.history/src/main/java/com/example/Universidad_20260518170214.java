package com.example;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "universidades")
public class Universidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     // ──── Atributos ────────────────────────────────────────────────────
    
    private String nombre;
    private String ciudad;
    private String tipo; // Ej: "Pública", "Privada"

    // Relación: una Universidad ofrece muchas Carreras (1 → *)
    private List<Carrera> carreras;

    // ──── Constructor ──────────────────────────────────────────────────
    public Universidad(int id, String nombre, String ciudad, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.carreras = new ArrayList<>();
    }

    // ──── Métodos ──────────────────────────────────────────────────────

    /**
     * Agrega una carrera al catálogo que ofrece esta universidad.
     *
     * @param carrera la carrera a agregar
     */
    public void ofrecerCarrera(Carrera carrera) {
        carreras.add(carrera);
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String toString() {
        return "Universidad{id=" + id + ", nombre='" + nombre + "', ciudad='" + ciudad + "', tipo='" + tipo + "'}";
    }
}
