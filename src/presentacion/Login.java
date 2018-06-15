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

public class Login {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JTextField txtUser;
	private JButton btnConectar;
	private JPasswordField passwordField;
	private JLabel mensaje;

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
				lblNewLabel = new JLabel(Messages.getString("Login.lblNewLabel.text")); //$NON-NLS-1$
				lblNewLabel.setBounds(60, 88, 61, 16);
				panel.add(lblNewLabel);
			}
			{
				lblPassword = new JLabel(Messages.getString("Login.lblPassword.text")); //$NON-NLS-1$
				lblPassword.setBounds(60, 130, 61, 16);
				panel.add(lblPassword);
			}
			{
				txtUser = new JTextField();
				txtUser.addActionListener(new TxtUserActionListener());
				txtUser.setBounds(150, 83, 130, 26);
				panel.add(txtUser);
				txtUser.setColumns(10);
			}
			{
				btnConectar = new JButton(Messages.getString("Login.btnConectar.text")); //$NON-NLS-1$
				btnConectar.addActionListener(new BtnConectarActionListener());
				btnConectar.setBounds(150, 219, 117, 29);
				panel.add(btnConectar);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setEnabled(false);
				passwordField.setBounds(150, 125, 130, 26);
				panel.add(passwordField);
			}
			{
				mensaje = new JLabel(); //$NON-NLS-1$
				mensaje.setForeground(Color.RED);
				mensaje.setBounds(150, 177, 211, 16);
				panel.add(mensaje);
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
	private class TxtUserActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			passwordField.setEnabled(true);
			passwordField.requestFocus();
			
		}
	}
}
