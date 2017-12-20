package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Login2 {

	private JFrame Login2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login2 window = new Login2();
					window.Login2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Login2 = new JFrame();
		Login2.setBounds(100, 100, 450, 300);
		Login2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
