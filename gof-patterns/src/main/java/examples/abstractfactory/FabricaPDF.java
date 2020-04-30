package examples.abstractfactory;

public class FabricaPDF extends FabricaAbstractaDocumentos {

    @Override
    DocumentoDigital getDocumentoDigital(String formatoDocumento) {
        if(formatoDocumento.equals("color")){
            return new DocumentoDigitalAColor();
        }
        return null;
    }

    @Override
    DocumentoFisico getDocumentoFisico(String tipoHoja) {
        return null;
    }

}
