package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField txtUser;
	private JTextField txtPass;
	private JButton btnConectar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("user");
				lblNewLabel.setBounds(60, 88, 61, 16);
				panel.add(lblNewLabel);
			}
			{
				lblPassword = new JLabel("password");
				lblPassword.setBounds(60, 130, 61, 16);
				panel.add(lblPassword);
			}
			{
				txtUser = new JTextField();
				txtUser.setBounds(150, 83, 130, 26);
				panel.add(txtUser);
				txtUser.setColumns(10);
			}
			{
				txtPass = new JTextField();
				txtPass.setBounds(150, 125, 130, 26);
				panel.add(txtPass);
				txtPass.setColumns(10);
			}
			{
				btnConectar = new JButton("Conectar");
				btnConectar.addActionListener(new BtnConectarActionListener());
				btnConectar.setBounds(150, 219, 117, 29);
				panel.add(btnConectar);
			}
		}
	}
	private class BtnConectarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			
			if(txtUser.getText().equals("perico") && txtPass.getText().equals("palote")) {
				
				frame.setVisible(false);
				App app = new App();
				app.main(null);
			}
		}
	}
}
