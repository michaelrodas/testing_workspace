/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;

import logica.util.Base;
import logica.Conversor;

/**
 *
 * @author Michael Rodas
 */
public class Modelo {
    private VentanaPrincipal ventanaPrincipal;
    private Conversor conversorNumerico;
    
    public void iniciar() {
        getVentanaPrincipal();
    }
    
    public VentanaPrincipal getVentanaPrincipal(){
        if(ventanaPrincipal == null){
            ventanaPrincipal = new VentanaPrincipal(this);
            ventanaPrincipal.setVisible(true);
        }
        return ventanaPrincipal;
    }
    
    public Conversor getConversorNumerico(){
        if(conversorNumerico == null){
            conversorNumerico = new Conversor();
        }
        return conversorNumerico;
    }
    
    public void convertirValor(){
    	boolean huboError;
    	getConversorNumerico().setResultado(null);
    	huboError = verificar(getValorEntrada());
    	if(huboError){
    		return;
    	}
    	try {
			getConversorNumerico().convertirValor(getValorEntrada(),getBaseEntrada(),getBaseSalida());
		} catch (NumberFormatException e) {
			getVentanaPrincipal().getLblResultado().setText("No fue posible convertir el valor");
		}
    }

	public Base getBaseSalida() {
		if(getVentanaPrincipal().getRbOpcionSalidaBin().isSelected()){
			return Base.BIN;
		}
		if(getVentanaPrincipal().getRbOpcionSalidaOct().isSelected()){
			return Base.OCT;
		}
		if(getVentanaPrincipal().getRbOpcionSalidaHex().isSelected()){
			return Base.HEX;
		}
		return Base.DEC;
	}

	public Base getBaseEntrada() {
		if(getVentanaPrincipal().getRbOpcionEntradaBin().isSelected()){
			return Base.BIN;
		}
		if(getVentanaPrincipal().getRbOpcionEntradaOct().isSelected()){
			return Base.OCT;
		}
		if(getVentanaPrincipal().getRbOpcionEntradaHex().isSelected()){
			return Base.HEX;
		}
		return Base.DEC;
	}

	private String getValorEntrada() {
		return getVentanaPrincipal().getTxtNumeroEntrada().getText();
	}
    
    private boolean verificar(String textoEntrada) {
		if(textoEntrada.isEmpty()){
			getVentanaPrincipal().getLblResultado().setText("Por favor ingrese un valor de entrada");
			return true;
		}
		if(!getBaseEntrada().equals(Base.HEX) && textoEntrada.matches("[a-zA-Z]+")){
			getVentanaPrincipal().getLblResultado().setText("Solo se admiten letras en base 16");
			return true;
		}else if(getBaseEntrada().equals(Base.HEX) && !textoEntrada.matches("[0-9A-Fa-f]+")){
			getVentanaPrincipal().getLblResultado().setText("Valor incompatible en base 16");
			return true;
		}
		if(getBaseEntrada().equals(Base.BIN) && !textoEntrada.matches("[0-1]+")){
			getVentanaPrincipal().getLblResultado().setText("Valor incompatible en base 2");
			return true;
		}
		if(getBaseEntrada().equals(Base.OCT) && !textoEntrada.matches("[0-7]+")){
			getVentanaPrincipal().getLblResultado().setText("Valor incompatible en base 8");
			return true;
		}
		return false;
	}


	
}
