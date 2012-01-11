package startProgramm;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.plagiatorz.app.gui.LoginGUI;

/**
 * Programmstart, oeffnet das GUI
 * @author MARIUS
 *
 */
public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("Paketversand");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LoginGUI lo = new LoginGUI(frame, new JPanel());
		lo.displayContentPanel();
	}

}
