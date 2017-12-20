package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {
	private String contraseña="contraseña";
	private JPanel contentPane;
	private JPanel panellogin;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JButton btnConectar;
	private JPasswordField pwdContrasea;
	private JLabel lblAviso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panellogin = new JPanel();
			contentPane.add(panellogin, BorderLayout.CENTER);
			GridBagLayout gbl_panellogin = new GridBagLayout();
			gbl_panellogin.columnWidths = new int[] {0, 84, 0, 0, 89, 72, 0, 70, 98, 30, 0, 0};
			gbl_panellogin.rowHeights = new int[] {109, 0, 0, 0, 0, 76, 0, 0, 0, 0, 62, 0, 0};
			gbl_panellogin.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
			gbl_panellogin.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panellogin.setLayout(gbl_panellogin);
			{
				lblUsuario = new JLabel("usuario");
				GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
				gbc_lblUsuario.anchor = GridBagConstraints.EAST;
				gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
				gbc_lblUsuario.gridx = 3;
				gbc_lblUsuario.gridy = 1;
				panellogin.add(lblUsuario, gbc_lblUsuario);
			}
			{
				txtUsuario = new JTextField();
				GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
				gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
				gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtUsuario.gridx = 4;
				gbc_txtUsuario.gridy = 1;
				panellogin.add(txtUsuario, gbc_txtUsuario);
				txtUsuario.setColumns(10);
			}
			{
				lblContrasea = new JLabel("contraseña");
				GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
				gbc_lblContrasea.anchor = GridBagConstraints.EAST;
				gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
				gbc_lblContrasea.gridx = 3;
					gbc_lblContrasea.gridy = 2;
				panellogin.add(lblContrasea, gbc_lblContrasea);
			}
			{
				pwdContrasea = new JPasswordField();
				GridBagConstraints gbc_pwdContrasea = new GridBagConstraints();
				gbc_pwdContrasea.insets = new Insets(0, 0, 5, 5);
				gbc_pwdContrasea.fill = GridBagConstraints.HORIZONTAL;
				gbc_pwdContrasea.gridx = 4;
				gbc_pwdContrasea.gridy = 2;
				panellogin.add(pwdContrasea, gbc_pwdContrasea);
			}
			{
				btnConectar = new JButton("conectar");
				btnConectar.addActionListener(new BtnConectarActionListener());
				GridBagConstraints gbc_btnConectar = new GridBagConstraints();
				gbc_btnConectar.anchor = GridBagConstraints.NORTH;
				gbc_btnConectar.insets = new Insets(0, 0, 5, 5);
				gbc_btnConectar.gridx = 4;
				gbc_btnConectar.gridy = 4;
				panellogin.add(btnConectar, gbc_btnConectar);
			}
			{
				lblAviso = new JLabel("");
				GridBagConstraints gbc_lblAviso = new GridBagConstraints();
				gbc_lblAviso.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblAviso.gridwidth = 4;
				gbc_lblAviso.insets = new Insets(0, 0, 5, 5);
				gbc_lblAviso.gridx = 1;
				gbc_lblAviso.gridy = 9;
				panellogin.add(lblAviso, gbc_lblAviso);
			}
		}
	}

	private class BtnConectarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (String.valueOf(pwdContrasea.getPassword()).equals(contraseña)) {
				lblAviso.setBackground(Color.GREEN); lblAviso.setText("Contraseña correcta. Puede entrar"); lblAviso.setVisible(true); 
				contentPane.setVisible(false); //pongo lo de dentro del jpanel vacio..... casi pero no XD
				
				app app=new app();// crea la ventana nueva pero dudo que sea asin sobre todo x lo de abajo a null
				app.main(null);
				
				} else {
				lblAviso.setBackground(Color.RED); lblAviso.setText("Contraseña incorrecta. Vuelva a intentarlo"); lblAviso.setVisible(true);
				
				}
			
		}
	}
}
