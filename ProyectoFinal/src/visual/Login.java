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
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JPanel cancelarPanel;
	private JPanel IngresarPanel;

	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maykhol Sosa\\Downloads\\matematicas.png"));
		setTitle("Login");
		setType(Type.POPUP);
		setBounds(100, 100, 683, 510);
		setLocationRelativeTo(null);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblIngresa = new JLabel("INICIO DE SECCION");
			lblIngresa.setForeground(Color.BLACK);
			lblIngresa.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblIngresa.setHorizontalAlignment(SwingConstants.CENTER);
			lblIngresa.setBounds(57, 13, 263, 59);
			panel.add(lblIngresa);
			
			txtUsuario = new JTextField();
			txtUsuario.setBackground(Color.LIGHT_GRAY);
			txtUsuario.setBounds(79, 125, 212, 35);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBackground(Color.LIGHT_GRAY);
			passwordField.setBounds(79, 244, 212, 35);
			panel.add(passwordField);
			
			JLabel lblUsuario = new JLabel("");
			lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/image/usuario (4).png")));
			lblUsuario.setBackground(Color.BLACK);
			lblUsuario.setForeground(Color.BLACK);
			lblUsuario.setBounds(166, 77, 44, 35);
			panel.add(lblUsuario);
			
			JLabel lblContrasena = new JLabel("");
			lblContrasena.setIcon(new ImageIcon(Login.class.getResource("/image/candado (2).png")));
			lblContrasena.setForeground(Color.BLACK);
			lblContrasena.setBounds(166, 196, 44, 35);
			panel.add(lblContrasena);
			
			IngresarPanel = new JPanel();
			IngresarPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
				 IngresarPanel.setBackground(Color.GRAY);
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					IngresarPanel.setBackground(Color.WHITE);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
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
			IngresarPanel.setBackground(Color.WHITE);
			IngresarPanel.setBounds(35, 335, 137, 43);
			panel.add(IngresarPanel);
			
			JLabel lblNewLabel_1 = new JLabel("INGRESAR");
			lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 24));
			lblNewLabel_1.setForeground(Color.BLACK);
			IngresarPanel.add(lblNewLabel_1);
			
			cancelarPanel = new JPanel();
			cancelarPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					cancelarPanel.setBackground(Color.GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					cancelarPanel.setBackground(Color.WHITE);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					Principal.cancelLogin();
				}
			});
			cancelarPanel.setBackground(Color.WHITE);
			cancelarPanel.setBounds(211, 335, 137, 43);
			panel.add(cancelarPanel);
			
			JLabel lblCancelar = new JLabel("CANCELAR");
			lblCancelar.setForeground(Color.BLACK);
			lblCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 24));
			cancelarPanel.add(lblCancelar);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/image/vecteezy_blank-math-template-with-math-symbol_.jpg")));
			lblNewLabel.setBounds(374, 0, 281, 453);
			panel.add(lblNewLabel);
			
			
		}
	}
}

