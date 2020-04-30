package examples.abstractfactory;

public class DocumentoA4 implements DocumentoFisico {

    @Override
    public void crearDocumentoFisico() {
        System.out.println("Creando Documento formato A4");
    }

}
