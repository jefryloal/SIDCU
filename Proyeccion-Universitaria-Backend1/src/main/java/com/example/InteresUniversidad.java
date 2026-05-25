package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "interes_universidad")
public class InteresUniversidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idestudiante;
    private Long iduniversidad;

    public InteresUniversidad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InteresUniversidad(Long idestudiante, Long iduniversidad) {
        this.idestudiante = idestudiante;
        this.iduniversidad = iduniversidad;
    }

    public Long getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Long idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Long getIduniversidad() {
        return iduniversidad;
    }

    public void setIduniversidad(Long iduniversidad) {
        this.iduniversidad = iduniversidad;
    }

    @Override
    public String toString() {
        return "InteresUniversidad [idestudiante=" + idestudiante + ", iduniversidad=" + iduniversidad + "]";
    }
}
