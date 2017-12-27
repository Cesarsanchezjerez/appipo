package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnLogin;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JTextField textUsuario;
	private JPasswordField passwordField;

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 261);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			contentPanel.setLayout(null);
		}
		{
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new BtnLoginActionListener());
			btnLogin.setBounds(93, 160, 228, 23);
			contentPanel.add(btnLogin);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(93, 81, 46, 14);
			contentPanel.add(lblUsuario);
		}
		{
			lblContraseña = new JLabel("Contraseña");
			lblContraseña.setBounds(93, 112, 56, 14);
			contentPanel.add(lblContraseña);
		}
		{
			textUsuario = new JTextField();
			textUsuario.setBounds(159, 78, 162, 20);
			contentPanel.add(textUsuario);
			textUsuario.setColumns(10);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(159, 109, 162, 20);
			contentPanel.add(passwordField);
		}
	}
	private class BtnLoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			App.main(null);
		}
		
	}
}
