package Orders;

public class ColombianOrder extends Order {
  private double orderAmount;
  private double IvaTax; 
  private double total;
  
  public ColombianOrder() {
  }
  public ColombianOrder(double inp_orderAmount,
      double inp_IvaTax, int numOrder) {
    orderAmount = inp_orderAmount;
    IvaTax = inp_IvaTax;
    num= numOrder;
    tipo="Colombian";
  }
  public double getOrderAmount() {
    return this.orderAmount;
  }
  public double getIvaTax() {
    return this.IvaTax;
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
    System.out.println("El total de esta orden de tipo Colombia es "+orderAmount+" + "+ IvaTax+" = "+(orderAmount+IvaTax));
    //return orderAmount+additionalTax;
    return this.total; 
  }  
}

