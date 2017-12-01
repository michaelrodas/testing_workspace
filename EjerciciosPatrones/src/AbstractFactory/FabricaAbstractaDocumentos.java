package AbstractFactory;

public abstract class FabricaAbstractaDocumentos {
    abstract DocumentoDigital getDocumentoDigital(String formatoDocumento);
    abstract DocumentoFisico getDocumentoFisico(String tipoHoja);
}
