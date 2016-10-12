/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patadura.sports.logica;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Disciplinas {
   private String nombre;
   private String estadio;
   private String fase;
   private Date fecha_y_hora;
   private String nombre_atletas;
   private String pais;
   
   public Disciplinas(String nombre,String estadio,String fase,Date fecha_y_hora,String nombre_atletas,String pais){
       this.nombre = nombre;
       this.estadio = estadio;
       this.fase = fase;
       this.fecha_y_hora = fecha_y_hora;
       this.nombre_atletas= nombre_atletas;
       this.pais = pais;
   } 
    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nuevoNombre) {

        nombre = nuevoNombre;
    }
    public String getEstadio() {

        return estadio;
    }

    public void setEstadio(String nuevoEstadio) {

        estadio = nuevoEstadio;
    }
    public String getFase() {

        return fase;
    }

    public void setFase(String nuevaFase) {

        fase = nuevaFase;
    }
     public Date getFecha_y_hora() {

        return fecha_y_hora;
    }

    public void setFecha_y_hora(Date nuevaFecha_y_hora) {

        fecha_y_hora = nuevaFecha_y_hora;
    }
    public String getNombre_atletas() {

        return nombre_atletas;
    }

    public void setNombre_atletas(String nuevoNombre_atletas) {

        nombre_atletas = nuevoNombre_atletas;
    
    }
      public String getPais() {

        return pais;
    }

    public void setPais(String nuevoPais) {

        pais = nuevoPais;
    }
    
    
    
     public boolean equals(Object object){
      boolean valido = false;
      if(object instanceof Disciplinas){
           Disciplinas disciplinas = ( Disciplinas) object;
          valido = nombre.equals(disciplinas.getNombre())&& estadio.equals(disciplinas.getEstadio())&& fecha_y_hora.equals(disciplinas.getFecha_y_hora()) && nombre_atletas.equals(disciplinas.getNombre_atletas());  ;
      }
  return valido;
  }
    public String toString(){
    return "Disciplina(Nombre:" + nombre + ",Estadio:" + estadio + ",Fase:" + fase + ",Fecha y hora:" + fecha_y_hora + ",Deportistas:" + nombre_atletas + ",País:" + pais + ").";   
   
    
    
    
     }
    
    
   }
