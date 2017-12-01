package Singleton;

public class Prueba {

    public static void main(String[] args) {
        System.out.println(CargadorPropiedades.getInstance().getPropiedad("font_style"));
        System.out.println(CargadorPropiedades.getInstance().getPropiedad("default_number"));
    }

}
