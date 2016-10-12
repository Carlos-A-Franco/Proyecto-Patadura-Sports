/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package patadura.sports.tabla.grafica;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Fila {
private ArrayList<String>listadoFilas;
public Fila(ArrayList<String>listado){
    listadoFilas=listado;
}
public Object[]datos(){
    return listadoFilas.toArray();
}
}
