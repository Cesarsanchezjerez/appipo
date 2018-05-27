package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class DialogoActividad extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtInicio;
	private JTextField txtFin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoActividad dialog = new DialogoActividad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoActividad() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 1;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setText("Nombre");
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
			gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNombre.gridx = 2;
			gbc_txtNombre.gridy = 1;
			contentPanel.add(txtNombre, gbc_txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblInicio = new JLabel("Inicio");
			GridBagConstraints gbc_lblInicio = new GridBagConstraints();
			gbc_lblInicio.anchor = GridBagConstraints.EAST;
			gbc_lblInicio.insets = new Insets(0, 0, 0, 5);
			gbc_lblInicio.gridx = 1;
			gbc_lblInicio.gridy = 2;
			contentPanel.add(lblInicio, gbc_lblInicio);
		}
		{
			txtInicio = new JTextField();
			txtInicio.setText("Inicio");
			GridBagConstraints gbc_txtInicio = new GridBagConstraints();
			gbc_txtInicio.insets = new Insets(0, 0, 0, 5);
			gbc_txtInicio.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtInicio.gridx = 2;
			gbc_txtInicio.gridy = 2;
			contentPanel.add(txtInicio, gbc_txtInicio);
			txtInicio.setColumns(10);
		}
		{
			JLabel lblFin = new JLabel("Fin");
			GridBagConstraints gbc_lblFin = new GridBagConstraints();
			gbc_lblFin.insets = new Insets(0, 0, 0, 5);
			gbc_lblFin.anchor = GridBagConstraints.EAST;
			gbc_lblFin.gridx = 3;
			gbc_lblFin.gridy = 2;
			contentPanel.add(lblFin, gbc_lblFin);
		}
		{
			txtFin = new JTextField();
			txtFin.setText("Fin");
			GridBagConstraints gbc_txtFin = new GridBagConstraints();
			gbc_txtFin.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFin.gridx = 4;
			gbc_txtFin.gridy = 2;
			contentPanel.add(txtFin, gbc_txtFin);
			txtFin.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
