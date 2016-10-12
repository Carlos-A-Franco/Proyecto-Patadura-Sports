/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patadura.sports.logica;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import patadura.sports.persistencia.Consulta;

/**
 *
 * @author Carlos
 */
public class Persona {
    private String usuario;
    private String contrasenia;
    private String tipo;
    private Date fecha_ingreso;
    
    public Persona(String usuario,String contrasenia,String tipo,Date fecha_ingreso){
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
        this.fecha_ingreso = fecha_ingreso;
    }
 public String getUsuario(){
     return usuario;
 }   
    public void setUsuario(String nuevoUsuario){
       usuario = nuevoUsuario; 
    }
    public String getContrasenia(){
        return contrasenia;
    }
    public void setContrasenia(String nuevaContrasenia){
        contrasenia = nuevaContrasenia;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String nuevoTipo){
        tipo = nuevoTipo;
    }
    public Date getFecha_ingreso(){
        return fecha_ingreso;
    }
    public void setFecha_ingreso(Date nuevaFecha_ingreso){
        fecha_ingreso = nuevaFecha_ingreso;
    }
    
     public boolean loguearse(String usuario,String contrasenia,String tipo) {
        
        try {
            Consulta consulta;
            try {
                consulta = new Consulta();
                return consulta.loguearse(usuario,contrasenia,tipo);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
       
       
     }
    @Override
    
     
    
     
    
    
    
    
    public boolean equals(Object object){
        boolean valido = false;
        if(object instanceof Persona){
           Persona persona = (Persona) object;
           valido = usuario.equals(persona.getUsuario()) && contrasenia.equals(persona.getContrasenia());
           
        }
        return valido;
    }
     public String toString(){
         return "Persona(Usuario:" + usuario + ",Contraseña:" + contrasenia + ",Tipo:" + tipo + ",Fecha de ingreso:" + fecha_ingreso + ").";
     }

     public void ingresoPersona(Persona persona) throws SQLException{
     Consulta.getInstancia().ingresoPersona(persona);    
    }
    
    
}
