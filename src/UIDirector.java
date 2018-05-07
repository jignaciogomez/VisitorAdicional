/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author jigna
 */
public class UIDirector {
  private UIBuilder builder;

  public UIDirector(UIBuilder bldr) {
    builder = bldr;
  }
  public void build() {
    builder.AgregarNuevosControles();    
  }

}
