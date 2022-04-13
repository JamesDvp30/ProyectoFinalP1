package logico;

import java.io.Serializable;

public class Vertice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 34649820967457501L;
	private float posicionX;
	private float posicionY;
	public Vertice(float posicionX, float posicionY) {
		super();
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	public float getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(float posicionX) {
		this.posicionX = posicionX;
	}
	public float getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(float posicionY) {
		this.posicionY = posicionY;
	}
	

}
