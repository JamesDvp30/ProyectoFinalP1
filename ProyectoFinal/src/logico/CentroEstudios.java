package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CentroEstudios implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4175295123552801657L;
	private ArrayList<Usuario> misUsuarios;
	private ArrayList<Grupo> misGrupos;
	private ArrayList<Prisma> misPrismas;
	private static CentroEstudios instance = null;
	private static File Fname = new File("centro_estudios.dat");
	private String llaveDeEncriptado;
	private CentroEstudios() {
		super();
		misUsuarios = new ArrayList<>();
		misGrupos = new ArrayList<>();
		misPrismas = new ArrayList<>();
		llaveDeEncriptado = "iuTRi2h6Rg0ZQTMFBoQG";
	}
	public static CentroEstudios getInstance() {
		if (instance == null) {
			instance = new CentroEstudios();
		}
		return instance;
	}
	public static void setInstance() {
		if(Fname.exists()) {
			load();
		}
	}
	private static void load() {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(Fname));
			instance = (CentroEstudios) input.readObject();
			input.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void save() {
		ObjectOutputStream output;
		try {
			output = new ObjectOutputStream(new FileOutputStream(Fname));
			output.writeObject(instance);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}
	public ArrayList<Grupo> getMisGrupos() {
		return misGrupos;
	}
	public ArrayList<Prisma> getMisPrismas() {
		return misPrismas;
	}
	public boolean addUsuario(Usuario usuario) {
		//Se busca si el usuario ya existe para no registrar usuarios repetidos
		Usuario new_user = buscarUsuarioByUsername(usuario.getUsername());
		if(new_user == null) {
			usuario.setId(Integer.toString(misUsuarios.size()));
			usuario.setPass(PasswordUtils.generateSecurePassword(usuario.getPass(),llaveDeEncriptado));
			misUsuarios.add(usuario);
			return true; //Quiere decir que se ha registrado con exito
		}
		else {
			return false; //Quiere decir que el usuario existe
		}
		
	}
	public boolean updateUser(Usuario usuario) {
		
		int ind = getUsuarioPosition(usuario.getId());
		
		//Se comprueba que no se use el nombre de usuario de otro usuario
		for(int i = 0; i < misUsuarios.size(); i++) {
			if(usuario.getUsername() == misUsuarios.get(i).getUsername()) {
				if(i != ind) {
					return false;
				}
			}
		}
		misUsuarios.set(ind, usuario);
		return true;
	}

	public void addGrupo(Usuario profesor) {
		int ind = getUsuarioPosition(profesor.getId());
		
		Grupo grupo = new Grupo(profesor);	
		grupo.setId(Integer.toString(misGrupos.size()));
		this.misGrupos.add(grupo);
		
		profesor.setGrupo(grupo.getId());
		misUsuarios.set(ind, profesor);
	}
	public void addEstudianteAGrupo(Grupo grupo, Usuario estudiante) {
		int ind = getUsuarioPosition(estudiante.getId());

		grupo.addEstudiante(estudiante);
		int index = getGrupoPosition(grupo.getId());
		misGrupos.set(index, grupo);
		
		estudiante.setGrupo(grupo.getId());
		misUsuarios.set(ind, estudiante);
	}
	public int getGrupoPosition(String id) {
		for(int i = 0; i < misGrupos.size(); i++) {
			if(misGrupos.get(i).getId().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}
	public void addPrismas(Prisma prisma, Usuario usuario) {
		int index = getUsuarioPosition(usuario.getId());
		prisma.setId(Integer.toString(misPrismas.size()));
		usuario.setMisPrismas(prisma);
		misUsuarios.set(index, usuario);
		
		int groupIndex = getGrupoPosition(usuario.getGrupo());
		Grupo grupo = misGrupos.get(groupIndex);
		
		if(usuario.isEsProfesor()) {
			grupo.setProfesor(usuario);

		}else if(!usuario.isAdmin()) {
			int groupEstu = grupo.getEstuPosition(usuario.getId());
			grupo.getEstudiantes().set(groupEstu, usuario);

		}
		misGrupos.set(groupIndex, grupo);
		
		this.misPrismas.add(prisma);
	}
	public Usuario login(String usuario, String pass) {
		//Se busca el usuario, se retorna null si no existe o si la clave es incorrecta
		Usuario user = buscarUsuarioByUsername(usuario);
		if(user == null) {
			return null;
		}
		else if(!PasswordUtils.verifyUserPassword(pass, user.getPass(), llaveDeEncriptado)){
			return null;			
		}
		else {
			return user;
		}
	}
	public Usuario buscarUsuarioByUsername(String usuario) {
		for(Usuario user : misUsuarios) {
			if(user.getUsername().equals(usuario)) {
				return user;
			}
		}
		return null;
	}
	public Usuario buscarUsuarioById(String id) {
		for(Usuario user : misUsuarios) {
			if(user.getId().equalsIgnoreCase(id)) {
				return user;
			}
		}
		return null;
	}
	public int getUsuarioPosition(String id) {
		for(int i = 0; i < misUsuarios.size(); i++) {
			if(misUsuarios.get(i).getId().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
		
	}
}