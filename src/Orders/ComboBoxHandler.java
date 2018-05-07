/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;

/**
 *
 * @author Luisao
 */
class ComboBoxHandler implements ItemListener {

    OrderManager manager;
    UIBuilder builder;

    @Override
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            Object item = event.getItem();
            String tipo = manager.getOrderType();

            BuiderFactory factory = new BuiderFactory();
            builder = factory.getUIBuilder(tipo);
            UIDirector director = new UIDirector(builder);   
            
            director.build();
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