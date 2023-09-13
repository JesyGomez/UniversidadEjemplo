
package universidadejemplogrupo64.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadejemgrupo64.Entidades.Materia;


public class MateriaData {
      private Connection con=null;

    public MateriaData() {
        
        con=Conexion.getConexion();
    }
    
     public void guardarMateria(Materia materia){
    
    String sql="INSERT INTO materia (idMateria, nombre,año, estado)"
            + "VALUES(?, ?, ?, ?)";
    
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, materia.getIdMateria());
            ps.setString(2,materia.getNombre() );
            ps.setInt(3, materia.getAnio());
            ps.setBoolean(4, materia.isEstado());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Materia Guardada" );
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Materia" );
        }

    }
     
      public Materia buscarMateria (int id) {
     
         String sql= "SELECT idMateria, nombre, año  FROM materia WHERE idMateria = ? AND estado = 1";
        Materia materia=null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                materia =new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("Año"));
                materia.setEstado(true);
                
            }else{
             JOptionPane.showMessageDialog(null,"La Materia no Existe" );
            
            }
            ps.close();
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Materia " );
        }
        return materia;
     }
      
      public void modificarMateria(Materia materia){
     
     String sql="UPDATE materia SET nombre= ?, año= ? ,estado= ? "
             + "WHERE idMateria = ?";
     
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getIdMateria());
            int exito = ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null,"Materia Modificada " );
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder ala tabla Materia " );
        }
     }
      
      public void eliminarMateria(int id){
     
     String sql="UPDATE materia SET estado = 0 WHERE idMateria = ?";
     
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            if (exito==1) {
                JOptionPane.showMessageDialog(null,"Materia Eliminada " );
                
            }
            
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"Error al acceder ala tabla Materia " );
        }
     
     
     } 
      
       public List<Materia> listarMateria () {
     
         String sql= "SELECT idMateria, nombre, año, estado FROM materia WHERE estado = 1";
         ArrayList<Materia> materias=new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
          
            ResultSet rs=ps.executeQuery();
           while(rs.next()) {
              Materia materia=new Materia();
               // materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(true);
                
                 materias.add(materia);
            }
            ps.close();
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder ala tabla Materia " );
        }
        return materias;
        
     } 
     
}
