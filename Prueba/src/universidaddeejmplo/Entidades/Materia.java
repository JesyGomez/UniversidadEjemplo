

package universidaddeejmplo.Entidades;


public class Materia {
    
    private int id_materia;
    private String nombre;
    private int anio;
    private int estado;

    public Materia() {
    }

    public Materia(String nombre, int anio, int estado) {
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    

    public Materia(int id_materia, String nombre, int anio, int estado) {
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "materia{" + "id_materia=" + id_materia + ", nombre=" + nombre + ", estado=" + estado + '}';
    }

    
    
}
