package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.CentroEstudios;
import logico.Prisma;
import logico.Usuario;
import java.awt.Color;
import java.awt.Toolkit;

public class ListPrismas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String select;
	private int index;
	private JButton btnVisualizar = new JButton("Ver Prisma");
	private JButton btnEliminar;

	public ListPrismas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maykhol Sosa\\Downloads\\matematicas.png"));
		setTitle("Lista de Mis Prismas");
		setBounds(100, 100, 756, 476);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(78, 0, 650, 380);
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
							btnVisualizar.setEnabled(true);
							btnEliminar.setEnabled(true);
							
						}
					}
				});
				model = new DefaultTableModel();
				String[] columnNames = {"Id","Altura"};
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVisualizar.setEnabled(false);
				
				btnVisualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int fila = table.getSelectedRow();
						CentroEstudios.getInstance().buscarPrismaByCodigo(CentroEstudios.getInstance().getMisPrismas().get(fila).getId());
                        Prisma1 dialog = new Prisma1();
                        dialog.setVisible(true);
					}
				});
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int fila = table.getSelectedRow();
						Prisma aux = CentroEstudios.getInstance().getMisPrismas().get(fila);
						CentroEstudios.getInstance().EliminarPrisma(aux);
						loadPrismas();
					}
				});
				buttonPane.add(btnEliminar);
				btnVisualizar.setActionCommand("OK");
				buttonPane.add(btnVisualizar);
				getRootPane().setDefaultButton(btnVisualizar);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadPrismas();
	}
	private void loadPrismas() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
			for(int i = 0; i < CentroEstudios.getInstance().getCantPrismas(); i++) {
				fila[0] = CentroEstudios.getInstance().getMisPrismas().get(i).getId();
				fila[1] = CentroEstudios.getInstance().getMisPrismas().get(i).getAlto();
				
			
			

			model.addRow(fila);
			}
		}
}

