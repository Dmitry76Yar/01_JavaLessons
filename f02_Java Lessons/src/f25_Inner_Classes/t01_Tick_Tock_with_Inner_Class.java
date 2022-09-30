package f25_Inner_Classes;

/*An inner class automatically has access to all the fields and methods of the outer class, even to private fields and methods.
  Thus an inner class has more access to its outer class than a subclass has to its superclass. (A subclass can access public and
  protected members of its superclass, but not private members.) 
*/

import java.awt.event.*;
import javax.swing.*;

public class t01_Tick_Tock_with_Inner_Class {
	
	private String tickMessage = "Tick...";
	private String tockMessage = "Tock...";
	
	private void go() {
		// create a timer that calls the Ticker class at one second intervals
	Timer t = new Timer(1000, new Ticker());
	t.start();
		// display a message box to prevent the program from ending immediately
	JOptionPane.showMessageDialog(null, "Click OK to exit program");
	System.exit(0);
	}
	
	class Ticker implements ActionListener {
		private boolean tick = true;
		public void actionPerformed(ActionEvent event) {
			if (tick)	System.out.println(tickMessage);
			else 		System.out.println(tockMessage); 
			tick = !tick;
		}
	}
	
public static void main(String[] args) {
	t01_Tick_Tock_with_Inner_Class t = new t01_Tick_Tock_with_Inner_Class();
	t.go();
    }
}
        
        
  