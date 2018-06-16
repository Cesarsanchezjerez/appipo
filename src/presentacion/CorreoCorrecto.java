package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class CorreoCorrecto extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	/**
	 * Create the dialog.
	 */
	public CorreoCorrecto() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CorreoCorrecto.class.getResource("/recursos/icon.png")));
		setBounds(100, 100, 258, 113);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblCorreoEnviadoCorrectamente = new JLabel("Correo enviado correctamente");
			contentPanel.add(lblCorreoEnviadoCorrectamente);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			getContentPane().add(panel, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				panel.add(btnAceptar);
			}
		}
	}

	
}
