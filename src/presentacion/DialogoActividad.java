package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;

import dominio.Actividad;

import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class DialogoActividad extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtInicio;
	private JTextField txtFin;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Actividad nActividad;

	/**
	 * Launch the application.
	 */
	public static void main() {
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
	 *  
	 */
	public DialogoActividad() {
		setTitle("Nueva actividad");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
			gbc_txtFin.insets = new Insets(0, 0, 5, 5);
			gbc_txtFin.gridx = 5;
			gbc_txtFin.gridy = 2;
			contentPanel.add(txtFin, gbc_txtFin);
			txtFin.setColumns(10);
		}
		{
			JList list = new JList();
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"lalala", "lelele", "lelelel"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			list.setBorder(new TitledBorder(null, "Integrantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.gridheight = 2;
			gbc_list.gridwidth = 2;
			gbc_list.insets = new Insets(0, 0, 5, 5);
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 2;
			gbc_list.gridy = 4;
			contentPanel.add(list, gbc_list);
		}
		{
			JTextPane txtpnDescripcin = new JTextPane();
			txtpnDescripcin.setBorder(new TitledBorder(null, "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_txtpnDescripcin = new GridBagConstraints();
			gbc_txtpnDescripcin.gridwidth = 3;
			gbc_txtpnDescripcin.gridheight = 2;
			gbc_txtpnDescripcin.insets = new Insets(0, 0, 5, 0);
			gbc_txtpnDescripcin.fill = GridBagConstraints.BOTH;
			gbc_txtpnDescripcin.gridx = 5;
			gbc_txtpnDescripcin.gridy = 4;
			contentPanel.add(txtpnDescripcin, gbc_txtpnDescripcin);
		}
		{
			JLabel lblPrioridad = new JLabel("Prioridad");
			GridBagConstraints gbc_lblPrioridad = new GridBagConstraints();
			gbc_lblPrioridad.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrioridad.gridx = 2;
			gbc_lblPrioridad.gridy = 6;
			contentPanel.add(lblPrioridad, gbc_lblPrioridad);
		}
		{
			JRadioButton rdbtnBaja = new JRadioButton("Baja");
			buttonGroup.add(rdbtnBaja);
			GridBagConstraints gbc_rdbtnBaja = new GridBagConstraints();
			gbc_rdbtnBaja.insets = new Insets(0, 0, 0, 5);
			gbc_rdbtnBaja.gridx = 2;
			gbc_rdbtnBaja.gridy = 7;
			contentPanel.add(rdbtnBaja, gbc_rdbtnBaja);
		}
		{
			JRadioButton rdbtnMedia = new JRadioButton("Media");
			buttonGroup.add(rdbtnMedia);
			GridBagConstraints gbc_rdbtnMedia = new GridBagConstraints();
			gbc_rdbtnMedia.insets = new Insets(0, 0, 0, 5);
			gbc_rdbtnMedia.gridx = 3;
			gbc_rdbtnMedia.gridy = 7;
			contentPanel.add(rdbtnMedia, gbc_rdbtnMedia);
		}
		{
			JRadioButton rdbtnAlta = new JRadioButton("Alta");
			buttonGroup.add(rdbtnAlta);
			GridBagConstraints gbc_rdbtnAlta = new GridBagConstraints();
			gbc_rdbtnAlta.insets = new Insets(0, 0, 0, 5);
			gbc_rdbtnAlta.gridx = 4;
			gbc_rdbtnAlta.gridy = 7;
			contentPanel.add(rdbtnAlta, gbc_rdbtnAlta);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private int prioridad(String pr) {
		int prioridad=-1;
		switch (pr) {
		case "Alta":
			prioridad=1;
			break;
		case "Media":
			prioridad=2;
			break;
		case "Baja":
			prioridad=3;
			break;
		}
		return prioridad;
	}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Actividad actividad = new Actividad("", null,"","",0);;
			actividad.setNombre(txtNombre.getText());
			actividad.setFechaInin(txtInicio.getText());
			actividad.setFechaFin(txtFin.getText());
			actividad.setFechaInin(txtInicio.getText());
			actividad.setFechaFin(txtFin.getText());
			actividad.setPrioridad(prioridad(buttonGroup.getSelection().toString()));
			nActividad=actividad;
			dispose();
		}
	}
	public Actividad getActividad() {
		return this.nActividad;
	}
}
