

public class NonCaliforniaOrder extends Order {
  private double orderAmount;
  private double total;  
  public NonCaliforniaOrder() {
  }
  public NonCaliforniaOrder(double inp_orderAmount, int num1) {
    orderAmount = inp_orderAmount;
    num= num1;
    tipo="NonCalifornia";
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
  public boolean  aceptarModificacion(OrderVisitor v, int num) {
    return v.visitarModificando(this,num); 
  }
  public double obtenerTotal(){
    System.out.println("El total de esta orden de tipo NonCalifornia es "+orderAmount);
    //return orderAmount;
      return total; 
  }
  public void setTotal(double to) {
    total=to;
  }
 
}


