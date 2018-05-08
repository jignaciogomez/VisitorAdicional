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
public class OverseasBuilder extends UIBuilder {

    private JLabel lblAdditionalSH;
    private JTextField txtAdditionalSH;

    public OverseasBuilder() {
    }

    @Override
    public void AgregarNuevosControles() {
        nuevoPanel = new JPanel();

        lblAdditionalSH = new JLabel("Additional SH:  ");
        txtAdditionalSH = new JTextField(10);
        
        GridBagLayout gridbag = new GridBagLayout();
        nuevoPanel.setLayout(gridbag);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        nuevoPanel.add(lblAdditionalSH);
        nuevoPanel.add(txtAdditionalSH);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblAdditionalSH, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtAdditionalSH, gbc);

    }

    @Override
    public int getValorAdicional() {
       return Integer.parseInt(txtAdditionalSH.getText()) ;
    }


}
