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

public class ListPrismas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String select;
	private int index;
	private JButton btnVisualizar = new JButton("Ver Prisma");

	public ListPrismas(Usuario usuario) {
		setTitle("Lista de Mis Prismas");
		setBounds(100, 100, 980, 476);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
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
							btnVisualizar.setEnabled(true);
						}
					}
				});
				model = new DefaultTableModel();
				String[] columnNames = {"Id","Tipo","Vertice 1","Vertice 2","Vertice 3","Vertice 4", "Area Base", "Perimetro", "Area Lateral", "Area Total",  "Volumen"};
				model.setColumnIdentifiers(columnNames);
				loadPrismas(usuario.getMisPrismas());
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

					}
				});
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
	}
	private void loadPrismas(ArrayList<Prisma> prismas) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		
		for (Prisma prisma : prismas) {
			fila[0] = prisma.getId();
			fila[1] = prisma.getClass().getSimpleName();
			for(int i = 0; i < prisma.getVertices().size(); i++) {
				fila[i+2] =  "(" + String.valueOf(prisma.getVertices().get(i).getPosicionX())+ "," + String.valueOf(prisma.getVertices().get(i).getPosicionY()) + ")";
			}
			fila[6] = prisma.area();
			fila[7] = prisma.perimetro();
			fila[8] = prisma.areaLateral();
			fila[9] = prisma.areaTotal();
			fila[10] = prisma.volumen();

			model.addRow(fila);
		}
		
	}

}

