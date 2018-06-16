package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Persona;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DialogoCorreo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Asunto;
	private JComboBox<String> comboBox;

	
	public DialogoCorreo(ArrayList<Persona> personas) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblDe = new JLabel("De:");
			GridBagConstraints gbc_lblDe = new GridBagConstraints();
			gbc_lblDe.anchor = GridBagConstraints.WEST;
			gbc_lblDe.insets = new Insets(0, 0, 5, 5);
			gbc_lblDe.gridx = 0;
			gbc_lblDe.gridy = 0;
			contentPanel.add(lblDe, gbc_lblDe);
		}
		{
			JLabel lblPedroipocom = new JLabel("pedro@IPO.com");
			GridBagConstraints gbc_lblPedroipocom = new GridBagConstraints();
			gbc_lblPedroipocom.insets = new Insets(0, 0, 5, 5);
			gbc_lblPedroipocom.gridx = 1;
			gbc_lblPedroipocom.gridy = 0;
			contentPanel.add(lblPedroipocom, gbc_lblPedroipocom);
		}
		{
			JLabel lblPara = new JLabel("Para:");
			GridBagConstraints gbc_lblPara = new GridBagConstraints();
			gbc_lblPara.anchor = GridBagConstraints.WEST;
			gbc_lblPara.insets = new Insets(0, 0, 5, 5);
			gbc_lblPara.gridx = 0;
			gbc_lblPara.gridy = 1;
			contentPanel.add(lblPara, gbc_lblPara);
		}
		{
			comboBox = new JComboBox<String>();
			for (Persona persona : personas) {
				comboBox.addItem(persona.getNombre());
			}
			comboBox.setSelectedIndex(-1);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 1;
			contentPanel.add(comboBox, gbc_comboBox);
		}
		{
			JLabel lblAsunto = new JLabel("Asunto:");
			GridBagConstraints gbc_lblAsunto = new GridBagConstraints();
			gbc_lblAsunto.anchor = GridBagConstraints.WEST;
			gbc_lblAsunto.insets = new Insets(0, 0, 5, 5);
			gbc_lblAsunto.gridx = 0;
			gbc_lblAsunto.gridy = 2;
			contentPanel.add(lblAsunto, gbc_lblAsunto);
		}
		{
			Asunto = new JTextField();
			GridBagConstraints gbc_Asunto = new GridBagConstraints();
			gbc_Asunto.gridwidth = 2;
			gbc_Asunto.insets = new Insets(0, 0, 5, 0);
			gbc_Asunto.anchor = GridBagConstraints.ABOVE_BASELINE;
			gbc_Asunto.fill = GridBagConstraints.HORIZONTAL;
			gbc_Asunto.gridx = 1;
			gbc_Asunto.gridy = 2;
			contentPanel.add(Asunto, gbc_Asunto);
			Asunto.setColumns(10);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridwidth = 3;
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 3;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Enviar\r\n");
				okButton.addActionListener(new OkButtonActionListener());
				{
					JLabel lblAviso = new JLabel("");
					lblAviso.setForeground(Color.RED);
					buttonPane.add(lblAviso);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new CancelButtonActionListener());
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
	}
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (comboBox.getSelectedItem()==null) {
			
			}
		}
	}
}
