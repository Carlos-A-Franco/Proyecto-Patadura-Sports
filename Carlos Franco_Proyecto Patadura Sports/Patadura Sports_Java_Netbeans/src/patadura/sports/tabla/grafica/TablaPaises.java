/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package patadura.sports.tabla.grafica;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public class TablaPaises implements IModelos{
private ArrayList<String>listadoColumnas;
private ArrayList<Fila>listadoFilas;
public TablaPaises(ArrayList<String>listadoColumnas,ArrayList<Fila>listadoFilas){
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
