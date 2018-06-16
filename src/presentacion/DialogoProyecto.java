package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import dominio.Persona;
import dominio.Proyecto;
import javax.swing.JFormattedTextField;
import java.awt.Color;


public class DialogoProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private Proyecto proyecto;
	private JList<Persona> listaPersonas;
	MaskFormatter formatter =new MaskFormatter("##/##/####");
	MaskFormatter formatter2 =new MaskFormatter("##/##/####");
	private JFormattedTextField frmtdtxtfldInicio;
	private JFormattedTextField fechaFin;
	private JLabel lblAviso;
	
	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public DialogoProyecto(ArrayList<Persona> personas) throws ParseException {
		setTitle(Messages.getString("DialogoProyecto.this.title")); //$NON-NLS-1$
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 103, 0, 0, 91, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel(Messages.getString("DialogoProyecto.lblNombre.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 1;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setToolTipText(Messages.getString("DialogoProyecto.txtNombre.toolTipText")); //$NON-NLS-1$
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
			JLabel lblInicio = new JLabel(Messages.getString("DialogoProyecto.lblInicio.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblInicio = new GridBagConstraints();
			gbc_lblInicio.anchor = GridBagConstraints.EAST;
			gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
			gbc_lblInicio.gridx = 1;
			gbc_lblInicio.gridy = 2;
			contentPanel.add(lblInicio, gbc_lblInicio);
		}
		{
			
			frmtdtxtfldInicio = new JFormattedTextField(formatter);
			frmtdtxtfldInicio.setToolTipText(Messages.getString("DialogoProyecto.frmtdtxtfldInicio.toolTipText"));
			GridBagConstraints gbc_frmtInicio = new GridBagConstraints();
			gbc_frmtInicio.fill = GridBagConstraints.HORIZONTAL;
			gbc_frmtInicio.gridwidth = 2;
			gbc_frmtInicio.insets = new Insets(0, 0, 5, 5);
			gbc_frmtInicio.gridx = 2;
			gbc_frmtInicio.gridy = 2;
			contentPanel.add(frmtdtxtfldInicio, gbc_frmtInicio);
		}
		{
			JLabel lblFin = new JLabel(Messages.getString("DialogoProyecto.lblFin.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblFin = new GridBagConstraints();
			gbc_lblFin.insets = new Insets(0, 0, 5, 5);
			gbc_lblFin.anchor = GridBagConstraints.EAST;
			gbc_lblFin.gridx = 4;
			gbc_lblFin.gridy = 2;
			contentPanel.add(lblFin, gbc_lblFin);
		}
		{
			fechaFin = new JFormattedTextField(formatter2);
			fechaFin.setToolTipText(Messages.getString("DialogoProyecto.frmtdtxtfldFin.toolTipText")); 
			GridBagConstraints gbc_fechaFin = new GridBagConstraints();
			gbc_fechaFin.fill = GridBagConstraints.HORIZONTAL;
			gbc_fechaFin.gridwidth = 2;
			gbc_fechaFin.insets = new Insets(0, 0, 5, 5);
			gbc_fechaFin.gridx = 5;
			gbc_fechaFin.gridy = 2;
			contentPanel.add(fechaFin, gbc_fechaFin);
		}
		{
			
			
			JList<Persona> lista = new JList<Persona>();
			lista.setToolTipText(Messages.getString("DialogoProyecto.lista.toolTipText")); //$NON-NLS-1$
			
			
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
			lista.setBorder(new TitledBorder(null, Messages.getString("DialogoProyecto.lista.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			GridBagConstraints gbc_lista = new GridBagConstraints();
			gbc_lista.gridheight = 4;
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
				JButton okButton = new JButton(Messages.getString("DialogoProyecto.okButton.text")); //$NON-NLS-1$
				okButton.addActionListener(new OkButtonActionListener( personas));
				{
					lblAviso = new JLabel(); //$NON-NLS-1$
					lblAviso.setForeground(Color.RED);
					buttonPane.add(lblAviso);
				}
				okButton.setActionCommand(Messages.getString("DialogoProyecto.okButton.actionCommand")); //$NON-NLS-1$
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton(Messages.getString("DialogoProyecto.cancelButton.text")); //$NON-NLS-1$
				cancelButton.addActionListener(new CancelButtonActionListener());
				cancelButton.setActionCommand(Messages.getString("DialogoProyecto.cancelButton.actionCommand")); //$NON-NLS-1$
				buttonPane.add(cancelButton);
			}
		}
}
	private class OkButtonActionListener implements ActionListener {
		private ArrayList<Persona> seleccionadas;
		public OkButtonActionListener(ArrayList<Persona> personas) {
			seleccionadas=personas;
		}

		public void actionPerformed(ActionEvent e) {
			if(txtNombre.getText().isEmpty()) {
				lblAviso.setText("El nombre del proyecto no puede estar vacío");
			
			}else if(!fechasCorrectas(frmtdtxtfldInicio.getText(), fechaFin.getText())){
				lblAviso.setText("Las fechas no son correctas");
			}else if(listaPersonas.getSelectedValue()==null){
				lblAviso.setText("Debe elegir al menos un integrante");
			}else {
				Proyecto nproyecto= new Proyecto("","","");
				nproyecto.setNombre(txtNombre.getText());
				nproyecto.setFechaInin(frmtdtxtfldInicio.getText());
				nproyecto.setFechaFin(fechaFin.getText());
				
				int [] x= listaPersonas.getSelectedIndices();
				for (int i = 0; i < x.length; i++) {
					nproyecto.añadirIntegrante(seleccionadas.get(i));
				}
				
				
				ProyectoCorrecto pc=new ProyectoCorrecto();
				pc.setVisible(true);
				proyecto=nproyecto;
				dispose();
			}
			
		}
	}
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	
	public boolean fechasCorrectas(String ini, String fin) {
		boolean correcto=false;
		int diaI=0;
		int mesI=0;
		int anoI=0;
		int diaF=0;
		int mesF=0;
		int anoF=0;
		if (ini.equals("  /  /    ") || fin.equals("  /  /    ")) {
			
		}else {
			diaI=Integer.parseInt(ini.charAt(0)+""+ini.charAt(1));
			mesI=Integer.parseInt(ini.charAt(3)+""+ini.charAt(4));
			anoI=Integer.parseInt(ini.charAt(6)+""+ini.charAt(7)+""+ini.charAt(8)+""+ini.charAt(9));
			
			diaF=Integer.parseInt(ini.charAt(0)+""+ini.charAt(1));
			mesF=Integer.parseInt(ini.charAt(3)+""+ini.charAt(4));
			anoF=Integer.parseInt(ini.charAt(6)+""+ini.charAt(7)+""+ini.charAt(8)+""+ini.charAt(9));
			
			if (anoF>=anoI) {
				if(mesF>=mesI){
					if(diaF>=diaI) {
						correcto=true;
					}
				}
			}
			
			
		}
		return correcto;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
}