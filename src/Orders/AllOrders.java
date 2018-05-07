package Orders;
import java.util.*;

public class AllOrders implements Iterator {
  VisitorInterface ac;
  Order nextOrder;
  Enumeration ecOrders;

  public AllOrders(VisitorInterface inp_ac) {
    ac = inp_ac;
    ecOrders = inp_ac.getAllOrders(); 
  }

    public AllOrders() {
        
    }
  
  public boolean hasNext() {
    boolean matchFound = false;
    while (ecOrders.hasMoreElements()) {
      Order tempObj = (Order) ecOrders.nextElement();
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



