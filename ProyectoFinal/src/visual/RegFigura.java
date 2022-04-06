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
import java.awt.Panel;

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
	private JTextField txtVerticeTX;
	private JTextField txtVerticeTY;
	private JTextField textField_5;
	private JTextField textField_6;
	private Panel PanelTrapecio;
	private JTextField txtVerticeTZ;
	private JTextField txtAlturaT;
	private JTextField txtVerticeT;
	private Panel PanelCuadrado;
	private Panel PanelRombo;
	private JLabel lblNewLabel_7;
	private JTextField textField_3;
	private JLabel lblNewLabel_8;
	private JTextField textField_4;
	private JLabel lblNewLabel_9;
	private JTextField textField_7;
	private JTextField textField_8;
	private Panel panelTriangulo;
	private JLabel lblVerticeeBx;
	private JTextField textField_9;
	private JLabel lblVerticeBy;
	private JTextField textField_10;
	private JLabel lblVerticeAltura;
	private JTextField textField_11;
	private Panel panelRectangulo;
	private JLabel lblNewLabel_10;
	private JTextField textField_12;
	private JLabel lblNewLabel_11;
	private JTextField textField_13;
	private JLabel lblNewLabel_12;
	private JLabel lblVerticeR;
	private JTextField textField_14;

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
		setBounds(100, 100, 591, 625);
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
			panel.setBounds(12, 143, 548, 69);
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
		
		PanelTrapecio = new Panel();
		PanelTrapecio.setBounds(12, 420, 548, 113);
		contentPanel.add(PanelTrapecio);
		PanelTrapecio.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Vertice TX:");
		lblNewLabel_2.setBounds(12, 23, 71, 16);
		PanelTrapecio.add(lblNewLabel_2);
		
		txtVerticeTX = new JTextField();
		txtVerticeTX.setBounds(95, 20, 116, 22);
		PanelTrapecio.add(txtVerticeTX);
		txtVerticeTX.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Vertice TY:");
		lblNewLabel_3.setBounds(12, 52, 71, 16);
		PanelTrapecio.add(lblNewLabel_3);
		
		txtVerticeTY = new JTextField();
		txtVerticeTY.setBounds(95, 49, 116, 22);
		PanelTrapecio.add(txtVerticeTY);
		txtVerticeTY.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Vertice TZ:");
		lblNewLabel_6.setBounds(12, 81, 64, 16);
		PanelTrapecio.add(lblNewLabel_6);
		
		txtVerticeTZ = new JTextField();
		txtVerticeTZ.setBounds(95, 78, 116, 22);
		PanelTrapecio.add(txtVerticeTZ);
		txtVerticeTZ.setColumns(10);
		
		txtAlturaT = new JTextField();
		txtAlturaT.setBounds(338, 20, 116, 22);
		PanelTrapecio.add(txtAlturaT);
		txtAlturaT.setColumns(10);
		
		txtVerticeT = new JTextField();
		txtVerticeT.setBounds(338, 49, 116, 22);
		PanelTrapecio.add(txtVerticeT);
		txtVerticeT.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura T:");
		lblAltura.setBounds(259, 23, 56, 16);
		PanelTrapecio.add(lblAltura);
		
		JLabel lblVerticeT = new JLabel("Vertice T:");
		lblVerticeT.setBounds(259, 52, 67, 16);
		PanelTrapecio.add(lblVerticeT);
		
		PanelRombo = new Panel();
		PanelRombo.setBounds(12, 325, 547, 42);
		contentPanel.add(PanelRombo);
		PanelRombo.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Vertice X:");
		lblNewLabel_4.setBounds(12, 13, 66, 16);
		PanelRombo.add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(74, 10, 66, 22);
		PanelRombo.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Vertice Y:");
		lblNewLabel_5.setBounds(152, 13, 56, 16);
		PanelRombo.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(220, 10, 66, 22);
		PanelRombo.add(textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Vertice Z:");
		lblNewLabel_9.setBounds(298, 13, 60, 16);
		PanelRombo.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setBounds(370, 10, 56, 22);
		PanelRombo.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(484, 10, 51, 22);
		PanelRombo.add(textField_8);
		textField_8.setColumns(10);
		
		lblVerticeR = new JLabel("Vertice R:");
		lblVerticeR.setBounds(431, 13, 72, 16);
		PanelRombo.add(lblVerticeR);
		
		PanelCuadrado = new Panel();
		PanelCuadrado.setBounds(12, 218, 548, 36);
		contentPanel.add(PanelCuadrado);
		PanelCuadrado.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Vertice X:");
		lblNewLabel_7.setBounds(12, 13, 67, 16);
		PanelCuadrado.add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		textField_3.setBounds(91, 10, 116, 22);
		PanelCuadrado.add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Vertice Y:");
		lblNewLabel_8.setBounds(263, 13, 56, 16);
		PanelCuadrado.add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		textField_4.setBounds(347, 10, 116, 22);
		PanelCuadrado.add(textField_4);
		textField_4.setColumns(10);
		
		panelTriangulo = new Panel();
		panelTriangulo.setBounds(12, 260, 548, 42);
		contentPanel.add(panelTriangulo);
		panelTriangulo.setLayout(null);
		
		lblVerticeeBx = new JLabel("Verticee BX:");
		lblVerticeeBx.setBounds(10, 13, 71, 16);
		panelTriangulo.add(lblVerticeeBx);
		
		textField_9 = new JTextField();
		textField_9.setBounds(93, 10, 98, 22);
		panelTriangulo.add(textField_9);
		textField_9.setColumns(10);
		
		lblVerticeBy = new JLabel("Vertice BY:");
		lblVerticeBy.setBounds(203, 13, 80, 16);
		panelTriangulo.add(lblVerticeBy);
		
		textField_10 = new JTextField();
		textField_10.setBounds(281, 10, 93, 22);
		panelTriangulo.add(textField_10);
		textField_10.setColumns(10);
		
		lblVerticeAltura = new JLabel("Vertice Altura:");
		lblVerticeAltura.setBounds(386, 13, 93, 16);
		panelTriangulo.add(lblVerticeAltura);
		
		textField_11 = new JTextField();
		textField_11.setBounds(480, 10, 56, 22);
		panelTriangulo.add(textField_11);
		textField_11.setColumns(10);
		
		panelRectangulo = new Panel();
		panelRectangulo.setBounds(12, 378, 548, 36);
		contentPanel.add(panelRectangulo);
		panelRectangulo.setLayout(null);
		
		lblNewLabel_10 = new JLabel("Vertice X:");
		lblNewLabel_10.setBounds(12, 13, 58, 16);
		panelRectangulo.add(lblNewLabel_10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(82, 10, 104, 22);
		panelRectangulo.add(textField_12);
		textField_12.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Vertice Y:");
		lblNewLabel_11.setBounds(200, 13, 56, 16);
		panelRectangulo.add(lblNewLabel_11);
		
		textField_13 = new JTextField();
		textField_13.setBounds(268, 10, 89, 22);
		panelRectangulo.add(textField_13);
		textField_13.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Vertice Z:");
		lblNewLabel_12.setBounds(362, 13, 56, 16);
		panelRectangulo.add(lblNewLabel_12);
		
		textField_14 = new JTextField();
		textField_14.setBounds(420, 10, 116, 22);
		panelRectangulo.add(textField_14);
		textField_14.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setForeground(new Color(0, 0, 255));
				btnRegistrar.setFont(new Font("Book Antiqua", Font.BOLD, 14));
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setForeground(new Color(0, 0, 255));
				btnCancelar.setFont(new Font("Book Antiqua", Font.BOLD, 14));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
