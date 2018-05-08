package Orders;


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

    @Override
    public int getValorAdicional() {
        return Integer.parseInt(txtAdditionalTax.getText()) ;
    }
    
    
}
