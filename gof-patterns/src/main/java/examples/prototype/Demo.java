package examples.prototype;

public class Demo {
    public static void main(String[] args) {
        CacheFamilias.cargarCache();

        FamiliaChina familiaClonada = (FamiliaChina) CacheFamilias.getFamilia("Wong");
        familiaClonada.presentar();   
        
        FamiliaChina familiaClonada2 = (FamiliaChina) CacheFamilias.getFamilia("Lei");
        familiaClonada2.presentar();   
     }
}
