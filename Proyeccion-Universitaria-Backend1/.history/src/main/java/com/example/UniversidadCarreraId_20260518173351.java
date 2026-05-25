package com.example;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

/**
 * Clase que representa la llave compuesta de la tabla universidad_carrera.
 */
@Embeddable
public class UniversidadCarreraId implements Serializable {

    private Long idUniversidad;
    private Long idCarrera;

    public UniversidadCarreraId() {
    }

    public UniversidadCarreraId(Long idUniversidad, Long idCarrera) {
        this.idUniversidad = idUniversidad;
        this.idCarrera = idCarrera;
    }

    public Long getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Long idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniversidadCarreraId that = (UniversidadCarreraId) o;
        return Objects.equals(idUniversidad, that.idUniversidad) && Objects.equals(idCarrera, that.idCarrera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUniversidad, idCarrera);
    }
}
