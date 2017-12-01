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
 * @author Michael Rodas
 */
public class Controlador implements ActionListener {
    private VentanaPrincipal ventanaPrincipal;
    
    public Controlador(VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
    }

	@Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == ventanaPrincipal.getbtnConvertir()){
            ventanaPrincipal.convertirValor();
        }
    }
    
}
