package Orders;

import java.util.Enumeration;
import java.util.Vector;

public interface VisitorInterface {
  public void visit(NonCaliforniaOrder nco);
  public void visit(CaliforniaOrder co);
  public void visit(OverseasOrder oo);
  public void visit(ColombianOrder co);
  public Enumeration getAllOrders();
  public Order getSpecificOrder(int numOrder);
}
