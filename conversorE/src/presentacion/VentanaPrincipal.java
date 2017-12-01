/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import logica.util.Base;

/**
 *
 * @author Michael Rodas
 */
public class VentanaPrincipal extends JFrame{

    private Modelo modelo;
    private Controlador controlador;
    private JButton btnConvertir;
    private JLabel lblLetreroEntrada;
    private ButtonGroup bgGrupoOpcionesEntrada;
    private JRadioButton rbOpcionEntradaBin;
    private JRadioButton rbOpcionEntradaOct;
    private JRadioButton rbOpcionEntradaDec;
    private JRadioButton rbOpcionEntradaHex;
    private JLabel lblNumero;
    private JTextField txtNumeroEntrada;
	private JLabel lblLetreroSalida;
    private ButtonGroup bgGrupoOpcionesSalida;
    private JRadioButton rbOpcionSalidaBin;
    private JRadioButton rbOpcionSalidaOct;
    private JRadioButton rbOpcionSalidaDec;
    private JRadioButton rbOpcionSalidaHex;
    private JLabel lblResultado;
    
    public VentanaPrincipal(Modelo modelo){
        installLookAndFeel();
        this.modelo = modelo;
        initComponents();
        getControlador();
    }

    private void installLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
    
    private void initComponents(){
        btnConvertir = new JButton("Convertir");
        lblLetreroEntrada = new JLabel("Seleccione el sistema de entrada:");
        lblLetreroEntrada.setBounds(20, 20, 300, 15);
        bgGrupoOpcionesEntrada = new ButtonGroup();
        rbOpcionEntradaBin = new JRadioButton("Bin",true);
        rbOpcionEntradaOct = new JRadioButton("Oct");
        rbOpcionEntradaDec = new JRadioButton("Dec");
        rbOpcionEntradaHex = new JRadioButton("Hex");
        rbOpcionEntradaBin.setBounds(20, 40, 60, 20);
        rbOpcionEntradaOct.setBounds(80, 40, 60, 20);
        rbOpcionEntradaDec.setBounds(140, 40, 60, 20);
        rbOpcionEntradaHex.setBounds(200, 40, 60, 20);
        lblNumero = new JLabel("N\u00famero");
        lblNumero.setBounds(20, 75, 60, 15);
        txtNumeroEntrada = new JTextField();
        txtNumeroEntrada.setBounds(80, 70, 100, 25);
        txtNumeroEntrada.setForeground(Color.red);
        lblLetreroSalida = new JLabel("Sistema de salida:");
        lblLetreroSalida.setBounds(20, 100, 300, 15);
        bgGrupoOpcionesSalida = new ButtonGroup();
        rbOpcionSalidaBin = new JRadioButton("Bin",true);
        rbOpcionSalidaOct = new JRadioButton("Oct");
        rbOpcionSalidaDec = new JRadioButton("Dec");
        rbOpcionSalidaHex = new JRadioButton("Hex");
        rbOpcionSalidaBin.setBounds(20, 130, 60, 20);
        rbOpcionSalidaOct.setBounds(80, 130, 60, 20);
        rbOpcionSalidaDec.setBounds(140, 130, 60, 20);        
        rbOpcionSalidaHex.setBounds(200, 130, 60, 20);
//        rbOpcionSalidaBin.setForeground(Color.red);
//        rbOpcionSalidaOct.setForeground(Color.red);
//        rbOpcionSalidaDec.setForeground(Color.red);
//        rbOpcionSalidaHex.setForeground(Color.red);
        btnConvertir.setBounds(90, 160, 100, 25);
        btnConvertir.addActionListener(getControlador());
        lblResultado = new JLabel();
        lblResultado.setBounds(20, 200, 600, 25);
        lblResultado.setForeground (Color.red);
        getContentPane().add(btnConvertir);
        getContentPane().add(lblLetreroEntrada);
        getContentPane().add(rbOpcionEntradaBin);
        getContentPane().add(rbOpcionEntradaOct);
        getContentPane().add(rbOpcionEntradaDec);
        getContentPane().add(rbOpcionEntradaHex);
        bgGrupoOpcionesEntrada.add(rbOpcionEntradaBin);
        bgGrupoOpcionesEntrada.add(rbOpcionEntradaOct);
        bgGrupoOpcionesEntrada.add(rbOpcionEntradaDec);
        bgGrupoOpcionesEntrada.add(rbOpcionEntradaHex);
        getContentPane().add(lblNumero);
        getContentPane().add(txtNumeroEntrada);
        getContentPane().add(lblLetreroSalida);
        getContentPane().add(rbOpcionSalidaBin);
        getContentPane().add(rbOpcionSalidaOct);
        getContentPane().add(rbOpcionSalidaDec);
        getContentPane().add(rbOpcionSalidaHex);
        bgGrupoOpcionesSalida.add(rbOpcionSalidaBin);
        bgGrupoOpcionesSalida.add(rbOpcionSalidaOct);
        bgGrupoOpcionesSalida.add(rbOpcionSalidaDec);
        bgGrupoOpcionesSalida.add(rbOpcionSalidaHex);
        getContentPane().add(lblResultado);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversor Num\u00e9rico");
        setSize(350,280);
        setLocationRelativeTo(null);
    }
    
