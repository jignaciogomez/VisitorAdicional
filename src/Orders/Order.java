package Orders;

public abstract class Order {
    
  protected int num;
  protected String tipo;

  public abstract void accept(OrderVisitor v);
  
 // public abstract boolean aceptarModificacion(OrderVisitor v, int num);          
          
  public abstract double obtenerTotal();
  
  public abstract void setTotal(double totalValue) ;
  
  public int getNum() {
    return num;
  }
  public void setNum(int n) {
    num=n;
  }
  public String getTipo() {
    return tipo;
  }
  
}