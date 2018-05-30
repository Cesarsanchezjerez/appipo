package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dominio.Persona;
import dominio.Proyecto;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DialogoProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtInicio;
	private JTextField txtFin;
	private Proyecto proyecto;
	private JList<Persona> listaPersonas;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public DialogoProyecto(ArrayList<Persona> personas) {
		setTitle("Nuevo Proyecto");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.gridwidth = 2;
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
			gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
			gbc_lblInicio.gridx = 1;
			gbc_lblInicio.gridy = 2;
			contentPanel.add(lblInicio, gbc_lblInicio);
		}
		{
			txtInicio = new JTextField();
			GridBagConstraints gbc_txtInicio = new GridBagConstraints();
			gbc_txtInicio.gridwidth = 2;
			gbc_txtInicio.insets = new Insets(0, 0, 5, 5);
			gbc_txtInicio.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtInicio.gridx = 2;
			gbc_txtInicio.gridy = 2;
			contentPanel.add(txtInicio, gbc_txtInicio);
			txtInicio.setColumns(10);
		}
		{
			JLabel lblFin = new JLabel("Fin");
			GridBagConstraints gbc_lblFin = new GridBagConstraints();
			gbc_lblFin.insets = new Insets(0, 0, 5, 5);
			gbc_lblFin.anchor = GridBagConstraints.EAST;
			gbc_lblFin.gridx = 4;
			gbc_lblFin.gridy = 2;
			contentPanel.add(lblFin, gbc_lblFin);
		}
		{
			txtFin = new JTextField();
			GridBagConstraints gbc_txtFin = new GridBagConstraints();
			gbc_txtFin.anchor = GridBagConstraints.WEST;
			gbc_txtFin.gridwidth = 2;
			gbc_txtFin.insets = new Insets(0, 0, 5, 0);
			gbc_txtFin.gridx = 5;
			gbc_txtFin.gridy = 2;
			contentPanel.add(txtFin, gbc_txtFin);
			txtFin.setColumns(10);
		}
		{
			
			
			JList<Persona> lista = new JList<Persona>();
			lista.setModel(new AbstractListModel<Persona>() {
				ArrayList<Persona> values =personas;
				public int getSize() {
					return personas.size();
				}
				public Persona getElementAt(int index) {
					return personas.get(index);
				}
			});
			listaPersonas=lista;
			lista.setBorder(new TitledBorder(null, "Integrantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_lista = new GridBagConstraints();
			gbc_lista.gridheight = 2;
			gbc_lista.gridwidth = 2;
			gbc_lista.insets = new Insets(0, 0, 5, 5);
			gbc_lista.fill = GridBagConstraints.BOTH;
			gbc_lista.gridx = 2;
			gbc_lista.gridy = 4;
			contentPanel.add(lista, gbc_lista);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new OkButtonActionListener());
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new CancelButtonActionListener());
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Proyecto nproyecto= new Proyecto("","","");
			nproyecto.setNombre(txtNombre.getText());
			nproyecto.setFechaInin(txtInicio.getText());
			nproyecto.setFechaFin(txtFin.getText());
			System.out.println(listaPersonas.getSelectedValue().toString());
			nproyecto.añadirIntegrante(listaPersonas.getSelectedValue());
			//integrantes 
			proyecto=nproyecto;
			dispose();
		}
	}
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
}