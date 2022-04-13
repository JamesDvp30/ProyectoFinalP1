package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.CentroEstudios;
import logico.Cuadrado;
import logico.Prisma;
import logico.Rectangulo;
import logico.Rombo;
import logico.Trapecio;
import logico.Triangulo;
import logico.Usuario;
import logico.Vertice;

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

public class CreatePrisma extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbtnCuadrado = new JRadioButton("Cuadrado");
	private JRadioButton rdbtnRectangulo = new JRadioButton("Rectangulo");
	private JRadioButton rdbtnRombo = new JRadioButton("Rombo");
	private JRadioButton rdbtnTriangulo = new JRadioButton("Triangulo");
	private JRadioButton rdbtnTrapecio = new JRadioButton("Trapecio");
	private JSpinner spnAltura = new JSpinner();
	private JSpinner spnVertice1X = new JSpinner();
	private JSpinner spnVertice1Y = new JSpinner();
	private JSpinner spnVertice2X = new JSpinner();
	private JSpinner spnVertice2Y = new JSpinner();
	private JSpinner spnVertice3Y = new JSpinner();
	private JSpinner spnVertice3X = new JSpinner();
	private JSpinner spnVertice4X = new JSpinner();
	private JSpinner spnVertice4Y = new JSpinner();
	private JSpinner spnTrapecio = new JSpinner();
	public CreatePrisma(Usuario usuario) {
		setTitle("Crear Prisma");
		setBounds(100, 100, 581, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPrincipal.setBackground(Color.LIGHT_GRAY);
		panelPrincipal.setBounds(10, 11, 543, 112);
		contentPanel.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura del Prisma:");
		lblAltura.setBounds(10, 11, 102, 14);
		panelPrincipal.add(lblAltura);
		
		
		spnAltura.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnAltura.setBounds(122, 8, 121, 20);
		panelPrincipal.add(spnAltura);
		
		JLabel lblTipoBase = new JLabel("Tipo de Base:");
		lblTipoBase.setBounds(10, 36, 102, 14);
		panelPrincipal.add(lblTipoBase);
		rdbtnCuadrado.setBackground(Color.LIGHT_GRAY);
		
		rdbtnCuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCuadrado.setSelected(true);
				rdbtnRectangulo.setSelected(false);
				rdbtnRombo.setSelected(false);
				rdbtnTriangulo.setSelected(false);
				rdbtnTrapecio.setSelected(false);

				spnVertice3Y.setEnabled(false);
				spnVertice3X.setEnabled(false);
				spnVertice4X.setEnabled(false);
				spnVertice4Y.setEnabled(false);
				spnTrapecio.setEnabled(false);


			}
		});
		rdbtnCuadrado.setSelected(true);
		rdbtnCuadrado.setBounds(10, 57, 109, 23);
		panelPrincipal.add(rdbtnCuadrado);
		rdbtnRectangulo.setBackground(Color.LIGHT_GRAY);
		
		rdbtnRectangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCuadrado.setSelected(false);
				rdbtnRectangulo.setSelected(true);
				rdbtnRombo.setSelected(false);
				rdbtnTriangulo.setSelected(false);
				rdbtnTrapecio.setSelected(false);

				spnVertice3Y.setEnabled(true);
				spnVertice3X.setEnabled(true);
				spnVertice4X.setEnabled(false);
				spnVertice4Y.setEnabled(false);
				spnTrapecio.setEnabled(false);


				
			}
		});
		rdbtnRectangulo.setBounds(122, 57, 109, 23);
		panelPrincipal.add(rdbtnRectangulo);
		rdbtnRombo.setBackground(Color.LIGHT_GRAY);
		
		rdbtnRombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCuadrado.setSelected(false);
				rdbtnRectangulo.setSelected(false);
				rdbtnRombo.setSelected(true);
				rdbtnTriangulo.setSelected(false);
				rdbtnTrapecio.setSelected(false);

				spnVertice3Y.setEnabled(true);
				spnVertice3X.setEnabled(true);
				spnVertice4X.setEnabled(true);
				spnVertice4Y.setEnabled(true);
				spnTrapecio.setEnabled(false);

			}
		});
		rdbtnRombo.setBounds(344, 57, 109, 23);
		panelPrincipal.add(rdbtnRombo);
		rdbtnTriangulo.setBackground(Color.LIGHT_GRAY);
		
		rdbtnTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCuadrado.setSelected(false);
				rdbtnRectangulo.setSelected(false);
				rdbtnRombo.setSelected(false);
				rdbtnTriangulo.setSelected(true);
				rdbtnTrapecio.setSelected(false);

				spnVertice3Y.setEnabled(true);
				spnVertice3X.setEnabled(true);
				spnVertice4X.setEnabled(false);
				spnVertice4Y.setEnabled(false);
				spnTrapecio.setEnabled(false);

			}
		});
		rdbtnTriangulo.setBounds(233, 57, 109, 23);
		panelPrincipal.add(rdbtnTriangulo);
		rdbtnTrapecio.setBackground(Color.LIGHT_GRAY);
		
		rdbtnTrapecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCuadrado.setSelected(false);
				rdbtnRectangulo.setSelected(false);
				rdbtnRombo.setSelected(false);
				rdbtnTriangulo.setSelected(false);
				rdbtnTrapecio.setSelected(true);

				spnVertice3Y.setEnabled(true);
				spnVertice3X.setEnabled(true);
				spnVertice4X.setEnabled(true);
				spnVertice4Y.setEnabled(true);
				spnTrapecio.setEnabled(true);

			}
		});
		rdbtnTrapecio.setBounds(455, 57, 109, 23);
		panelPrincipal.add(rdbtnTrapecio);
		
		JPanel panelVertices = new JPanel();
		panelVertices.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelVertices.setBackground(Color.LIGHT_GRAY);
		panelVertices.setBounds(10, 134, 543, 188);
		contentPanel.add(panelVertices);
		panelVertices.setLayout(null);
		
		JLabel lblVertice1 = new JLabel("Vertice1:");
		lblVertice1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice1.setBounds(31, 11, 64, 14);
		panelVertices.add(lblVertice1);
		
		JLabel lblVertice1X = new JLabel("X");
		lblVertice1X.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice1X.setBounds(10, 36, 46, 14);
		panelVertices.add(lblVertice1X);
		
		JLabel lblVertice1Y = new JLabel("Y");
		lblVertice1Y.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice1Y.setBounds(66, 36, 46, 14);
		panelVertices.add(lblVertice1Y);
		
		
		spnVertice1X.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnVertice1X.setBounds(10, 61, 46, 20);
		panelVertices.add(spnVertice1X);
		
		
		spnVertice1Y.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnVertice1Y.setBounds(66, 61, 46, 20);
		panelVertices.add(spnVertice1Y);
		
		JLabel lblVertice2X = new JLabel("X");
		lblVertice2X.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice2X.setBounds(153, 36, 46, 14);
		panelVertices.add(lblVertice2X);
		
		
		spnVertice2X.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnVertice2X.setBounds(153, 61, 46, 20);
		panelVertices.add(spnVertice2X);
		
		
		spnVertice2Y.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnVertice2Y.setBounds(209, 61, 46, 20);
		panelVertices.add(spnVertice2Y);
		
		JLabel lblVertice2Y = new JLabel("Y");
		lblVertice2Y.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice2Y.setBounds(209, 36, 46, 14);
		panelVertices.add(lblVertice2Y);
		
		JLabel lblVertice2 = new JLabel("Vertice2:");
		lblVertice2.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice2.setBounds(171, 11, 64, 14);
		panelVertices.add(lblVertice2);
		spnVertice3Y.setEnabled(false);
		
		
		spnVertice3Y.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnVertice3Y.setBounds(353, 61, 46, 20);
		panelVertices.add(spnVertice3Y);
		spnVertice3X.setEnabled(false);
		
		
		spnVertice3X.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnVertice3X.setBounds(297, 61, 46, 20);
		panelVertices.add(spnVertice3X);
		
		JLabel lblVertice3X = new JLabel("X");
		lblVertice3X.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice3X.setBounds(297, 36, 46, 14);
		panelVertices.add(lblVertice3X);
		
		JLabel lblVertice3Y = new JLabel("Y");
		lblVertice3Y.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice3Y.setBounds(353, 36, 46, 14);
		panelVertices.add(lblVertice3Y);
		
		JLabel lblVertice3 = new JLabel("Vertice3:");
		lblVertice3.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice3.setBounds(318, 11, 64, 14);
		panelVertices.add(lblVertice3);
		
		JLabel lblVertice4 = new JLabel("Vertice4:");
		lblVertice4.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice4.setBounds(449, 11, 64, 14);
		panelVertices.add(lblVertice4);
		
		JLabel lblVertice4X = new JLabel("X");
		lblVertice4X.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice4X.setBounds(431, 36, 46, 14);
		panelVertices.add(lblVertice4X);
		
		JLabel lblVertice4Y = new JLabel("Y");
		lblVertice4Y.setHorizontalAlignment(SwingConstants.CENTER);
		lblVertice4Y.setBounds(487, 36, 46, 14);
		panelVertices.add(lblVertice4Y);
		spnVertice4X.setEnabled(false);
		
		
		spnVertice4X.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnVertice4X.setBounds(431, 61, 46, 20);
		panelVertices.add(spnVertice4X);
		spnVertice4Y.setEnabled(false);
		
		
		spnVertice4Y.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnVertice4Y.setBounds(487, 61, 46, 20);
		panelVertices.add(spnVertice4Y);
		
		JLabel lblAlturaTrapecio = new JLabel("Altura Trapecio:");
		lblAlturaTrapecio.setBounds(10, 108, 102, 14);
		panelVertices.add(lblAlturaTrapecio);
		spnTrapecio.setEnabled(false);
		
		
		spnTrapecio.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		spnTrapecio.setBounds(10, 133, 80, 20);
		panelVertices.add(spnTrapecio);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Dependiendo de cual opcion fue seleccionada, se eligen los vertice
						if(rdbtnCuadrado.isSelected()) {
							Vertice[] vertices = {new Vertice((Float)spnVertice1X.getValue(), (Float)spnVertice1Y.getValue()),
									new Vertice((Float)spnVertice2X.getValue(), (Float)spnVertice2Y.getValue())};
						
							Cuadrado cuadrado = new Cuadrado((Float) spnAltura.getValue());
							guardarVertices(vertices, cuadrado, usuario);
							
						}
						else if(rdbtnRectangulo.isSelected()) {
							Vertice[] vertices = {new Vertice((Float)spnVertice1X.getValue(), (Float)spnVertice1Y.getValue()), 
									new Vertice((Float)spnVertice2X.getValue(), (Float)spnVertice2Y.getValue()),
									new Vertice((Float)spnVertice3X.getValue(), (Float)spnVertice3Y.getValue())};
							Rectangulo rectangulo = new Rectangulo((Float) spnAltura.getValue());
							guardarVertices(vertices, rectangulo, usuario);

						}
						else if(rdbtnTriangulo.isSelected()) {
							Vertice[] vertices = {new Vertice((Float)spnVertice1X.getValue(), (Float)spnVertice1Y.getValue()), 
									new Vertice((Float)spnVertice2X.getValue(), (Float)spnVertice2Y.getValue()),
									new Vertice((Float)spnVertice3X.getValue(), (Float)spnVertice3Y.getValue())};
							Triangulo triangulo = new Triangulo((Float) spnAltura.getValue());
							guardarVertices(vertices, triangulo, usuario);
						}
						else if(rdbtnRombo.isSelected()) {
							Vertice[] vertices = {new Vertice((Float)spnVertice1X.getValue(), (Float)spnVertice1Y.getValue()), 
									new Vertice((Float)spnVertice2X.getValue(), (Float)spnVertice2Y.getValue()),
									new Vertice((Float)spnVertice3X.getValue(), (Float)spnVertice3Y.getValue()),
									new Vertice((Float)spnVertice4X.getValue(), (Float)spnVertice4Y.getValue())};
							Rombo rombo = new Rombo((Float) spnAltura.getValue());
							guardarVertices(vertices, rombo, usuario);

						}
						else if(rdbtnTrapecio.isSelected()) {
							Vertice[] vertices = {new Vertice((Float)spnVertice1X.getValue(), (Float)spnVertice1Y.getValue()), 
									new Vertice((Float)spnVertice2X.getValue(), (Float)spnVertice2Y.getValue()),
									new Vertice((Float)spnVertice3X.getValue(), (Float)spnVertice3Y.getValue()),
									new Vertice((Float)spnVertice4X.getValue(), (Float)spnVertice4Y.getValue())};
							Trapecio trapecio = new Trapecio((Float) spnAltura.getValue(), (Float)spnTrapecio.getValue());
							guardarVertices(vertices, trapecio, usuario);
						}
						
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton brnCancelar = new JButton("Cancelar");
				brnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				brnCancelar.setActionCommand("Cancel");
				buttonPane.add(brnCancelar);
			}
		}
		
	}
	private void clean() {
		spnVertice1X.setValue(0.0f);
		spnVertice1Y.setValue(0.0f);
		spnVertice2X.setValue(0.0f);
		spnVertice2Y.setValue(0.0f);
		spnVertice3Y.setValue(0.0f);
		spnVertice3X.setValue(0.0f);
		spnVertice4X.setValue(0.0f);
		spnVertice4Y.setValue(0.0f);
		spnTrapecio.setValue(1.0f);
		spnAltura.setValue(1.0f);
	}
	private void guardarVertices(Vertice[] vertices, Prisma prisma, Usuario usuario) {
		boolean error = false;

		for(Vertice vertice : vertices) {
			error = !prisma.addVertice(vertice);
			if(error) {
				JOptionPane.showMessageDialog(null, "No pueden haber dos vertices iguales!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		if(!error) {
			CentroEstudios.getInstance().addPrismas(prisma, usuario);
			JOptionPane.showMessageDialog(null, "Prisma Registrado Con Exito", "Realizado", JOptionPane.INFORMATION_MESSAGE);
			clean();
		}
	}
}

