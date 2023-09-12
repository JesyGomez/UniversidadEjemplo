package universidaddeejmplo.AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;  // 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion{
    
    private static final String URL= "jdbc:mariadb://localhost/";
    private static final String DB= "universidadejemplo";
    private static final String USUARIO = "root";    // root
    private static final String PASSWORD = "";   // ""
    private static Connection conexion = null;  // lo que importa  
    
    private Conexion(){}
    
    public static Connection buscarConexion(){
        
        if (conexion==null) {
            
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
                JOptionPane.showMessageDialog(null, "Usted se ha conectado exitosamente a la "
                        + "base de datos: "+ DB);
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error de carga de Driver. Verifique");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problema de conexion, verifique servicio de XAAMP y "
                        + "datos de conexion (Url, Base de Datos, Usuario y Password)");
            }
            
        }
        return conexion;
        
    }
}
    
    
      
 

