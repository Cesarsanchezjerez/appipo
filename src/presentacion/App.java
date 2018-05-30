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
	private JLabel lblPendientes;
	private JLabel lblEnProceso;
	private JLabel lblTerminadas;
	private ArrayList<Proyecto> proyectos= new ArrayList<Proyecto>();
	private ArrayList<Persona> personas= new ArrayList<Persona>();
	private JLabel lbl3;
	private JLabel lbl2;
	private JLabel lbl1;
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
		frame.getContentPane().setLayout(new MigLayout("", "[182.00px][697px,grow]", "[421px,grow][23px]"));
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
			frame.getContentPane().add(pnlProyecto, "cell 1 0 1 2,grow");
			pnlProyecto.setLayout(new BoxLayout(pnlProyecto, BoxLayout.X_AXIS));
			{
				pnlPendientes = new JPanel();
				pnlPendientes.setBorder(null);
				pnlProyecto.add(pnlPendientes);
				pnlPendientes.setLayout(new GridLayout(0, 1, 0, 0));
				{
					lblPendientes = new JLabel("Pendientes");
					pnlPendientes.add(lblPendientes);
				}
				{
					lbl1 = new JLabel("New label");
					pnlPendientes.add(lbl1);
				}
				{
					lbl2 = new JLabel("New label");
					pnlPendientes.add(lbl2);
				}
				{
					lbl3 = new JLabel("Actividades añadidas");
					pnlPendientes.add(lbl3);
				}
			}
			{
				pnlEnProceso = new JPanel();
				pnlEnProceso.setBorder(null);
				pnlProyecto.add(pnlEnProceso);
				pnlEnProceso.setLayout(new BorderLayout(0, 0));
				{
					scrollPane_1 = new JScrollPane();
					pnlEnProceso.add(scrollPane_1, BorderLayout.CENTER);
				}
				{
					lblEnProceso = new JLabel("En Proceso");
					pnlEnProceso.add(lblEnProceso, BorderLayout.NORTH);
				}
			}
			{
				pnlTerminadas = new JPanel();
				pnlTerminadas.setBorder(null);
				pnlProyecto.add(pnlTerminadas);
				pnlTerminadas.setLayout(new BorderLayout(0, 0));
				{
					scrollPane_2 = new JScrollPane();
					pnlTerminadas.add(scrollPane_2, BorderLayout.CENTER);
				}
				{
					lblTerminadas = new JLabel("Terminadas");
					pnlTerminadas.add(lblTerminadas, BorderLayout.NORTH);
				}
			}
			{
				btnNuevaActividad = new JButton("Nueva actividad");
				btnNuevaActividad.addActionListener(new BtnNuevaActividadActionListener());
				pnlProyecto.add(btnNuevaActividad);
			}
		}
		pnlProyecto.setVisible(false);
		{
			btnAadirProyecto = new JButton("Añadir proyecto");
			btnAadirProyecto.addActionListener(new BtnAadirProyectoActionListener());
			frame.getContentPane().add(btnAadirProyecto, "cell 0 1,alignx center,aligny center");
			
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
		
		JLabel lista_lbl []= {lbl1,lbl2,lbl3};
		 
		
		try {
			for(int i =0; i<pr.getActividades().size();i++) {
				lista_lbl[i].setText(pr.getActividades().get(i).getNombre());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void limpiarpanel() {
		
		JLabel lista_lbl []= {lbl1,lbl2,lbl3};
		 
		
		try {
			for(int i =0; i<lista_lbl.length;i++) {
				lista_lbl[i].setText("");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
