package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import logico.CentroEstudios;
import logico.Usuario;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Toolkit;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnEstudiante;
	private JPasswordField psfPass;
	private JPasswordField psfConfirmPass;
	private JLabel lblest;
	private JLabel lblprof;
	private JPanel panelprofe;
	private JPanel panelleyendo;
	
	
	public RegUsuario(boolean listarUsuario) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maykhol Sosa\\Downloads\\matematicas.png"));
		setTitle("Registrar Usuario");
		setBounds(100, 100, 418, 503);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_principal = new JPanel();
		panel_principal.setBounds(10, 11, 382, 401);
		panel_principal.setBackground(SystemColor.activeCaption);
		panel_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel_principal);
		panel_principal.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(161, 149, 66, 16);
		panel_principal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(70, 176, 248, 28);
		panel_principal.add(txtNombre);
		txtNombre.setColumns(10);
		
		rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnEstudiante.setBackground(SystemColor.activeCaption);
		rdbtnEstudiante.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(rdbtnProfesor.isSelected()) {
					//rdbtnEstudiante.setSelected(true);
					rdbtnProfesor.setSelected(false);
					
					panelleyendo.setVisible(true);
					panelprofe.setVisible(false);
					
				}
				else if(rdbtnEstudiante.isSelected()) {
					rdbtnEstudiante.setSelected(true);
					panelleyendo.setVisible(false);
					panelprofe.setVisible(true);
				}
			}
		});
		rdbtnEstudiante.setBounds(54, 247, 115, 18);
		panel_principal.add(rdbtnEstudiante);
		
		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnProfesor.setBackground(SystemColor.activeCaption);
		rdbtnProfesor.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(rdbtnEstudiante.isSelected()) {
					rdbtnProfesor.setSelected(true);
					rdbtnEstudiante.setSelected(false);
					
					panelleyendo.setVisible(false);
					panelprofe.setVisible(true);
				}
				else if(rdbtnProfesor.isSelected()) {
					rdbtnProfesor.setSelected(true);
					
					panelleyendo.setVisible(true);
					panelprofe.setVisible(false);
				}
			}
		});
		//rdbtnProfesor.setSelected(true);
		rdbtnProfesor.setBounds(218, 247, 115, 18);
		panel_principal.add(rdbtnProfesor);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(161, 86, 66, 16);
		panel_principal.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(70, 113, 248, 28);
		panel_principal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPass.setBounds(150, 272, 93, 14);
		panel_principal.add(lblPass);
		
		psfPass = new JPasswordField();
		psfPass.setBounds(54, 297, 281, 28);
		panel_principal.add(psfPass);
		
		JLabel lblConfirmPass = new JLabel("Confirmar Contrase\u00F1a:");
		lblConfirmPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmPass.setBounds(119, 336, 165, 14);
		panel_principal.add(lblConfirmPass);
		
		psfConfirmPass = new JPasswordField();
		psfConfirmPass.setBounds(52, 361, 281, 28);
		panel_principal.add(psfConfirmPass);
		
		JLabel lblTipoUsuario = new JLabel("Tipo De Usuario:");
		lblTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoUsuario.setBounds(141, 215, 115, 14);
		panel_principal.add(lblTipoUsuario);
		
		panelleyendo = new JPanel();
		panelleyendo.setBackground(SystemColor.activeCaption);
		panelleyendo.setBounds(161, 11, 64, 64);
		panel_principal.add(panelleyendo);
		panelleyendo.setLayout(null);
		
		lblest = new JLabel("");
		lblest.setIcon(new ImageIcon("C:\\Users\\Maykhol Sosa\\Downloads\\leyendo.png"));
		lblest.setBounds(0, 0, 64, 64);
		panelleyendo.add(lblest);
		
		panelprofe = new JPanel();
		panelprofe.setBackground(SystemColor.activeCaption);
		panelprofe.setBounds(161, 11, 66, 64);
		panel_principal.add(panelprofe);
		panelprofe.setLayout(null);
		
		lblprof = new JLabel("");
		lblprof.setIcon(new ImageIcon("C:\\Users\\Maykhol Sosa\\Downloads\\profesor.png"));
		lblprof.setBounds(0, 0, 64, 64);
		panelprofe.add(lblprof);
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setBackground(Color.LIGHT_GRAY);
			cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			cancelButton.setBounds(202, 416, 95, 45);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		{
			JButton okButton = new JButton("Registrar");
			okButton.setBackground(Color.LIGHT_GRAY);
			okButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			okButton.setBounds(96, 416, 95, 45);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {		
					if(txtUsuario.getText().isEmpty() || txtNombre.getText().isEmpty() || String.valueOf(psfPass.getPassword()).isEmpty() || String.valueOf(psfConfirmPass.getPassword()).isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos", "ERROR!", JOptionPane.ERROR_MESSAGE);
					}
					else if(!String.valueOf(psfPass.getPassword()).equals(String.valueOf(psfConfirmPass.getPassword()))) {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "ERROR!", JOptionPane.ERROR_MESSAGE);
					}
					else {
						boolean success = CentroEstudios.getInstance().addUsuario(new Usuario(txtNombre.getText(), txtUsuario.getText(),  String.valueOf(psfPass.getPassword()), rdbtnProfesor.isSelected(), false));
						if(!success) {
							JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe", "ERROR!", JOptionPane.ERROR_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Usuario registrado con exito", "Realizado", JOptionPane.INFORMATION_MESSAGE);
							if(listarUsuario) {
								ListUsuarios.loadUsuarios();
							}
							clean();
						}
					}
					
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
	}
	private void clean() {
		txtUsuario.setText("");
		txtNombre.setText("");
		psfPass.setText("");
		psfConfirmPass.setText("");
		
	}
}
