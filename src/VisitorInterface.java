

import java.util.Vector;

public interface VisitorInterface {
  public void visit(NonCaliforniaOrder nco);
  public void visit(CaliforniaOrder co);
  public void visit(OverseasOrder oo);
  public void visit(SpainOrder oo);
  public boolean visitarModificando(NonCaliforniaOrder nco, int num);
  public boolean visitarModificando(CaliforniaOrder co, int num );
  public boolean visitarModificando(OverseasOrder oo, int num );
  public boolean visitarModificando(SpainOrder oo, int num );
  public Vector getAllOrders();
  //public Order specificOrder(S)//hay que arreglar esto
}
