package Orders;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jigna
 */
public class BuiderFactory {

    public UIBuilder getUIBuilder(String str) {
        UIBuilder builder = null;
        if (str.equals(OrderManager.CA_ORDER)) {
            builder = new CaliforniaBuilder();
        } else if (str.equals(OrderManager.NON_CA_ORDER)) {
            builder = new NonCaliforniaBuilder();
        } else if (str.equals(OrderManager.OVERSEAS_ORDER)) {
            builder = new OverseasBuilder();
        } else if (str.equals(OrderManager.COL_ORDER)) {
            builder = new ColBuilder();
        }

        return builder;
    }
}
