
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Connection conex;
    private String usuario = "PAGO_DE_UNA";
    private String pass = "PAGO_DE_UNA";
    private String url = "jdbc:oracle:thin:"+usuario+"/"+pass+"@localhost:1521:ORCL";
 
    public Conexion() {
        try {
            //cargar la libreria jdbc para oracle
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            this.conex = DriverManager.getConnection(url,usuario, pass);
        } catch (Exception e) {
            System.out.println("Error de la conexión : "+e.getMessage());
        }
    }
    
    public Connection obtenerConex(){
        return this.conex;
    }    
}