    public JButton getbtnConvertir() {
        return btnConvertir;
    }

    void convertirValor() {
        modelo.convertirValor();
        mostrarResultado();
    }

	private void mostrarResultado() {
		if (hayResultado()) {
			lblResultado.setText(getMensajeResultado());
		}
	}

	private String getMensajeResultado() {
		return txtNumeroEntrada.getText() + " en base "
				+ modelo.getBaseEntrada().getValorBase() + " es "
				+ agregarCerosIzquierda(modelo.getConversorNumerico().getResultado()) 
				+ " en base " + modelo.getBaseSalida().getValorBase();
	}

	private String agregarCerosIzquierda(String resultado) {
	    StringBuilder grupoCeros = new StringBuilder();
        if(!modelo.getBaseSalida().equals(Base.DEC)){
            boolean concatenarCeros = cantidadCerosRestantes(resultado) >= 1;
            if(concatenarCeros){
                for (int i = 0; i < cantidadCerosRestantes(resultado); i++) {
                    grupoCeros.append("0");
                }
            }
            return grupoCeros.append(resultado).toString();
        }else {
            return resultado;
        }
    }

    private int cantidadCerosRestantes(String resultado) {
        return 16-resultado.length();
    }

    private boolean hayResultado() {
		return modelo.getConversorNumerico().getResultado() != null
				&& !modelo.getConversorNumerico().getResultado().isEmpty();
	}

    private Controlador getControlador() {
        if(controlador == null){
            controlador = new Controlador(this);
        }
        return controlador;
    }
    
    public JTextField getTxtNumeroEntrada() {
		return txtNumeroEntrada;
	}

	public void setTxtNumeroEntrada(JTextField txtNumeroEntrada) {
		this.txtNumeroEntrada = txtNumeroEntrada;
	}

	public JLabel getLblResultado() {
		return lblResultado;
	}

	public void setLblResultado(JLabel lblResultado) {
		this.lblResultado = lblResultado;
	}

	public JRadioButton getRbOpcionEntradaBin() {
		return rbOpcionEntradaBin;
	}

	public void setRbOpcionEntradaBin(JRadioButton rbOpcionEntradaBin) {
		this.rbOpcionEntradaBin = rbOpcionEntradaBin;
	}

	public JRadioButton getRbOpcionEntradaOct() {
		return rbOpcionEntradaOct;
	}

	public void setRbOpcionEntradaOct(JRadioButton rbOpcionEntradaOct) {
		this.rbOpcionEntradaOct = rbOpcionEntradaOct;
	}

	public JRadioButton getRbOpcionEntradaDec() {
		return rbOpcionEntradaDec;
	}

	public void setRbOpcionEntradaDec(JRadioButton rbOpcionEntradaDec) {
		this.rbOpcionEntradaDec = rbOpcionEntradaDec;
	}

	public JRadioButton getRbOpcionEntradaHex() {
		return rbOpcionEntradaHex;
	}

	public void setRbOpcionEntradaHex(JRadioButton rbOpcionEntradaHex) {
		this.rbOpcionEntradaHex = rbOpcionEntradaHex;
	}

	public JRadioButton getRbOpcionSalidaBin() {
		return rbOpcionSalidaBin;
	}

	public void setRbOpcionSalidaBin(JRadioButton rbOpcionSalidaBin) {
		this.rbOpcionSalidaBin = rbOpcionSalidaBin;
	}

	public JRadioButton getRbOpcionSalidaOct() {
		return rbOpcionSalidaOct;
	}

	public void setRbOpcionSalidaOct(JRadioButton rbOpcionSalidaOct) {
		this.rbOpcionSalidaOct = rbOpcionSalidaOct;
	}

	public JRadioButton getRbOpcionSalidaDec() {
		return rbOpcionSalidaDec;
	}

	public void setRbOpcionSalidaDec(JRadioButton rbOpcionSalidaDec) {
		this.rbOpcionSalidaDec = rbOpcionSalidaDec;
	}

	public JRadioButton getRbOpcionSalidaHex() {
		return rbOpcionSalidaHex;
	}

	public void setRbOpcionSalidaHex(JRadioButton rbOpcionSalidaHex) {
		this.rbOpcionSalidaHex = rbOpcionSalidaHex;
	}
}
