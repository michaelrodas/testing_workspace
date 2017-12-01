package Prototype;

import java.util.Hashtable;

public class CacheFamilias {
    private static Hashtable<String, FamiliaChina> mapaFamilias = new Hashtable<String, FamiliaChina>();
    
    public static FamiliaChina getFamilia(String apellido) {
        FamiliaChina cacheFamilias = mapaFamilias.get(apellido);
        return (FamiliaChina) cacheFamilias.clone();
     }
    
     public static void cargarCache() {
        FamiliaChinaGrande familiaGrande = new FamiliaChinaGrande();
        mapaFamilias.put(familiaGrande.getApellido(),familiaGrande);

        FamiliaChinaPequenia familiaPequenia = new FamiliaChinaPequenia();
        mapaFamilias.put(familiaPequenia.getApellido(),familiaPequenia);
     }
}
