package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import dominio.Persona;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class DialogoPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtEmail;
	private JLabel lblNewLabel;
	private JLabel lblAviso;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public DialogoPersona(Persona persona) {
		setResizable(false);
		setBounds(100, 100, 473, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 25, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel(Messages.getString("DialogoPersona.lblNombre.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 2;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			txtNombre = new JTextField();
			
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.gridwidth = 2;
			gbc_txtNombre.anchor = GridBagConstraints.SOUTH;
			gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
			gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNombre.gridx = 2;
			gbc_txtNombre.gridy = 2;
			contentPanel.add(txtNombre, gbc_txtNombre);
			txtNombre.setColumns(10);
		}
		{
			lblNewLabel = new JLabel(); //$NON-NLS-1$
			lblNewLabel.setIcon(new ImageIcon(DialogoPersona.class.getResource("/recursos/descarga.png")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridheight = 5;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.gridx = 5;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblDni = new JLabel(Messages.getString("DialogoPersona.lblDni.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblDni = new GridBagConstraints();
			gbc_lblDni.anchor = GridBagConstraints.EAST;
			gbc_lblDni.insets = new Insets(0, 0, 5, 5);
			gbc_lblDni.gridx = 1;
			gbc_lblDni.gridy = 3;
			contentPanel.add(lblDni, gbc_lblDni);
		}
		{
			
			MaskFormatter formatoDNI;
			try {
			formatoDNI = new MaskFormatter("########'-U"); 
			formatoDNI.setPlaceholderCharacter('X'); 
			txtDni = new JFormattedTextField(formatoDNI);
			txtDni.setToolTipText(Messages.getString("DialogoPersona.txtDni.toolTipText")); //$NON-NLS-1$
			} catch (ParseException e) {
			    // TODO Auto-generated catch block
			e.printStackTrace(); }
			
			GridBagConstraints gbc_txtDni = new GridBagConstraints();
			gbc_txtDni.gridwidth = 2;
			gbc_txtDni.insets = new Insets(0, 0, 5, 5);
			gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDni.gridx = 2;
			gbc_txtDni.gridy = 3;
			contentPanel.add(txtDni, gbc_txtDni);
			txtDni.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel(Messages.getString("DialogoPersona.lblEmail.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.gridx = 1;
			gbc_lblEmail.gridy = 4;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			txtEmail = new JTextField();
			
			GridBagConstraints gbc_txtEmail = new GridBagConstraints();
			gbc_txtEmail.gridwidth = 2;
			gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
			gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEmail.gridx = 2;
			gbc_txtEmail.gridy = 4;
			contentPanel.add(txtEmail, gbc_txtEmail);
			txtEmail.setColumns(10);
		}
		{
			JButton btnElegirImagen = new JButton(Messages.getString("DialogoPersona.btnElegirImagen.text")); //$NON-NLS-1$
			btnElegirImagen.addActionListener(new BtnElegirImagenActionListener());
			GridBagConstraints gbc_btnElegirImagen = new GridBagConstraints();
			gbc_btnElegirImagen.anchor = GridBagConstraints.EAST;
			gbc_btnElegirImagen.gridx = 5;
			gbc_btnElegirImagen.gridy = 6;
			contentPanel.add(btnElegirImagen, gbc_btnElegirImagen);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton(Messages.getString("DialogoPersona.okButton.text")); //$NON-NLS-1$
				okButton.addActionListener(new OkButtonActionListener(persona));
				{
					lblAviso = new JLabel(); //$NON-NLS-1$
					lblAviso.setForeground(Color.RED);
					buttonPane.add(lblAviso);
				}
				okButton.setActionCommand(Messages.getString("DialogoPersona.okButton.actionCommand")); //$NON-NLS-1$
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton(Messages.getString("DialogoPersona.cancelButton.text")); //$NON-NLS-1$
				cancelButton.addActionListener(new CancelButtonActionListener());
				cancelButton.setActionCommand(Messages.getString("DialogoPersona.cancelButton.actionCommand")); //$NON-NLS-1$
				buttonPane.add(cancelButton);
			}
		}
	}

	private class OkButtonActionListener implements ActionListener {
		Persona p;
		public OkButtonActionListener(Persona persona) {
			p=persona;
		}

		public void actionPerformed(ActionEvent e) {
			if(txtNombre.getText().isEmpty()) {
				lblAviso.setText("El Nombre no puede estar vacío");
			}else if(txtDni.getText().equals("XXXXXXXX-X")) {
				lblAviso.setText("El DNI no puede estar vacío");
			}else if(txtEmail.getText().isEmpty()) {
				lblAviso.setText("El email no puede estar vacío");
			}else {
				p.setDNI(txtDni.getText());
				p.setNombre(txtNombre.getText());
				PersonaCorrecta pc =new PersonaCorrecta();
				pc.setVisible(true);
				dispose();
			}
			
		}
	}
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	private class BtnElegirImagenActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lblNewLabel.setIcon(new ImageIcon(DialogoPersona.class.getResource("/recursos/User-icon.png")));
		}
	}
}
