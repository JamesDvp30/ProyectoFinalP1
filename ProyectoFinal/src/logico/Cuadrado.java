package logico;

import java.util.ArrayList;

public class Cuadrado extends Prisma {
private float baseMedio;
private float profundido;
	public Cuadrado(String id, float alto,float baseMedio,float profundido) {
		super(id, alto);
		this.baseMedio = baseMedio;
		this.profundido = profundido;
		// TODO Auto-generated constructor stub
	}
	public float getBaseMedio() {
		return baseMedio;
	}

	public void setBaseMedio(float baseMedio) {
		this.baseMedio = baseMedio;
	}


	public float getProfundido() {
		return profundido;
	}
	public void setProfundido(float profundido) {
		this.profundido = profundido;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 6184343429074930682L;

}



