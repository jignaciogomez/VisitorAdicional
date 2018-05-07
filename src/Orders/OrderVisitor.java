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
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getAdditionalTax());//si se quitara esta línea no tendría gracia visitar la clase hija en vez de la clase abstracta (o interfaz)
    //orderTotal = orderTotal + inp_order.getOrderAmount()+inp_order.getAdditionalTax();
      ordeObjVector.add(inp_order); 
  }
  public void visit(ColombianOrder inp_order) {
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getIvaTax());
      ordeObjVector.add(inp_order); 
  }
  public void visit(OverseasOrder inp_order) {
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getAdditionalSH());
    //orderTotal = orderTotal + inp_order.getOrderAmount()+inp_order.getAdditionalSH();
      ordeObjVector.add(inp_order); 
  }
  
  @Override
  public boolean visitarModificando(NonCaliforniaOrder inp_order, int num) { 
      inp_order.setTotal(inp_order.getOrderAmount());
      for (int i=0;i<ordeObjVector.size();i++ ){
          Order order=(Order)ordeObjVector.get(i);
          if (order.getNum()==num){
              if(inp_order.obtenerTotal()!=0){
                inp_order.setNum(num);
                System.out.println("Se va a modificar la orden "+i);
                //order.setTotal(((NonCaliforniaOrder)o2).getOrderAmount());              
                ordeObjVector.set(i, inp_order);
                return true;
              }else{
                    ordeObjVector.remove(i);
                    return true; 
              }
          }
      }
      return false; 
  }
  @Override
  public boolean visitarModificando(CaliforniaOrder inp_order, int num) { 
        inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getAdditionalTax());
        for (int i=0;i<ordeObjVector.size();i++ ){
          Order order=(Order)ordeObjVector.get(i);
            if (order.getNum()==num){              
                if(inp_order.obtenerTotal()!=0){
                    inp_order.setNum(num);
                    //order.setTotal(((CaliforniaOrder)o2).getOrderAmount()+((CaliforniaOrder)o2).getAdditionalTax());              
                    System.out.println("Se va a modificar la orden "+i);
                    ordeObjVector.set(i, inp_order);
                    return true; 
                }else{
                    ordeObjVector.remove(i);
                    return true; 
                }
            }
        }
        return false; 
    }
  @Override
  public boolean visitarModificando(OverseasOrder inp_order, int num) { 
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getAdditionalSH());
      for (int i=0;i<ordeObjVector.size();i++ ){
          Order order=(Order)ordeObjVector.get(i);
          if (order.getNum()==num){
              if(inp_order.obtenerTotal()!=0){              
                inp_order.setNum(num);
                //order.setTotal(((CaliforniaOrder)o2).getOrderAmount()+((CaliforniaOrder)o2).getAdditionalTax());  
                System.out.println("Se va a modificar la orden "+i);
                ordeObjVector.set(i, inp_order);
                return true; 
              }else{
                ordeObjVector.remove(i);
                return true; 
            }
          }
      }
      return false; 
  }
  @Override
  public boolean visitarModificando(ColombianOrder inp_order, int num) { 
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getIvaTax());
      for (int i=0;i<ordeObjVector.size();i++ ){
          Order order=(Order)ordeObjVector.get(i);
          if (order.getNum()==num){
              if(inp_order.obtenerTotal()!=0){              
                inp_order.setNum(num);
                //order.setTotal(((CaliforniaOrder)o2).getOrderAmount()+((CaliforniaOrder)o2).getAdditionalTax());  
                System.out.println("Se va a modificar la orden "+i);
                ordeObjVector.set(i, inp_order);
                return true; 
              }else{
                ordeObjVector.remove(i);
                return true;  
              }
          }
      }
      return false; 
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
  
  public String obtenerOrdenes(){
      String cad="Num , Valor , Tipo\n";
      for (int i=0;i<ordeObjVector.size();i++ ){
          Order order=(Order)ordeObjVector.get(i);
          cad=cad+order.getNum()+" , "+order.obtenerTotal()+" , "+order.getTipo()+" \n";
      }
      return cad;
  }
  
  public Order specificOrder(String id,OrderVisitor visitor,String tipo) {
      for (int i=0;i<ordeObjVector.size();i++ ){
          Order order=(Order)ordeObjVector.get(i);
          if (order.getNum()==Integer.parseInt(id) && tipo.equals(order.getClass().toString())){//hay que arreglar esto
              return order; 
          }
      }
      return null;
  }
  
  
}
