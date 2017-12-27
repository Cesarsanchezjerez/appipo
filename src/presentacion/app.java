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

public class App {

	private JFrame frame;
	private JButton btnAadirProyecto;
	private JMenuBar menuBar;
	private JList listaProyectos;
	private JLabel lblArchivo;
	private JPanel pnlProyecto;

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
			gbl_pnlProyecto.columnWidths = new int[]{0};
			gbl_pnlProyecto.rowHeights = new int[]{0};
			gbl_pnlProyecto.columnWeights = new double[]{Double.MIN_VALUE};
			gbl_pnlProyecto.rowWeights = new double[]{Double.MIN_VALUE};
			pnlProyecto.setLayout(gbl_pnlProyecto);
		}
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

}
