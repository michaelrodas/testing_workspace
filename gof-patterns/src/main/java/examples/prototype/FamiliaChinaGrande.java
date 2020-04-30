package examples.prototype;

public class FamiliaChinaGrande extends FamiliaChina {

    public FamiliaChinaGrande(){
        setNumeroHijos("1");
        setApellido("Wong");
    }
    
    @Override
    void presentar() {
        System.out.println("La familia "+ getApellido() + " tiene "+ getNumeroHijos() +" hijos");
    }

}
