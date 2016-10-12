/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patadura.sports.tabla.grafica;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import patadura.sports.logica.Atletas;

/**
 *
 * @author Carlos
 */
public class TablaAtletasPorPais extends DefaultTableModel{
     public TablaAtletasPorPais(Iterator<Atletas> iterador){
        super();
        addColumn("Nombre_atletas");
        addColumn("País");
        addColumn("Disciplina");
        addColumn("Edad");
        addColumn("Altura");
        addColumn("Peso");
        addColumn("Títulos");
        addColumn("Participaciones");
        
        
        while(iterador.hasNext()){
            Atletas atletas=iterador.next();
            
            Object[]fila=new Object[8];
            fila[0]=atletas.getNombre_atletas();
            fila[1]=atletas.getPais();
            fila[2]=atletas.getDisciplina();
            fila[3]=atletas.getEdad();
            fila[4]=atletas.getAltura()+"";
            fila[5]=atletas.getPeso()+"";
            fila[6]=atletas.getTitulos();
            fila[7]=atletas.getParticipaciones();
            addRow(fila);
        }
     }
   
}
