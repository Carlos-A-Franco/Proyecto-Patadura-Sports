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
public class Medallas {
 private String pais;
 private String nombre_atletas;
 private String disciplina;
 private String valor;
 private Date fechaIngreso;
 
 public Medallas(String pais, String nombre_atletas,String disciplina,String valor,Date fechaIngreso){
     this.pais=pais;
     this.nombre_atletas=nombre_atletas;
     this.disciplina=disciplina;
     this.valor=valor;
     this.fechaIngreso=fechaIngreso;
 }
 
  public String getPais() {

        return pais;
    }

    public void setPais(String nuevoPais) {

        pais = nuevoPais;
    }
    
     public String getNombre_atletas() {

        return nombre_atletas;
    }

    public void setNombre_atletas(String nuevoNombre_atletas) {

        nombre_atletas = nuevoNombre_atletas;
    
    }
     public String getDisciplina() {

        return disciplina;
    }

    public void setDisciplina(String nuevaDisciplina) {

        disciplina = nuevaDisciplina;
    }
     public String getValor() {

        return valor;
    }

    public void setValor(String nuevoValor) {

        valor = nuevoValor;
    }
    public Date getFechaIngreso() {

        return fechaIngreso;
    }

    public void setFechaIngreso(Date nuevaFechaIngreso) {

        fechaIngreso= nuevaFechaIngreso;
    }
     public boolean equals(Object object){
      boolean valido = false;
      if(object instanceof Medallas){
          Medallas medallas = (Medallas) object;
          valido = pais.equals(medallas.getPais()) && nombre_atletas.equals( medallas.getNombre_atletas())&& disciplina.equals(medallas.getDisciplina()) && valor.equals(medallas.getValor()) ;
      }
  return valido;
  }
    
}
