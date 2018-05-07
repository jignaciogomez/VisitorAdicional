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
public class CaliforniaBuilder extends UIBuilder {

    private JLabel lblAdditionalTax;
    private JTextField txtAdditionalTax;

    public CaliforniaBuilder() {
    }
    
    public String getAdditionalTax() {
        return txtAdditionalTax.getText();
    }

    public void AgregarNuevosControles() {

        nuevoPanel = new JPanel();

        lblAdditionalTax = new JLabel("Additional Tax:  ");
        txtAdditionalTax = new JTextField(10);
        
        GridBagLayout gridbag = new GridBagLayout();
        nuevoPanel.setLayout(gridbag);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        nuevoPanel.add(lblAdditionalTax);
        nuevoPanel.add(txtAdditionalTax);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblAdditionalTax, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtAdditionalTax, gbc);

    }
    
    
}
