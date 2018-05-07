package Orders;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

public class OrderManager extends JFrame {

    public static final String GET_TOTAL = "Get Total";
    public static final String CREATE_ORDER = "Create Order";
    public static final String CHANGE_ORDER = "Update Order";
    public static final String EXIT = "Exit";
    public static final String CLEAR = "Clear";

    public static final String EMPTY_ORDER = "";
    public static final String CA_ORDER = "California Order";
    public static final String COL_ORDER = "Colombian Order";
    public static final String NON_CA_ORDER = "Non-California Order";
    public static final String OVERSEAS_ORDER = "Overseas Order";

    private JComboBox cmbOrderType;
    private JTextField txtOrderAmount, txtId;
    private JLabel lblOrderType, lblOrderAmount, lblTotal, lblTotalValue, lblInfoBuscar, lblId;

    private OrderVisitor objVisitor;
    private JPanel paneldinamico;
    //ManyOrders ordenes;

    public OrderManager() {
        super("Visitor Pattern - Example");

        //Create the visitor instance
        objVisitor = new OrderVisitor();

        ///INI-PANEL DE BOTONES///
        JButton getTotalButton = new JButton(OrderManager.GET_TOTAL);
        getTotalButton.setMnemonic(KeyEvent.VK_G);
        getTotalButton.setMnemonic(KeyEvent.VK_C);

        JButton createOrderButton = new JButton(OrderManager.CREATE_ORDER);

        JButton exitButton = new JButton(OrderManager.EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);

        JButton clearButton = new JButton(OrderManager.CLEAR);

        JButton changeOrderButton = new JButton(OrderManager.CHANGE_ORDER);

        ButtonHandler objButtonHandler = new ButtonHandler(this);
        getTotalButton.addActionListener(objButtonHandler);
        createOrderButton.addActionListener(objButtonHandler);
        exitButton.addActionListener(objButtonHandler);
        clearButton.addActionListener(objButtonHandler);
        changeOrderButton.addActionListener(objButtonHandler);

        //For layout purposes, put the buttons in a separate panel
        JPanel panel = new JPanel();

        GridBagLayout gridbag2 = new GridBagLayout();
        panel.setLayout(gridbag2);
        GridBagConstraints gbc2 = new GridBagConstraints();

        
        //gbc2.insets.top = 50;
        gbc2.insets.bottom = 20;
        //gbc2.insets.left = 50;
        //gbc2.insets.right = 50;
        
        panel.add(getTotalButton);
        panel.add(createOrderButton);
        panel.add(clearButton);
        panel.add(exitButton);

        gbc2.anchor = GridBagConstraints.EAST;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gridbag2.setConstraints(createOrderButton, gbc2);

        //inicio de K
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gridbag2.setConstraints(getTotalButton, gbc2);
        gbc2.gridx = 3;
        gbc2.gridy = 0;
        gridbag2.setConstraints(exitButton, gbc2);

        gbc2.gridx = 4;
        gbc2.gridy = 0;
        gridbag2.setConstraints(clearButton, gbc2);
        ///FIN-PANEL DE BOTONES///

        ///INI-PANEL SUPERIOR 
        cmbOrderType = new JComboBox();
        cmbOrderType.addItem(OrderManager.EMPTY_ORDER);
        cmbOrderType.addItem(OrderManager.CA_ORDER);
        cmbOrderType.addItem(OrderManager.COL_ORDER);
        cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
        cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);

        ComboBoxHandler cbhandler2 = new ComboBoxHandler(this);
        cmbOrderType.addItemListener(cbhandler2);

        txtOrderAmount = new JTextField(10);

        lblOrderType = new JLabel("Order Type:");
        lblOrderAmount = new JLabel("Order Amount:");
        paneldinamico = new JPanel();
        lblTotal = new JLabel("Result:");
        lblTotalValue = new JLabel("Orders Total = 0.0");

        //****************************************************
        JPanel buttonPanel = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(lblOrderType);
        buttonPanel.add(cmbOrderType);

        buttonPanel.add(lblOrderAmount);
        buttonPanel.add(txtOrderAmount);

        buttonPanel.add(paneldinamico);

        buttonPanel.add(lblTotal);
        buttonPanel.add(lblTotalValue);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderType, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(cmbOrderType, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(lblOrderAmount, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gridbag.setConstraints(txtOrderAmount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gridbag.setConstraints(paneldinamico, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gridbag.setConstraints(lblTotal, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gridbag.setConstraints(lblTotalValue, gbc);
        ///FIN-PANEL SUPERIOR 

        ///INI-PANEL CENTRAL --BUSCAR--
        JPanel CenterPanel = new JPanel();
        GridBagLayout gridbagC = new GridBagLayout();
        CenterPanel.setLayout(gridbagC);
        GridBagConstraints gbc3 = new GridBagConstraints();

        lblId = new JLabel("ID order to find:");
        lblInfoBuscar = new JLabel("Buscar:");
        txtId = new JTextField(10);

        CenterPanel.add(lblInfoBuscar);
        CenterPanel.add(txtId);
        CenterPanel.add(lblId);
        CenterPanel.add(changeOrderButton);

        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.gridx = 0;
        gbc3.gridy = 0;
        gridbagC.setConstraints(lblInfoBuscar, gbc3);

        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gridbagC.setConstraints(lblId, gbc3);

        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.gridx = 1;
        gbc3.gridy = 2;
        gridbagC.setConstraints(txtId, gbc3);

        gbc3.anchor = GridBagConstraints.EAST;
        gbc3.gridx = 1;
        gbc3.gridy = 3;
        gridbagC.setConstraints(changeOrderButton, gbc3);

        ///FIN-- PANEL CENTRAL --BUSCAR--
        //****************************************************
        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(CenterPanel, BorderLayout.CENTER);
        contentPane.add(panel, BorderLayout.SOUTH);
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            SwingUtilities.updateComponentTreeUI(
                    OrderManager.this);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void clear() {
        System.out.println("antes de borrar");
        txtOrderAmount.setText("");
        txtId.setText("");
        paneldinamico.removeAll();
        paneldinamico.validate();
        validate();
    }

    public void MostarNuevaUI(JPanel panel) {
        paneldinamico.removeAll();
        paneldinamico.add(panel);
        paneldinamico.validate();
        validate();
    }

    public static void main(String[] args) {
        JFrame frame = new OrderManager();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );

        frame.setSize(400, 350);
        frame.setVisible(true);
    }

    public void setTotalValue(String msg) {
        lblTotalValue.setText(msg);
    }

    public OrderVisitor getOrderVisitor() {
        return objVisitor;
    }

    public String getOrderType() {
        return (String) cmbOrderType.getSelectedItem();
    }

    public String getOrderAmount() {
        return txtOrderAmount.getText();
    }

    public String getId() {
        return txtId.getText();
    }
}