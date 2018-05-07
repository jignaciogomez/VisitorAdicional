package Orders;

public class ColombianOrder extends Order {
  private double orderAmount;
  private double spainTax; 
  private double total;
  
  public ColombianOrder() {
  }
  public ColombianOrder(double inp_orderAmount,
      double inp_SpainTax, int numOrder) {
    orderAmount = inp_orderAmount;
    spainTax = inp_SpainTax;
    num= numOrder;
    tipo="Colombian";
  }
  public double getOrderAmount() {
    return this.orderAmount;
  }
  public double getSpainTax() {
    return this.spainTax;
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
    System.out.println("El total de esta orden de tipo Spain es "+orderAmount+" + "+spainTax+" = "+(orderAmount+spainTax));
    //return orderAmount+additionalTax;
    return this.total; 
  }  
}

