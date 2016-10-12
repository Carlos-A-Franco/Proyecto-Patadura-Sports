/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patadura.sports.logica;

/**
 *
 * @author Carlos
 */
public class Atletas {
 private String nombre_atletas;
  private String pais;
  private String disciplina;
  private int edad;
  private float altura;
  private float peso;
  private String titulos;
   private String participaciones;
   
   public Atletas(String nombre_atletas,String pais,String disciplina,int edad,float altura,float peso,String titulos,String participaciones){
       
       this.nombre_atletas=nombre_atletas;
       this.pais=pais;
       this.disciplina=disciplina;
       this.edad=edad;
       this.altura=altura;
       this.peso=peso;
       this.titulos=titulos;
       this.participaciones=participaciones;
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
    public String getDisciplina() {

        return disciplina;
    }

    public void setDisciplina(String nuevaDisciplina) {

        disciplina = nuevaDisciplina;
    }
    public int getEdad() {

        return edad;
    }

    public void setEdad(int nuevaEdad) {

        edad = nuevaEdad;
    }
    public float getAltura() {

        return altura;
    }

    public void setAltura(float nuevaAltura) {

        altura = nuevaAltura;
    }
   public float getPeso() {

        return peso;
    }

    public void setPeso(float nuevoPeso) {

        peso = nuevoPeso;
    }
    public String getTitulos() {

        return titulos;
    }

    public void setTitulos(String nuevoTitulos) {

        titulos = nuevoTitulos;
    }
    public String getParticipaciones() {

        return participaciones;
    }

    public void setParticipaciones(String nuevaParticipaciones) {

        participaciones = nuevaParticipaciones;
    }
   public boolean equals(Object object) {
        boolean valido = false;
        if (object instanceof Atletas) {
            Atletas atletas = (Atletas) object;
            valido = nombre_atletas.equals(atletas.getNombre_atletas()); 
        }
        return valido;
    }

    public String toString() {
    return "Atletas( Nombre:" + nombre_atletas + ",País:" + pais +",Disciplina:" + disciplina + ",Edad:" + edad + ",Altura:" + altura + ",Peso:" + peso + ",Títulos:" + titulos + ",Participaciones:" + participaciones + ").";
    
            }

}
