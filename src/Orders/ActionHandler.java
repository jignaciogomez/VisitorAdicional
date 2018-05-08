/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Luisao
 */
class ActionHandler implements ActionListener {

    OrderManager objOrderManager;
    static int numOrder = 0;
    UIBuilder builder;

    public void actionPerformed(ActionEvent e) {
        String totalResult = null;

        if (e.getActionCommand().equals(OrderManager.EXIT)) {
            System.exit(1);
        }
        if (e.getActionCommand().equals(OrderManager.CLEAR)) {
            objOrderManager.clear();
        }
        if (e.getSource() == objOrderManager.getSearchTypeCtrl()) {
            String tipo = objOrderManager.getOrderType();

            BuiderFactory factory = new BuiderFactory();
            builder = factory.getUIBuilder(tipo);
            UIDirector director = new UIDirector(builder);

            director.build();
            JPanel UIObj = builder.getNuevoPanel();
            objOrderManager.MostarNuevaUI(UIObj);
        }
        if (e.getActionCommand().equals(OrderManager.FIND_ORDER)) {

            OrderVisitor visitor = objOrderManager.getOrderVisitor();
            Order objTemOrder = visitor.getSpecificOrder(Integer.parseInt(objOrderManager.getId()));
            if (objTemOrder == null) {
                objOrderManager.setResultOrder("order not found");
            } else {

                objOrderManager.setResultOrder("Result: Type= " + objTemOrder.getTipo() + " Total= " + objTemOrder.obtenerTotal());
            }
        }
        if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) // || e.getActionCommand().equals(OrderManager.CHANGE_ORDER)) {
        {
            String orderType = objOrderManager.getOrderType();///
            String strOrderAmount = objOrderManager.getOrderAmount();

            double dblOrderAmount = 0.0;

            if (strOrderAmount.trim().length() == 0) {
                strOrderAmount = "0.0";
            }

            dblOrderAmount = Double.parseDouble(strOrderAmount);

            ////Get the Visitor  
            OrderVisitor visitor = objOrderManager.getOrderVisitor();//

            if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
                ////Create the order
                Order order = createOrder(orderType, dblOrderAmount);///            

                //// accept the visitor instance
                order.accept(visitor);//

                objOrderManager.setTotalValue("Orden Creada con el Id: " + String.valueOf(numOrder));
            }
        }

        if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
            //Get the Visitor
            OrderVisitor visitor = objOrderManager.getOrderVisitor();
            //Get total from all orders
            totalResult = Double.toString(visitor.getOrderTotal());
            totalResult = " Orders Total = " + totalResult;
            objOrderManager.setTotalValue(totalResult);
        }
    }

    public Order createOrder(String orderType, double orderAmount) {

        if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
            numOrder++;
            int tax = builder.getValorAdicional();
            return new CaliforniaOrder(orderAmount, tax, numOrder);
        }
        if (orderType.equalsIgnoreCase(OrderManager.NON_CA_ORDER)) {
            numOrder++;
            return new NonCaliforniaOrder(orderAmount, numOrder);
        }
        if (orderType.equalsIgnoreCase(OrderManager.OVERSEAS_ORDER)) {
            numOrder++;
            int SH = builder.getValorAdicional();
            return new OverseasOrder(orderAmount, SH, numOrder);
        }
        if (orderType.equalsIgnoreCase(OrderManager.COL_ORDER)) {
            numOrder++;
            int IVATax = builder.getValorAdicional();
            return new ColombianOrder(orderAmount, IVATax, numOrder);
        }

        return null;
    }

    public ActionHandler() {
    }

    public ActionHandler(OrderManager inObjOrderManager) {
        objOrderManager = inObjOrderManager;
    }

}
