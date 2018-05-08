package Orders;

import javax.swing.JPanel;

/** 
 *
 * @author jigna
 */
public abstract class UIBuilder {
	protected JPanel nuevoPanel;

	public abstract void AgregarNuevosControles();
        public abstract int getValorAdicional();
	        
        public JPanel getNuevoPanel(){
            return nuevoPanel;
        }
}
