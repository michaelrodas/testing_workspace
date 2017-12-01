package Singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CargadorPropiedades {

    private static CargadorPropiedades instance;
    private static Properties configurationProp;
    
    public static CargadorPropiedades getInstance() {
        if (instance == null) {
            return new CargadorPropiedades();
        } else {
            return instance;
        }
    }
    
    private CargadorPropiedades(){
        cargarPropiedades();
    }

    private void cargarPropiedades() {
        InputStream archivoPropiedades = null;
        try {
            String nombreArchivoPropiedades = "configuracion.properties";
            configurationProp = new Properties();
            archivoPropiedades = leerArchivo(nombreArchivoPropiedades);
            configurationProp.load(archivoPropiedades);
        } catch (IOException ex) {
           ex.printStackTrace();
        } finally {
            if(archivoPropiedades != null){
                try {
                    archivoPropiedades.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private FileInputStream leerArchivo(String nombreArchivoPropiedades) throws FileNotFoundException {
        return new FileInputStream(new File(obtenerRutaProyecto()).getParentFile()
                + "/src/Singleton/resources/" + nombreArchivoPropiedades);
    }

    private String obtenerRutaProyecto() {
        return CargadorPropiedades.class.getProtectionDomain().getCodeSource().getLocation().getPath().toString();
    }

    
    public String getPropiedad(String nombre){
        return configurationProp.getProperty(nombre);
    }
}
