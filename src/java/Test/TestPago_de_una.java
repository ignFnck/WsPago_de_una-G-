/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Clases.Tarjeta;
import DAO.TarjetaDAO;
import java.util.List;

public class TestPago_de_una {

    
    public static void main(String[] args)  {
         try {
            List<Tarjeta> lista = new TarjetaDAO().listarTarjetas();
                  for (Tarjeta tarjeta : lista) {
                       System.out.println(tarjeta);    
                  }
        } catch (Exception e) {
            System.out.println("Error de cosola");
        }
    }
    
}
