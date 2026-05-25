package com.example;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

/**
 * Clase que representa la llave compuesta de la tabla interes_universidad.
 */
@Embeddable
public class InteresUniversidadId implements Serializable {

    private Long id;
    private Long idUniversidad;

    public InteresUniversidadId() {
    }

    public InteresUniversidadId(Long id, Long idUniversidad) {
        this.id = id;
        this.idUniversidad = idUniversidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Long idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InteresUniversidadId that = (InteresUniversidadId) o;
        return Objects.equals(id, that.id) && Objects.equals(idUniversidad, that.idUniversidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUniversidad);
    }
}
