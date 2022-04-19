package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
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
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Font;

public class VerDetallesGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableEstudiantes;
	private JTable tablePrismas;
	private static DefaultTableModel modelEstu;
	private static Object[] filaEstu;
	private static DefaultTableModel modelPrism;
	private static Object[] filaPrism;
	private JTextField txtProfesor;
	private static Grupo grupo;

	public VerDetallesGrupo(String grupoId) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maykhol Sosa\\Downloads\\matematicas.png"));
		int index = CentroEstudios.getInstance().getGrupoPosition(grupoId);
		if(index == -1) {
			JOptionPane.showMessageDialog(null, "El usuario no pertenece a ningun grupo", "ERROR!", JOptionPane.ERROR_MESSAGE);
			dispose();
		}
		grupo = CentroEstudios.getInstance().getMisGrupos().get(index);
		
		setTitle("Detalles de Mi Grupo");
		setBounds(100, 100, 747, 687);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.window);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(SystemColor.activeCaption);
			panel_1.setBounds(10, 11, 697, 47);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblProfesor = new JLabel("Profesor: ");
			lblProfesor.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblProfesor.setBounds(10, 11, 69, 14);
			panel_1.add(lblProfesor);
			
			txtProfesor = new JTextField();
			txtProfesor.setEditable(false);
			txtProfesor.setBounds(89, 8, 159, 20);
			panel_1.add(txtProfesor);
			txtProfesor.setColumns(10);
			txtProfesor.setText(grupo.getProfesor().getNombre());
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(SystemColor.activeCaption);
			panel_2.setBounds(10, 69, 697, 285);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblEstudiantes = new JLabel("Estudiantes:");
			lblEstudiantes.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEstudiantes.setBounds(10, 11, 95, 14);
			panel_2.add(lblEstudiantes);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 36, 667, 238);
			panel_2.add(scrollPane);
			{
				tableEstudiantes = new JTable();
				tableEstudiantes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				modelEstu = new DefaultTableModel();
				String[] columnNames = {"Id","Nombre de Usuario","Nombre", "Rol"};
				modelEstu.setColumnIdentifiers(columnNames);
				loadEstudiantes(grupo);
				tableEstudiantes.setModel(modelEstu);
				scrollPane.setViewportView(tableEstudiantes);
			}
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(SystemColor.activeCaption);
			panel_3.setBounds(10, 365, 697, 222);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblPrismas = new JLabel("Prismas Del Grupo:");
			lblPrismas.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPrismas.setBounds(10, 11, 137, 14);
			panel_3.add(lblPrismas);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(20, 36, 667, 175);
			panel_3.add(scrollPane_1);
			{
				tablePrismas = new JTable();
				tablePrismas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				
				modelPrism = new DefaultTableModel();
				String[] columnNames = {"Id","Tipo","Vertice X", "Vertice Y", "Altura","Area"};
				modelPrism.setColumnIdentifiers(columnNames);
				//loadPrismas(grupo);
				tablePrismas.setModel(modelPrism);
				scrollPane_1.setViewportView(tablePrismas);
				
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
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
	private void loadEstudiantes(Grupo grupo) {
		modelEstu.setRowCount(0);
		filaEstu = new Object[modelEstu.getColumnCount()];
		for (Usuario usuario : grupo.getEstudiantes()) {
			filaEstu[0] = usuario.getId();
			filaEstu[1] = usuario.getUsername();
			filaEstu[2] = usuario.getNombre();			
			modelEstu.addRow(filaEstu);
		}
	}
	/*private void loadPrismas(Grupo grupo) {
		modelPrism.setRowCount(0);
		filaPrism = new Object[modelPrism.getColumnCount()];
		for (Prisma prisma : grupo.getEstudentPrism()) {
			filaPrism[0] = prisma.getId();
			filaPrism[1] = prisma.getClass().getSimpleName();
			for(int i = 0; i < prisma.getVertices().size(); i++) {
				filaPrism[i+2] =  "(" + String.valueOf(prisma.getVertices().get(i).getPosicionX())+ "," + String.valueOf(prisma.getVertices().get(i).getPosicionY()) + ")";
			}
			filaPrism[6] = prisma.area();
			filaPrism[7] = prisma.perimetro();
			filaPrism[8] = prisma.areaLateral();
			filaPrism[9] = prisma.areaTotal();
			filaPrism[10] = prisma.volumen();		
			modelPrism.addRow(filaPrism);
		}
	}*/
}
