/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patadura.sports.logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import patadura.sports.persistencia.Conexion;
import patadura.sports.persistencia.Consulta;
import patadura.sports.tabla.grafica.Fila;
import patadura.sports.tabla.grafica.TablaAtletas;
import patadura.sports.tabla.grafica.TablaAtletasPorPais;
import patadura.sports.tabla.grafica.TablaDisciplinas;
import patadura.sports.tabla.grafica.TablaNovedades;
import patadura.sports.tabla.grafica.TablaPaises;
import patadura.sports.tabla.grafica.TablaProximosEventos;
import patadura.sports.tabla.grafica.TablaUltimosGanadores;

/**
 *
 * @author Carlos
 */
public class Sistema {
     private static Sistema objeto=null;
     private ArrayList<Persona> coleccion;
    private Sistema(){
        coleccion=new ArrayList<Persona>();
    }
     
     
      public static Sistema getInstance() {
        if(objeto==null){
            objeto=new Sistema();
        }
        return objeto;
    }
      
     public boolean loguearse(String usuario,String contrasenia,String  tipo) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
         Consulta consulta=new Consulta();
        return consulta.loguearse(usuario,contrasenia,tipo);
    }
    
 public void agregarPaises(Paises paises) throws SQLException {
        Consulta.getInstancia().agregarPaises(paises);
    }
    public TablaPaises tablaPaises() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ArrayList<String> listadoColumnas = new ArrayList<String>();
        ArrayList<Fila> filas = new ArrayList<Fila>();
        listadoColumnas.add("Nombre");
        listadoColumnas.add("Poblacion");
        listadoColumnas.add("Continente");
        Consulta consulta = new Consulta();

        ArrayList<Paises> listaPaises = consulta.listadoPaises();
        for (int i = 0; i < listaPaises.size(); i++) {
            ArrayList<String> fil = new ArrayList<String>();
            Paises paises = listaPaises.get(i);
            fil.add(paises.getNombre());
            fil.add(paises.getPoblacion()+"");
            fil.add(paises.getContinente());
            Fila fila = new Fila(fil);
            filas.add(fila);

        }
        TablaPaises tabla;
        tabla = new TablaPaises(listadoColumnas, filas);
        return tabla;
    }
 
 public void eliminarPaises(Paises paises) throws SQLException{
     Consulta.getInstancia().eliminarPaises(paises);
 }
  
  public void editarPaises(Paises paises) throws SQLException{
     Consulta.getInstancia().editarPaises(paises);
 }
 
 public void agregarAtletas(Atletas atletas) throws SQLException{
     Consulta.getInstancia().agregarAtletas(atletas);
 }
   public void eliminarAtletas(Atletas atletas) throws SQLException{
     Consulta.getInstancia().eliminarAtletas(atletas);
 } 
  public TablaAtletas tablaAtletas() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ArrayList<String> listadoColumnas = new ArrayList<String>();
        ArrayList<Fila> filas = new ArrayList<Fila>();
       
        listadoColumnas.add("Nombre_atletas");
         listadoColumnas.add("Pais");
        listadoColumnas.add("Disciplina");
        listadoColumnas.add("Edad");
        listadoColumnas.add("Altura");
        listadoColumnas.add("Peso");
        listadoColumnas.add("Titulos");
        listadoColumnas.add("Participaciones");
        
        Consulta consulta = new Consulta();

        ArrayList<Atletas> listaAtletas = consulta.listadoAtletas();
        for (int i = 0; i < listaAtletas.size(); i++) {
            ArrayList<String> fil = new ArrayList<String>();
            Atletas atletas = listaAtletas.get(i);
           
            fil.add(atletas.getNombre_atletas());
             fil.add(atletas.getPais());
            fil.add(atletas.getDisciplina());
            fil.add(atletas.getEdad()+"");
            fil.add(atletas.getAltura()+"");
            fil.add(atletas.getPeso()+"");
            fil.add(atletas.getTitulos());
            fil.add(atletas.getParticipaciones());
            
            
            Fila fila = new Fila(fil);
            filas.add(fila);

        }
        TablaAtletas tabla;
        tabla = new TablaAtletas(listadoColumnas, filas);
        return tabla;
    } 
    public void editarAtletas(Atletas atletas) throws SQLException{
     Consulta.getInstancia().editarAtletas(atletas);
 } 
  public String dateToMySql(Date fecha_y_hora){
        java.text.SimpleDateFormat formato=new java.text.SimpleDateFormat("yyyy-MM-dd-HH:mm");
        return formato.format(fecha_y_hora);
    } 
  public void agregarDisciplinas(Disciplinas disciplinas) throws SQLException{
     Consulta.getInstancia().agregarDisciplinas(disciplinas);
 } 
  public TablaDisciplinas tablaDisciplinas() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ArrayList<String> listadoColumnas = new ArrayList<String>();
        ArrayList<Fila> filas = new ArrayList<Fila>();
       
        listadoColumnas.add("Nombre");
         listadoColumnas.add("Estadio");
        listadoColumnas.add("Fase");
        listadoColumnas.add("Fecha_y_hora");
        listadoColumnas.add("Nombre_atletas");
        listadoColumnas.add("Pais");
        
        
        Consulta consulta = new Consulta();

        ArrayList<Disciplinas> listaDisciplinas = consulta.listadoDisciplinas();
        for (int i = 0; i < listaDisciplinas.size(); i++) {
            ArrayList<String> fil = new ArrayList<String>();
            Disciplinas disciplinas = listaDisciplinas.get(i);
           
            fil.add(disciplinas.getNombre());
             fil.add(disciplinas.getEstadio());
            fil.add(disciplinas.getFase());
            fil.add(disciplinas.getFecha_y_hora()+"");
            fil.add(disciplinas.getNombre_atletas());
            fil.add(disciplinas.getPais());
            
            
            Fila fila = new Fila(fil);
            filas.add(fila);

        }
        TablaDisciplinas tabla;
        tabla = new TablaDisciplinas(listadoColumnas, filas);
        return tabla;
    } 
  
   public void eliminarDisciplinas(Disciplinas disciplinas) throws SQLException{
     Consulta.getInstancia().eliminarDisciplinas(disciplinas);
 } 
   public void editarDisciplinas(Disciplinas disciplinas) throws SQLException{
     Consulta.getInstancia().editarDisciplinas(disciplinas);
 } 
  
    public TablaNovedades tablaNovedades() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ArrayList<String> listadoColumnas = new ArrayList<String>();
        ArrayList<Fila> filas = new ArrayList<Fila>();
       
        listadoColumnas.add("Nombre");
         listadoColumnas.add("Estadio");
        listadoColumnas.add("Fase");
        listadoColumnas.add("Fecha_y_hora");
        listadoColumnas.add("Nombre_atletas");
        listadoColumnas.add("Pais");
        
        
        Consulta consulta = new Consulta();

        ArrayList<Disciplinas> listaNovedades = consulta.listadoNovedades();
        for (int i = 0; i < listaNovedades.size(); i++) {
            ArrayList<String> fil = new ArrayList<String>();
            Disciplinas disciplinas = listaNovedades.get(i);
           
            fil.add(disciplinas.getNombre());
             fil.add(disciplinas.getEstadio());
            fil.add(disciplinas.getFase());
            fil.add(disciplinas.getFecha_y_hora()+"");
            fil.add(disciplinas.getNombre_atletas());
            fil.add(disciplinas.getPais());
            
            
            Fila fila = new Fila(fil);
            filas.add(fila);

        }
        TablaNovedades tabla;
        tabla = new TablaNovedades(listadoColumnas, filas);
        return tabla;
    } 
   public String dateIngreso(Date fechaIngreso){
        java.text.SimpleDateFormat formato=new java.text.SimpleDateFormat("yyyy-MM-dd");
        return formato.format(fechaIngreso);
    } 
   
  public void agregarMedallas(Medallas medallas) throws SQLException{
     Consulta.getInstancia().agregarMedallas(medallas);
 } 
   public Iterator<Atletas> AtletasPais(String pais) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
       
        Consulta consulta = new Consulta();
        return consulta.listadoAtletasPorPais( pais).iterator();
    }

  
   public String medallasPorPais (String pais) throws SQLException{
     return  Consulta.getInstancia().medallasPorPais(pais);
         
         
   }

    public String medallasPorAtleta (String atleta) throws SQLException{
     return  Consulta.getInstancia().medallasPorAtleta(atleta);
         
         
   }
