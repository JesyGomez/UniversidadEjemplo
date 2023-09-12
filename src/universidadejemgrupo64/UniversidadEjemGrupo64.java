package universidadejemgrupo64;

import java.sql.Connection;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import universidadejemgrupo64.Entidades.Alumno;
import universidadejemplogrupo64.AccesoADatos.AlumnoData;
import universidadejemplogrupo64.AccesoADatos.Conexion;

public class UniversidadEjemGrupo64 {

    public static void main(String[] args) {

        //Connection con=Conexion.getConexion();
        //Alumno Alejandro=new Alumno(3,30597421,"Lopez","Lionel",LocalDate.of(1980, 5, 20),true);
        AlumnoData alu = new AlumnoData();
        //alu.guardarAlumno(Alejandro);
        //alu.modificarAlumno(Alejandro);
        //alu.eliminarAlumno(3);
        Alumno alumnoEncontrado = alu.buscarAlumno(4);
        if (alumnoEncontrado != null) {
            System.out.println("IdAlumno: " + alumnoEncontrado.getIdAlumno());
            System.out.println("Apellido: " + alumnoEncontrado.getApellido());
            System.out.println("Nombre: "+ alumnoEncontrado.getNombre());
        }
        /*Alumno alumnoEncontrado = alu.buscarAlumnoPorDni(1235897);
        if (alumnoEncontrado != null) {
            System.out.println("Dni: " + alumnoEncontrado.getDni());
            System.out.println("Apellido: " + alumnoEncontrado.getApellido());
        }
     AlumnoData alu=new AlumnoData();
        for (Alumno alumno:alu.listarAlumnos()){
            System.out.println("Dni: "+alumno.getDni());
            System.out.println("Apellido: "+alumno.getApellido());
            System.out.println("Nombre: "+alumno.getNombre());
            System.out.println("Fecha de Nacimiento: "+alumno.getFechaNacimiento());
            System.out.println("");
            
        }*/
    }

}
