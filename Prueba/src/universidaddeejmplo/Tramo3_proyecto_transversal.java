

package universidaddeejmplo;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import universidaddeejmplo.AccesoDatos.AlumnoData;
import universidaddeejmplo.AccesoDatos.Conexion;
import universidaddeejmplo.Entidades.Alumno;


public class Tramo3_proyecto_transversal {

    
    public static void main(String[] args) {
        
       Connection con = Conexion.buscarConexion();
       
       //Creacion de un Alumno
       
       //Alumno Juan = new Alumno(45185522,"Iglesias","Ana Paula",LocalDate.of(2001, 1, 1),true);
      // AlumnoData alu = new AlumnoData();
       //alu.guardarAlumno(Juan);
       //alu.modificarAlumno(Juan);
       //alu.eliminarAlumno(1);
       
      // Alumno aluEncontrado=alu.buscarAlumnoPorDni(25185212);
       // System.out.println("Apellido: "+aluEncontrado.getApellido());
       // System.out.println("Nombre: "+aluEncontrado.getNombre());
       // System.out.println("DNI: "+aluEncontrado.getDni());
       
//       AlumnoData alu = new AlumnoData();
//        for (Alumno alumno : alu.listarAlumnos()) {
//            
//            System.out.println(alumno.getApellido());
//            System.out.println(alumno.getNombre());
//            System.out.println(alumno.getDni());
//            System.out.println(alumno.getFechaNacimiento());
//            System.out.println(alumno.getId_alumno());
//            System.out.println("");
//            
        }
    }
