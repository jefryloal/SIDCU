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

@Entity
@Table(name = "interes")
public class Interes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idestudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "idcarrera", nullable = false)
    private Carrera carrera;

    @Column(columnDefinition = "DATE DEFAULT GETDATE()")
    private LocalDate fechaInteres;

    // ──── Constructor ──────────────────────────────────────────────────
    public Interes() {
        this.fechaInteres = LocalDate.now();
    }

    public Interes(Estudiante estudiante, Carrera carrera) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fechaInteres = LocalDate.now();
    }

    // ──── Getters y Setters ────────────────────────────────────────────
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.idEstudiante = estudiante.getId();
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public LocalDate getFechaInteres() {
        return fechaInteres;
    }

    public void setFechaInteres(LocalDate fechaInteres) {
        this.fechaInteres = fechaInteres;
    }

    @Override
    public String toString() {
        return "Interes{id=" + id + ", estudiante='" + estudiante.getNombre()
                + "', carrera='" + carrera.getNombre() + "', fecha='" + fechaInteres + "'}";
    }
}
