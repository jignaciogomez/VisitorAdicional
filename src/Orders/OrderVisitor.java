package Orders;

import java.util.*;

class OrderVisitor implements VisitorInterface{
  private Enumeration orderObjList;
  private Vector ordeObjVector;
  
  public Enumeration getAllOrders(){
      return ordeObjVector.elements();
  }

  public OrderVisitor() {
    ordeObjVector = new Vector();
  }
 
  public void visit(NonCaliforniaOrder inp_order) {
    inp_order.setTotal(inp_order.getOrderAmount());
     ordeObjVector.add(inp_order);
  }
  public void visit(CaliforniaOrder inp_order) {
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getAdditionalTax());
      ordeObjVector.add(inp_order);
  }
  public void visit(ColombianOrder inp_order) {
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getIvaTax()); 
      ordeObjVector.add(inp_order);
  }
  public void visit(OverseasOrder inp_order) {
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getAdditionalSH());
      ordeObjVector.add(inp_order);
  }
  
  public double getOrderTotal() {
    double orderTotal=0; 
    Iterator allOrdersObj = new AllOrders(this);
    
    while(allOrdersObj.hasNext())
    {
        Order tempObj = (Order) allOrdersObj.next();
        orderTotal=orderTotal+tempObj.obtenerTotal();
    }  
    return orderTotal;
  }
  
  public Order getSpecificOrder(int numOrder){
    Iterator allOrdersObj = new AllOrders(this);
    
    while(allOrdersObj.hasNext())
    {
        Order tempObj = (Order) allOrdersObj.next();
        if (tempObj.getNum()==numOrder)
        {
            return tempObj;
        }
    }  
      return null;
  }
  
}
