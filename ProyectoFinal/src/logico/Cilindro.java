package logico;

public class Cilindro extends Prisma {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6400059259252304998L;
	private float baseMedio;
	public Cilindro(String id, float alto, float baseMedio) {
		super(id, alto);
		this.baseMedio = baseMedio;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public float getBaseMedio() {
		return baseMedio;
	}
	public void setBaseMedio(float baseMedio) {
		this.baseMedio = baseMedio;
	}
}
