/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patadura.sports.logica;

import java.sql.SQLException;
import patadura.sports.persistencia.Consulta;
import java.lang.String;

/**
 *
 * @author Carlos
 */
public class Paises {
  private String nombre;
  private int poblacion;
  private String continente;

  
  public Paises(String nombre,int poblacion,String continente){
      this.nombre = nombre;
       this.poblacion = poblacion;
      this.continente = continente;
     
  }

  
   
  public String getNombre() {

        return nombre;
    }

    public void setNombre(String nuevoNombre) {

        nombre = nuevoNombre;
    }
 
  public int getPoblacion(){
      return poblacion;
  }
  public void setPoblacion(int nuevaPoblacion){
      poblacion = nuevaPoblacion;
  }
  public String getContinente(){
      return continente;
  }
  public void setContinente(String nuevoContinente){
      continente = nuevoContinente;
  }
  public void agregarPaises(Paises paises) throws SQLException {
        Consulta.getInstancia().agregarPaises(paises);
    }
    public void eliminarPaises(Paises paises) throws SQLException{
     Consulta.getInstancia().eliminarPaises(paises);
 }
   public void editarPaises(Paises paises) throws SQLException{
     Consulta.getInstancia().editarPaises(paises);
 }
 
  
  
  
  public boolean equals(Object object){
      boolean valido = false;
      if(object instanceof Paises){
          Paises paises = (Paises) object;
          valido = nombre.equals(paises.getNombre()) && getPoblacion() == paises.getPoblacion() ;
      }
  return valido;
  }
  public String toString(){
      return "País(Nombre:" + nombre + ",Población:" + poblacion + ",Continente:"+ continente +").";
  }
  
  
}
