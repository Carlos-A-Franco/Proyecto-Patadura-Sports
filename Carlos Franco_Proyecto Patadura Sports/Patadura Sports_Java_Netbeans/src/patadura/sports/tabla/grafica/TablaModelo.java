/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package patadura.sports.tabla.grafica;

import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */public class TablaModelo extends DefaultTableModel{

public TablaModelo(IModelos modelo){
  super();
  Iterator<String>iteradorColumna=modelo.listadoColumnas();
  while(iteradorColumna.hasNext()){
      String columna=iteradorColumna.next();
      addColumn(columna);

  }
  Iterator<Fila>iteradorFila=modelo.listadoFilas();
  while(iteradorFila.hasNext()){
      Fila fila=iteradorFila.next();
      Object[] fil=fila.datos();
      addRow(fil);
  }
}
}
