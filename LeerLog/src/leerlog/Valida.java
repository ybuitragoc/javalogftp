package leerlog;

import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Valida {
    int numero;

    public Valida(int numero) {
        this.numero = numero;
    }
    
    public Valida(){}
         static Logger  log = Logger.getLogger(Valida.class);
         URL url = Valida.class.getResource("login4j.properties");
        
         
         public void validar(int numero){
           PropertyConfigurator.configure(url);
            
          
           if(numero==0){
              log.info("conexion exitosa");
            } 
            else if(numero <0){
                log.warn("Posiblemente sucedio un error");
            } else {
                log.fatal("error fatal");
            }
        }
         
         private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
        
}
