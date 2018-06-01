package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dominio.Actividad;
import dominio.Persona;
import dominio.Proyecto;
import net.miginfocom.swing.MigLayout;
import presentacion.App.CustomListModel;

import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.UIManager;

import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

import javax.swing.ListSelectionModel;

public class App {
//asassadassd
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
	private JMenu mnEdicion;
	private JMenu mnAyuda;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmAbrir;
	private JSeparator separator;
	private JMenuItem mntmSalir;
	private JMenuItem mntmGuardar;
	private JMenuItem mntmManual;
	private JMenuItem mntmIdioma;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private ArrayList<Proyecto> proyectos= new ArrayList<Proyecto>();
	private ArrayList<Persona> personas= new ArrayList<Persona>();
	private JList listaProceso;
	private JList listaTerminadas;
	private JScrollPane scrollPane;
	private JList<Actividad> listaPendientes;
	 ListTransferHandler lh;
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
		frame.getContentPane().setLayout(new MigLayout("", "[182.00px][697px,grow]", "[421px,grow][][23px]"));
		{
			//********************************
			Persona p1= new Persona("perico", "palote");
			Persona p2= new Persona("pepe", "palote");
			
			DialogoActividad da;
			ArrayList <Persona> listaPersonas= new ArrayList<Persona>();
			
			listaPersonas.add(p1);
			listaPersonas.add(p2);
			personas=listaPersonas;
			
			
			
			Proyecto pr = new Proyecto("prueba" ,"", "");
			pr.setIntegrantes(listaPersonas);
			proyectos.add(pr);
			
			
				listaProyectos = new JList<Proyecto>();
				listaProyectos.addListSelectionListener(new ListaProyectosListSelectionListener());
				listaProyectos.setBorder(new TitledBorder(null, "Lista de proyectos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				listaProyectos.setModel(new AbstractListModel<Proyecto>() {
					
					public int getSize() {
						return proyectos.size();
					}
					public Proyecto getElementAt(int index) {
						return proyectos.get(index);
					}
				});
			frame.getContentPane().add(listaProyectos, "cell 0 0,grow");
		}
		{
			pnlProyecto = new JPanel();
			pnlProyecto.setBorder(new TitledBorder(null, "Proyecto ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			frame.getContentPane().add(pnlProyecto, "cell 1 0 1 3,grow");
			GridBagLayout gbl_pnlProyecto = new GridBagLayout();
			gbl_pnlProyecto.columnWidths = new int[]{193, 193, 193, 64, 0};
			gbl_pnlProyecto.rowHeights = new int[]{61, 181, 0, 0};
			gbl_pnlProyecto.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnlProyecto.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			pnlProyecto.setLayout(gbl_pnlProyecto);
			{
				btnNuevaActividad = new JButton("Nueva \r\nactividad");
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
					pnlPendientes.setBorder(new TitledBorder(null, "Pendientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
							
							CustomListModel modeloPendientes = new CustomListModel();
							listaPendientes = new JList<Actividad>(modeloPendientes);
							
							
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
					pnlEnProceso.setBorder(new TitledBorder(null, "En proceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
							
							CustomListModel modeloProceso = new CustomListModel();
						
							
							listaProceso = new JList<Actividad>(modeloProceso);
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
					pnlTerminadas.setBorder(new TitledBorder(null, "Terminadas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
							CustomListModel modeloTerminadas = new CustomListModel();
						
							listaTerminadas = new JList<Actividad>(modeloTerminadas);
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
			btnAadirProyecto = new JButton("Añadir proyecto");
			btnAadirProyecto.addActionListener(new BtnAadirProyectoActionListener());
			frame.getContentPane().add(btnAadirProyecto, "cell 0 2,alignx center,aligny center");
			
		}
		{
			menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			{
				mnArchivo = new JMenu("Archivo");
				menuBar.add(mnArchivo);
				{
					mntmNuevo = new JMenuItem("Nuevo");
					mnArchivo.add(mntmNuevo);
				}
				{
					mntmAbrir = new JMenuItem("Abrir");
					mnArchivo.add(mntmAbrir);
				}
				{
					separator_2 = new JSeparator();
					mnArchivo.add(separator_2);
				}
				{
					mntmGuardar = new JMenuItem("Guardar");
					mnArchivo.add(mntmGuardar);
				}
				{
					separator = new JSeparator();
					mnArchivo.add(separator);
				}
				{
					mntmSalir = new JMenuItem("Salir");
					mnArchivo.add(mntmSalir);
				}
			}
			{
				mnEdicion = new JMenu("Edicion");
				menuBar.add(mnEdicion);
			}
			{
				mnAyuda = new JMenu("Ayuda");
				menuBar.add(mnAyuda);
				{
					mntmManual = new JMenuItem("Manual");
					mnAyuda.add(mntmManual);
				}
				{
					separator_1 = new JSeparator();
					mnAyuda.add(separator_1);
				}
				{
					mntmIdioma = new JMenuItem("Idioma");
					mnAyuda.add(mntmIdioma);
				}
			}
		}
	}

	
	
	
	private class BtnAadirProyectoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DialogoProyecto dp = new DialogoProyecto(personas);
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
			
			
			DialogoActividad da;
			
			da = new DialogoActividad(listaProyectos.getSelectedValue());
			da.setVisible(true);
			
		}
	}
	private class ListaProyectosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			pnlProyecto.setVisible(true);
			limpiarpanel();
			cargarActividades(listaProyectos.getSelectedValue());
		}
	}
	private void cargarActividades(Proyecto pr) {
		
		CustomListModel modeloPendientes = new CustomListModel();
		 
		
		try {
			for(int i =0; i<pr.getActividades().size();i++) {
				modeloPendientes.addActividad(pr.getActividades().get(i));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		listaPendientes.setModel(modeloPendientes);
	}
	private void limpiarpanel() {
		
		
		 
		
		try {
			//for(int i =0; i<lista_lbl.length;i++) {
				//lista_lbl[i].setText("");
			//}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$44
	// solo puesto en el modelo el copiar y el añadir
	public class CustomListModel extends DefaultListModel{
		 
	    private ArrayList<Actividad> lista = new ArrayList<>();
	 
	    @Override
	    public int getSize() {
	        return lista.size();
	    }
	 
	    @Override
	    public Object getElementAt(int index) {
	    	Actividad a = lista.get(index);	
	        return a.getNombre();
	    }
	    public void addActividad(Actividad a){
	        lista.add(a);
	        this.fireIntervalAdded(this, getSize(), getSize()+1);
	    }
	    public void eliminarActividad(int index0){
	        lista.remove(index0);
	        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
	    }
	    public Actividad getActividad(int index){
	        return lista.get(index);
	    }
	}
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	 public JMenuBar createMenuBar() {
		    JMenuItem menuItem = null;
		    JMenuBar menuBar = new JMenuBar();
		    JMenu mainMenu = new JMenu("Edit");
		    mainMenu.setMnemonic(KeyEvent.VK_E);
		    TransferActionListener actionListener = new TransferActionListener();

		    menuItem = new JMenuItem("Cut");
		    menuItem.setActionCommand((String) TransferHandler.getCutAction().getValue(
		        Action.NAME));
		    menuItem.addActionListener(actionListener);
		    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
		        ActionEvent.CTRL_MASK));
		    menuItem.setMnemonic(KeyEvent.VK_T);
		    mainMenu.add(menuItem);

		    menuItem = new JMenuItem("Copy");
		    menuItem.setActionCommand((String) TransferHandler.getCopyAction()
		        .getValue(Action.NAME));
		    menuItem.addActionListener(actionListener);
		    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
		        ActionEvent.CTRL_MASK));
		    menuItem.setMnemonic(KeyEvent.VK_C);
		    mainMenu.add(menuItem);

		    menuItem = new JMenuItem("Paste");
		    menuItem.setActionCommand((String) TransferHandler.getPasteAction()
		        .getValue(Action.NAME));
		    menuItem.addActionListener(actionListener);
		    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
		        ActionEvent.CTRL_MASK));
		    menuItem.setMnemonic(KeyEvent.VK_P);
		    mainMenu.add(menuItem);

		    menuBar.add(mainMenu);
		    return menuBar;
		  }

		  /**
		   * Add the cut/copy/paste actions to the action map.
		   */
		  private void setMappings(JList list) {
		    ActionMap map = list.getActionMap();
		    map.put(TransferHandler.getCutAction().getValue(Action.NAME),
		        TransferHandler.getCutAction());
		    map.put(TransferHandler.getCopyAction().getValue(Action.NAME),
		        TransferHandler.getCopyAction());
		    map.put(TransferHandler.getPasteAction().getValue(Action.NAME),
		        TransferHandler.getPasteAction());

		  }

		  /**
		   * Create the GUI and show it. For thread safety, this method should be
		   * invoked from the event-dispatching thread.
		   */
		  

		 
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
		    CustomListModel model = (CustomListModel) list.getModel();
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
		    JList<Actividad> list = (JList) c;
		    CustomListModel model = (CustomListModel) list.getModel();
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

		/*
		 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc. All rights reserved.
		 * 
		 * Redistribution and use in source and binary forms, with or without
		 * modification, are permitted provided that the following conditions are met:
		 *  - Redistributions of source code must retain the above copyright notice,
		 * this list of conditions and the following disclaimer.
		 *  - Redistributions in binary form must reproduce the above copyright notice,
		 * this list of conditions and the following disclaimer in the documentation
		 * and/or other materials provided with the distribution.
		 *  - Neither the name of Sun Microsystems nor the names of its contributors may
		 * be used to endorse or promote products derived from this software without
		 * specific prior written permission.
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
		 * TransferActionListener.java is used by the ListCutPaste example.
		 */

		/**
		 * A class that tracks the focused component. This is necessary to delegate the
		 * menu cut/copy/paste commands to the right component. An instance of this
		 * class is listening and when the user fires one of these commands, it calls
		 * the appropriate action on the currently focused component.
		 */
		class TransferActionListener implements ActionListener, PropertyChangeListener {
		  private JComponent focusOwner = null;

		  public TransferActionListener() {
		    KeyboardFocusManager manager = KeyboardFocusManager
		        .getCurrentKeyboardFocusManager();
		    manager.addPropertyChangeListener("permanentFocusOwner", this);
		  }

		  public void propertyChange(PropertyChangeEvent e) {
		    Object o = e.getNewValue();
		    if (o instanceof JComponent) {
		      focusOwner = (JComponent) o;
		    } else {
		      focusOwner = null;
		    }
		  }

		  public void actionPerformed(ActionEvent e) {
		    if (focusOwner == null)
		      return;
		    String action = (String) e.getActionCommand();
		    Action a = focusOwner.getActionMap().get(action);
		    if (a != null) {
		      a.actionPerformed(new ActionEvent(focusOwner,
		          ActionEvent.ACTION_PERFORMED, null));
		    }
		  }
	
}
