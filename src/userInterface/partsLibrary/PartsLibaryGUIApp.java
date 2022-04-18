/**
 * 
 */
package userInterface.partsLibrary;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author lekar
 *
 */
public class PartsLibaryGUIApp {

	/**
	 * @param args
	 *            Inputs from other application.
	 */
	public static void main(String[] args) {
		Runnable guiRun = new Runnable() {
			public void run() {
				partsLibrary.Parts model = new partsLibrary.Parts(1, 1, "a",
						"b", "c", 0, 0);
				JFrame jf = new PartsWinGUI(model);
				jf.setTitle("Parts Library GUI");
				System.out.printf("Images %s%n", jf.getIconImages());
				jf.pack();
				jf.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(guiRun);
	}
}
