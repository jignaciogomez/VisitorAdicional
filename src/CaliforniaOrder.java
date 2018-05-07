

public class CaliforniaOrder extends Order {
  private double orderAmount;
  private double additionalTax; 
  private double total;
  
  public CaliforniaOrder() {
  }
  public CaliforniaOrder(double inp_orderAmount,
      double inp_additionalTax, int num1) {
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
    num= num1;
    tipo="California";
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalTax() {
    return additionalTax;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
  
  public boolean  aceptarModificacion(OrderVisitor v, int num) {
    return v.visitarModificando(this,num); 
  }
  
  public double obtenerTotal(){
    System.out.println("El total de esta orden de tipo California es "+orderAmount+" + "+additionalTax+" = "+(orderAmount+additionalTax));
    //return orderAmount+additionalTax;
    return total; 
  }  
  public void setTotal(double to) {
    total=to;
  }
  
}



