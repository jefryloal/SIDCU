package com.example;



/**
 * Clase que representa un test vocacional dentro del sistema SIDCU.
 * Un estudiante realiza un TestVocacional para obtener una recomendación de
 * carrera.
 *
 * Relaciones:
 * - Asociado a 1 Estudiante (asociación, cardinalidad 1 a 1)
 */
public class TestVocacional {

    // ──── Atributos ────────────────────────────────────────────────────
    
    
    private int id;
    private String preguntas; // Representa el banco de preguntas del test
    private String resultado; // Resultado arrojado por el test

    // ──── Constructor ──────────────────────────────────────────────────
    public TestVocacional(int id, String preguntas, String resultado) {
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

