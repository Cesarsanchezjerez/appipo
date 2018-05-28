package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.AbstractListModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;

import dominio.Actividad;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {
//asassadassd
	private JFrame frame;
	private JButton btnAadirProyecto;
	private JMenuBar menuBar;
	private JList listaProyectos;
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
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JLabel lblPendientes;
	private JLabel lblEnProceso;
	private JLabel lblTerminadas;

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
			listaProyectos = new JList();
			listaProyectos.addMouseListener(new ListaProyectosMouseListener());
			listaProyectos.setBorder(new TitledBorder(null, "Lista de proyectos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			listaProyectos.setModel(new AbstractListModel() {
				String[] values = new String[] {"Proyecto A", "Proyecto B", "Proyecto C"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
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
				pnlPendientes.setLayout(new BorderLayout(0, 0));
				{
					scrollPane = new JScrollPane();
					pnlPendientes.add(scrollPane);
				}
				{
					lblPendientes = new JLabel("Pendientes");
					pnlPendientes.add(lblPendientes, BorderLayout.NORTH);
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

	
	
	private class ListaProyectosMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			pnlProyecto.setVisible(true);
		}
	}
	private class BtnAadirProyectoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DialogoProyecto dp = new DialogoProyecto();
			dp.setVisible(true);
		}
	}
	private class BtnNuevaActividadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DialogoActividad da;
			try {
				da = new DialogoActividad(null);
				da.setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
