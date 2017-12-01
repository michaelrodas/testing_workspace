/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author estudiantes
 */
public class Controlador implements ActionListener
{
    private final VistaPrincipal ventana;
    private Modelo sistema;
    
    public Controlador(VistaPrincipal ventanaPrincipal) {
        ventana = ventanaPrincipal;
        sistema = ventana.getSistema();
    }

    public VistaPrincipal getVentana() {
		return ventana;
	}

	public Modelo getSistema() {
		return sistema;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
