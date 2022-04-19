package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.CentroEstudios;
import logico.Cilindro;
import logico.Cuadrado;
import logico.Esfera;
import logico.Prisma;
import logico.Rectangulo;
import logico.Triangulo;
import logico.Usuario;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class CreatePrisma extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbtnCuadrado = new JRadioButton("Cuadrado");
	private JRadioButton rdbtnRectangulo = new JRadioButton("Rectangulo");
	private JRadioButton rdbtnRombo = new JRadioButton("Esfera");
	private JRadioButton rdbtnTriangulo = new JRadioButton("Triangulo");
	private JRadioButton rdbtnTrapecio = new JRadioButton("Cilindro");
	private JTextField spnAltura;
	private JTextField spnVertice1X;
	private JTextField spnVertice1Y;
	private JTextField textID;
	private JLabel labelTriangulo;
	private JLabel labelEsfera;
	private JLabel labelRectangulo;
	private JLabel labelCuadrado;
	private JLabel labelCilindro;
	public CreatePrisma(Usuario usuario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maykhol Sosa\\Downloads\\matematicas.png"));
		setTitle("Crear Prisma");
		setBounds(100, 100, 723, 461);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPrincipal.setBackground(Color.PINK);
		panelPrincipal.setBounds(11, 11, 683, 112);
		contentPanel.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblTipoBase = new JLabel("Tipo de Base:");
		lblTipoBase.setBounds(10, 36, 102, 14);
		panelPrincipal.add(lblTipoBase);
		rdbtnCuadrado.setBackground(Color.PINK);
		
		rdbtnCuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCuadrado.setSelected(true);
				rdbtnRectangulo.setSelected(false);
				rdbtnRombo.setSelected(false);
				rdbtnTriangulo.setSelected(false);
				rdbtnTrapecio.setSelected(false);
				textID.setText("C-"+CentroEstudios.getInstance().getCantPrismas());
				labelRectangulo.setVisible(false);
				labelTriangulo.setVisible(false);
				labelEsfera.setVisible(false);
				labelCilindro.setVisible(false);
				labelCuadrado.setVisible(true);



			}
		});
		rdbtnCuadrado.setSelected(true);
		rdbtnCuadrado.setBounds(10, 57, 109, 23);
		panelPrincipal.add(rdbtnCuadrado);
		rdbtnRectangulo.setBackground(Color.PINK);
		
		rdbtnRectangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCuadrado.setSelected(false);
				rdbtnRectangulo.setSelected(true);
				rdbtnRombo.setSelected(false);
				rdbtnTriangulo.setSelected(false);
				rdbtnTrapecio.setSelected(false);
				spnAltura.setEnabled(true);
				spnVertice1X.setEnabled(true);
				spnVertice1Y.setEnabled(true);
				textID.setText("R-"+CentroEstudios.getInstance().getCantPrismas());
				labelRectangulo.setVisible(true);
				labelTriangulo.setVisible(false);
				labelEsfera.setVisible(false);
				labelCilindro.setVisible(false);
				labelCuadrado.setVisible(false);



				
			}
		});
		rdbtnRectangulo.setBounds(155, 57, 109, 23);
		panelPrincipal.add(rdbtnRectangulo);
		rdbtnRombo.setBackground(Color.PINK);
		
		rdbtnRombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCuadrado.setSelected(false);
				rdbtnRectangulo.setSelected(false);
				rdbtnRombo.setSelected(true);
				rdbtnTriangulo.setSelected(false);
				rdbtnTrapecio.setSelected(false);

				
				spnVertice1Y.setEnabled(false);
				spnAltura.setEnabled(false);
				textID.setText("E-"+CentroEstudios.getInstance().getCantPrismas());
				
				labelRectangulo.setVisible(false);
				labelTriangulo.setVisible(false);
				labelEsfera.setVisible(true);
				labelCilindro.setVisible(false);
				labelCuadrado.setVisible(false);

			}
		});
		rdbtnRombo.setBounds(416, 57, 109, 23);
		panelPrincipal.add(rdbtnRombo);
		rdbtnTriangulo.setBackground(Color.PINK);
		
		rdbtnTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCuadrado.setSelected(false);
				rdbtnRectangulo.setSelected(false);
				rdbtnRombo.setSelected(false);
				rdbtnTriangulo.setSelected(true);
				rdbtnTrapecio.setSelected(false);
				spnVertice1Y.setEnabled(false);
				spnAltura.setEnabled(true);
				textID.setText("T-"+CentroEstudios.getInstance().getCantPrismas());
				labelRectangulo.setVisible(false);
				labelTriangulo.setVisible(true);
				labelEsfera.setVisible(false);
				labelCilindro.setVisible(false);
				labelCuadrado.setVisible(false);
				


			}
		});
		rdbtnTriangulo.setBounds(286, 57, 109, 23);
		panelPrincipal.add(rdbtnTriangulo);
		rdbtnTrapecio.setBackground(Color.PINK);
		
		rdbtnTrapecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCuadrado.setSelected(false);
				rdbtnRectangulo.setSelected(false);
				rdbtnRombo.setSelected(false);
				rdbtnTriangulo.setSelected(false);
				rdbtnTrapecio.setSelected(true);
                spnAltura.setEnabled(true);
				spnVertice1Y.setEnabled(false);
				spnVertice1X.setEnabled(true);
				textID.setText("CI-"+CentroEstudios.getInstance().getCantPrismas());
				
				labelRectangulo.setVisible(false);
				labelTriangulo.setVisible(false);
				labelEsfera.setVisible(false);
				labelCilindro.setVisible(true);
				labelCuadrado.setVisible(false);

			}
		});
		rdbtnTrapecio.setBounds(549, 57, 109, 23);
		panelPrincipal.add(rdbtnTrapecio);
		
		JPanel panelVertices = new JPanel();
		panelVertices.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelVertices.setBackground(Color.ORANGE);
		panelVertices.setBounds(40, 152, 624, 188);
		contentPanel.add(panelVertices);
		panelVertices.setLayout(null);
		
		JLabel lblVertice1 = new JLabel("Vertice:");
		lblVertice1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice1.setBounds(239, 11, 64, 14);
		panelVertices.add(lblVertice1);
		
		JLabel lblVertice1X = new JLabel("X");
		lblVertice1X.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice1X.setBounds(214, 38, 46, 14);
		panelVertices.add(lblVertice1X);
		
		JLabel lblVertice1Y = new JLabel("Y");
		lblVertice1Y.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice1Y.setBounds(282, 38, 46, 14);
		panelVertices.add(lblVertice1Y);
		
		JLabel lblAltura = new JLabel("Altura del Prisma:");
		lblAltura.setBounds(32, 38, 131, 14);
		panelVertices.add(lblAltura);
		
		spnAltura = new JTextField();
		spnAltura.setBounds(30, 65, 116, 22);
		panelVertices.add(spnAltura);
		spnAltura.setColumns(10);
		
		spnVertice1X = new JTextField();
		spnVertice1X.setBounds(191, 65, 69, 22);
		panelVertices.add(spnVertice1X);
		spnVertice1X.setColumns(10);
		
		spnVertice1Y = new JTextField();
		spnVertice1Y.setColumns(10);
		spnVertice1Y.setBounds(282, 65, 69, 22);
		panelVertices.add(spnVertice1Y);
		
		textID = new JTextField();
		textID.setBackground(Color.LIGHT_GRAY);
		textID.setEditable(false);
		textID.setBounds(496, 7, 116, 22);
		panelVertices.add(textID);
		textID.setColumns(10);
		
		labelCilindro = new JLabel("");
		labelCilindro.setVisible(false);
		labelCilindro.setIcon(new ImageIcon(CreatePrisma.class.getResource("/image/cilindro (1).png")));
		labelCilindro.setBounds(423, 38, 140, 138);
		panelVertices.add(labelCilindro);
		
		labelCuadrado = new JLabel("");
		labelCuadrado.setIcon(new ImageIcon(CreatePrisma.class.getResource("/image/cuadrado (1).png")));
		labelCuadrado.setBounds(423, 37, 140, 138);
		panelVertices.add(labelCuadrado);
		
		labelRectangulo = new JLabel("");
		labelRectangulo.setVisible(false);
		labelRectangulo.setIcon(new ImageIcon(CreatePrisma.class.getResource("/image/rectangulo.png")));
		labelRectangulo.setBounds(423, 37, 140, 138);
		panelVertices.add(labelRectangulo);
		
		labelEsfera = new JLabel("");
		labelEsfera.setVisible(false);
		labelEsfera.setIcon(new ImageIcon(CreatePrisma.class.getResource("/image/esfera (1).png")));
		labelEsfera.setBounds(423, 37, 140, 138);
		panelVertices.add(labelEsfera);
		
		labelTriangulo = new JLabel("");
		labelTriangulo.setVisible(false);
		labelTriangulo.setIcon(new ImageIcon(CreatePrisma.class.getResource("/image/triangulo (1).png")));
		labelTriangulo.setBounds(423, 37, 140, 138);
		panelVertices.add(labelTriangulo);
		rdbtnCuadrado.setSelected(true);
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(524, 378, 83, 36);
			contentPanel.add(btnAceptar);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String codigo = textID.getText();
					//Dependiendo el rdbtn que este selecionado se hara esa figura con los datos obtenidos
					if(rdbtnCuadrado.isSelected()) {
						Prisma pris = new Cuadrado(codigo,Float.parseFloat(spnVertice1Y.getText()),Float.parseFloat(spnAltura.getText()),Float.parseFloat(spnVertice1X.getText()));
						CentroEstudios.getInstance().addPrismas(pris, usuario);
					}
					else if(rdbtnRectangulo.isSelected()) {
						Prisma pris = new Rectangulo(codigo,Float.parseFloat(spnVertice1Y.getText()),Float.parseFloat(spnAltura.getText()),Float.parseFloat(spnVertice1X.getText()));
						CentroEstudios.getInstance().addPrismas(pris, usuario);
						

					}
					else if(rdbtnTriangulo.isSelected()) {
						Prisma pris = new Triangulo(codigo,Float.parseFloat(spnVertice1X.getText()),Float.parseFloat(spnAltura.getText()));
						CentroEstudios.getInstance().addPrismas(pris, usuario);
						
					}
					else if(rdbtnRombo.isSelected()) {
						Prisma pris = new Esfera(codigo,Float.parseFloat(spnVertice1X.getText()));
						CentroEstudios.getInstance().addPrismas(pris, usuario);

					}
					else if(rdbtnTrapecio.isSelected()) {
						Prisma pris = new Cilindro(codigo,Float.parseFloat(spnVertice1X.getText()),Float.parseFloat(spnAltura.getText()));
						CentroEstudios.getInstance().addPrismas(pris, usuario);
						
					}
					Prisma1 dialog = new Prisma1();
					dialog.setVisible(true);
					textID.setText("C-"+CentroEstudios.getInstance().getCantPrismas());
					rdbtnCuadrado.setSelected(true);
					
				}
			});
			btnAceptar.setActionCommand("OK");
			getRootPane().setDefaultButton(btnAceptar);
		}
		{
			JButton brnCancelar = new JButton("Cancelar");
			brnCancelar.setBounds(609, 378, 96, 36);
			contentPanel.add(brnCancelar);
			brnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			brnCancelar.setActionCommand("Cancel");
		}
		
		
	}
	private void clean() {
		spnVertice1Y.setText("");;
		spnVertice1X.setText("");
	}
}

