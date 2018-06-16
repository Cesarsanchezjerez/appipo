package presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.metal.MetalPopupMenuSeparatorUI;

import dominio.Actividad;
import dominio.Persona;
import dominio.Proyecto;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class App {

	private JFrame frame;
	private JButton btnAadirProyecto;
	private JMenuBar menuBar;
	private JList<Proyecto> listaProyectos;
	private JPanel pnlProyecto;
	private JPanel pnlPendientes;
	private JPanel pnlEnProceso;
	private JPanel pnlTerminadas;
	private JButton btnNuevaActividad;
	private JMenu mnArchivo;
	private JMenu mnAyuda;
	private JMenuItem mntmManual;
	private JSeparator separator_1;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private ArrayList<Proyecto> proyectos= new ArrayList<Proyecto>();
	private ArrayList<Persona> personas= new ArrayList<Persona>();
	private JList<Actividad> listaProceso;
	private JList<Actividad> listaTerminadas;
	private JScrollPane scrollPane;
	private JList<Actividad> listaPendientes;
	
	
	ListTransferHandler lh;
	private JMenu mnNuevo;
	private JMenuItem mntmPersona;
	private JMenuItem mntmProyecto;
	private JMenu mnIdioma;
	private JMenuItem mntmEspaol;
	private JMenuItem mntmEnglish;
	private JLabel lblUltimaConexin;
	private JMenu mnPersonas;
	private JMenuItem mntmListaDePersonas;
	private JMenuItem mntmEnviarUnCorreo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		lh = new ListTransferHandler();
		frame = new JFrame();
		frame.setBounds(100, 100, 1003, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[182.00px][670.00px,grow,left]", "[76.00px][][][grow][23px]"));
		{
			//********************************
			Persona p1= new Persona("Pedro", "666666");
			Persona p2= new Persona("Cesar", "777777");
			Persona p3= new Persona("Paco", "222223");
			Persona p4= new Persona("Sergio", "745234");
			Persona p5= new Persona("María", "623585");
			Persona p6= new Persona("Juliana", "834224");
			Persona p7= new Persona("Julio", "455774");
			Persona p8= new Persona("Martina", "723345");
			DialogoActividad da;
			ArrayList <Persona> listaPersonas= new ArrayList<Persona>();
			
			listaPersonas.add(p1);
			listaPersonas.add(p2);
			listaPersonas.add(p3);
			listaPersonas.add(p4);
			listaPersonas.add(p5);
			listaPersonas.add(p6);
			listaPersonas.add(p7);
			listaPersonas.add(p8);
			personas=listaPersonas;
			
			
			
			Proyecto pr = new Proyecto("prueba" ,"", "");
			pr.setIntegrantes(listaPersonas);
			proyectos.add(pr);
			
			
				listaProyectos = new JList<Proyecto>();
				
				listaProyectos.addListSelectionListener(new ListaProyectosListSelectionListener());
				listaProyectos.setBorder(new TitledBorder(null, Messages.getString("App.listaProyectos.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
				listaProyectos.setModel(new AbstractListModel<Proyecto>() {
					
					public int getSize() {
						return proyectos.size();
					}
					public Proyecto getElementAt(int index) {
						return proyectos.get(index);
					}
				});
			frame.getContentPane().add(listaProyectos, "cell 0 0 1 4,grow");
		}
		{
			pnlProyecto = new JPanel();
			pnlProyecto.addMouseListener(new PnlProyectoMouseListener());
			pnlProyecto.setBorder(new TitledBorder(null, Messages.getString("App.pnlProyecto.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
			frame.getContentPane().add(pnlProyecto, "cell 1 0 1 4,grow");
			GridBagLayout gbl_pnlProyecto = new GridBagLayout();
			gbl_pnlProyecto.columnWidths = new int[]{193, 193, 193, 64, 0};
			gbl_pnlProyecto.rowHeights = new int[]{61, 181, 0, 0};
			gbl_pnlProyecto.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnlProyecto.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			pnlProyecto.setLayout(gbl_pnlProyecto);
			{
				btnNuevaActividad = new JButton(Messages.getString("App.btnNuevaActividad.text")); //$NON-NLS-1$
				btnNuevaActividad.setIcon(new ImageIcon(App.class.getResource("/recursos/add-document.png")));
				btnNuevaActividad.setAlignmentX(Component.CENTER_ALIGNMENT);
				btnNuevaActividad.setAlignmentY(0.0f);
				btnNuevaActividad.addActionListener(new BtnNuevaActividadActionListener());
				GridBagConstraints gbc_btnNuevaActividad = new GridBagConstraints();
				gbc_btnNuevaActividad.insets = new Insets(0, 0, 5, 0);
				gbc_btnNuevaActividad.fill = GridBagConstraints.VERTICAL;
				gbc_btnNuevaActividad.gridx = 3;
				gbc_btnNuevaActividad.gridy = 0;
				pnlProyecto.add(btnNuevaActividad, gbc_btnNuevaActividad);
				{
					pnlPendientes = new JPanel();
					pnlPendientes.setBorder(new TitledBorder(null, Messages.getString("App.pnlPendientes.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
					GridBagConstraints gbc_pnlPendientes = new GridBagConstraints();
					gbc_pnlPendientes.gridheight = 3;
					gbc_pnlPendientes.fill = GridBagConstraints.BOTH;
					gbc_pnlPendientes.insets = new Insets(0, 0, 0, 5);
					gbc_pnlPendientes.gridx = 0;
					gbc_pnlPendientes.gridy = 0;
					pnlProyecto.add(pnlPendientes, gbc_pnlPendientes);
					pnlPendientes.setLayout(new BorderLayout(0, 0));
					{
						scrollPane = new JScrollPane();
						pnlPendientes.add(scrollPane, BorderLayout.CENTER);
						{
							
							DefaultListModel modeloPendientes = new DefaultListModel();
							listaPendientes = new JList<Actividad>(modeloPendientes);
							listaPendientes.setToolTipText(Messages.getString("App.listaPendientes.toolTipText")); //$NON-NLS-1$
							listaPendientes.addMouseListener(new ListaPendientesMouseListener());
							
							
							listaPendientes.setDragEnabled(true);
							listaPendientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							listaPendientes.setTransferHandler(lh);
							listaPendientes.setDropMode(DropMode.ON_OR_INSERT);
							setMappings(listaPendientes);
							scrollPane.setViewportView(listaPendientes);
							
							
						}
					}
				}
				{
					pnlEnProceso = new JPanel();
					pnlEnProceso.setBorder(new TitledBorder(null, Messages.getString("App.pnlEnProceso.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
					GridBagConstraints gbc_pnlEnProceso = new GridBagConstraints();
					gbc_pnlEnProceso.gridheight = 3;
					gbc_pnlEnProceso.fill = GridBagConstraints.BOTH;
					gbc_pnlEnProceso.insets = new Insets(0, 0, 0, 5);
					gbc_pnlEnProceso.gridx = 1;
					gbc_pnlEnProceso.gridy = 0;
					pnlProyecto.add(pnlEnProceso, gbc_pnlEnProceso);
					pnlEnProceso.setLayout(new BorderLayout(0, 0));
					{
						scrollPane_1 = new JScrollPane();
						pnlEnProceso.add(scrollPane_1, BorderLayout.CENTER);
						{
							
							DefaultListModel modeloProceso = new DefaultListModel();
							
							
							listaProceso = new JList<Actividad>(modeloProceso);
							listaProceso.addMouseListener(new ListaProcesoMouseListener());
							
							listaProceso.setDragEnabled(true);
							listaProceso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							listaProceso.setTransferHandler(lh);
							listaProceso.setDropMode(DropMode.ON_OR_INSERT);
							setMappings(listaProceso);
							scrollPane_1.setViewportView(listaProceso);
							
							
							
							
						}
					}
				}
				{
					pnlTerminadas = new JPanel();
					pnlTerminadas.setBorder(new TitledBorder(null, Messages.getString("App.pnlTerminadas.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
					GridBagConstraints gbc_pnlTerminadas = new GridBagConstraints();
					gbc_pnlTerminadas.gridheight = 3;
					gbc_pnlTerminadas.fill = GridBagConstraints.BOTH;
					gbc_pnlTerminadas.insets = new Insets(0, 0, 0, 5);
					gbc_pnlTerminadas.gridx = 2;
					gbc_pnlTerminadas.gridy = 0;
					pnlProyecto.add(pnlTerminadas, gbc_pnlTerminadas);
					pnlTerminadas.setLayout(new BorderLayout(0, 0));
					{
						scrollPane_2 = new JScrollPane();
						pnlTerminadas.add(scrollPane_2, BorderLayout.CENTER);
						{
							DefaultListModel modeloTerminadas = new DefaultListModel();
						
							listaTerminadas = new JList<Actividad>(modeloTerminadas);
							listaTerminadas.addMouseListener(new ListaTerminadasMouseListener());
							listaTerminadas.setDragEnabled(true);
							listaTerminadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							listaTerminadas.setTransferHandler(lh);
							listaTerminadas.setDropMode(DropMode.ON_OR_INSERT);
							setMappings(listaTerminadas);
							scrollPane_2.setViewportView(listaTerminadas);
						}
					}
				}
			}
		}
		pnlProyecto.setVisible(false);
		{
			btnAadirProyecto = new JButton(Messages.getString("App.btnAadirProyecto.text")); //$NON-NLS-1$
			btnAadirProyecto.addActionListener(new BtnAadirProyectoActionListener());
			frame.getContentPane().add(btnAadirProyecto, "cell 0 4,alignx center,aligny center");
			
		}
		{
			lblUltimaConexin = new JLabel(Messages.getString("App.lblUltimaConexin.text")); //$NON-NLS-1$
			frame.getContentPane().add(lblUltimaConexin, "cell 1 4");
		}
		{
			menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			{
				mnArchivo = new JMenu(Messages.getString("App.mnArchivo.text")); //$NON-NLS-1$
				menuBar.add(mnArchivo);
				{
					mnNuevo = new JMenu(Messages.getString("App.mnNuevo.text")); //$NON-NLS-1$
					mnArchivo.add(mnNuevo);
					{
						mntmPersona = new JMenuItem(Messages.getString("App.mntmPersona.text")); //$NON-NLS-1$
						mntmPersona.addActionListener(new MntmPersonaActionListener());
						mntmPersona.setIcon(new ImageIcon(App.class.getResource("/recursos/add-user-button.png")));
						mnNuevo.add(mntmPersona);
					}
					{
						mntmProyecto = new JMenuItem(Messages.getString("App.mntmProyecto.text")); //$NON-NLS-1$
						mntmProyecto.addActionListener(new MntmProyectoActionListener());
						mntmProyecto.setIcon(new ImageIcon(App.class.getResource("/recursos/file-in-folder.png")));
						mnNuevo.add(mntmProyecto);
					}
				}
				{
					mnPersonas = new JMenu(Messages.getString("App.mnPersonas.text")); //$NON-NLS-1$
					mnArchivo.add(mnPersonas);
					{
						mntmListaDePersonas = new JMenuItem(Messages.getString("App.mntmListaDePersonas.text")); //$NON-NLS-1$
						mnPersonas.add(mntmListaDePersonas);
					}
					{
						mntmEnviarUnCorreo = new JMenuItem(Messages.getString("App.mntmEnviarUnCorreo.text")); //$NON-NLS-1$
						mntmEnviarUnCorreo.addActionListener(new MntmEnviarUnCorreoActionListener());
						mnPersonas.add(mntmEnviarUnCorreo);
					}
				}
			}
			{
				mnAyuda = new JMenu(Messages.getString("App.mnAyuda.text")); //$NON-NLS-1$
				menuBar.add(mnAyuda);
				{
					mntmManual = new JMenuItem(Messages.getString("App.mntmManual.text")); //$NON-NLS-1$
					
					mnAyuda.add(mntmManual);
				}
				{
					separator_1 = new JSeparator();
					mnAyuda.add(separator_1);
				}
				{
					mnIdioma = new JMenu(Messages.getString("App.mnIdioma.text")); //$NON-NLS-1$
					mnAyuda.add(mnIdioma);
					{
						mntmEspaol = new JMenuItem(Messages.getString("App.mntmEspaol.text")); //$NON-NLS-1$
						mntmEspaol.addActionListener(new MntmEspaolActionListener());
						mnIdioma.add(mntmEspaol);
					}
					{
						mntmEnglish = new JMenuItem(Messages.getString("App.mntmEnglish.text")); //$NON-NLS-1$
						mntmEnglish.addActionListener(new MntmEnglishActionListener());
						mnIdioma.add(mntmEnglish);
					}
				}
			}
		}
	}

	
	
	
	private class BtnAadirProyectoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DialogoProyecto dp = null;
			try {
				dp = new DialogoProyecto(personas);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dp.setVisible(true);
			proyectos.add(dp.getProyecto());
			listaProyectos.setModel(new AbstractListModel<Proyecto>() {
				
				public int getSize() {
					return proyectos.size();
				}
				public Proyecto getElementAt(int index) {
					return proyectos.get(index);
				}
			});
			
			pnlProyecto.setVisible(false);
		}
	}
	private class BtnNuevaActividadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			DialogoActividad da = null;
			
			try {
				da = new DialogoActividad(listaProyectos.getSelectedValue());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			da.setVisible(true);
			cargarActividades(listaProyectos.getSelectedValue());
			
			//limpiarpanel();
			
		}
	}
	
	private class ListaProyectosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			pnlProyecto.setVisible(true);
			cargarActividades(listaProyectos.getSelectedValue());
			
		}
	}
	
	
	private class ListaPendientesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			DefaultListModel modeloPendientes = (DefaultListModel) listaPendientes.getModel();
			String act=(String) modeloPendientes.get(listaPendientes.getSelectedIndex());
			
			if(e.getClickCount()==2 && listaPendientes.getSelectedValue()!=null) {
				
				Dialogoeditaractividad dga=new Dialogoeditaractividad(listaProyectos.getSelectedValue(),act);
				dga.setVisible(true);
				cargarActividades(listaProyectos.getSelectedValue());
				
			}
		}
	}
	private class PnlProyectoMouseListener extends MouseAdapter {
		@Override
		public void mouseExited(MouseEvent e) {
			limpiarpanel();
			cargarActividades(listaProyectos.getSelectedValue());
		}
	}
	private class ListaProcesoMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			DefaultListModel modeloproceso = (DefaultListModel) listaProceso.getModel();
			String act=(String) modeloproceso.get(listaProceso.getSelectedIndex());
			
			if(e.getClickCount()==2 && listaProceso.getSelectedValue()!=null) {
				
				Dialogoeditaractividad dga=new Dialogoeditaractividad(listaProyectos.getSelectedValue(),act);
				dga.setVisible(true);
				cargarActividades(listaProyectos.getSelectedValue());
				
			}
			
		}
	}
	private class ListaTerminadasMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			DefaultListModel modeloterminadas = (DefaultListModel) listaTerminadas.getModel();
			String act=(String) modeloterminadas.get(listaTerminadas.getSelectedIndex());
			
			if(e.getClickCount()==2 && listaTerminadas.getSelectedValue()!=null) {
				
				Dialogoeditaractividad dga=new Dialogoeditaractividad(listaProyectos.getSelectedValue(),act);
				dga.setVisible(true);
				cargarActividades(listaProyectos.getSelectedValue());
				
			}
		}
	}
	private class MntmProyectoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			DialogoProyecto dp = null;
			try {
				dp = new DialogoProyecto(personas);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dp.setVisible(true);
			proyectos.add(dp.getProyecto());
			listaProyectos.setModel(new AbstractListModel<Proyecto>() {
				
				public int getSize() {
					return proyectos.size();
				}
				public Proyecto getElementAt(int index) {
					return proyectos.get(index);
				}
			});
			
			pnlProyecto.setVisible(false);
		}
		
	}
	private class MntmPersonaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Persona persona= new Persona("", "");
			DialogoPersona dp=new DialogoPersona(persona);
			dp.setVisible(true);
			personas.add(persona);
		}
	}
	private class MntmEspaolActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			Messages.setIdioma("spain");
			App app =new App();
			
			app.frame.setVisible(true);
			frame.dispose();
			
		}
	}
	
	private class MntmEnglishActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			Messages.setIdioma("ingles");
			App app =new App();
			
			app.frame.setVisible(true);
			frame.dispose();
		}
	}
	private class MntmEnviarUnCorreoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DialogoCorreo dc = new DialogoCorreo(personas);
			dc.setVisible(true);
		}
	}
	
	
	private void cambiarEstado(Proyecto pr) {
			
		
			
			DefaultListModel modeloPendientes = (DefaultListModel) listaPendientes.getModel();
			DefaultListModel modeloProceso = (DefaultListModel) listaProceso.getModel();
			DefaultListModel modeloTerminadas = (DefaultListModel) listaTerminadas.getModel();
			 try {

					for (int i = 0; i < modeloPendientes.getSize(); i++) {
						for (int j = 0; j < pr.getActividades().size(); j++) {
							if(modeloPendientes.get(i).equals(pr.getActividades().get(j).getNombre())) {
								pr.getActividades().get(j).setEstado("pendiente");
							}
						}
					}
					for (int i = 0; i < modeloProceso.getSize(); i++) {
						for (int j = 0; j < pr.getActividades().size(); j++) {
							if(modeloProceso.get(i).equals(pr.getActividades().get(j).getNombre())) {
								pr.getActividades().get(j).setEstado("proceso");
							}
						}
					}
					for (int i = 0; i < modeloTerminadas.getSize(); i++) {
						for (int j = 0; j < pr.getActividades().size(); j++) {
							if(modeloTerminadas.get(i).equals(pr.getActividades().get(j).getNombre())) {
								pr.getActividades().get(j).setEstado("terminada");
							}
						}
					}
					
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
	
		
		
	}
	
	private void cargarActividades(Proyecto pr) {
		
		DefaultListModel modeloPendientes = new DefaultListModel();
		DefaultListModel modeloProceso = new DefaultListModel();
		DefaultListModel modeloTerminadas =new DefaultListModel();
		 
		 
		cambiarEstado(pr);
		
		try {
			for(int i =0; i<pr.getActividades().size();i++) {
				
				
				
				switch (pr.getActividades().get(i).getEstado()) {
				
				case "pendiente":
					modeloPendientes.addElement(pr.getActividades().get(i).getNombre());
					
					break;
				case "proceso":
					modeloProceso.addElement(pr.getActividades().get(i).getNombre());
				
					break;
				case "terminada":
					modeloTerminadas.addElement(pr.getActividades().get(i).getNombre());
					break;
				default:
					break;
				}
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		listaPendientes.setModel(modeloPendientes);
		listaProceso.setModel(modeloProceso);
		listaTerminadas.setModel(modeloTerminadas);
		
	}
	private void limpiarpanel() {
		
		
		 
		
		try {
			
			listaPendientes.removeAll();
			listaProceso.removeAll();
			listaTerminadas.removeAll();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 private void setMappings(JList list) {
		    ActionMap map = list.getActionMap();
		    map.put(TransferHandler.getCutAction().getValue(Action.NAME),
		        TransferHandler.getCutAction());
		    map.put(TransferHandler.getCopyAction().getValue(Action.NAME),
		        TransferHandler.getCopyAction());
		    map.put(TransferHandler.getPasteAction().getValue(Action.NAME),
		        TransferHandler.getPasteAction());

		  }

		

		
		}/*
		   * Copyright (c) 1995 - 2008 Sun Microsystems, Inc. All rights reserved.
		   * 
		   * Redistribution and use in source and binary forms, with or without
		   * modification, are permitted provided that the following conditions are met:
		   *  - Redistributions of source code must retain the above copyright notice,
		   * this list of conditions and the following disclaimer.
		   *  - Redistributions in binary form must reproduce the above copyright
		   * notice, this list of conditions and the following disclaimer in the
		   * documentation and/or other materials provided with the distribution.
		   *  - Neither the name of Sun Microsystems nor the names of its contributors
		   * may be used to endorse or promote products derived from this software
		   * without specific prior written permission.
		   * 
		   * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
		   * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
		   * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
		   * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
		   * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
		   * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
		   * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
		   * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
		   * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
		   * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
		   * POSSIBILITY OF SUCH DAMAGE.
		   */

		/*
		 * ListTransferHandler.java is used by the ListCutPaste example.
		 */

		class ListTransferHandler extends TransferHandler {

		  /**
		   * Perform the actual data import.
		   */
		  public boolean importData(TransferHandler.TransferSupport info) {
		    String data = null;

		    // If we can't handle the import, bail now.
		    if (!canImport(info)) {
		      return false;
		    }

		    JList list = (JList) info.getComponent();
		    DefaultListModel model = (DefaultListModel) list.getModel();
		    // Fetch the data -- bail if this fails
		    try {
		      data = (String) info.getTransferable().getTransferData(
		          DataFlavor.stringFlavor);
		    } catch (UnsupportedFlavorException ufe) {
		      System.out.println("importData: unsupported data flavor");
		      return false;
		    } catch (IOException ioe) {
		      System.out.println("importData: I/O exception");
		      return false;
		    }

		    if (info.isDrop()) { // This is a drop
		      JList.DropLocation dl = (JList.DropLocation) info.getDropLocation();
		      int index = dl.getIndex();
		      if (dl.isInsert()) {
		        model.add(index, data);
		        return true;
		      } else {
		        model.set(index, data);
		        return true;
		      }
		    } else { // This is a paste
		      int index = list.getSelectedIndex();
		      // if there is a valid selection,
		      // insert data after the selection
		      if (index >= 0) {
		        model.add(list.getSelectedIndex() + 1, data);
		        // else append to the end of the list
		      } else {
		        model.addElement(data);
		      }
		      return true;
		    }
		  }

		  /**
		   * Bundle up the data for export.
		   */
		  protected Transferable createTransferable(JComponent c) {
		    JList list = (JList) c;
		    int index = list.getSelectedIndex();
		    String value = (String) list.getSelectedValue();
		    return new StringSelection(value);
		  }

		  /**
		   * The list handles both copy and move actions.
		   */
		  public int getSourceActions(JComponent c) {
		    return COPY_OR_MOVE;
		  }

		  /**
		   * When the export is complete, remove the old list entry if the action was a
		   * move.
		   */
		  protected void exportDone(JComponent c, Transferable data, int action) {
		    if (action != MOVE) {
		      return;
		    }
		    JList list = (JList) c;
		    DefaultListModel model = (DefaultListModel) list.getModel();
		    int index = list.getSelectedIndex();
		    model.remove(index);
		  }

		  /**
		   * We only support importing strings.
		   */
		  public boolean canImport(TransferHandler.TransferSupport support) {
		    // we only import Strings
		    if (!support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
		      return false;
		    }
		    return true;
		  }
		}

	
		

