package examples.prototype;

public abstract class FamiliaChina implements Cloneable {
    private String apellido;
    private String numeroHijos;

    abstract void presentar();
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(String numeroHijos) {
        this.numeroHijos = numeroHijos;
    }
    
    public Object clone() {
        Object clone = null;
        
        try {
           clone = super.clone();
           
        } catch (CloneNotSupportedException e) {
           e.printStackTrace();
        }
        return clone;
     }
}
