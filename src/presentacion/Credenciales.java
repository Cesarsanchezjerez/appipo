package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Credenciales extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblHolaPedroRamrez;
	private JLabel lblImagen;
	private JLabel lblltimaConexin;
	private JLabel label;
	private JLabel lblPedroipocom;
	private JLabel lblHola;

	
	
	/**
	 * Create the dialog.
	 */
	public Credenciales() {
		setTitle("Login CORRECTO");
		setAlwaysOnTop(true);
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Credenciales.class.getResource("/recursos/icon.png")));
		setBounds(100, 100, 461, 419);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblHolaPedroRamrez = new JLabel("PEDRO RAMÍREZ");
			lblHolaPedroRamrez.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblHolaPedroRamrez.setBounds(169, 276, 95, 14);
			contentPanel.add(lblHolaPedroRamrez);
		}
		{
			lblImagen = new JLabel("");
			lblImagen.setIcon(new ImageIcon(Credenciales.class.getResource("/recursos/user.png")));
			lblImagen.setBounds(86, 0, 290, 265);
			contentPanel.add(lblImagen);
		}
		{
			lblltimaConexin = new JLabel("Última conexión:");
			lblltimaConexin.setBounds(74, 355, 105, 14);
			contentPanel.add(lblltimaConexin);
		}
		{
			label = new JLabel("16/06/2018");
			label.setBounds(169, 355, 64, 14);
			contentPanel.add(label);
		}
		{
			lblPedroipocom = new JLabel("pedro@IPO.com");
			lblPedroipocom.setBounds(169, 301, 95, 14);
			contentPanel.add(lblPedroipocom);
		}
		{
			lblHola = new JLabel("Hola!");
			lblHola.setBounds(113, 276, 46, 14);
			contentPanel.add(lblHola);
		}
	}
}
