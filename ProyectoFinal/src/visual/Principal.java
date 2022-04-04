package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Principal extends JFrame {

	private JPanel contentPane;
	 private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					Fondo d = new Fondo ("/visual/fondo.PNG");
					frame.getContentPane().add(d);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/image/principal (2).jpg")));
		setFont(new Font("Arial", Font.PLAIN, 15));
		setTitle("Centro Matematico \"Los Duros\"");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dim= getToolkit().getScreenSize();   
		setBounds(100, 100, 953, 556);
		setLocationRelativeTo(null); 
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Profesor/Estudiante");
		mnNewMenu.setBackground(SystemColor.inactiveCaption);
		mnNewMenu.setFont(new Font("Segoe Script", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registro\r\n");
		mntmNewMenuItem.setBackground(new Color(255, 215, 0));
		mntmNewMenuItem.setFont(new Font("Segoe Script", Font.BOLD, 13));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mntmListado.setBackground(new Color(0, 255, 0));
		mntmListado.setFont(new Font("Segoe Script", Font.BOLD, 13));
		mnNewMenu.add(mntmListado);
		
		JMenu mnNewMenu_1 = new JMenu("Figuras");
		mnNewMenu_1.setBackground(SystemColor.inactiveCaption);
		mnNewMenu_1.setFont(new Font("Segoe Script", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registro");
		mntmNewMenuItem_1.setBackground(new Color(0, 255, 0));
		mntmNewMenuItem_1.setFont(new Font("Segoe Script", Font.BOLD, 13));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listado\r\n");
		mntmNewMenuItem_2.setBackground(new Color(255, 215, 0));
		mntmNewMenuItem_2.setFont(new Font("Segoe Script", Font.BOLD, 13));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
	}
}
