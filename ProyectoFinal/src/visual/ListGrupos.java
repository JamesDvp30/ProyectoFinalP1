package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.CentroEstudios;
import logico.Grupo;
import logico.Prisma;
import logico.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ListGrupos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String select;
	private int index;
	JButton btnVerDetalles = new JButton("Ver Detalles");

	JButton btnAgregar = new JButton("Agregar Estudiante");


	public ListGrupos() {
		setTitle("Listar Todos Los Grupos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);
			{
				table = new JTable();
				table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						index = table.getSelectedRow();
						if(index >= 0) {
							select = table.getValueAt(index, 0).toString();
							btnAgregar.setEnabled(true);
							btnVerDetalles.setEnabled(true);
						}
					}
				});
				model = new DefaultTableModel();
				String[] columnNames = {"Id","Profesor", "Cant. Estudiantes"};
				model.setColumnIdentifiers(columnNames);
				loadGrupos();
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAgregar.setEnabled(false);
				btnAgregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListUsuarios listUsuarios = new ListUsuarios(true, select);
						listUsuarios.setModal(true);
						listUsuarios.setVisible(true);
					}
				});
				{
					btnVerDetalles.setEnabled(false);
					btnVerDetalles.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int ind = CentroEstudios.getInstance().getGrupoPosition(select);
							Grupo grupo = CentroEstudios.getInstance().getMisGrupos().get(ind);
							VerDetallesGrupo verdetalles = new VerDetallesGrupo(grupo.getId());
							verdetalles.setModal(true);
							verdetalles.setVisible(true);
						}
					});
					buttonPane.add(btnVerDetalles);
				}
				btnAgregar.setActionCommand("OK");
				buttonPane.add(btnAgregar);
				getRootPane().setDefaultButton(btnAgregar);
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
	public static void loadGrupos() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		
		for (Grupo grupo : CentroEstudios.getInstance().getMisGrupos()) {
			fila[0] = grupo.getId();
			fila[1] = grupo.getProfesor().getNombre();
			fila[2] = grupo.getEstudiantes().size();
			model.addRow(fila);
		}
	}

}

