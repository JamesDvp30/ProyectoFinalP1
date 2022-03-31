package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegFigura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbtnTrapecio;
	private JRadioButton rdbtnRombo;
	private JRadioButton rdbtnCuadrado;
	private JRadioButton rdbtnTriangulo;
	private JRadioButton rdbtnRectangulo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegFigura dialog = new RegFigura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegFigura() {
		setTitle("Registro de figura");
		setBounds(100, 100, 585, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Quien Registra la figura?", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(12, 13, 548, 136);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setBounds(12, 26, 56, 16);
			panel.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(80, 23, 199, 22);
			panel.add(textField);
			textField.setColumns(10);
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(348, 22, 97, 25);
			panel.add(btnBuscar);
			
			textField_1 = new JTextField();
			textField_1.setEnabled(false);
			textField_1.setBounds(103, 68, 116, 22);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre: ");
			lblNewLabel_1.setBounds(12, 71, 56, 16);
			panel.add(lblNewLabel_1);
			
			JLabel lblCodigo = new JLabel("Codigo:");
			lblCodigo.setBounds(12, 100, 56, 16);
			panel.add(lblCodigo);
			
			textField_2 = new JTextField();
			textField_2.setEnabled(false);
			textField_2.setBounds(103, 97, 116, 22);
			panel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Elija el tipo de figura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(12, 162, 548, 69);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			rdbtnTrapecio = new JRadioButton("Trapecio");
			rdbtnTrapecio.setBounds(8, 23, 83, 25);
			panel.add(rdbtnTrapecio);
			
			rdbtnRombo = new JRadioButton("Rombo");
			rdbtnRombo.setBounds(116, 23, 75, 25);
			panel.add(rdbtnRombo);
			
			rdbtnCuadrado = new JRadioButton("Cuadrado");
			rdbtnCuadrado.setBounds(205, 23, 83, 25);
			panel.add(rdbtnCuadrado);
			
			rdbtnTriangulo = new JRadioButton("Triangulo");
			rdbtnTriangulo.setBounds(310, 23, 91, 25);
			panel.add(rdbtnTriangulo);
			
			rdbtnRectangulo = new JRadioButton("Rectangulo");
			rdbtnRectangulo.setBounds(416, 23, 127, 25);
			panel.add(rdbtnRectangulo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
