/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luisao
 */
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

            double dblOrderAmount = 0.0;
            double dblTax = 0.0;
            double dblSH = 0.0;
            double dblIVATax = 0.0;

//            if (strOrderAmount.trim().length() == 0) {
//                strOrderAmount = "0.0";
//            }
//            if (strTax.trim().length() == 0) {
//                strTax = "0.0";
//            }
//            if (strSH.trim().length() == 0) {
//                strSH = "0.0";
//            }
//            if (strIVATax.trim().length() == 0) {
//                strIVATax = "0.0";
//            }

            dblOrderAmount = Double.parseDouble(strOrderAmount);
//            dblTax = new Double(strTax).doubleValue();
//            dblSH = new Double(strSH).doubleValue();///
//            dblIVATax = new Double(strIVATax).doubleValue();///

            ////Get the Visitor  
            OrderVisitor visitor = objOrderManager.getOrderVisitor();//

            if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
                ////Create the order
                Order order = createOrder(orderType, dblOrderAmount, dblTax, dblSH, dblIVATax);///            

                //// accept the visitor instance
                order.accept(visitor);//

                objOrderManager.setTotalValue(" Order Created Successfully");
                //objOrderManager.setMaxValue(" .");
            }

            if (e.getActionCommand().equals(OrderManager.CHANGE_ORDER)) {
                String strId = objOrderManager.getId();//se obtiene el Id del objeto que se va a modificar
                System.out.println("se va a modificar la orden con id " + strId);
                if (strId.trim().length() == 0) {
                    strId = "0";
                }
                Order newOrder = createOrder(orderType, dblOrderAmount, dblTax, dblSH, dblIVATax);///  
                
                //Order order = visitor.specificOrder(strId, visitor,orderType );  
                System.out.println("Se ha creado una orden de tipo " + orderType + ". " + newOrder.getClass().toString());
                boolean updated = newOrder.aceptarModificacion(visitor, Integer.parseInt(strId));//  

                if (updated) {
                    objOrderManager.setTotalValue(" The list was updated.");
                } else {
                    objOrderManager.setTotalValue(" The order was not found.");
                }
            }
            objOrderManager.setOrdenes(visitor.obtenerOrdenes());
            //objOrderManager.getTaOrdenes().setCaretPosition(objOrderManager.getTaOrdenes().getDocument().getLength() - 1);
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

    public Order createOrder(String orderType,
            double orderAmount, double tax, double SH, double IVATax) {

        if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {  
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
            return new ColombianOrder(orderAmount, IVATax, num);
        }

        return null;
    }

    public ButtonHandler() {
    }

    public ButtonHandler(OrderManager inObjOrderManager) {
        objOrderManager = inObjOrderManager;
    }

}
