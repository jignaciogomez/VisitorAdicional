package Orders;
import java.util.*;

public class AllOrders implements Iterator {
  VisitorInterface ac;
  Order nextOrder;
  Enumeration ec;

  public AllOrders(VisitorInterface inp_ac) {
    ac = inp_ac;
    ec = inp_ac.getAllOrders(); 
  }
  
  public boolean hasNext() {
    boolean matchFound = false;
    while (ec.hasMoreElements()) {
      Order tempObj = (Order) ec.nextElement();
        matchFound = true;
        nextOrder = tempObj;
        break;
    }
    if (matchFound == true) {
    } else {
      nextOrder = null;
    }
    return matchFound;
  }

  public Object next() {
    if (nextOrder == null) {
      throw new NoSuchElementException();
    } else {
      return nextOrder;
    }
  }

  public void remove() {};

}



