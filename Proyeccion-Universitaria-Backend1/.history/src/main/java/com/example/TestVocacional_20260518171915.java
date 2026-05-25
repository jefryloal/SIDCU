package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Clase que representa un test vocacional dentro del sistema SIDCU.
 * Un estudiante realiza un TestVocacional para obtener una recomendación de
 * carrera.
 *
 * Relaciones:
 * - Asociado a 1 Estudiante (asociación, cardinalidad 1 a 1)
 */
@Entity
@Table(name = "test")
public class TestVocacional {

    // ──── Atributos ────────────────────────────────────────────────────
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String preguntas; // Representa el banco de preguntas del test
    private String resultado; // Resultado arrojado por el test

    // ──── Constructor ──────────────────────────────────────────────────
    public TestVocacional(Long id, String preguntas, String resultado) {
        this.id = id;
        this.preguntas = preguntas;
        this.resultado = resultado;
    }

    // ──── Métodos ──────────────────────────────────────────────────────

    /**
     * Ejecuta el test vocacional para el estudiante.
     */
    public void realizarTest() {
        System.out.println("Iniciando test vocacional (id=" + id + ")...");
        System.out.println("Preguntas: " + preguntas);
        System.out.println("Test completado.");
    }

    /**
     * Retorna y muestra la recomendación de carrera basada en el resultado del
     * test.
     */
    public void obtenerRecomendacion() {
        System.out.println("Recomendación basada en tu perfil: " + resultado);
    }

    // ──── Getters y Setters ────────────────────────────────────────────
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(String preguntas) {
        this.preguntas = preguntas;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "TestVocacional{id=" + id + ", resultado='" + resultado + "'}";
    }
}