public String dateRegistro(Date fecha_ingreso){
        java.text.SimpleDateFormat formato=new java.text.SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        return formato.format(fecha_ingreso);
    } 
    public void ingresoPersona(Persona persona) throws SQLException{
     Consulta.getInstancia().ingresoPersona(persona);    
    }
    
    public TablaProximosEventos tablaProximosEventos () throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ArrayList<String> listadoColumnas = new ArrayList<String>();
        ArrayList<Fila> filas = new ArrayList<Fila>();
       
        listadoColumnas.add("Nombre");
         listadoColumnas.add("Estadio");
        listadoColumnas.add("Fase");
        listadoColumnas.add("Fecha_y_hora");
        
        
        
        Consulta consulta = new Consulta();

        ArrayList<Disciplinas> listaTresEventos = consulta.listadoTresEventos();
        for (int i = 0; i < listaTresEventos.size(); i++) {
            ArrayList<String> fil = new ArrayList<String>();
            Disciplinas disciplinas = listaTresEventos.get(i);
           
            fil.add(disciplinas.getNombre());
             fil.add(disciplinas.getEstadio());
            fil.add(disciplinas.getFase());
            fil.add(disciplinas.getFecha_y_hora()+"");
           
            
            
            Fila fila = new Fila(fil);
            filas.add(fila);

        }
        TablaProximosEventos tabla;
        tabla = new TablaProximosEventos(listadoColumnas, filas);
        return tabla;
    } 
    
    public void atletasPorPais(String valor,JTable tabla) throws SQLException{
        Consulta.getInstancia().atletasPorPais(valor,tabla);
    }
    
    public void atletasMasMedallas(String pais,JTable tabla) throws SQLException{
       Consulta.getInstancia().atletasMasMedallas(pais, tabla);
    }
    
    public TablaUltimosGanadores tablaUltimosGanadores() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        ArrayList<String> listadoColumnas = new ArrayList<String>();
        ArrayList<Fila> filas = new ArrayList<Fila>();
       
        listadoColumnas.add("País");
         listadoColumnas.add("Nombre_atletas");
        listadoColumnas.add("Disciplina");
        listadoColumnas.add("Valor");
        listadoColumnas.add("Fecha");
       
        
        Consulta consulta = new Consulta();

        ArrayList<Medallas> listaMedallas = consulta.listadoGanadores();
        for (int i = 0; i < listaMedallas.size(); i++) {
            ArrayList<String> fil = new ArrayList<String>();
            Medallas medallas = listaMedallas.get(i);
           
            fil.add(medallas.getNombre_atletas());
             fil.add(medallas.getPais());
            fil.add(medallas.getDisciplina());
            fil.add(medallas.getValor());
            fil.add(medallas.getFechaIngreso()+"");
            
            
            
            Fila fila = new Fila(fil);
            filas.add(fila);

        }
        TablaUltimosGanadores tabla;
        tabla = new TablaUltimosGanadores(listadoColumnas, filas);
        return tabla;
    } 
}
