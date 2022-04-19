package logico;

import java.io.Serializable;
import java.util.ArrayList;

public  class Prisma implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1093142714433252182L;
	protected String id;
	protected float alto;
	protected float baseMedio;
	public Prisma(String id, float alto) {
		super();
		this.id = id;
		this.alto = alto;
	}
	
	
	public String getId() {
		return id;
	}
	protected void setId(String id) {
		this.id = id;
	}
	public float getAlto() {
		return alto;
	}


	public void setAlto(float alto) {
		this.alto = alto;
	}


	public float getBaseMedio() {
		return baseMedio;
	}


	public void setBaseMedio(float baseMedio) {
		this.baseMedio = baseMedio;
	}
	
	
}
