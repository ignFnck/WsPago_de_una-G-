
package DAO;

import Clases.Tarjeta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class TarjetaDAO {
    private Connection conex;
    
    public TarjetaDAO() {
    }
   
    public List <Tarjeta> listarTarjetas() throws SQLException{
        List <Tarjeta> lista = new ArrayList<>();       
        try { 
            this.conex = new Conexion.Conexion().obtenerConex(); 
         String llamada = "{ call SP_LISTAR_TARJETA(?)}"; 
         CallableStatement cstmt = this.conex.prepareCall(llamada);
         cstmt.registerOutParameter(1, OracleTypes.CURSOR);
         cstmt.execute();
         ResultSet rs = (ResultSet)cstmt.getObject(1);
         while(rs.next()){
           Tarjeta T = new Tarjeta();
           T.setNum_tarjeta(rs.getInt("num_tarjeta"));
           T.setCvv(rs.getInt("cvv"));
           T.setSaldo(rs.getInt("saldo"));
           T.setFecha_vencimiento(rs.getString("fecha_vencimiento"));         
           lista.add(T);         }
        } catch (Exception e) {
        System.out.println("Error al entregar lista "+e.getMessage());
    } finally {
      this.conex.close();
    }
    return lista;
    }
    
    public int Pagar (int p_num_tarjeta, int p_cvv, String p_fecha_vencimiento, int p_costo) throws SQLException {
        try {
            for (Tarjeta t : listarTarjetas()) {
                if (t.getNum_tarjeta() == p_num_tarjeta && t.getCvv() == p_cvv && t.getFecha_vencimiento().equalsIgnoreCase(p_fecha_vencimiento)) {
                    if (t.getSaldo() >= p_costo){
                        this.conex = new Conexion.Conexion().obtenerConex();
                        String llamada = " { SP_RESTAR_SALDO (? ,?)} ";
                        CallableStatement cstmt = this.conex.prepareCall(llamada);
                        cstmt.setInt(1, p_num_tarjeta);
                        cstmt.setInt(2, p_costo );
                        if (cstmt.executeUpdate()> 0){
                            return 1;
                        }    
                    }else{
                    return -3;}
                }
            }    
        } catch (Exception e) {
            System.out.println("Error en el pago" + e.getMessage());
        } finally {
            this.conex.close();
        }
        return 0;
                
    }
    
    
    
}
