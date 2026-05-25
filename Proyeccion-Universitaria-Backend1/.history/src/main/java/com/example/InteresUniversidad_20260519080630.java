package com.example;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase que representa el interés de un estudiante por una universidad.
 * Relación Many-to-Many entre Estudiante y Universidad.
 */
@Entity
@Table(name = "interes_universidad")
public class InteresUniversidad {

    @ManyToOne
    @JoinColumn(name = "idestudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "iduniversidad", nullable = false)
    private Universidad universidad;

    @Column(columnDefinition = "DATE DEFAULT GETDATE()")
    private LocalDate fechaInteres;

    // ──── Constructor ──────────────────────────────────────────────────
    public InteresUniversidad() {
        this.fechaInteres = LocalDate.now();
    }

    public InteresUniversidad(Estudiante estudiante, Universidad universidad) {
        this.estudiante = estudiante;
        this.universidad = universidad;
        this.fechaInteres = LocalDate.now();
    }

    // ──── Getters y Setters ────────────────────────────────────────────
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public LocalDate getFechaInteres() {
        return fechaInteres;
    }

    public void setFechaInteres(LocalDate fechaInteres) {
        this.fechaInteres = fechaInteres;
    }

    @Override
    public String toString() {
        return "InteresUniversidad{" +
                "estudiante='" + estudiante.getNombre() + '\'' +
                ", universidad='" + universidad.getNombre() + '\'' +
                ", fecha='" + fechaInteres + '\'' +
                '}';
    }
}
