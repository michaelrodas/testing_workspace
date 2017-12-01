package Prototype;

public class FamiliaChinaPequenia extends FamiliaChina {

    public FamiliaChinaPequenia() {
        setNumeroHijos("0");
        setApellido("Lei");
    }
    
    @Override
    void presentar() {
        System.out.println("La familia "+ getApellido() + " tiene "+ getNumeroHijos() +" hijos");
    }

}
