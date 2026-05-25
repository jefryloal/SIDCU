/**
 * Clase que representa el interés de un estudiante por una carrera.
 * Modela la relación muchos a muchos entre Estudiante y Carrera.
 *
 * Relaciones:
 * - Tiene 1 Estudiante (llave foránea idestudiante)
 * - Tiene 1 Carrera (llave foránea idcarrera)
 */
public class Interes {

    // ──── Atributos (llaves foráneas del diagrama) ─────────────────────
    private int idEstudiante;
    private int idCarrera;

    // Referencias a los objetos relacionados
    private Estudiante estudiante;
    private Carrera carrera;

    // ──── Constructor ──────────────────────────────────────────────────
    public Interes(Estudiante estudiante, Carrera carrera) {
        this.estudiante = estudiante;
        this.idEstudiante = estudiante.getId();
        this.carrera = carrera;
        this.idCarrera = carrera.getId();
    }

    // ──── Getters y Setters ────────────────────────────────────────────
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
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
        this.idCarrera = carrera.getId();
    }

    @Override
    public String toString() {
        return "Interes{idEstudiante=" + idEstudiante
                + ", idCarrera=" + idCarrera
                + ", estudiante='" + estudiante.getNombre()
                + "', carrera='" + carrera.getNombre() + "'}";
    }
}
