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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Credenciales extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblHolaPedroRamrez;
	private JLabel lblImagen;
	private JLabel lblltimaConexin;
	private JLabel label;
	private JLabel lblPedroipocom;
	private JLabel lblHola;
	private JPanel panel;
	private JButton btnAceptar;

	
	
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
			lblHolaPedroRamrez.setBounds(183, 276, 95, 14);
			contentPanel.add(lblHolaPedroRamrez);
		}
		{
			lblImagen = new JLabel("");
			lblImagen.setIcon(new ImageIcon(Credenciales.class.getResource("/recursos/user.png")));
			lblImagen.setBounds(100, 0, 290, 265);
			contentPanel.add(lblImagen);
		}
		{
			lblltimaConexin = new JLabel("Última conexión:");
			lblltimaConexin.setBounds(88, 326, 105, 14);
			contentPanel.add(lblltimaConexin);
		}
		{
			label = new JLabel("16/06/2018");
			label.setBounds(199, 326, 64, 14);
			contentPanel.add(label);
		}
		{
			lblPedroipocom = new JLabel("pedro@IPO.com");
			lblPedroipocom.setBounds(183, 301, 95, 14);
			contentPanel.add(lblPedroipocom);
		}
		{
			lblHola = new JLabel("Hola!");
			lblHola.setBounds(127, 276, 46, 14);
			contentPanel.add(lblHola);
		}
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			getContentPane().add(panel, BorderLayout.SOUTH);
			{
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{453, 0, 0};
				gbl_panel.rowHeights = new int[]{23, 0};
				gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
			}
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setHorizontalAlignment(SwingConstants.RIGHT);
			btnAceptar.addActionListener(new BtnAceptarActionListener());
			GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
			gbc_btnAceptar.anchor = GridBagConstraints.EAST;
			gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
			gbc_btnAceptar.fill = GridBagConstraints.VERTICAL;
			gbc_btnAceptar.gridx = 0;
			gbc_btnAceptar.gridy = 0;
			panel.add(btnAceptar, gbc_btnAceptar);
		}
	}
	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
