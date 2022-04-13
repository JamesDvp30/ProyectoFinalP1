package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Grupo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7474695256527999402L;
	private String id;
	private Usuario profesor;
	private ArrayList<Usuario> estudiantes;
	public Grupo(Usuario profesor) {
		super();
		this.profesor = profesor;
		estudiantes = new ArrayList<>();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Usuario getProfesor() {
		return profesor;
	}
	public void setProfesor(Usuario profesor) {
		this.profesor = profesor;
	}
	public ArrayList<Usuario> getEstudiantes() {
		return estudiantes;
	}
	public void addEstudiante(Usuario estudiante) {
		this.estudiantes.add(estudiante);
	}
	public ArrayList<Prisma> getEstudentPrism() {
		ArrayList<Prisma> prismas = new ArrayList<>();
		
		for(Usuario estudiante: estudiantes) {
			prismas.addAll(estudiante.getMisPrismas());
		}
		return prismas;
		
	}
	public int getEstuPosition(String id) {
		for(int i = 0; i < estudiantes.size(); i++) {
			if(estudiantes.get(i).getId().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}
}
