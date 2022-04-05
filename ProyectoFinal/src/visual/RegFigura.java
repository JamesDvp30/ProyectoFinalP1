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
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPanel PanelTrapecio;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPanel PanelCuadrado;
	private JPanel panel_1;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegFigura.class.getResource("/image/Reg figuras.jpg")));
		setTitle("Registro de figura");
		setBounds(100, 100, 585, 503);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaciones Figuras :", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(255, 255, 255)));
			panel.setBounds(12, 13, 548, 128);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
			lblNewLabel.setBounds(12, 26, 58, 16);
			panel.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(80, 23, 199, 22);
			panel.add(textField);
			textField.setColumns(10);
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.setForeground(new Color(0, 0, 255));
			btnBuscar.setFont(new Font("Book Antiqua", Font.BOLD, 13));
			btnBuscar.setBounds(315, 21, 97, 25);
			panel.add(btnBuscar);
			
			textField_1 = new JTextField();
			textField_1.setEnabled(false);
			textField_1.setBounds(80, 56, 199, 22);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre: ");
			lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 12));
			lblNewLabel_1.setBounds(12, 59, 56, 16);
			panel.add(lblNewLabel_1);
			
			JLabel lblCodigo = new JLabel("Codigo:");
			lblCodigo.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
			lblCodigo.setBounds(12, 92, 56, 16);
			panel.add(lblCodigo);
			
			textField_2 = new JTextField();
			textField_2.setEnabled(false);
			textField_2.setBounds(80, 89, 199, 22);
			panel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Eliga Tipo De Figura  :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
			panel.setBounds(12, 162, 548, 69);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			rdbtnTrapecio = new JRadioButton("Trapecio");
			rdbtnTrapecio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					rdbtnTrapecio.setSelected(true);
					rdbtnCuadrado.setSelected(false);
					rdbtnTriangulo.setSelected(false);
					rdbtnRectangulo.setSelected(false);
					rdbtnRombo.setSelected(false);
					
					PanelTrapecio.setVisible(true);
					PanelCuadrado.setVisible(false);
				//	.PanelTrapecPanelTrapecio.setVisible(true);
					
				}
			});
			rdbtnTrapecio.setBackground(Color.LIGHT_GRAY);
			rdbtnTrapecio.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
			rdbtnTrapecio.setBounds(8, 23, 83, 25);
			panel.add(rdbtnTrapecio);
			
			rdbtnRombo = new JRadioButton("Rombo");
			rdbtnRombo.setBackground(Color.LIGHT_GRAY);
			rdbtnRombo.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
			rdbtnRombo.setBounds(116, 23, 75, 25);
			panel.add(rdbtnRombo);
			
			rdbtnCuadrado = new JRadioButton("Cuadrado");
			rdbtnCuadrado.setBackground(Color.LIGHT_GRAY);
			rdbtnCuadrado.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
			rdbtnCuadrado.setBounds(205, 23, 91, 25);
			panel.add(rdbtnCuadrado);
			
			rdbtnTriangulo = new JRadioButton("Triangulo");
			rdbtnTriangulo.setBackground(Color.LIGHT_GRAY);
			rdbtnTriangulo.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
			rdbtnTriangulo.setBounds(310, 23, 104, 25);
			panel.add(rdbtnTriangulo);
			
			rdbtnRectangulo = new JRadioButton("Rectangulo");
			rdbtnRectangulo.setBackground(Color.LIGHT_GRAY);
			rdbtnRectangulo.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
			rdbtnRectangulo.setBounds(416, 23, 127, 25);
			panel.add(rdbtnRectangulo);
		}
		
		PanelTrapecio = new JPanel();
		PanelTrapecio.setBackground(Color.LIGHT_GRAY);
		PanelTrapecio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dimensiones Trapecio :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		PanelTrapecio.setBounds(12, 244, 543, 164);
		contentPanel.add(PanelTrapecio);
		PanelTrapecio.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Vertice TX");
		lblNewLabel_2.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
		lblNewLabel_2.setBounds(12, 41, 79, 16);
		PanelTrapecio.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(97, 38, 116, 22);
		PanelTrapecio.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Vertice TY");
		lblNewLabel_3.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
		lblNewLabel_3.setBounds(12, 70, 79, 16);
		PanelTrapecio.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(97, 67, 116, 22);
		PanelTrapecio.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Vertice TZ");
		lblNewLabel_4.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
		lblNewLabel_4.setBounds(12, 99, 73, 16);
		PanelTrapecio.add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(97, 96, 116, 22);
		PanelTrapecio.add(textField_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Vertice T");
		lblNewLabel_2_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(235, 41, 75, 16);
		PanelTrapecio.add(lblNewLabel_2_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(310, 35, 116, 22);
		PanelTrapecio.add(textField_6);
		
		JLabel lblNewLabel_3_1 = new JLabel("Altura T");
		lblNewLabel_3_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(235, 70, 62, 16);
		PanelTrapecio.add(lblNewLabel_3_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(310, 64, 116, 22);
		PanelTrapecio.add(textField_7);
		
		PanelCuadrado = new JPanel();
		PanelCuadrado.setBorder(new TitledBorder(null, "Informacion Rombo:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PanelCuadrado.setBounds(0, 0, 543, 164);
		PanelTrapecio.add(PanelCuadrado);
		PanelCuadrado.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Vertice X:");
		lblNewLabel_5.setBounds(27, 135, 86, 16);
		PanelCuadrado.add(lblNewLabel_5);
		
		JLabel lblVerticeY = new JLabel("Vertice Y:");
		lblVerticeY.setBounds(252, 135, 56, 16);
		PanelCuadrado.add(lblVerticeY);
		
		textField_8 = new JTextField();
		textField_8.setBounds(97, 132, 116, 22);
		PanelCuadrado.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(320, 132, 116, 22);
		PanelCuadrado.add(textField_9);
		textField_9.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 543, 164);
		PanelCuadrado.add(panel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setForeground(new Color(0, 0, 255));
				okButton.setFont(new Font("Book Antiqua", Font.BOLD, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(new Color(0, 0, 255));
				cancelButton.setFont(new Font("Book Antiqua", Font.BOLD, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
