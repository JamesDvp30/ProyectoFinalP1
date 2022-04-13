package visual;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import logico.CentroEstudios;
import logico.Usuario;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal{
	private static JFrame frame;
	private Dimension dim;
	private JMenuItem mntmListarUsuarios;
	private static Usuario usuario = null;
	private Login login = new Login();
	private static JMenu mnUsuarios = new JMenu("Usuarios") ;
	private static JMenuItem mntmCrearGrupo = new JMenuItem("Crear Grupo");
	private static JMenuItem mntmListarTodosLosGrupos = new JMenuItem("Listar Todos Los Grupos");
	private static JMenuItem mntmVerMiGrupo = new JMenuItem("Ver Mi Grupo");

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Principal() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				CentroEstudios.save();
			}
		});
		CentroEstudios.setInstance();
		
		Usuario admin = new Usuario("Administrador", "admin", "admin", false, true);
		CentroEstudios.getInstance().addUsuario(admin);
		frame.setTitle("Herramienta Geometrica");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dim = frame.getToolkit().getScreenSize();
		frame.setSize(1392,1030);
		frame.setLocationRelativeTo(null);
		
		login.setModal(true);
		login.setVisible(true);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Principal.class.getResource("/img/background.jpg")));
		panel.add(background, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFiguras = new JMenu("Figuras");
		menuBar.add(mnFiguras);
		
		JMenuItem mntmCrearFigura = new JMenuItem("Crear Figura");
		mntmCrearFigura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatePrisma createPrisma = new CreatePrisma(usuario);
				createPrisma.setModal(true);
				createPrisma.setVisible(true);
			}
		});
		mnFiguras.add(mntmCrearFigura);
		
		JMenuItem mntmListarFiguras = new JMenuItem("Mis Figuras");
		mntmListarFiguras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPrismas listPrismas = new ListPrismas(usuario);
				listPrismas.setModal(true);
				listPrismas.setVisible(true);
			}
		});
		mnFiguras.add(mntmListarFiguras);
		
		menuBar.add(mnUsuarios);
		
		JMenuItem mntmCrearUsuario = new JMenuItem("Crear Usuario");
		mntmCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegUsuario regUsuario = new RegUsuario(false);
				regUsuario.setModal(true);
				regUsuario.setVisible(true);
				
			}
		});
		mnUsuarios.add(mntmCrearUsuario);
		
		mntmListarUsuarios = new JMenuItem("Listar Usuarios");
		mntmListarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListUsuarios listUsuarios = new ListUsuarios(false,null);
				listUsuarios.setModal(true);
				listUsuarios.setVisible(true);
			}
		});
		mnUsuarios.add(mntmListarUsuarios);
		
		JMenu mnGrupos = new JMenu("Grupos");
		menuBar.add(mnGrupos);
		mntmCrearGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearGrupo crearGrupo = new CrearGrupo();
				crearGrupo.setModal(true);
				crearGrupo.setVisible(true);
			}
		});
		
		mnGrupos.add(mntmCrearGrupo);
		
		mntmVerMiGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerDetallesGrupo verdetalles = new VerDetallesGrupo(usuario.getGrupo());
				verdetalles.setModal(true);
				verdetalles.setVisible(true);
			}
		});
		mnGrupos.add(mntmVerMiGrupo);
		
		mntmListarTodosLosGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListGrupos listGrupos = new ListGrupos();
				listGrupos.setModal(true);
				listGrupos.setVisible(true);
			}
		});
		mnGrupos.add(mntmListarTodosLosGrupos);
		
		JMenu mnMiPerfil = new JMenu("Mi Perfil");
		menuBar.add(mnMiPerfil);
		
		JMenuItem mntmEditarPerfil = new JMenuItem("Editar Perfil");
		mntmEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdUsuario updUsuario = new UpdUsuario(usuario);
				updUsuario.setModal(true);
				updUsuario.setVisible(true);
			}
		});
		mnMiPerfil.add(mntmEditarPerfil);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				usuario = null;
				login.setModal(true);
				login.setVisible(true);
			}
		});
		mnMiPerfil.add(mntmCerrarSesion);
		
	}
	public static void login(Usuario logUser) {
		
		usuario = logUser;
		mnUsuarios.setVisible(usuario.isAdmin());
		mntmCrearGrupo.setVisible(usuario.isAdmin());
		mntmListarTodosLosGrupos.setVisible(usuario.isAdmin());
		mntmVerMiGrupo.setVisible(!usuario.isAdmin());
		frame.setVisible(true);
		
	}
	public static void cancelLogin() {
		System.exit(0);
	}
}

