/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patadura.sports.tabla.grafica;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Carlos
 */
public class TablaUltimosGanadores implements IModelos{
    private ArrayList<String>listadoColumnas;
private ArrayList<Fila>listadoFilas;
public  TablaUltimosGanadores(ArrayList<String>listadoColumnas,ArrayList<Fila>listadoFilas){
    this.listadoColumnas=listadoColumnas;
this.listadoFilas=listadoFilas;
}
public Iterator<String>listadoColumnas(){
    return listadoColumnas.iterator();
}
public Iterator<Fila>listadoFilas(){
    return listadoFilas.iterator();
}   
    
}
