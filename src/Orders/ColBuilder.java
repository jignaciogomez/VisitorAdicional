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
public class ColBuilder extends UIBuilder {

    private JLabel lblIVA;
    private JTextField txtIVA;

    public ColBuilder() {
    }

    @Override
    public void AgregarNuevosControles() {
        nuevoPanel = new JPanel();

        lblIVA = new JLabel("Percent IVA :    ");
        txtIVA = new JTextField(10);

        GridBagLayout gridbag = new GridBagLayout();
        nuevoPanel.setLayout(gridbag);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        nuevoPanel.add(lblIVA);
        nuevoPanel.add(txtIVA);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblIVA, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtIVA, gbc);

    }

    @Override
    public int getValorAdicional() {
        return Integer.parseInt(txtIVA.getText()) ;
    }
    


}
