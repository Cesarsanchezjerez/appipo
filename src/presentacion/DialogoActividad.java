package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import dominio.Actividad;
import dominio.Persona;
import dominio.Proyecto;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class DialogoActividad extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Actividad actividad;
	private JFormattedTextField formattedInicio;
	private JFormattedTextField formattedFin;
	MaskFormatter formatter =new MaskFormatter("##/##/####");
	private areadibujo areadibujo;
	private ImageIcon imagen;
	private int x, y;
	private JLabel lblAviso;
	private JTextField txtTexto = new JTextField();
	private JList<Persona> list;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 *  
	 */
	public DialogoActividad(Proyecto pr) throws ParseException{
		setTitle(Messages.getString("DialogoActividad.this.title"));
		setModal(true);
		setBounds(100, 100, 535, 508);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 46, 47, 0, 44, 79, 99, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		
		
		{
			JLabel lblNombre = new JLabel(Messages.getString("DialogoActividad.lblNombre.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.anchor = GridBagConstraints.WEST;
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 1;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setToolTipText(Messages.getString("DialogoActividad.txtNombre.toolTipText")); //$NON-NLS-1$
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
			JLabel lblInicio = new JLabel(Messages.getString("DialogoActividad.lblInicio.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblInicio = new GridBagConstraints();
			gbc_lblInicio.anchor = GridBagConstraints.WEST;
			gbc_lblInicio.insets = new Insets(0, 0, 5, 5);
			gbc_lblInicio.gridx = 1;
			gbc_lblInicio.gridy = 2;
			contentPanel.add(lblInicio, gbc_lblInicio);
		}
		{
			formattedInicio = new JFormattedTextField(formatter);
			formattedInicio.setToolTipText(Messages.getString("DialogoActividad.formattedInicio.toolTipText")); //$NON-NLS-1$
			GridBagConstraints gbc_formattedInicio = new GridBagConstraints();
			gbc_formattedInicio.gridwidth = 2;
			gbc_formattedInicio.insets = new Insets(0, 0, 5, 5);
			gbc_formattedInicio.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedInicio.gridx = 2;
			gbc_formattedInicio.gridy = 2;
			contentPanel.add(formattedInicio, gbc_formattedInicio);
		}
		{
			JLabel lblFin = new JLabel(Messages.getString("DialogoActividad.lblFin.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblFin = new GridBagConstraints();
			gbc_lblFin.insets = new Insets(0, 0, 5, 5);
			gbc_lblFin.anchor = GridBagConstraints.EAST;
			gbc_lblFin.gridx = 4;
			gbc_lblFin.gridy = 2;
			contentPanel.add(lblFin, gbc_lblFin);
		}
		{
			formattedFin = new JFormattedTextField(formatter);
			formattedFin.setToolTipText(Messages.getString("DialogoActividad.formattedFin.toolTipText")); //$NON-NLS-1$
			GridBagConstraints gbc_formattedFin = new GridBagConstraints();
			gbc_formattedFin.gridwidth = 2;
			gbc_formattedFin.insets = new Insets(0, 0, 5, 5);
			gbc_formattedFin.fill = GridBagConstraints.HORIZONTAL;
			gbc_formattedFin.gridx = 5;
			gbc_formattedFin.gridy = 2;
			contentPanel.add(formattedFin, gbc_formattedFin);
		}
		{
			list = new JList<Persona>();
			list.setToolTipText(Messages.getString("DialogoActividad.list.toolTipText")); //$NON-NLS-1$
			list.setModel(new AbstractListModel<Persona>() {
				ArrayList<Persona> values = pr.getIntegrantes();
				public int getSize() {
					return pr.getIntegrantes().size();
				}
				public Persona getElementAt(int index) {
					return pr.getIntegrantes().get(index);
				}
			});
			list.setBorder(new TitledBorder(null, Messages.getString("DialogoActividad.list.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
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
			txtpnDescripcin.setBorder(new TitledBorder(null, Messages.getString("DialogoActividad.txtpnDescripcin.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			GridBagConstraints gbc_txtpnDescripcin = new GridBagConstraints();
			gbc_txtpnDescripcin.gridwidth = 3;
			gbc_txtpnDescripcin.gridheight = 2;
			gbc_txtpnDescripcin.insets = new Insets(0, 0, 5, 5);
			gbc_txtpnDescripcin.fill = GridBagConstraints.BOTH;
			gbc_txtpnDescripcin.gridx = 5;
			gbc_txtpnDescripcin.gridy = 4;
			contentPanel.add(txtpnDescripcin, gbc_txtpnDescripcin);
		}
		{
			JLabel lblPrioridad = new JLabel(Messages.getString("DialogoActividad.lblPrioridad.text")); //$NON-NLS-1$
			GridBagConstraints gbc_lblPrioridad = new GridBagConstraints();
			gbc_lblPrioridad.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrioridad.gridx = 2;
			gbc_lblPrioridad.gridy = 6;
			contentPanel.add(lblPrioridad, gbc_lblPrioridad);
		}
		{
			JRadioButton rdbtnBaja = new JRadioButton(Messages.getString("DialogoActividad.rdbtnBaja.text")); //$NON-NLS-1$
			rdbtnBaja.setSelected(true);
			rdbtnBaja.setMnemonic('3');
			buttonGroup.add(rdbtnBaja);
			GridBagConstraints gbc_rdbtnBaja = new GridBagConstraints();
			gbc_rdbtnBaja.anchor = GridBagConstraints.WEST;
			gbc_rdbtnBaja.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnBaja.gridx = 2;
			gbc_rdbtnBaja.gridy = 7;
			contentPanel.add(rdbtnBaja, gbc_rdbtnBaja);
		}
		{
			JRadioButton rdbtnMedia = new JRadioButton(Messages.getString("DialogoActividad.rdbtnMedia.text")); //$NON-NLS-1$
			rdbtnMedia.setMnemonic('2');
			buttonGroup.add(rdbtnMedia);
			GridBagConstraints gbc_rdbtnMedia = new GridBagConstraints();
			gbc_rdbtnMedia.anchor = GridBagConstraints.WEST;
			gbc_rdbtnMedia.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnMedia.gridx = 3;
			gbc_rdbtnMedia.gridy = 7;
			contentPanel.add(rdbtnMedia, gbc_rdbtnMedia);
		}
		{
			JRadioButton rdbtnAlta = new JRadioButton(Messages.getString("DialogoActividad.rdbtnAlta.text")); //$NON-NLS-1$
			rdbtnAlta.setMnemonic('1');
			buttonGroup.add(rdbtnAlta);
			GridBagConstraints gbc_rdbtnAlta = new GridBagConstraints();
			gbc_rdbtnAlta.anchor = GridBagConstraints.WEST;
			gbc_rdbtnAlta.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnAlta.gridx = 4;
			gbc_rdbtnAlta.gridy = 7;
			contentPanel.add(rdbtnAlta, gbc_rdbtnAlta);
		}
		{
			JButton btnAdjuntarImagen = new JButton(Messages.getString("DialogoActividad.btnAdjuntarImagen.text")); //$NON-NLS-1$
			btnAdjuntarImagen.addActionListener(new BtnAdjuntarImagenActionListener());
			GridBagConstraints gbc_btnAdjuntarImagen = new GridBagConstraints();
			gbc_btnAdjuntarImagen.insets = new Insets(0, 0, 5, 5);
			gbc_btnAdjuntarImagen.gridx = 6;
			gbc_btnAdjuntarImagen.gridy = 8;
			contentPanel.add(btnAdjuntarImagen, gbc_btnAdjuntarImagen);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 3;
			gbc_scrollPane.gridwidth = 4;
			gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 2;
			gbc_scrollPane.gridy = 8;
			contentPanel.add(scrollPane, gbc_scrollPane);
			
			areadibujo = new areadibujo(); 
			areadibujo.addMouseListener(new AreadibujoMouseListener());
			areadibujo.setIcon(null);
			scrollPane.setViewportView(areadibujo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton(Messages.getString("DialogoActividad.okButton.text")); //$NON-NLS-1$
				okButton.addActionListener(new OkButtonActionListener(pr));
				{
					lblAviso = new JLabel(); //$NON-NLS-1$
					lblAviso.setForeground(Color.RED);
					buttonPane.add(lblAviso);
				}
				okButton.setActionCommand(Messages.getString("DialogoActividad.okButton.actionCommand")); //$NON-NLS-1$
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
			}
			{
				JButton cancelButton = new JButton(Messages.getString("DialogoActividad.cancelButton.text")); //$NON-NLS-1$
				cancelButton.addActionListener(new CancelButtonActionListener());
				cancelButton.setActionCommand(Messages.getString("DialogoActividad.cancelButton.actionCommand")); //$NON-NLS-1$
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private int prioridad( int pr) {
		int prioridad=-1;
		switch (pr) {
		case 49:
			prioridad=1;
			break;
		case 50:
			prioridad=2;
			break;
		case 51:
			prioridad=3;
			break;
		}
		return prioridad;
	}
	private class OkButtonActionListener implements ActionListener {
		private Proyecto proyecto;
		public OkButtonActionListener(Proyecto pr) {
			proyecto=pr;
		}
		public void actionPerformed(ActionEvent e) {
			
			if(txtNombre.getText().isEmpty()) {
				lblAviso.setText("El nombre del proyecto no puede estar vacío");
			
			}else if(!fechasCorrectas(formattedInicio.getText(), formattedFin.getText())){
				lblAviso.setText("Las fechas no son correctas");
			}else if(list.getSelectedValue()==null){
				lblAviso.setText("Debe elegir al menos un integrante");
			}else {
				Actividad nActividad = new Actividad("", null,"","",0);;
				nActividad.setNombre(txtNombre.getText());
				nActividad.setFechaInin(formattedInicio.getText());
				nActividad.setFechaFin(formattedFin.getText());
				nActividad.setAreadibujo(areadibujo);
				nActividad.setImagen(imagen);
				nActividad.setPrioridad(prioridad(buttonGroup.getSelection().getMnemonic()));
				actividad=nActividad;
				proyecto.añadirActividad(nActividad);
				ActividadCorrecta ac= new ActividadCorrecta();
				ac.setVisible(true);
				dispose();
			}
			
			
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
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}
	private class BtnAdjuntarImagenActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser fcAbrir = new JFileChooser();
			
			int valorDevuelto = fcAbrir.showOpenDialog(getParent()); 
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {	
				File file = fcAbrir.getSelectedFile();
				imagen = new ImageIcon(file.getAbsolutePath());
				areadibujo.setIcon(imagen);
		}
	}
	}
	private class AreadibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			txtTexto.setBounds(x, y, 200,30);
			txtTexto.setVisible(true); 
			txtTexto.requestFocus(); 
			txtTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg) { 
					if(!txtTexto.getText().equals(""))areadibujo.addObjetoGrafico(new objetoGrafico(x,y+15,txtTexto.getText(),Color.blue));
					txtTexto.setText(""); 
					txtTexto.setVisible(false); 
					areadibujo.repaint();
				}

				
			});
			areadibujo.add(txtTexto);
		}
	}
	public Actividad getActividad() {
		return this.actividad;
	}
}
