package visual;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.CentroEstudios;
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	public Login() {
		setType(Type.POPUP);
		setResizable(false);
		setBounds(100, 100, 391, 450);
		setLocationRelativeTo(null);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblIngresa = new JLabel("Ingresa");
			lblIngresa.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblIngresa.setHorizontalAlignment(SwingConstants.CENTER);
			lblIngresa.setBounds(115, 61, 116, 59);
			panel.add(lblIngresa);
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(85, 156, 183, 35);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(85, 227, 183, 35);
			panel.add(passwordField);
			
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(85, 131, 72, 14);
			panel.add(lblUsuario);
			
			JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
			lblContrasena.setBounds(85, 202, 72, 14);
			panel.add(lblContrasena);
			
			JButton btnLogin = new JButton("Ingresar");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Usuario usuario = CentroEstudios.getInstance().login(txtUsuario.getText(), String.valueOf(passwordField.getPassword()));
					if(usuario == null) {
						JOptionPane.showMessageDialog(null, "La contraseña o el usuario no son correctos", "ERROR!", JOptionPane.ERROR_MESSAGE);

					}else {
						txtUsuario.setText("");
						passwordField.setText("");
						dispose();
						Principal.login(usuario);
					}
					
				}
			});
			btnLogin.setBounds(131, 290, 100, 35);
			panel.add(btnLogin);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Principal.cancelLogin();
				}
			});
			btnCancelar.setBounds(131, 336, 100, 35);
			panel.add(btnCancelar);
			
			
		}
	}
}

