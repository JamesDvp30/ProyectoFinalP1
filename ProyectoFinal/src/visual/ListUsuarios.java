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
		setTitle("Lista de Usuarios");
		setBounds(100, 100, 570, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		btnSeleccionar.setEnabled(false);
		btnSeleccionar.setVisible(listGrupos);
		btnRegistrar.setVisible(!listGrupos);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
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
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
					buttonPane.add(btnSeleccionar);
				}
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
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

