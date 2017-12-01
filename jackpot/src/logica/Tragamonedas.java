/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Random;

import presentacion.Modelo;

/**
 *
 * @author estudiantes
 */
public class Tragamonedas {

    private Modelo modelo;
    
    public Tragamonedas(Modelo modelo) {
    	this.modelo = modelo;
    }

    /** Genera los numeros de los 3 carretes. */
	public void generarNumerosCarrete() {
		Random numeroAleatorio = new Random();
		if (modelo.getVentanaPrincipal().getCbSiempreGana().isSelected() == true) { // si el timo de siempre gana esta activado.
			int tipoTriunfo = numeroAleatorio.nextInt(4); // genera un numero entre 0-3 para determinar el tipo de triunfo
			modelo.setCarrete1(numeroAleatorio.nextInt(getLongitudListaImagenes()));
			if (tipoTriunfo == 0) { 		// tipoTriunfo = 0 - Reels 1, 2 and 3 will all match.
				modelo.setCarrete2(modelo.getCarrete1());
				modelo.setCarrete3(modelo.getCarrete1());
			} else if (tipoTriunfo == 1) { 	// tipoTriunfo = 1 - carretes 1 y 2 emparejaran.
				modelo.setCarrete2(modelo.getCarrete1());
			} else if (tipoTriunfo == 2) { 	// tipoTriunfo = 2 - carretes 1 y 3 emparejaran.
				modelo.setCarrete3(modelo.getCarrete1());
			} else {					// tipoTriunfo = 3 - carretes 2 y 3 emparejaran.
				if (modelo.getCarrete1() >= 0 ) { 
					modelo.setCarrete2(modelo.getCarrete1() + 1);
					modelo.setCarrete3(modelo.getCarrete1() + 1);
				} if (modelo.getCarrete1() == getLongitudListaImagenes()-1) {
					modelo.setCarrete2(modelo.getCarrete1() - 1);
					modelo.setCarrete3(modelo.getCarrete1() - 1);
				}
			}
		} else { // Si el modo timo esta desactivado, se juego un juego normal.
			modelo.setCarrete1(numeroAleatorio.nextInt(getLongitudListaImagenes()));
			modelo.setCarrete2(numeroAleatorio.nextInt(getLongitudListaImagenes()));
			modelo.setCarrete3(numeroAleatorio.nextInt(getLongitudListaImagenes()));
		}
		
	}

	private int getLongitudListaImagenes() {
		return modelo.getVentanaPrincipal().getListaImagenes().size();
	}

	public void ejecutarJuego() {
		if (puedeGirar()) {
			modelo.getVentanaPrincipal().cambiarColorFondoCarretes();
			modelo.generarNumerosCarrete();
			modelo.revisarResultadoGiro();
		} else {
			modelo.getVentanaPrincipal().getLblEstado().setText("La apuesta es "+modelo.getApuesta()+" cr\u00e9ditos, compre m\u00e1s con $!");
		}
		modelo.getVentanaPrincipal().revisarFondos();
	}
	
	public int gana() {
		return modelo.getAtinaTres() + modelo.getAtinaDos();
	}

	public boolean tieneFondosSuficientesParaApostar() {
		return modelo.getFondos() < modelo.getApuesta();
	}
	
	public boolean puedeGirar(){
		return (modelo.getCreditos() - modelo.getApuesta()) >= 0;
	}
	
	public boolean puedeComprar() {
		return modelo.getFondos() >= modelo.getCompraCredito();
	}

	public void restarCompraCreditosAFondos() {
		modelo.setFondos(modelo.getFondos() - modelo.getCompraCredito());
	}

	public void sumarCreditosComprados() {
		modelo.setCreditos(modelo.getCreditos() + modelo.getCreditosComprados());
	}

	/** Incrementa a atinaTres en 1 y retorna el valor. */
	public int incrementarAtinaTres() {
		modelo.setAtinaTres(modelo.getAtinaTres() + 1);
		return modelo.getAtinaTres();
	}
	
	/** Incrementa a atinaDos en 1 y retorna el valor. */
	public int incrementarAtinaDos() {
		modelo.setAtinaDos(modelo.getAtinaDos() + 1);
		return modelo.getAtinaDos();
	}

	/** Incrementa perdido en 1 y retorna el valor. */
	public int incrementarPerdida() {
		modelo.setPerdido(modelo.getPerdido() + 1);
		return modelo.getPerdido();
	}

	/** calcula el premio a entregar por ganar basado en el numero de atinos y timos. */
	public double getPremio(double premio) {
		if (esTripleta()) {
			if (modelo.getVentanaPrincipal().getCbSuperJackpot().isSelected() == true) {
				premio *= 100; // si esta en timo y le atina a todo, retorna la paga x100.
			} else {
				premio = modelo.getPago(); // si le atina a todo, retorna la paga completa.
			}
		} else if (esDupla()) {
			if (modelo.getVentanaPrincipal().getCbSuperJackpot().isSelected() == true) {
				premio *= 50; // si esta en timo y atina a dos, retorna la paga x50.
			} else {
				premio = modelo.getPago() / 5; // si atina a dos, retorna 1/5 de la paga.
			}
		} else {
			premio = 0; // sino gana, no retorna premio.
		}
		return premio;
	}
	
	public boolean esDupla() {
		return modelo.getCarrete1() == modelo.getCarrete2()
				|| modelo.getCarrete1() == modelo.getCarrete3()
				|| modelo.getCarrete2() == modelo.getCarrete3();
	}

