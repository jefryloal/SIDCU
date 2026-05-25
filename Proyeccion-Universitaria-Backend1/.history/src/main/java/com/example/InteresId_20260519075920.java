package com.example;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

/**
 * Clase que representa la llave compuesta de la tabla interes.
 */
@Embeddable
public class InteresId implements Serializable {

    private Long idestudiante;
    private Long idcarrera;

    public InteresId() {
    }

    public InteresId(Long idestudiante, Long idcarrera) {
        this.idestudiante = idestudiante;
        this.idcarrera = idcarrera;
    }

    public Long getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Long idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Long getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(Long idcarrera) {
        this.idcarrera = idcarrera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InteresId interesId = (InteresId) o;
        return Objects.equals(idestudiante, interesId.idestudiante) && Objects.equals(idcarrera, interesId.idcarrera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idestudiante, idcarrera);
    }
}
