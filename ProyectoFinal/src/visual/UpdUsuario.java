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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import logico.CentroEstudios;
import logico.Usuario;
import java.awt.Color;

public class UpdUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JPasswordField psfPass;
	private JPasswordField psfConfirmPass;
	
	public UpdUsuario(Usuario usuario) {
		setTitle("Modificar Usuario");
		setBounds(100, 100, 432, 365);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
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

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 11, 55, 16);
		panel_principal.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(10, 38, 248, 28);
		panel_principal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(10, 137, 77, 14);
		panel_principal.add(lblPass);
		
		psfPass = new JPasswordField();
		psfPass.setBounds(10, 162, 290, 28);
		panel_principal.add(psfPass);
		
		JLabel lblConfirmPass = new JLabel("Confirmar Contrase\u00F1a:");
		lblConfirmPass.setBounds(10, 201, 141, 14);
		panel_principal.add(lblConfirmPass);
		
		psfConfirmPass = new JPasswordField();
		psfConfirmPass.setBounds(10, 226, 290, 28);
		panel_principal.add(psfConfirmPass);
		
		loadUsuario(usuario);
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
							JOptionPane.showMessageDialog(null, "Las contraseņas no coinciden", "ERROR!", JOptionPane.ERROR_MESSAGE);
						}
						else {
							Usuario updatedUser = new Usuario(txtNombre.getText(), txtUsuario.getText(), psfPass.getPassword().toString(), usuario.isEsProfesor(), usuario.isAdmin());
							updatedUser.setId(usuario.getId());
							boolean success = CentroEstudios.getInstance().updateUser(updatedUser);
							if(!success) {
								JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe", "ERROR!", JOptionPane.ERROR_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(null, "Usuario modificado con exito", "Realizado", JOptionPane.INFORMATION_MESSAGE);
								psfPass.setText("");
								psfConfirmPass.setText("");
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
	private void loadUsuario(Usuario usuario) {
		txtUsuario.setText(usuario.getUsername());
		txtNombre.setText(usuario.getNombre());
		psfPass.setText("");
		psfConfirmPass.setText("");
		
	}

}

