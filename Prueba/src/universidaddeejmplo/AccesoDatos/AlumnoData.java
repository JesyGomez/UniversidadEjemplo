package universidaddeejmplo.AccesoDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidaddeejmplo.Entidades.Alumno;

public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {

        con = Conexion.buscarConexion();

    }

    public void guardarAlumno(Alumno alumno) {

        String sql = "INSERT INTO Alumno (dni,apellido,nombre,fechaNacimiento,estado) "
                + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                alumno.setId_alumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "El alumno ha sido guardado exitosamente");

            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ALUMNO");
        }

    }

    public void modificarAlumno(Alumno alumno) {

        String sql = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=?"
                + "WHERE idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getId_alumno());
            int exito = ps.executeUpdate();

            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "El alumno se modifico exitosamente.");
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ALUMNO al modificar");
        }

    }

    public void eliminarAlumno(int id) {

        String sql = "UPDATE alumno "
                + "SET estado = 0 "
                + "WHERE idAlumno=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "El alumno se ha dado de baja de forma exitosa.");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ALUMNO al eliminar");
        }

    }
    
    public Alumno buscarAlumno(int id){
        
        String sql = "SELECT dni,apellido,nombre,fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
        Alumno alumno = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                alumno = new Alumno();
                alumno.setId_alumno(alumno.getId_alumno());
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                
            }else{
                
                JOptionPane.showMessageDialog(null, "No existe el alumno solicitado.");
                
            }
        ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ALUMNO al buscar");
        }
        
        return alumno;
    }
    
    
    public Alumno buscarAlumnoPorDni(int dni){
        
        String sql = "SELECT idAlumno, dni,apellido,nombre,fechaNacimiento FROM alumno WHERE dni = ? AND estado = 1";
        Alumno alumno = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                alumno = new Alumno();
                alumno.setId_alumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                
            }else{
                
                JOptionPane.showMessageDialog(null, "No existe el alumno solicitado.");
                
            }
        ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ALUMNO al buscar");
        }
        
        return alumno;
    }
    
    
     public List<Alumno> listarAlumnos(){
        
        String sql = "SELECT idAlumno, dni,apellido,nombre,fechaNacimiento FROM alumno WHERE estado = 1";
        ArrayList <Alumno> alumnos = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                
                Alumno alumno = new Alumno();
                alumno.setId_alumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                
                alumnos.add(alumno);
                
          
                
                //JOptionPane.showMessageDialog(null, "No existe el alumno solicitado.");
                
            }
        ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ALUMNO al buscar");
        }
        
        return alumnos;
    }

}
