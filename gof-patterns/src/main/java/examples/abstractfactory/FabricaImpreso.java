package examples.abstractfactory;

public class FabricaImpreso extends FabricaAbstractaDocumentos {

    @Override
    DocumentoDigital getDocumentoDigital(String formatoDocumento) {
        return null;
    }

    @Override
    DocumentoFisico getDocumentoFisico(String tipoHoja) {
        if(tipoHoja.equals("A4")){
            return new DocumentoA4();
        }
        return null;
    }

}
