

public class SpainOrder extends Order {
  private double orderAmount;
  private double spainTax; 
  private double total;
  
  public SpainOrder() {
  }
  public SpainOrder(double inp_orderAmount,
      double inp_SpainTax, int num1) {
    orderAmount = inp_orderAmount;
    spainTax = inp_SpainTax;
    num= num1;
    tipo="Spain";
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getSpainTax() {
    return spainTax;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
  
  public boolean  aceptarModificacion(OrderVisitor v, int num) {
    return v.visitarModificando(this,num);  
  }
  
  public double obtenerTotal(){
    System.out.println("El total de esta orden de tipo Spain es "+orderAmount+" + "+spainTax+" = "+(orderAmount+spainTax));
    //return orderAmount+additionalTax;
    return total; 
  }  
  public void setTotal(double to) {
    total=to;
  }
  
}

