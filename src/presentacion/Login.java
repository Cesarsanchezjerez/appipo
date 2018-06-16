package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField txtUser;
	private JButton btnConectar;
	private JPasswordField passwordField;
	private JLabel mensaje;
	private JLabel label;

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/recursos/guinea-pig-heag.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel(Messages.getString("Login.lblNewLabel.text")); //$NON-NLS-1$
				lblNewLabel.setBounds(38, 236, 61, 16);
				panel.add(lblNewLabel);
			}
			{
				lblPassword = new JLabel(Messages.getString("Login.lblPassword.text")); //$NON-NLS-1$
				lblPassword.setBounds(38, 278, 61, 16);
				panel.add(lblPassword);
			}
			{
				txtUser = new JTextField();
				txtUser.setBounds(128, 231, 130, 26);
				panel.add(txtUser);
				txtUser.setColumns(10);
			}
			{
				btnConectar = new JButton(Messages.getString("Login.btnConectar.text")); //$NON-NLS-1$
				btnConectar.addActionListener(new BtnConectarActionListener());
				btnConectar.setBounds(128, 331, 117, 29);
				panel.add(btnConectar);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setBounds(128, 273, 130, 26);
				panel.add(passwordField);
			}
			{
				mensaje = new JLabel(); //$NON-NLS-1$
				mensaje.setForeground(Color.RED);
				mensaje.setBounds(113, 310, 211, 16);
				panel.add(mensaje);
			}
			{
				label = new JLabel(); 
				label.setIcon(new ImageIcon(Login.class.getResource("/recursos/240px-LogoUCLM.svg.png")));
				label.setBounds(73, 0, 251, 227);
				panel.add(label);
			}
		}
	}
	private class BtnConectarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			
			if(txtUser.getText().equals("Pedro") && passwordField.getText().equals("Cesar")) {
				
				frame.setVisible(false);
				
				App.main(null);
			}else {
				mensaje.setText("usuario o contraseña erronea");
			}
		}
	}
}
