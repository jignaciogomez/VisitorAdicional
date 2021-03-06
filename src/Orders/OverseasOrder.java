package Orders;

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
    return this.orderAmount;
  }
  public double getAdditionalSH() {
    return this.additionalSH;
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
  public double obtenerTotal(){
    return this.total; 
  }
}
