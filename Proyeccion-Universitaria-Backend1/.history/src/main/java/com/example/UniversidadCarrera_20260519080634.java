package com.example;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

/**
 * Clase que representa la relación Many-to-Many entre Universidad y Carrera.
 * Una universidad ofrece varias carreras y una carrera puede ser ofrecida por varias universidades.
 */
@Entity
@Table(name = "universidad_carrera")
public class UniversidadCarrera {

    @EmbeddedId
    private UniversidadCarreraId id;

    @ManyToOne
    @MapsId("idUniversidad")
    @JoinColumn(name = "iduniversidad")
    private Universidad universidad;

    @ManyToOne
    @MapsId("idCarrera")
    @JoinColumn(name = "idcarrera")
    private Carrera carrera;

    // ──── Constructor ──────────────────────────────────────────────────
    public UniversidadCarrera() {
    }

    public UniversidadCarrera(Universidad universidad, Carrera carrera) {
        this.universidad = universidad;
        this.carrera = carrera;
        this.id = new UniversidadCarreraId(universidad.getIduniversidad(), carrera.getIdcarrera());
    }

    // ──── Getters y Setters ────────────────────────────────────────────
    public UniversidadCarreraId getId() {
        return id;
    }

    public void setId(UniversidadCarreraId id) {
        this.id = id;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "UniversidadCarrera{" +
                "universidad='" + universidad.getNombre() + '\'' +
                ", carrera='" + carrera.getNombre() + '\'' +
                '}';
    }
}
