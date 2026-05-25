
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
