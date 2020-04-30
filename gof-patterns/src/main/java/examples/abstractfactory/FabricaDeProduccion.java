package examples.abstractfactory;

public class FabricaDeProduccion {
    public static FabricaAbstractaDocumentos getFabrica(String tipoFabrica) {
        if (tipoFabrica.equals("pdf")) {
            return new FabricaPDF();
        }
        if (tipoFabrica.equals("impreso")) {
            return new FabricaImpreso();
        }
        return null;
    }
}
