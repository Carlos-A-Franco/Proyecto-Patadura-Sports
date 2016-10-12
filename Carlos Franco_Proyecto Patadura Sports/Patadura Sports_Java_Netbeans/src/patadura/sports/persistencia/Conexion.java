/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patadura.sports.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import patadura.sports.logica.Paises;

/**
 *
 * @author Capitan Carlos Visual B
 */

public class Conexion {
 private Connection base;
 public Conexion(String driver,String servidor,String usuario,String pass) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
      Class.forName(driver).newInstance();
      base=DriverManager.getConnection(servidor,usuario,pass);
 }
 protected ResultSet consultar(String sql) throws SQLException{
     Statement consulta=base.createStatement();
     return consulta.executeQuery(sql);
 }
        
  protected int actualizarPaises(String Sql,ArrayList <String>listadoParametros) throws SQLException {
      PreparedStatement consulta;
        consulta=base.prepareStatement(Sql);   
        consulta.setString(1, listadoParametros.get(0));
        consulta.setString(2, listadoParametros.get(1));
        consulta.setString(3, listadoParametros.get(2));
       
        return consulta.executeUpdate();
        
    }
  

  protected int actualizar(String SQL, ArrayList<String> listadoParametros) throws SQLException {

        int i = 1;
        PreparedStatement consulta;
        consulta = base.prepareStatement(SQL);
        for (String dato : listadoParametros) {
            try {
                int entero = Integer.parseInt(dato);
                consulta.setInt(i, entero);
            } catch (Exception e) {
            }
            try {
                float flotante = Float.parseFloat(dato);
                consulta.setFloat(i, flotante);
            } catch (Exception e) {
                consulta.setString(i, dato);
            }
            i++;
        }
        return consulta.executeUpdate();
    }
  
  
 
 
 
  
 
  }

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

