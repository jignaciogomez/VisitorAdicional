

import java.util.*;

class OrderVisitor implements VisitorInterface {
  private Vector orderObjList;//no se necesitaba
  //private double orderTotal;
  
  public Vector getAllOrders(){
      return orderObjList;
  }

  public OrderVisitor() {
    orderObjList = new Vector();//no se necesitaba
  }
  public void visit(NonCaliforniaOrder inp_order) {
    inp_order.setTotal(inp_order.getOrderAmount());
    //orderTotal = orderTotal + inp_order.getOrderAmount();
    orderObjList.add(inp_order); 
  }
  public void visit(CaliforniaOrder inp_order) {
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getAdditionalTax());//si se quitara esta línea no tendría gracia visitar la clase hija en vez de la clase abstracta (o interfaz)
    //orderTotal = orderTotal + inp_order.getOrderAmount()+inp_order.getAdditionalTax();
      orderObjList.add(inp_order); 
  }
  public void visit(SpainOrder inp_order) {
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getSpainTax());
      //orderTotal = orderTotal + inp_order.getOrderAmount()+inp_order.getSpainTax();
      orderObjList.add(inp_order); 
  }
  public void visit(OverseasOrder inp_order) {
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getAdditionalSH());
    //orderTotal = orderTotal + inp_order.getOrderAmount()+inp_order.getAdditionalSH();
      orderObjList.add(inp_order); 
  }
  
  public boolean visitarModificando(NonCaliforniaOrder inp_order, int num) { 
      inp_order.setTotal(inp_order.getOrderAmount());
      for (int i=0;i<orderObjList.size();i++ ){
          Order order=(Order)orderObjList.get(i);
          if (order.getNum()==num){
              if(inp_order.obtenerTotal()!=0){
                inp_order.setNum(num);
                System.out.println("Se va a modificar la orden "+i);
                //order.setTotal(((NonCaliforniaOrder)o2).getOrderAmount());              
                orderObjList.set(i, inp_order);
                return true;
              }else{
                    orderObjList.remove(i);
                    return true; 
              }
          }
      }
      return false; 
  }
    public boolean visitarModificando(CaliforniaOrder inp_order, int num) { 
        inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getAdditionalTax());
        for (int i=0;i<orderObjList.size();i++ ){
          Order order=(Order)orderObjList.get(i);
            if (order.getNum()==num){              
                if(inp_order.obtenerTotal()!=0){
                    inp_order.setNum(num);
                    //order.setTotal(((CaliforniaOrder)o2).getOrderAmount()+((CaliforniaOrder)o2).getAdditionalTax());              
                    System.out.println("Se va a modificar la orden "+i);
                    orderObjList.set(i, inp_order);
                    return true; 
                }else{
                    orderObjList.remove(i);
                    return true; 
                }
            }
        }
        return false; 
    }
  public boolean visitarModificando(OverseasOrder inp_order, int num) { 
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getAdditionalSH());
      for (int i=0;i<orderObjList.size();i++ ){
          Order order=(Order)orderObjList.get(i);
          if (order.getNum()==num){
              if(inp_order.obtenerTotal()!=0){              
                inp_order.setNum(num);
                //order.setTotal(((CaliforniaOrder)o2).getOrderAmount()+((CaliforniaOrder)o2).getAdditionalTax());  
                System.out.println("Se va a modificar la orden "+i);
                orderObjList.set(i, inp_order);
                return true; 
              }else{
                orderObjList.remove(i);
                return true; 
            }
          }
      }
      return false; 
  }
  public boolean visitarModificando(SpainOrder inp_order, int num) { 
      inp_order.setTotal(inp_order.getOrderAmount()+inp_order.getSpainTax());
      for (int i=0;i<orderObjList.size();i++ ){
          Order order=(Order)orderObjList.get(i);
          if (order.getNum()==num){
              if(inp_order.obtenerTotal()!=0){              
                inp_order.setNum(num);
                //order.setTotal(((CaliforniaOrder)o2).getOrderAmount()+((CaliforniaOrder)o2).getAdditionalTax());  
                System.out.println("Se va a modificar la orden "+i);
                orderObjList.set(i, inp_order);
                return true; 
              }else{
                orderObjList.remove(i);
                return true;  
              }
          }
      }
      return false; 
  }
  
  public double getOrderTotal() {
    double orderTotal=0; 
    
    for (int i=0;i<orderObjList.size();i++){
        Order order=(Order)orderObjList.get(i);
        //Class tipo_orden=order.getClass();
        //System.out.println("tipo de order:"+tipo_orden);
        orderTotal=orderTotal+order.obtenerTotal();
    }    
    return orderTotal;
  }
  
  public String obtenerOrdenes(){
      String cad="Num , Valor , Tipo\n";
      for (int i=0;i<orderObjList.size();i++ ){
          Order order=(Order)orderObjList.get(i);
          cad=cad+order.getNum()+" , "+order.obtenerTotal()+" , "+order.getTipo()+" \n";
      }
      return cad;
  }
  
  public Order specificOrder(String id,OrderVisitor visitor,String tipo) {
      for (int i=0;i<orderObjList.size();i++ ){
          Order order=(Order)orderObjList.get(i);
          if (order.getNum()==Integer.parseInt(id) && tipo.equals(order.getClass().toString())){//hay que arreglar esto
              return order; 
          }
      }
      return null;
  }
  
  public double getMaximoVal() {
    double mayor=0; 
    
    for (int i=0;i<orderObjList.size();i++){
        Order order=(Order)orderObjList.get(i);
        //Class tipo_orden=order.getClass();
        //System.out.println("tipo de order:"+tipo_orden);
        //orderTotal=orderTotal+order.obtenerTotal();
        if (order.obtenerTotal()>mayor){
            mayor=order.obtenerTotal();
        }
    }    
    return mayor;
  }
  
}
