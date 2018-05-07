

import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;
import java.applet.AudioClip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.swing.text.DefaultCaret;

public class OrderManager extends JFrame {

    public static final String newline = "\n";
    public static final String GET_TOTAL = "Get Total";
    public static final String CREATE_ORDER = "Create Order";

    public static final String CHANGE_ORDER = "Update/Delete Order";

    public static final String EXIT = "Exit";
    public static final String CLEAR = "Clear";
    public static final String CA_ORDER = "California Order";
    public static final String COL_ORDER = "Colombian Order";

    public static final String NON_CA_ORDER = "Non-California Order";

    //public static final String MAXIMO = "Maximum value: ";
    public static final String OVERSEAS_ORDER = "Overseas Order";

    ImageIcon icono;
    Image imagen;
    ImageIcon iconoEscalado;
    JLabel jLabelImg;

    private JComboBox cmbOrderType;
    private JTextField txtOrderAmount, txtId;
    private JLabel lblOrderType, lblOrderAmount;

    private JLabel lblTotal, lblTotalValue, lblMaxValue;

    private JLabel lblId, lblMaximo;

    private OrderVisitor objVisitor;

    private JTextArea taOrdenes;

    private JPanel paneldinamico;
    //ManyOrders ordenes;

    public OrderManager() {
        super("Visitor Pattern - Example");

        //Create the visitor instance
        objVisitor = new OrderVisitor();

        //ordenes=new ManyOrders(new Vector());
        cmbOrderType = new JComboBox();
        cmbOrderType.addItem("");
        cmbOrderType.addItem(OrderManager.CA_ORDER);
        cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
        cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
        cmbOrderType.addItem(OrderManager.COL_ORDER);

        ComboBoxHandler cbhandler2 = new ComboBoxHandler(this);
        cmbOrderType.addItemListener(cbhandler2);

        taOrdenes = new JTextArea(15, 27);
        taOrdenes.setEditable(false);
        //DefaultCaret caret = (DefaultCaret)taOrdenes.getCaret();
        //caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);    
        JScrollPane scrollPane = new JScrollPane(taOrdenes);
        //scrollPane.setBounds(10,60,780,500);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtOrderAmount = new JTextField(10);//
//        txtAdditionalTax = new JTextField(10);
//        txtSpainTax = new JTextField(10);
//        txtAdditionalSH = new JTextField(10);
        txtId = new JTextField(10);

        lblId = new JLabel("Id:");//
        lblMaximo = new JLabel("Maximum value:");

        lblOrderType = new JLabel("Order Type:");//
        lblOrderAmount = new JLabel("Order Amount:");

        paneldinamico = new JPanel();

        lblTotal = new JLabel("Result:");
        lblTotalValue = new JLabel("Click Create or GetTotal Button");

        lblMaxValue = new JLabel(".");

        //Create the open button
        JButton getTotalButton = new JButton(OrderManager.GET_TOTAL);

        JButton changeOrderButton = new JButton(OrderManager.CHANGE_ORDER);

        getTotalButton.setMnemonic(KeyEvent.VK_G);
        JButton createOrderButton = new JButton(OrderManager.CREATE_ORDER);
        getTotalButton.setMnemonic(KeyEvent.VK_C);
        JButton exitButton = new JButton(OrderManager.EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);
        ButtonHandler objButtonHandler = new ButtonHandler(this);//

        JButton clearButton = new JButton(OrderManager.CLEAR);

        getTotalButton.addActionListener(objButtonHandler);//
        createOrderButton.addActionListener(objButtonHandler);//

        changeOrderButton.addActionListener(objButtonHandler);//

        exitButton.addActionListener(new ButtonHandler());
        clearButton.addActionListener(new ButtonHandler(this));

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel();

        JPanel panel = new JPanel();//
        GridBagLayout gridbag2 = new GridBagLayout();//
        panel.setLayout(gridbag2);//
        GridBagConstraints gbc2 = new GridBagConstraints();//
        panel.add(getTotalButton);//
        panel.add(createOrderButton);

        //panel.add(changeOrderButton);
        panel.add(clearButton);//
        panel.add(exitButton);//
        gbc2.anchor = GridBagConstraints.EAST;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gridbag2.setConstraints(createOrderButton, gbc2);//  

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

        //****************************************************
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(lblOrderType);
        buttonPanel.add(cmbOrderType);


        buttonPanel.add(lblOrderAmount);
        buttonPanel.add(txtOrderAmount);

        buttonPanel.add(paneldinamico);

        buttonPanel.add(txtId);
        buttonPanel.add(changeOrderButton);
        buttonPanel.add(lblId);
        buttonPanel.add(lblMaximo);

        //fin de K
        buttonPanel.add(lblTotal);
        buttonPanel.add(lblTotalValue);//
        buttonPanel.add(lblMaxValue);//

        buttonPanel.add(scrollPane);
        //buttonPanel.add(taOrdenes);        

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;//
        //inicio de k2
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

        gbc.anchor = GridBagConstraints.WEST ;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gridbag.setConstraints(lblId, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gridbag.setConstraints(txtId, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gridbag.setConstraints(changeOrderButton, gbc);//

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 9;
        gridbag.setConstraints(lblMaximo, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 9;
        gridbag.setConstraints(lblMaxValue, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 10;
        gridbag.setConstraints(lblTotal, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 10;

        //fin de k2
        gridbag.setConstraints(lblTotalValue, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 11;
        gridbag.setConstraints(scrollPane, gbc);//scrollPane    taOrdenes

        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 40;

        //****************************************************
        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();//

        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);//
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            SwingUtilities.updateComponentTreeUI(
                    OrderManager.this);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public JTextArea getTaOrdenes() {
        return taOrdenes;
    }

    public JLabel getjLabelImg() {
        return jLabelImg;
    }

    public void setOrdenes(String ordenes) {
        taOrdenes.setText(ordenes);
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
        JFrame frame = new OrderManager();///

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );

        //frame.pack();
        frame.setSize(600, 720);
        frame.setVisible(true);
    }

    public void setTotalValue(String msg) {
        lblTotalValue.setText(msg);
    }

    public void setMaxValue(String msg) {
        this.lblMaxValue.setText(msg);
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

//    public String getTax() {
//        return txtAdditionalTax.getText();
//    }
//
//    public String getSpainTax() {
//        return txtSpainTax.getText();
//    }
//
//    public String getSH() {
//        return txtAdditionalSH.getText();
//    }

    public String getId() {
        return txtId.getText();
    }

} // End of class OrderManager

class ComboBoxHandler implements ItemListener {

    OrderManager manager;
    UIBuilder builder;

    @Override
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            Object item = event.getItem();
            String tipo = manager.getOrderType();

            System.out.println("tipo:" + tipo + ".");

            BuiderFactory factory = new BuiderFactory();
            builder = factory.getUIBuilder(tipo);
            UIDirector director = new UIDirector(builder);   
            
            director.build();
            //get the final build object
            JPanel UIObj = builder.getNuevoPanel();
            manager.MostarNuevaUI(UIObj);
        }
    }

    public ComboBoxHandler() {
    }

    public ComboBoxHandler(OrderManager inObjAutoSearchUI) {
        manager = inObjAutoSearchUI;
    }

}

class ButtonHandler implements ActionListener {

    OrderManager objOrderManager;
    static int num = 0;

    public void actionPerformed(ActionEvent e) {
        String totalResult = null;

        if (e.getActionCommand().equals(OrderManager.EXIT)) {           
            System.exit(1);
        }

        if (e.getActionCommand().equals(OrderManager.CLEAR)) {
            System.out.println("clear");
            //reproducir("cartoon048.wav");
            objOrderManager.clear();
        }

        if (e.getActionCommand().equals(OrderManager.CREATE_ORDER) || e.getActionCommand().equals(OrderManager.CHANGE_ORDER)) {
            //get input values
            String orderType = objOrderManager.getOrderType();///
            String strOrderAmount = objOrderManager.getOrderAmount();
//            String strTax = objOrderManager.getTax();//
//            String strSH = objOrderManager.getSH();//
//            String strSpainTax = objOrderManager.getSpainTax();//

            //ManyOrders orders =objOrderManager.getOrdenes();
            double dblOrderAmount = 0.0;
            double dblTax = 0.0;
            double dblSH = 0.0;
            double dblSpainTax = 0.0;

            if (strOrderAmount.trim().length() == 0) {
                strOrderAmount = "0.0";
            }
//            if (strTax.trim().length() == 0) {
//                strTax = "0.0";
//            }
//            if (strSH.trim().length() == 0) {
//                strSH = "0.0";
//            }
//            if (strSpainTax.trim().length() == 0) {
//                strSpainTax = "0.0";
//            }

            dblOrderAmount = new Double(strOrderAmount).doubleValue();
//            dblTax = new Double(strTax).doubleValue();
//            dblSH = new Double(strSH).doubleValue();///
//            dblSpainTax = new Double(strSpainTax).doubleValue();///

            ////Get the Visitor  
            OrderVisitor visitor = objOrderManager.getOrderVisitor();//

            if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
                ////Create the order
                Order order = createOrder(orderType, dblOrderAmount, dblTax, dblSH, dblSpainTax);///            

                //// accept the visitor instance
                order.accept(visitor);//

                objOrderManager.setTotalValue(" Order Created Successfully");
                objOrderManager.setMaxValue(" .");
            }

            if (e.getActionCommand().equals(OrderManager.CHANGE_ORDER)) {
                String strId = objOrderManager.getId();//se obtiene el Id del objeto que se va a modificar
                System.out.println("se va a modificar la orden con id " + strId);
                if (strId.trim().length() == 0) {
                    strId = "0";
                }
                Order newOrder = createOrder(orderType, dblOrderAmount, dblTax, dblSH, dblSpainTax);///  
                
                //Order order = visitor.specificOrder(strId, visitor,orderType );  
                System.out.println("Se ha creado una orden de tipo " + orderType + ". " + newOrder.getClass().toString());
                boolean updated = newOrder.aceptarModificacion(visitor, Integer.parseInt(strId));//  

                if (updated) {
                    objOrderManager.setTotalValue(" The list was updated.");
                } else {
                    objOrderManager.setTotalValue(" The order was not found.");
                }
                objOrderManager.setMaxValue(" ");
            }
            objOrderManager.setOrdenes(visitor.obtenerOrdenes());
            //objOrderManager.getTaOrdenes().setCaretPosition(objOrderManager.getTaOrdenes().getDocument().getLength() - 1);
        }

        if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
            //Get the Visitor
            OrderVisitor visitor = objOrderManager.getOrderVisitor();
            totalResult = new Double(visitor.getOrderTotal()).toString();
            totalResult = " Orders Total = " + totalResult;
            objOrderManager.setTotalValue(totalResult);
            String maximo = new Double(visitor.getMaximoVal()).toString();
            maximo = " " + maximo;
            objOrderManager.setMaxValue(maximo);
        }

    }

    public Order createOrder(String orderType,
            double orderAmount, double tax, double SH, double spainTax) {

        if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {///
            //System.out.println("una de California");      
            num++;
            return new CaliforniaOrder(orderAmount, tax, num);
        }
        if (orderType.equalsIgnoreCase(OrderManager.NON_CA_ORDER)) {
            num++;
            return new NonCaliforniaOrder(orderAmount, num);
        }
        if (orderType.equalsIgnoreCase(OrderManager.OVERSEAS_ORDER)) {
            num++;
            return new OverseasOrder(orderAmount, SH, num);
        }
        if (orderType.equalsIgnoreCase(OrderManager.COL_ORDER)) {
            num++;
            return new SpainOrder(orderAmount, spainTax, num);
        }

        return null;
    }

    /*public Order specificOrder(String id,OrderVisitor visitor) {
      return visitor.specificOrder(id, visitor);
  }*/
    public ButtonHandler() {
    }

    public ButtonHandler(OrderManager inObjOrderManager) {
        objOrderManager = inObjOrderManager;
    }

}
