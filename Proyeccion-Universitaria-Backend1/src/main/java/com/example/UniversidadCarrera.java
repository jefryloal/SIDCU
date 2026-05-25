package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "universidad_carrera")
public class UniversidadCarrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long iduniversidad;
    private Long idcarrera;

    public UniversidadCarrera() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UniversidadCarrera(Long iduniversidad, Long idcarrera) {
        this.iduniversidad = iduniversidad;
        this.idcarrera = idcarrera;
    }

    public Long getIduniversidad() {
        return iduniversidad;
    }

    public void setIduniversidad(Long iduniversidad) {
        this.iduniversidad = iduniversidad;
    }

    public Long getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Long idcarrera) {
        this.idcarrera = idcarrera;
    }

    @Override
    public String toString() {
        return "UniversidadCarrera [iduniversidad=" + iduniversidad + ", idcarrera=" + idcarrera + "]";
    }
}
