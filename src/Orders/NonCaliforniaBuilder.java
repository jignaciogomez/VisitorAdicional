package Orders;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jigna
 */
public class NonCaliforniaBuilder extends UIBuilder {



    public NonCaliforniaBuilder() {
    }

    public void AgregarNuevosControles() {
        nuevoPanel = new JPanel();

        //No se agregan controles adicionales ya que para NonCalifonia no aplican otros campos 

    }
}
