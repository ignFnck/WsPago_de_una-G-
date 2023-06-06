/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import Clases.Tarjeta;
import DAO.TarjetaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Don jhonatan XD
 */
@WebService(serviceName = "WsPago_de_una")
public class WsPago_de_una {

    @WebMethod(operationName = "listarTarjetas")
    public List<Tarjeta> listarTarjetas(){
        try {
            return new TarjetaDAO().listarTarjetas();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(WsPago_de_una.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    }
    
    @WebMethod(operationName = "Pagar")
    public int Pagar (@WebParam (name = "p_num_tarjeta") int p_num_tarjeta, 
                      @WebParam (name = "p_cvv") int p_cvv,
                      @WebParam (name = "p_fecha_vencimiento") String p_fecha_vencimiento,
                      @WebParam (name = "p_costo") int p_costo){
        try {
            return new TarjetaDAO().Pagar(p_num_tarjeta, p_cvv, p_fecha_vencimiento, p_costo);
            
       }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(WsPago_de_una.class.getName()).log(Level.SEVERE, null, ex); 
            return -1;
        }
    }
}
