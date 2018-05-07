

public class OverseasOrder extends Order {
  private double orderAmount;
  private double additionalSH;
  private double total;
  
  public OverseasOrder() {
  }
  public OverseasOrder(double inp_orderAmount,
      double inp_additionalSH, int num1) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
    num= num1;
    tipo="Overseas";
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
  public boolean  aceptarModificacion(OrderVisitor v, int num) {
    return v.visitarModificando(this,num); 
  }
  public double obtenerTotal(){
    System.out.println("El total de esta orden de tipo Overseas es "+orderAmount+" + "+additionalSH+" = "+(orderAmount+additionalSH));
    //return orderAmount+additionalSH;
    return total; 
  }
  
  public void setTotal(double to) {
    total=to;
  }
}
