package logico;

public class Triangulo extends Prisma {
   private float baseMedio;
	public Triangulo(String id, float alto,float baseMedio) {
		super(id, alto);
		this.baseMedio = baseMedio;
		// TODO Auto-generated constructor stub
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
	private static final long serialVersionUID = 5325596378792549454L;


}
