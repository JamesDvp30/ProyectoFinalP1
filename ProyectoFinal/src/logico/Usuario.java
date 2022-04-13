package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8407581393386972585L;
	private String id;
	private String nombre;
	private String username;
	private String pass;
	private boolean esProfesor;
	private boolean admin;
	private String idgrupo;
	private ArrayList<Prisma> misPrismas;
	
	public Usuario(String nombre, String username, String pass, boolean esProfesor, boolean admin) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.pass = pass;
		this.esProfesor = esProfesor;
		this.misPrismas = new ArrayList<>();
		this.admin = admin;
		this.idgrupo = null;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isEsProfesor() {
		return esProfesor;
	}
	public void setEsProfesor(boolean esProfesor) {
		this.esProfesor = esProfesor;
	}
	public ArrayList<Prisma> getMisPrismas() {
		return misPrismas;
	}
	public void setMisPrismas(Prisma prisma) {
		this.misPrismas.add(prisma);
	}
	public boolean isAdmin() {
		return admin;
	}
	public Prisma buscarPrismaById(String prismaId) {
		for(Prisma prisma : misPrismas) {
			if(prisma.getId().equals(prismaId)) {
				return prisma;
			}
		}
		return null;
	}
	public String getGrupo() {
		return idgrupo;
	}
	public void setGrupo(String grupo) {
		this.idgrupo = grupo;
	}
	

}
