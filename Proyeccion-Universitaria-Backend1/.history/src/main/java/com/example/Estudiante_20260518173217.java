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
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

      // ──── Atributos ────────────────────────────────────────────────────
    @Column(nullable = false, unique = true, length = 15)
    private String documento;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(length = 30)
    private String ciudad;

    // Relación: un Estudiante puede tener muchos Interes (0..*)
    @OneToMany(mappedBy = "estudiante")
    private List<Interes> intereses;

    // Relación: un Estudiante puede estar interesado en muchas Universidades
    @OneToMany(mappedBy = "estudiante")
    private List<InteresUniversidad> interesesUniversidades;

    // ──── Constructor ──────────────────────────────────────────────────
    public Estudiante() {
        this.intereses = new ArrayList<>();
        this.interesesUniversidades = new ArrayList<>();
    }

    public Estudiante(String documento, String nombre, String ciudad) {
        this.documento = documento;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.intereses = new ArrayList<>();
        this.interesesUniversidades = new ArrayList<>();
    }

    // ──── Métodos ──────────────────────────────────────────────────────

    /**
     * Registra el interés del estudiante por una carrera.
     *
     * @param carrera la carrera por la que el estudiante muestra interés
     */
    /**
     * Registra el interés del estudiante por una carrera.
     */
    public void registrarInteresEnCarrera(Carrera carrera) {
        Interes interes = new Interes(this, carrera);
        intereses.add(interes);
        System.out.println(nombre + " mostró interés en: " + carrera.getNombre());
    }

    /**
     * Registra el interés del estudiante por una universidad.
     */
    public void registrarInteresEnUniversidad(Universidad universidad) {
        InteresUniversidad interes = new InteresUniversidad(this, universidad);
        interesesUniversidades.add(interes);
        System.out.println(nombre + " mostró interés en: " + universidad.getNombre());
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public List<InteresUniversidad> getInteresesUniversidades() {
        return interesesUniversidades;
    }

    public void setInteresesUniversidades(List<InteresUniversidad> interesesUniversidades) {
        this.intereses = intereses;
    }

    @Override
    public String toString() {
        return "Estudiante{id=" + id + ", nombre='" + nombre + "', correo='" + correo + "', ciudad='" + ciudad + "'}";
    }
}
