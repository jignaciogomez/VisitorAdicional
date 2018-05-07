

import java.util.*;

public class ManyOrders implements Iterator {
  //private Vector v;//no se necesita
  VisitorInterface ac;
  //String certificationType;
  Order nextOrder;
  Enumeration ec;


  public ManyOrders(VisitorInterface inp_ac
      /*String certType*/) {
    ac = inp_ac;
    //certificationType = certType;
    ec = inp_ac.getAllOrders().elements(); 
  }
  public boolean hasNext() {
    boolean matchFound = false;
    while (ec.hasMoreElements()) {
      Order tempObj = (Order) ec.nextElement();
      //if (tempObj.getCertificationType().equals(            certificationType)) {
        matchFound = true;
        nextOrder = tempObj;
        break;
      //}
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

 
  
  /*public void setData(Vector v){
      data=v;
  }
  public Vector getData(){
      return data;
  }*/
  

  /*private void initialize() {
   
    data = new Vector();
    //FileUtil util = new FileUtil();

    Vector dataLines = util.fileToVector("Candidates.txt");
    for (int i = 0; i < dataLines.size(); i++) {
      String str = (String) dataLines.elementAt(i);
      StringTokenizer st = new StringTokenizer(str, ",");
      data.add(
        new Candidate(st.nextToken(), st.nextToken(),
                      st.nextToken()));
    }
  }*/

  /*public boolean hasNext() {
    boolean matchFound = false;

    nextOrder = null;

    while (ec.hasMoreElements()) {
      Order tempObj = (Order) ec.nextElement();
      nextOrder = tempObj;
      break;
    }
    return (nextOrder != null);
  }

  public Object next() {
    if (nextOrder == null) {
      throw new NoSuchElementException();
    } else {
      return nextOrder;
    }
  }*/

  //public void remove() {};

}



