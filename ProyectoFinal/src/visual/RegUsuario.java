package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnEstudiante;
	private JPasswordField psfPass;
	private JPasswordField psfConfirmPass;
	
	
	public RegUsuario(boolean listarUsuario) {
		setTitle("Registrar Usuario");
		setBounds(100, 100, 432, 405);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_principal = new JPanel();
		panel_principal.setBackground(Color.LIGHT_GRAY);
		panel_principal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPanel.add(panel_principal);
		panel_principal.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 71, 55, 16);
		panel_principal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 98, 301, 28);
		panel_principal.add(txtNombre);
		txtNombre.setColumns(10);
		
		rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.setBackground(Color.LIGHT_GRAY);
		rdbtnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnProfesor.isSelected()) {
					rdbtnEstudiante.setSelected(true);
					rdbtnProfesor.setSelected(false);
				}
				else if(rdbtnEstudiante.isSelected()) {
					rdbtnEstudiante.setSelected(true);
				}
			}
		});
		rdbtnEstudiante.setBounds(10, 158, 115, 18);
		panel_principal.add(rdbtnEstudiante);
		
		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setBackground(Color.LIGHT_GRAY);
		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnEstudiante.isSelected()) {
					rdbtnProfesor.setSelected(true);
					rdbtnEstudiante.setSelected(false);
				}
				else if(rdbtnProfesor.isSelected()) {
					rdbtnProfesor.setSelected(true);
				}
			}
		});
		rdbtnProfesor.setSelected(true);
		rdbtnProfesor.setBounds(149, 158, 115, 18);
		panel_principal.add(rdbtnProfesor);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 11, 55, 16);
		panel_principal.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 38, 248, 28);
		panel_principal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(10, 183, 77, 14);
		panel_principal.add(lblPass);
		
		psfPass = new JPasswordField();
		psfPass.setBounds(10, 208, 290, 28);
		panel_principal.add(psfPass);
		
		JLabel lblConfirmPass = new JLabel("Confirmar Contrase\u00F1a:");
		lblConfirmPass.setBounds(10, 247, 141, 14);
		panel_principal.add(lblConfirmPass);
		
		psfConfirmPass = new JPasswordField();
		psfConfirmPass.setBounds(10, 272, 290, 28);
		panel_principal.add(psfConfirmPass);
		
		JLabel lblTipoUsuario = new JLabel("Tipo De Usuario:");
		lblTipoUsuario.setBounds(10, 137, 95, 14);
		panel_principal.add(lblTipoUsuario);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void clean() {
		txtUsuario.setText("");
		txtNombre.setText("");
		psfPass.setText("");
		psfConfirmPass.setText("");
		
	}

}
