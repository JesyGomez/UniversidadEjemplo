package universidadejemgrupo64;

import java.sql.Connection;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import universidadejemgrupo64.Entidades.Alumno;
import universidadejemgrupo64.Entidades.Inscripcion;
import universidadejemgrupo64.Entidades.Materia;
import universidadejemplogrupo64.AccesoADatos.AlumnoData;
import universidadejemplogrupo64.AccesoADatos.Conexion;
import universidadejemplogrupo64.AccesoADatos.InscripcionData;
import universidadejemplogrupo64.AccesoADatos.MateriaData;

public class UniversidadEjemGrupo64 {

    public static void main(String[] args) {

        Connection con=Conexion.getConexion();
        
        //PROBANDO 
        
        //Alumno Alejandro=new Alumno(3,30597421,"Lopez","Lionel",LocalDate.of(1980, 5, 20),true);
        //AlumnoData alu = new AlumnoData();
        //alu.guardarAlumno(Alejandro);
        //alu.modificarAlumno(Alejandro);
        //alu.eliminarAlumno(3);
//        Alumno alumnoEncontrado = alu.buscarAlumno(4);
//        if (alumnoEncontrado != null) {
//            System.out.println("IdAlumno: " + alumnoEncontrado.getIdAlumno());
//            System.out.println("Apellido: " + alumnoEncontrado.getApellido());
//            System.out.println("Nombre: " + alumnoEncontrado.getNombre());
//        }
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
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        InscripcionData id = new InscripcionData();

//        Alumno Lionel = ad.buscarAlumno(12);
//        Materia mate = md.buscarMateria(5);
//        Inscripcion insc = new Inscripcion(Lionel, mate, 8);
//        id.guardarInscripcion(insc);
//        id.actualizarNota(3,2,7);
//        id.borrarInscripcionMateriaAlumno(3, 2);
//        for (Inscripcion inscripcion : id.obtenerInscripciones()) {
//            System.out.println("id"+inscripcion.getIdInscripcion());
//            System.out.println("Apellido"+inscripcion.getAlumno());
//            System.out.println("Materia"+inscripcion.getMateria());
//        }

        for (Materia materia : id.obtenerMateriasCursadas(5)) {
                System.out.println("nombre" + materia.getNombre());
        }
    }

}
