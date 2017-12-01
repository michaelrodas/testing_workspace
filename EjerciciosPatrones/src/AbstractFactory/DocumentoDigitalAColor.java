package AbstractFactory;

public class DocumentoDigitalAColor implements DocumentoDigital {

    @Override
    public void crearDocumentoDigital() {
       System.out.println("Creando PDF a color");
    }

}
