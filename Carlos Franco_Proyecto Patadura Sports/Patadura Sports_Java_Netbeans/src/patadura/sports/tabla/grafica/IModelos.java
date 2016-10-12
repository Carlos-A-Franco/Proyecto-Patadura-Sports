/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patadura.sports.tabla.grafica;

import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public interface IModelos {

    Iterator<String> listadoColumnas();

    Iterator<Fila> listadoFilas();
}
