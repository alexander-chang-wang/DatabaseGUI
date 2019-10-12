/**
 * Run the GUI
 */
import javax.swing.JFrame;
import gui.MainWindow;

public class Run {

	/* main method */
	public static void main(String[] ags) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}
	
	/* run the GUI method */
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new MainWindow();
	}
}
