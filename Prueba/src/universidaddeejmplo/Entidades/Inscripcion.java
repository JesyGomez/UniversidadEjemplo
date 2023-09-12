package universidaddeejmplo.Entidades;

public class Inscripcion {

    private int id_inscripto;
    private int nota;
    private Alumno id_alumno;
    private Alumno id_materia;

    public Inscripcion() {
    }

    public Inscripcion(int nota, Alumno id_alumno, Alumno id_materia) {
        this.nota = nota;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }

    public Inscripcion(int id_inscripto, int nota, Alumno id_alumno, Alumno id_materia) {
        this.id_inscripto = id_inscripto;
        this.nota = nota;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }

    public int getId_inscripto() {
        return id_inscripto;
    }

    public void setId_inscripto(int id_inscripto) {
        this.id_inscripto = id_inscripto;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Alumno getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Alumno id_alumno) {
        this.id_alumno = id_alumno;
    }

    public Alumno getId_materia() {
        return id_materia;
    }

    public void setId_materia(Alumno id_materia) {
        this.id_materia = id_materia;
    }

    @Override
    public String toString() {
        String insc = id_inscripto+" "+id_alumno.getApellido()+" "+id_alumno.getNombre()+" "+id_materia.getNombre();    
        return insc;
}
}
