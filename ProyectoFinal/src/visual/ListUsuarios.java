package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import logico.CentroEstudios;
import logico.Grupo;
import logico.Usuario;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Toolkit;

public class ListUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String select;
	private int index;
	private JButton btnRegistrar = new JButton("Registrar");
	JButton btnSeleccionar = new JButton("Seleccionar");

	public ListUsuarios(boolean listGrupos, String grupoId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maykhol Sosa\\Downloads\\matematicas.png"));
		getContentPane().setBackground(SystemColor.window);
		setTitle("Lista de Usuarios");
		setBounds(100, 100, 604, 398);
		getContentPane().setLayout(null);
		contentPanel.setBounds(10, 3, 568, 280);
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel);
		btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSeleccionar.setBounds(222, 7, 106, 36);
		btnSeleccionar.setEnabled(false);
		btnSeleccionar.setVisible(listGrupos);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setBounds(338, 7, 102, 36);
		btnRegistrar.setVisible(!listGrupos);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 550, 263);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						index = table.getSelectedRow();
						if(index >= 0) {
							select = table.getValueAt(index, 0).toString();
							btnSeleccionar.setEnabled(true);
						}
					}
				});
				model = new DefaultTableModel();
				String[] columnNames = {"Id","Nombre de Usuario","Nombre", "Rol"};
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				scrollPane.setViewportView(table);
				if(listGrupos) {
					loadEstudiantes();
				}
				else {					
					loadUsuarios();
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(20, 294, 547, 54);
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			getContentPane().add(buttonPane);
			{
				
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegUsuario regpersona = new RegUsuario(true);
						regpersona.setModal(true);
						regpersona.setVisible(true);
					}
				});
				{
					btnSeleccionar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int ind = CentroEstudios.getInstance().getGrupoPosition(grupoId);
							Grupo grupo = CentroEstudios.getInstance().getMisGrupos().get(ind);
							Usuario usuario = CentroEstudios.getInstance().buscarUsuarioById(select);
							CentroEstudios.getInstance().addEstudianteAGrupo(grupo, usuario);
							JOptionPane.showMessageDialog(null, "Usuario añadido con éxito!", "Realizado", JOptionPane.INFORMATION_MESSAGE);
							ListGrupos.loadGrupos();
							dispose();
						}
					});
					buttonPane.setLayout(null);
					buttonPane.add(btnSeleccionar);
				}
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnCancelar.setBounds(450, 7, 86, 36);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	public static void loadUsuarios() {

		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Usuario usuario : CentroEstudios.getInstance().getMisUsuarios()) {
			fila[0] = usuario.getId();
			fila[1] = usuario.getUsername();
			fila[2] = usuario.getNombre();
			fila[3] = usuario.isEsProfesor() ? "Profesor" : usuario.isAdmin() ? "Administrador" : "Estudiante";
			
			model.addRow(fila);
		}
		
	
		
	}
	public static void loadEstudiantes() {

		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Usuario usuario : CentroEstudios.getInstance().getMisUsuarios()) {
			if(!usuario.isEsProfesor() && !usuario.isAdmin() && usuario.getGrupo() == null) {
				fila[0] = usuario.getId();
				fila[1] = usuario.getUsername();
				fila[2] = usuario.getNombre();			
				model.addRow(fila);
			}

		}
	}

}

