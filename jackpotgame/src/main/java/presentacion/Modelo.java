package presentacion;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import logica.SocketClient;
import logica.Tragamonedas;

public class Modelo implements Runnable {

    private VistaPrincipal ventanaPrincipal;
    private VistaSplash ventanaSplash;
    private Tragamonedas miSistema;
    private Thread hiloDibujo;
    private boolean iniciado;
    private Image imgSplash;
    private MediaTracker tracker;
    private double pago = 25.0, compraCredito = 10.0, fondos;
    private int creditos = 100, creditosComprados = 100, apuesta = 15, atinaTres, atinaDos, ganar, perdido;
    private int carrete1 = 7, carrete2 = 7, carrete3 = 7; // valores iniciales carretes
    private DecimalFormat formatoDecimal = new DecimalFormat("0.00");
    SocketClient cliente = null;
    int numMaquina=(int) (Math.random()*100);
    
    public Modelo() {
    	getVentanaPrincipal().setVisible(false);
        tracker = new MediaTracker(getVentanaPrincipal().getLienzo());
        imgSplash = getVentanaPrincipal().crearImageIcon("/imagenes/splash.png", "splash").getImage();
        tracker.addImage(imgSplash, 0);
        hiloDibujo = new Thread(this);
        iniciado = true;
    }

    public void iniciar() {
        //Centramos la ventana de splash
        showVentanaSplash();
        getVentanaPrincipal().setVisible(true);
        hiloDibujo.start();
    }

	private void showVentanaSplash() {
        getVentanaSplash().setSize(350, 300);
        centrarVentanaSplash();
        try {
            getVentanaSplash().setVisible(true);
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
        getVentanaSplash().dispose(); // Eliminamos de memoria la ventana
	}

	private void centrarVentanaSplash() {
		int posX = (Toolkit.getDefaultToolkit().getScreenSize().width - getVentanaSplash().getWidth()) / 2;
        int posY = (Toolkit.getDefaultToolkit().getScreenSize().height - getVentanaSplash().getHeight()) / 2;
        getVentanaSplash().setLocation(posX, posY);
	}

    public VistaPrincipal getVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            ventanaPrincipal = new VistaPrincipal(this);
        }
        return ventanaPrincipal;
    }

    public VistaSplash getVentanaSplash() {
        if (ventanaSplash == null) {
            ventanaSplash = new VistaSplash(this);
        }
        return ventanaSplash;
    }

    public boolean isIniciado() {
        return iniciado;
    }

    public Tragamonedas getMiSistema() {
        if (miSistema == null) {
            miSistema = new Tragamonedas(this);
        }
        return miSistema;
    }

    public Image getImgFondo() {
        return imgSplash;
    }

    @Override
    public void run() {
        while (isIniciado()) {
            esperar();
        }
    }
    
    private void esperar() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
        	System.out.println("El hilo de ejecuci\u00f3n ha sido interrumpido");
        }
    }

	public void generarNumerosCarrete() {
		getMiSistema().generarNumerosCarrete();
		getVentanaPrincipal().setIconosCarretes(
				carrete1, carrete2, carrete3); // fija la imagen del carrete
	}

	public DecimalFormat getFormatoDecimal() {
		return formatoDecimal;
	}
	
	public int getCarrete1() {
		return carrete1;
	}

	public void setCarrete1(int carrete1) {
		this.carrete1 = carrete1;
	}

	public int getCarrete2() {
		return carrete2;
	}

	public void setCarrete2(int carrete2) {
		this.carrete2 = carrete2;
	}

	public int getCarrete3() {
		return carrete3;
	}

	public void setCarrete3(int carrete3) {
		this.carrete3 = carrete3;
	}
	
	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public double getFondos() {
		return fondos;
	}

	public void setFondos(double fondos) {
		this.fondos = fondos;
	}

	public double getPago() {
		return pago;
	}

	public int getCreditosComprados() {
		return creditosComprados;
	}

	public int getApuesta() {
		return apuesta;
	}
	public double getCompraCredito() {
		return compraCredito;
	}
	public int getAtinaTres() {
		return atinaTres;
	}

	public int getAtinaDos() {
		return atinaDos;
	}

	public void setAtinaTres(int atinaTres) {
		this.atinaTres = atinaTres;
	}

	public void setAtinaDos(int atinaDos) {
		this.atinaDos = atinaDos;
	}

	public int getPerdido() {
		return perdido;
	}

	public void setPerdido(int perdido) {
		this.perdido = perdido;
	}

	public boolean tieneFondosSuficientesParaApostar() {
		return getMiSistema().tieneFondosSuficientesParaApostar();
	}
	
	public void ejecutarJuego() {
		getMiSistema().ejecutarJuego();
		getCliente();
	}

	private void getCliente() {
		if(cliente ==null){
			cliente = new SocketClient(this);
		}
		
		cliente.startClient(this);
	}

	/** Valida el numero de atinos y ajusta el puntaje dependiendo del resultado. */
	public void revisarResultadoGiro() {
		getMiSistema().revisarResultadoGiro();
	}
	
	/** Incrementa ganar en 1, incrementa la barra de progreso y retorna el valor. */
	public int gana() {
		ganar = getMiSistema().gana();
		incrementarPrgBarCheck(); // Incrementa la barra de progreso para desbloquear el menu de timo.
		return ganar;
	}
	
	/** iguala la barra de progreso al numero de triunfos. si la barra se llena, desbloquea el menu de timo*/
	public void incrementarPrgBarCheck() {
		if (getVentanaPrincipal().getPrgbarDesbloqueadorTimo().getValue() <= 99) {
			getVentanaPrincipal().getPrgbarDesbloqueadorTimo().setValue(ganar);
		} else if (getVentanaPrincipal().getPrgbarDesbloqueadorTimo().getValue() == 100) { // despues de 100 trunfos, desbloquea el timo.
			getVentanaPrincipal().getPrgbarDesbloqueadorTimo().setValue(100);
			getVentanaPrincipal().getLblEstado().setText("100 triunfos! Felicitaciones, desbloqueste el men\u00fa de timo!");
			getVentanaPrincipal().getCbTrollface().setEnabled(true);
			getVentanaPrincipal().getCbSuperJackpot().setEnabled(true);
			getVentanaPrincipal().getCbSiempreGana().setEnabled(true);
		}
	}
	
	/** Si el jugador tiene suficientes fondos, se agregan creditos. */
	public void comprarCreditos() {
		getMiSistema().comprarCreditos();
	}

	public int getNumMaquina() {
		return numMaquina;
	}
	
	
}
