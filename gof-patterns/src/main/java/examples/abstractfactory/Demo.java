package examples.abstractfactory;

public class Demo {

    public static void main(String[] args) {
        FabricaAbstractaDocumentos fabricaDocumentosDigitales = FabricaDeProduccion.getFabrica("pdf");
        DocumentoDigital docDigital = (DocumentoDigitalAColor) fabricaDocumentosDigitales.getDocumentoDigital("color");
        docDigital.crearDocumentoDigital();
        
        FabricaAbstractaDocumentos fabricaDocumentosFisicos = FabricaDeProduccion.getFabrica("impreso");
        DocumentoFisico docImpreso = (DocumentoA4) fabricaDocumentosFisicos.getDocumentoFisico("A4");
        docImpreso.crearDocumentoFisico();
    }
}
