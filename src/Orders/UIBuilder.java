package Orders;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JPanel;

/** 
 *
 * @author jigna
 */
public abstract class UIBuilder {
	protected JPanel nuevoPanel;

	public abstract void AgregarNuevosControles();
	        
        public JPanel getNuevoPanel(){
            return nuevoPanel;
        }
}
