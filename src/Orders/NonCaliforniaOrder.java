package Orders;

public class NonCaliforniaOrder extends Order {
  private double orderAmount;
  private double total;  
  public NonCaliforniaOrder() {
  }
  public NonCaliforniaOrder(double inp_orderAmount, int numOrder) {
    orderAmount = inp_orderAmount;
    num= numOrder;
    tipo="NonCalifornia";
  }
  public double getOrderAmount() {
    return this.orderAmount;
  }
  public void setTotal(double totalValue) {
    this.total=totalValue;
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
    return this.total; 
  }
 
}


