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
import logico.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

public class CrearGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String select;
	private int index;
	JButton btnSeleccionar = new JButton("Seleccionar");

	public CrearGrupo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maykhol Sosa\\Downloads\\matematicas.png"));
		setTitle("Crear Grupo");
		setBounds(100, 100, 487, 393);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 472, 298);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(SystemColor.activeCaption);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Profesor Designado:");
			lblNewLabel.setBounds(10, 11, 149, 14);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			panel.add(lblNewLabel);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 36, 442, 245);
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
							btnSeleccionar.setEnabled(true);
						}
					}
				});
				model = new DefaultTableModel();
				String[] columnNames = {"Id","Usuario","Nombre"};
				model.setColumnIdentifiers(columnNames);
				loadProfesores();
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 295, 452, 48);
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setBackground(SystemColor.activeCaption);
			getContentPane().add(buttonPane);
			{
				btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnSeleccionar.setBounds(232, 7, 101, 30);
				btnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Usuario usuario = CentroEstudios.getInstance().buscarUsuarioById(select);
						CentroEstudios.getInstance().addGrupo(usuario);
						JOptionPane.showMessageDialog(null, "El grupo se ha creado con exito", "información", JOptionPane.INFORMATION_MESSAGE);
						loadProfesores();
					}
				});
				buttonPane.setLayout(null);
				
				btnSeleccionar.setEnabled(false);
				btnSeleccionar.setActionCommand("OK");
				buttonPane.add(btnSeleccionar);
				getRootPane().setDefaultButton(btnSeleccionar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 12));
				cancelButton.setBounds(343, 7, 95, 30);
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
	private static void loadProfesores() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		
		for(Usuario usuario : CentroEstudios.getInstance().getMisUsuarios()) {
			if(usuario.isEsProfesor() && usuario.getGrupo() == null) {
				fila[0] = usuario.getId();
				fila[1] = usuario.getUsername();
				fila[2] = usuario.getNombre();
				model.addRow(fila);
			}
		}
		
	}
}