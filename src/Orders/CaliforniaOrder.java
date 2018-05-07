package Orders;

public class CaliforniaOrder extends Order {
  private double orderAmount;
  private double additionalTax; 
  private double total;
  
  public CaliforniaOrder() {
  }
  public CaliforniaOrder(double inp_orderAmount,
      double inp_additionalTax, int numOrder) {
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
    num= numOrder;
    tipo="California";
  }
  public double getOrderAmount() {
    return this.orderAmount;
  }
  public double getAdditionalTax() {
    return this.additionalTax;
  }
  @Override
  public void setTotal(double totalValue) {
    this.total=totalValue;
  }
  
  @Override
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
  
  @Override
  public boolean  aceptarModificacion(OrderVisitor v, int num) {
    return v.visitarModificando(this,num); 
  }
  
  @Override
  public double obtenerTotal(){
    System.out.println("El total de esta orden de tipo California es "+orderAmount+" + "+additionalTax+" = "+(orderAmount+additionalTax));
    //return orderAmount+additionalTax;
    return this.total; 
  }  
}



