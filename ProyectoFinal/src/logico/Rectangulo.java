package logico;

public class Rectangulo extends Prisma {

	private float profundo;
	private float baseMedio;


	public Rectangulo(String id, float alto, float baseMedio,float profundo) {
		super(id, alto);
		this.setProfundo(profundo);
		this.baseMedio = baseMedio;
		// TODO Auto-generated constructor stub
	}

	public float getProfundo() {
		return profundo;	}

	public void setProfundo(float profundo) {
		this.profundo = profundo;
	}
	public float getBaseMedio() {
		return baseMedio;
	}

	public void setBaseMedio(float baseMedio) {
		this.baseMedio = baseMedio;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2160964019487119569L;
	
}
