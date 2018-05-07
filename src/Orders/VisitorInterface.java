package Orders;

import java.util.Enumeration;
import java.util.Vector;

public interface VisitorInterface {
  public void visit(NonCaliforniaOrder nco);
  public void visit(CaliforniaOrder co);
  public void visit(OverseasOrder oo);
  public void visit(ColombianOrder co);
  public boolean visitarModificando(NonCaliforniaOrder nco, int num);
  public boolean visitarModificando(CaliforniaOrder co, int num );
  public boolean visitarModificando(OverseasOrder oo, int num );
  public boolean visitarModificando(ColombianOrder co, int num );
  public Enumeration getAllOrders();
  //public Order specificOrder(S)//hay que arreglar esto
}
