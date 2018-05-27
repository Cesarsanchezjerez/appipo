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
import javax.swing.event.ListSelectionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App {

	private JFrame frame;
	private JButton btnAadirProyecto;
	private JMenuBar menuBar;
	private JList listaProyectos;
	private JLabel lblArchivo;
	private JPanel pnlProyecto;
	private JPanel pnlPendientes;
	private JPanel pnlEnProceso;
	private JPanel pnlTerminadas;
	private JButton btnNuevaActividad;

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
			GridBagLayout gbl_pnlProyecto = new GridBagLayout();
			gbl_pnlProyecto.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_pnlProyecto.rowHeights = new int[]{0, 0};
			gbl_pnlProyecto.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_pnlProyecto.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			pnlProyecto.setLayout(gbl_pnlProyecto);
			{
				pnlPendientes = new JPanel();
				pnlPendientes.setBorder(new TitledBorder(null, "Pendientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				GridBagConstraints gbc_pnlPendientes = new GridBagConstraints();
				gbc_pnlPendientes.insets = new Insets(0, 0, 0, 5);
				gbc_pnlPendientes.fill = GridBagConstraints.BOTH;
				gbc_pnlPendientes.gridx = 0;
				gbc_pnlPendientes.gridy = 0;
				pnlProyecto.add(pnlPendientes, gbc_pnlPendientes);
			}
			{
				pnlEnProceso = new JPanel();
				pnlEnProceso.setBorder(new TitledBorder(null, "En proceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				GridBagConstraints gbc_pnlEnProceso = new GridBagConstraints();
				gbc_pnlEnProceso.insets = new Insets(0, 0, 0, 5);
				gbc_pnlEnProceso.fill = GridBagConstraints.BOTH;
				gbc_pnlEnProceso.gridx = 1;
				gbc_pnlEnProceso.gridy = 0;
				pnlProyecto.add(pnlEnProceso, gbc_pnlEnProceso);
			}
			{
				pnlTerminadas = new JPanel();
				pnlTerminadas.setBorder(new TitledBorder(null, "Terminadas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				GridBagConstraints gbc_pnlTerminadas = new GridBagConstraints();
				gbc_pnlTerminadas.insets = new Insets(0, 0, 0, 5);
				gbc_pnlTerminadas.fill = GridBagConstraints.BOTH;
				gbc_pnlTerminadas.gridx = 2;
				gbc_pnlTerminadas.gridy = 0;
				pnlProyecto.add(pnlTerminadas, gbc_pnlTerminadas);
			}
			{
				btnNuevaActividad = new JButton("Nueva actividad");
				GridBagConstraints gbc_btnNuevaActividad = new GridBagConstraints();
				gbc_btnNuevaActividad.anchor = GridBagConstraints.NORTH;
				gbc_btnNuevaActividad.gridx = 3;
				gbc_btnNuevaActividad.gridy = 0;
				pnlProyecto.add(btnNuevaActividad, gbc_btnNuevaActividad);
			}
		}
		pnlProyecto.setVisible(false);
		{
			btnAadirProyecto = new JButton("Añadir proyecto");
			frame.getContentPane().add(btnAadirProyecto, "cell 0 1,alignx center,aligny center");
			
		}
		{
			menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			{
				lblArchivo = new JLabel("Archivo");
				menuBar.add(lblArchivo);
			}
		}
	}

	
	
	private class ListaProyectosMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			pnlProyecto.setVisible(true);
		}
	}
}
