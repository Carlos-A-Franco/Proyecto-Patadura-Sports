/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Configuracion {
private static Properties propiedad=new Properties();
static{
    InputStream archivo;
        try {
            archivo = new FileInputStream("Config.Patadura Sports");
            try {
                propiedad.load(archivo);
            } catch (IOException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }

}
public static String getServidor(){
    return propiedad.getProperty("servidor").toString();
}
public static String getDriver(){
    return propiedad.getProperty("driver").toString();
}
public static String getPass(){
    return propiedad.getProperty("pass").toString();
}
public static String getUsuario(){
    return propiedad.getProperty("usuario").toString();
}



}
