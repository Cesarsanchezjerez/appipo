package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTable;

public class CrearActividad extends JPanel {
	private JLabel lblNombre;
	private JLabel lblFechaInicio;
	private JTextField txtNombre;
	private JTextField txtFechainicio;
	private JLabel lblFechaFin;
	private JTextField txtFechafin;

	/**
	 * Create the panel.
	 */
	public CrearActividad() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "Crear Proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 93, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		{
			lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 1;
			add(lblNombre, gbc_lblNombre);
		}
		{
			txtNombre = new JTextField();
			GridBagConstraints gbc_txtNombre = new GridBagConstraints();
			gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
			gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNombre.gridx = 2;
			gbc_txtNombre.gridy = 1;
			add(txtNombre, gbc_txtNombre);
			txtNombre.setColumns(10);
		}
		{
			lblFechaInicio = new JLabel("Fecha Inicio");
			GridBagConstraints gbc_lblFechaInicio = new GridBagConstraints();
			gbc_lblFechaInicio.anchor = GridBagConstraints.EAST;
			gbc_lblFechaInicio.insets = new Insets(0, 0, 5, 5);
			gbc_lblFechaInicio.gridx = 1;
			gbc_lblFechaInicio.gridy = 2;
			add(lblFechaInicio, gbc_lblFechaInicio);
		}
		{
			txtFechainicio = new JTextField();
			txtFechainicio.setText("FechaInicio");
			GridBagConstraints gbc_txtFechainicio = new GridBagConstraints();
			gbc_txtFechainicio.insets = new Insets(0, 0, 5, 5);
			gbc_txtFechainicio.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFechainicio.gridx = 2;
			gbc_txtFechainicio.gridy = 2;
			add(txtFechainicio, gbc_txtFechainicio);
			txtFechainicio.setColumns(10);
		}
		{
			lblFechaFin = new JLabel("Fecha Fin");
			GridBagConstraints gbc_lblFechaFin = new GridBagConstraints();
			gbc_lblFechaFin.anchor = GridBagConstraints.EAST;
			gbc_lblFechaFin.insets = new Insets(0, 0, 5, 5);
			gbc_lblFechaFin.gridx = 3;
			gbc_lblFechaFin.gridy = 2;
			add(lblFechaFin, gbc_lblFechaFin);
		}
		{
			txtFechafin = new JTextField();
			txtFechafin.setText("FechaFin");
			GridBagConstraints gbc_txtFechafin = new GridBagConstraints();
			gbc_txtFechafin.insets = new Insets(0, 0, 5, 0);
			gbc_txtFechafin.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFechafin.gridx = 4;
			gbc_txtFechafin.gridy = 2;
			add(txtFechafin, gbc_txtFechafin);
			txtFechafin.setColumns(10);
		}
	}

}
