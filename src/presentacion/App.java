package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dominio.Actividad;
import dominio.Persona;
import dominio.Proyecto;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	private JList listaPendientes;
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
							listaPendientes = new JList();
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
							listaProceso = new JList();
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
							listaTerminadas = new JList();
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
		
		
		 
		
		try {
			for(int i =0; i<pr.getActividades().size();i++) {
				//lista_lbl[i].setText(pr.getActividades().get(i).getNombre());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
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
	
}
