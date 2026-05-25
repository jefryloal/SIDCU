package com.example;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

      // ──── Atributos ────────────────────────────────────────────────────
    private String nombre;
    private String correo;
    private String ciudad;

    // Relación: un Estudiante puede tener muchos Interes (0..*)
    private List<Interes> intereses;

    // ──── Constructor ──────────────────────────────────────────────────
    public Estudiante(int id, String nombre, String correo, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.ciudad = ciudad;
        this.intereses = new ArrayList<>();
    }

    // ──── Métodos ──────────────────────────────────────────────────────

    /**
     * Registra el interés del estudiante por una carrera.
     *
     * @param carrera la carrera por la que el estudiante muestra interés
     */
    public void buscarCarrera(Carrera carrera) {
        Interes interes = new Interes(this, carrera);
        intereses.add(interes);
        System.out.println(nombre + " mostró interés en: " + carrera.getNombre());
    }

    /**
     * Sobrecarga sin parámetros para compatibilidad con el diagrama original.
     */
    public void buscarCarrera() {
        System.out.println(nombre + " está buscando una carrera...");
    }

    /**
     * Suscribe al estudiante a la plataforma SIDCU.
     */
    public void suscribirse() {
        System.out.println(nombre + " se ha suscrito a SIDCU.");
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Interes> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<Interes> intereses) {
        this.intereses = intereses;
    }

    @Override
    public String toString() {
        return "Estudiante{id=" + id + ", nombre='" + nombre + "', correo='" + correo + "', ciudad='" + ciudad + "'}";
    }
}