	public boolean esTripleta() {
		return modelo.getCarrete1() == modelo.getCarrete2()
				&& modelo.getCarrete2() == modelo.getCarrete3();
	}

	public void revisarResultadoGiro() {
		if (esTripleta()) {
			setResultadoTripletaEnVentana();	
		} else if (modelo.getCarrete1() == modelo.getCarrete2() || modelo.getCarrete1() == modelo.getCarrete3()) {
			modelo.getVentanaPrincipal().getLblEstado().setText(
					"Atinaste DOS s\u00edmbolos ("
							+ modelo.getVentanaPrincipal().getListaImagenes()
									.get(modelo.getCarrete1()).getDescription()
							+ ")! +$"
							+ modelo.getFormatoDecimal().format(getPremio(
									modelo.getPago())) + "!");
			modelo.getVentanaPrincipal().getLblAtinaDos().setText("Atina Dos: "+ incrementarAtinaDos());
			if (modelo.getCarrete1() == modelo.getCarrete2()) {
				modelo.getVentanaPrincipal().getPnlCarrete1().setBackground(new java.awt.Color(255, 0, 0)); // Resalta los iconos atinados.
				modelo.getVentanaPrincipal().getPnlCarrete2().setBackground(new java.awt.Color(255, 0, 0));
			} else if (modelo.getCarrete1() == modelo.getCarrete3()){
				modelo.getVentanaPrincipal().getPnlCarrete1().setBackground(new java.awt.Color(255, 0, 0)); // Resalta los iconos atinados.
				modelo.getVentanaPrincipal().getPnlCarrete3().setBackground(new java.awt.Color(255, 0, 0));
			}
		} else if (modelo.getCarrete2() == modelo.getCarrete3()) {
			modelo.getVentanaPrincipal().getLblEstado().setText(
					"Atinaste DOS s\u00edmbolos ("
							+ modelo.getVentanaPrincipal().getListaImagenes()
									.get(modelo.getCarrete2()).getDescription()
							+ ")! +$"
							+ modelo.getFormatoDecimal().format(getPremio(
									modelo.getPago())) + "!");
			modelo.getVentanaPrincipal().getLblAtinaDos().setText("Atina dos: "+ incrementarAtinaDos());
			modelo.getVentanaPrincipal().getPnlCarrete2().setBackground(new java.awt.Color(255, 0, 0)); // Resalta los iconos atinados.
			modelo.getVentanaPrincipal().getPnlCarrete3().setBackground(new java.awt.Color(255, 0, 0));
		} else {
			modelo.getVentanaPrincipal().getLblEstado().setText("Lo siento, no le atinaste a ning\u00fan s\u00edmbolo. -"+modelo.getApuesta()+" cr\u00e9ditos!");
			modelo.getVentanaPrincipal().getLblPerdido().setText("Perdido: "+ incrementarPerdida());
		}
		modelo.setCreditos(modelo.getCreditos()-modelo.getApuesta());
		modelo.getVentanaPrincipal().getLblCreditos().setText("Cr\u00e9ditos: "+ modelo.getCreditos()); // deduce la cantidad de apuesta segun los creditos disponibles.
		modelo.setFondos(modelo.getFondos() + getPremio(modelo.getPago()));
		modelo.getVentanaPrincipal().getLblDinero().setText("Dinero: $"+ modelo.getFormatoDecimal().format(modelo.getFondos())); // si gana, agrega el valor a la olla de dinero.
		modelo.getVentanaPrincipal().getLblGanado().setText("Triunfos: "+modelo.gana()); // incrementa la cantidad de triunfos.
	}
	
	private void setResultadoTripletaEnVentana() {
		modelo.getVentanaPrincipal().getLblEstado().setText(
				"Atinaste TRES s\u00edmbolos ("
						+ modelo.getVentanaPrincipal().getListaImagenes()
								.get(modelo.getCarrete1()).getDescription()
						+ ")! +$"
						+ modelo.getFormatoDecimal().format(getPremio(
								modelo.getPago())) + "!");
		modelo.getVentanaPrincipal().getLblAtinaTres().setText("Atina Tres: "+ incrementarAtinaTres());
		modelo.getVentanaPrincipal().getPnlCarrete1().setBackground(new java.awt.Color(255, 0, 0)); // Resalta los iconos atinados.
		modelo.getVentanaPrincipal().getPnlCarrete2().setBackground(new java.awt.Color(255, 0, 0));
		modelo.getVentanaPrincipal().getPnlCarrete3().setBackground(new java.awt.Color(255, 0, 0));
	}

	public void comprarCreditos() {
		if (puedeComprar()) {
			restarCompraCreditosAFondos();
			modelo.getVentanaPrincipal().getLblDinero().setText("Dinero: $"+modelo.getFormatoDecimal().format(modelo.getFondos()));
			sumarCreditosComprados();
			modelo.getVentanaPrincipal().getLblCreditos().setText("Cr\u00e9ditos: "+modelo.getCreditos());
			modelo.getVentanaPrincipal().getLblEstado().setText(
					"+"+modelo.getCreditosComprados()+" cr\u00e9ditos comprados! -$"+modelo.getFormatoDecimal().format(modelo.getCompraCredito()));
		} else {
			modelo.getVentanaPrincipal().getLblEstado().setText("$ Insuficiente para comprar cr\u00e9ditos!");
		}
		modelo.getVentanaPrincipal().revisarFondos();
	}
}
