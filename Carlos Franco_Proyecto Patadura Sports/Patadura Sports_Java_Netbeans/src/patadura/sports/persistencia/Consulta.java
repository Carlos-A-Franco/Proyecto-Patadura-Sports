/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patadura.sports.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import patadura.sports.logica.Persona;
import  patadura.sports.grafica.VentanaPrincipal;
import patadura.sports.logica.Atletas;
import patadura.sports.logica.Disciplinas;
import patadura.sports.logica.Medallas;
import patadura.sports.logica.Paises;
import patadura.sports.logica.Sistema;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author Carlos
 */
public class Consulta extends Conexion {
    
    private static Consulta objeto = null;

    public Consulta() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        super("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/patadura sports", "root", "");

    }

    public static Consulta getInstancia() {
        if (objeto == null) {
            try {
                objeto = new Consulta();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return objeto;
    }
    
    public boolean loguearse(String usuario,String contrasenia,String tipo) throws SQLException{
        ResultSet resultado = this.consultar("SELECT * FROM persona WHERE usuario='"+ usuario +"' AND contrasenia= '"+contrasenia+"' AND tipo='"+tipo+"'");
        if(resultado.next())
            return true;
             
        else
            return false;
        
    }
    
    public void agregarPaises(Paises paises) throws SQLException{
        ArrayList<String> listadoParametros = new ArrayList<String>();
        listadoParametros.add(paises.getNombre());
        listadoParametros.add(paises.getPoblacion()+ "");
        listadoParametros.add(paises.getContinente());
        this.actualizar("INSERT INTO `paises`(`Nombre`, `Poblacion`, `Continente`) VALUES (?,?,?)", listadoParametros);
        
    }
    public ArrayList<Paises> listadoPaises() throws SQLException{
       ResultSet resultado=this.consultar("SELECT * FROM paises");
       ArrayList<Paises>listado=new ArrayList<Paises>();
       while(resultado.next()){
           String nombre=resultado.getString("nombre");
           int poblacion=resultado.getInt("poblacion");
          String continente=resultado.getString("continente");
           
           Paises paises=new Paises(nombre,poblacion,continente);
           listado.add(paises);
       }
       return listado;
       
   }
     
    
public void eliminarPaises(Paises paises) throws SQLException{
        ArrayList<String> listadoParametros = new ArrayList<String>();
        listadoParametros.add(paises.getNombre());
        listadoParametros.add(paises.getPoblacion()+ "");
        listadoParametros.add(paises.getContinente());
        this.actualizar(("DELETE  FROM paises WHERE nombre = ? and poblacion=? and continente = ?"), listadoParametros);
        
    }

    public void editarPaises(Paises paises) throws SQLException{
        ArrayList<String> listadoParametros = new ArrayList<String>();
        
        listadoParametros.add(paises.getPoblacion()+ "");
        listadoParametros.add(paises.getContinente());
        listadoParametros.add(paises.getNombre());
        this.actualizar(("UPDATE  paises SET poblacion = ?, continente = ? WHERE nombre=? "), listadoParametros);
        
    }
     public void agregarAtletas(Atletas atletas) throws SQLException{
        ArrayList<String> listadoParametros = new ArrayList<String>();
       
        listadoParametros.add(atletas.getNombre_atletas());
        listadoParametros.add(atletas.getPais());
        listadoParametros.add(atletas.getDisciplina());
        listadoParametros.add(atletas.getEdad()+(""));
        listadoParametros.add(atletas.getAltura()+(""));
        listadoParametros.add(atletas.getPeso()+(""));
        listadoParametros.add(atletas.getTitulos());
        listadoParametros.add(atletas.getParticipaciones());
        this.actualizar("INSERT INTO atletas(nombre_atletas,pais,disciplina,edad,altura,peso,titulos,participaciones)VALUES(?,?,?,?,?,?,?,?)", listadoParametros);
    
     }
     //No pude saber por qué? no me dió el eliminar aquí//
     //También quise hacer un método que no permitiera eliminar al atleta después de la fecha del evento.Ya que agregar y editar se podría porque un atleta se podría lesionar.La consulta era:(delete from atletas inner join disciplinas on atletas.nombre_atletas=disciplinas.nombre_atletas inner join persona on disciplinas.usuarioAdmin=persona.tipo where nombre_atletas=? and where fecha_y_hora>(select max(fecha_ingreso) as maximo from persona))//
  public void eliminarAtletas(Atletas atletas) throws SQLException{
        ArrayList<String> listadoParametros = new ArrayList<String>();
        
        listadoParametros.add(atletas.getNombre_atletas());
        listadoParametros.add(atletas.getPais());
        listadoParametros.add(atletas.getDisciplina());
        listadoParametros.add(atletas.getEdad()+(""));
        listadoParametros.add(atletas.getAltura()+(""));
        listadoParametros.add(atletas.getPeso()+(""));
        listadoParametros.add(atletas.getTitulos());
        listadoParametros.add(atletas.getParticipaciones());
        this.actualizar(("DELETE FROM atletas WHERE nombre_atletas=? and pais=? and disciplina=? and edad=? and altura=? and peso=? and titulos=? and participaciones=? " ), listadoParametros);
  }
      public ArrayList<Atletas> listadoAtletas() throws SQLException{
       ResultSet resultado=this.consultar("SELECT * FROM atletas");
       ArrayList<Atletas>listado=new ArrayList<Atletas>();
       while(resultado.next()){
       
       String nombre_atletas=resultado.getString("nombre_atletas");
        String pais=resultado.getString("pais");
       String disciplina=resultado.getString("disciplina");
       int edad= resultado.getInt("edad");
       float altura= resultado.getFloat("altura");
       float peso= resultado.getFloat("peso");
       String titulos= resultado.getString("titulos");
       String participaciones= resultado.getString("participaciones");
      Atletas atletas=new Atletas(nombre_atletas,pais,disciplina,edad,altura,peso,titulos,participaciones);
      listado.add(atletas);
       }
       return listado;
      }
      
      public void editarAtletas(Atletas atletas) throws SQLException{
        ArrayList<String> listadoParametros = new ArrayList<String>();
        
        listadoParametros.add(atletas.getNombre_atletas());
        listadoParametros.add(atletas.getPais());
        listadoParametros.add(atletas.getDisciplina());
        listadoParametros.add(atletas.getEdad()+(""));
        listadoParametros.add(atletas.getAltura()+(""));
        listadoParametros.add(atletas.getPeso()+(""));
        listadoParametros.add(atletas.getTitulos());
        listadoParametros.add(atletas.getParticipaciones());
        listadoParametros.add(atletas.getNombre_atletas());
        listadoParametros.add(atletas.getDisciplina());
        this.actualizar(("UPDATE  atletas SET nombre_atletas=?, pais=?, disciplina=?, edad=?,altura=? , peso=? , titulos=? , participaciones = ?  WHERE nombre_atletas=? and disciplina=? ") , listadoParametros);
  }
    public void agregarDisciplinas(Disciplinas disciplinas) throws SQLException {
      ArrayList<String> listadoParametros = new ArrayList<String>();
       
        listadoParametros.add(disciplinas.getNombre());
        listadoParametros.add(disciplinas.getEstadio());
        listadoParametros.add(disciplinas.getFase());
         String fecha_y_hora = Sistema.getInstance().dateToMySql(disciplinas.getFecha_y_hora());
        listadoParametros.add(fecha_y_hora +(""));
        listadoParametros.add(disciplinas.getNombre_atletas());
        listadoParametros.add(disciplinas.getPais());
       this.actualizar("INSERT INTO disciplinas(nombre,estadio,fase,fecha_y_hora,nombre_atletas,pais)VALUES(?,?,?,?,?,?)", listadoParametros);
    } 
   /*En la tabla que me traería fecha y hora no me trae la hora.Creo que debería 
    haber hecho la hora como atributo(individual)al comienzo pero no me dió el tiempo
    para solucionarlo
    
    */ 
     public ArrayList<Disciplinas> listadoDisciplinas() throws SQLException{
       ResultSet resultado=this.consultar("SELECT * FROM disciplinas");
       ArrayList<Disciplinas>listado=new ArrayList<Disciplinas>();
       while(resultado.next()){
       
       String nombre=resultado.getString("nombre");
        String estadio=resultado.getString("estadio");
       String fase=resultado.getString("fase"); 
      Date calendario=resultado.getDate("fecha_y_hora");
      SimpleDateFormat formato=new  SimpleDateFormat("yyyy-MM-dd-HH:mm");
      String nombre_atletas=resultado.getString("nombre_atletas");
      String pais=resultado.getString("pais");
      Disciplinas disciplinas=new Disciplinas(nombre,estadio,fase,calendario,nombre_atletas,pais);
      listado.add(disciplinas);
       }
       return listado;
     }
    public void eliminarDisciplinas(Disciplinas disciplinas) throws SQLException {
      ArrayList<String> listadoParametros = new ArrayList<String>();
       
        listadoParametros.add(disciplinas.getNombre());
        listadoParametros.add(disciplinas.getEstadio());
        listadoParametros.add(disciplinas.getFase());
         String fecha_y_hora = Sistema.getInstance().dateToMySql(disciplinas.getFecha_y_hora());
        listadoParametros.add(fecha_y_hora +(""));
        listadoParametros.add(disciplinas.getNombre_atletas());
        listadoParametros.add(disciplinas.getPais());
       this.actualizar("DELETE FROM disciplinas WHERE nombre=? and estadio=? and fase=? and fecha_y_hora=? and nombre_atletas=? and pais=? ", listadoParametros);
    }  
     
    public void editarDisciplinas(Disciplinas disciplinas) throws SQLException {
      ArrayList<String> listadoParametros = new ArrayList<String>();
       
        listadoParametros.add(disciplinas.getNombre());
        listadoParametros.add(disciplinas.getEstadio());
        listadoParametros.add(disciplinas.getFase());
         String fecha_y_hora = Sistema.getInstance().dateToMySql(disciplinas.getFecha_y_hora());
        listadoParametros.add(fecha_y_hora +(""));
        listadoParametros.add(disciplinas.getNombre_atletas());
        listadoParametros.add(disciplinas.getPais());
        listadoParametros.add(disciplinas.getNombre());
        listadoParametros.add(fecha_y_hora +(""));
       this.actualizar(("UPDATE  disciplinas SET  nombre=?,estadio=?, fase=?, fecha_y_hora=?, nombre_atletas=?, pais=? WHERE nombre=? and fecha_y_hora=?"), listadoParametros);
    } 
    //Agregué aquí un "usuario" improvisado al final de la tabla de bd. para comparar fechas.Capaz debería haberlo hecho como id,pero veré si me da el tiempo para cambiarlo.//
     public ArrayList<Disciplinas> listadoNovedades() throws SQLException{
       ResultSet resultado=this.consultar("SELECT DISTINCT(disciplinas.nombre_atletas),nombre,estadio,fase,fecha_y_hora,disciplinas.pais FROM disciplinas inner join medallas on disciplinas.usuarioAdmin=medallas.usuarioAdmin where fecha_y_hora>(SELECT MAX(fechaIngreso)as maximo FROM medallas)order by fecha_y_hora asc ");
       ArrayList<Disciplinas>listado=new ArrayList<Disciplinas>();
       while(resultado.next()){
       
       String nombre=resultado.getString("nombre");
        String estadio=resultado.getString("estadio");
       String fase=resultado.getString("fase"); 
      Date calendario=resultado.getDate("fecha_y_hora");
      SimpleDateFormat formato=new  SimpleDateFormat("yyyy-MM-dd-HH:mm");
      String nombre_atletas=resultado.getString("nombre_atletas");
      String pais=resultado.getString("pais");
      Disciplinas disciplinas=new Disciplinas(nombre,estadio,fase,calendario,nombre_atletas,pais);
      listado.add(disciplinas);
       }
       return listado;
    
     }
     
      public void agregarMedallas(Medallas medallas) throws SQLException {
      ArrayList<String> listadoParametros = new ArrayList<String>();
       
        listadoParametros.add(medallas.getPais());
        listadoParametros.add(medallas.getNombre_atletas());
        listadoParametros.add(medallas.getDisciplina());
           listadoParametros.add(medallas.getValor());     
         String fechaIngreso = Sistema.getInstance().dateIngreso(medallas.getFechaIngreso());
        listadoParametros.add(fechaIngreso +(""));
        
       this.actualizar("INSERT INTO medallas(pais,nombre_atletas,disciplina,valor,fechaIngreso)VALUES(?,?,?,?,?)", listadoParametros);
    } 
   /*Este tipo de tabla no me dió resultado.En gráfica me daba incompatible con 
      IModelos.Luego casteé la TablaAtletasPorPais a TableModel y no me dió tampoco
      */ 
      public ArrayList<Atletas> listadoAtletasPorPais(String pais) throws SQLException{
       ResultSet resultado=this.consultar("SELECT * FROM atletas WHERE pais='"+pais+"'");
       ArrayList<Atletas>listado=new ArrayList<Atletas>();
       while(resultado.next()){
       
       String nombre_atletas=resultado.getString("nombre_atletas");
         pais=resultado.getString("pais");
       String disciplina=resultado.getString("disciplina");
       int edad= resultado.getInt("edad");
       float altura= resultado.getFloat("altura");
       float peso= resultado.getFloat("peso");
       String titulos= resultado.getString("titulos");
       String participaciones= resultado.getString("participaciones");
      Atletas atletas=new Atletas(nombre_atletas,pais,disciplina,edad,altura,peso,titulos,participaciones);
      listado.add(atletas);
       }
       return listado;
      }
   
     public String medallasPorPais (String pais) throws SQLException{
         String cantidad;
         ResultSet resultado=this.consultar("SELECT COUNT(valor)as cantidad FROM medallas WHERE pais='"+pais+"'");
    resultado.next();
        cantidad=resultado.getString("cantidad");
        return cantidad;
    
        
     }
      
 public String medallasPorAtleta (String atleta) throws SQLException{
         String cantidad;
         ResultSet resultado=this.consultar("SELECT COUNT(valor)as cantidad FROM medallas WHERE nombre_atletas='"+atleta+"'");
    resultado.next();
        cantidad=resultado.getString("cantidad");
        return cantidad;
    
        
     }
   
 public void ingresoPersona(Persona persona) throws SQLException{
ArrayList<String> listadoParametros = new ArrayList<String>();
       
        listadoParametros.add(persona.getUsuario());
        listadoParametros.add(persona.getContrasenia()); 
         listadoParametros.add(persona.getTipo());
          String fecha_ingreso = Sistema.getInstance().dateRegistro(persona.getFecha_ingreso());
          listadoParametros.add(fecha_ingreso +(""));
          this.actualizar("INSERT INTO persona(usuario,contrasenia,tipo,fecha_ingreso)VALUES(?,?,?,?)",listadoParametros);
 }
 
 public ArrayList<Disciplinas>listadoTresEventos() throws SQLException{
       ResultSet resultado=this.consultar("SELECT distinct(fecha_y_hora),nombre,estadio,fase from disciplinas inner join persona on disciplinas.usuarioPeriod=persona.tipo where fecha_y_hora>(select max(fecha_ingreso) as maximo from persona) order by fecha_y_hora asc limit 3 ");
       ArrayList<Disciplinas>listado=new ArrayList<Disciplinas>();
       while(resultado.next()){
       
       String nombre=resultado.getString("nombre");
        String estadio=resultado.getString("estadio");
       String fase=resultado.getString("fase"); 
      Date calendario=resultado.getDate("fecha_y_hora");
      SimpleDateFormat formato=new  SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
      
      Disciplinas disciplinas=new Disciplinas(nombre,estadio,fase,calendario,null,null);
      listado.add(disciplinas);
       }
       return listado;
    
     }
 
 //Aquí hice un método void,con array incluidos.Porque de la manera "convencional" como lo hacíamos con tablas de interfaces IModelos y tablas comunes no me salía.Hacía un Arraylist con el valor como parámetro pero luego resultaba incompatible con IModelos y con una tabla hecha con un Object[] incluyendo un iterador// 
 public void atletasPorPais(String valor,JTable tabla) throws SQLException{
     DefaultTableModel ModeloTabla;
     String [] columnas={"Nombre_atletas","País","Disciplina","Edad","Altura","Peso","Títulos","Participaciones"};
      String [] registro=new String[8];
    ModeloTabla=new DefaultTableModel(null,columnas); 
     ResultSet resultado=this.consultar("SELECT * FROM atletas WHERE pais='"+valor+"'");
     while(resultado.next()){
       
       registro[0]=resultado.getString("nombre_atletas");
       registro[1] =resultado.getString("pais");
       registro[2] =resultado.getString("disciplina");
       registro[3] = resultado.getInt("edad")+"";
        registro[4]= resultado.getFloat("altura")+"";
       registro[5] = resultado.getFloat("peso")+"";
       registro[6] = resultado.getString("titulos");
        registro[7]= resultado.getString("participaciones");
     
      ModeloTabla.addRow(registro);
     }
     tabla.setModel(ModeloTabla);
 }
 
 public void atletasMasMedallas(String pais,JTable tabla) throws SQLException{
    DefaultTableModel ModeloTabla;
    String [] columnas={"Nombre","Medallas"};
     String [] registro=new String[2];
    ModeloTabla=new DefaultTableModel(null,columnas);
    ResultSet resultado=this.consultar("SELECT nombre_atletas,COUNT(nombre_atletas)as cantidad from medallas where pais='"+pais+"' group by nombre_atletas order by cantidad desc");
    while(resultado.next()){
       
       registro[0]=resultado.getString("nombre_atletas");
       registro[1] =resultado.getString("cantidad");
      ModeloTabla.addRow(registro);
     }
     tabla.setModel(ModeloTabla); 
 }
 
 //Aquí hice la consulta y ordené por fecha,me hubiera gustado ordenar también por posición,pero creo tendría que poner en el ingreso 1,2,y3.Si me diera el tiempo lo corregiría//
 public ArrayList<Medallas>listadoGanadores() throws SQLException{
       ResultSet resultado=this.consultar("SELECT distinct(nombre_atletas),pais,disciplina,valor,fechaIngreso FROM medallas inner join persona on medallas.usuarioPeriod=persona.tipo where medallas.fechaIngreso>(select max(fecha_ingreso) as maximo from persona) order by fechaIngreso desc");
       ArrayList<Medallas>listado=new ArrayList<Medallas>();
       while(resultado.next()){
       
       String nombre_atletas=resultado.getString("nombre_atletas");
        String pais=resultado.getString("pais");
       String disciplina=resultado.getString("disciplina");
       String valor=resultado.getString("valor");
      Date fechaIngreso=resultado.getDate("fechaIngreso");
      
      
      Medallas medallas=new Medallas(nombre_atletas,pais,disciplina,valor,fechaIngreso);
      listado.add(medallas);
       }
       return listado;
    
     }
 
 
}