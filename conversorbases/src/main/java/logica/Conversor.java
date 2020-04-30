/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import logica.util.Base;

/**
 *
 * @author Michael Rodas
 */
public class Conversor {
	
	private String resultado;
	
    public void convertirValor(String valorEntrada, Base baseEntrada, Base baseSalida) throws NumberFormatException{
    	Integer numeroAConvertir = getNumeroAConvertir(valorEntrada,
				baseEntrada);
    	String numeroConvertido = getNumeroConvertido(baseSalida,
				numeroAConvertir);
       setResultado(numeroConvertido.toString());
    }

	private String getNumeroConvertido(Base baseSalida,
			Integer numeroAConvertir) throws NumberFormatException{
		String numeroConvertido = null;
			switch (baseSalida) {
			case BIN:
				numeroConvertido = Integer.toBinaryString(numeroAConvertir);
				break;
			case OCT:
				numeroConvertido = Integer.toOctalString(numeroAConvertir);
				break;
			case HEX:
				numeroConvertido = Integer.toHexString(numeroAConvertir);
				break;
			case DEC:
				numeroConvertido = Integer.toString(numeroAConvertir);
				break;
			}
		return numeroConvertido;
	}

	private Integer getNumeroAConvertir(String valorEntrada, Base baseEntrada) throws NumberFormatException{
		Integer numeroAConvertir = 0;
    	switch (baseEntrada) {
		case BIN:
			numeroAConvertir = Integer.parseInt(valorEntrada, 2);
			break;
		case OCT:
			numeroAConvertir = Integer.parseInt(valorEntrada, 8);
			break;
		case HEX:
			numeroAConvertir = Integer.parseInt(valorEntrada, 16);
			break;
		case DEC:
			numeroAConvertir = Integer.parseInt(valorEntrada);
			break;
		}
		return numeroAConvertir;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
