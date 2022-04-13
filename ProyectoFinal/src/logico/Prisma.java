package logico;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Prisma implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1093142714433252182L;
	protected String id;
	protected ArrayList<Vertice> vertices;
	protected float altura3d;
	public Prisma(float altura3d) {
		super();
		vertices = new ArrayList<>();
		this.altura3d = altura3d;
	}
	
	public String getId() {
		return id;
	}
	protected void setId(String id) {
		this.id = id;
	}

	public float volumen() {
		// V = A * h
		return area() * altura3d;
	}
	public float areaTotal() {
		//At = Al + 2* A
		return areaLateral() + (2* area());
	}
	public float areaLateral() {
		//Al = P * h
		return perimetro() * altura3d;
	};
	public float perimetro() {
		float perimetro = 0;
		int i;
		//Para obtener los lados se calcula la distancia entre el punto i y el punto i + 1
		//y luego se suman esos lados para obtener le perimetro
		for(i = 0; i < vertices.size() - 1; i++) {
			perimetro += calcularDistancia(i,i+1);
		}
		
		//Se calcula la distancia del ultimo vertice con el primero, para asi obtener el lado restante
		perimetro +=  calcularDistancia(i,0);
		return perimetro;
	}
	
	public abstract float area();
	
	
	public float getAltura3d() {
		return altura3d;
	}
	protected void setAltura3d(float altura3d) {
		this.altura3d = altura3d;
	}
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	public boolean addVertice(Vertice vertice) {
		//Se verifica que no hay un vertice igual en el arreglo
		for(Vertice old_vertice : vertices) {
			if(vertice.getPosicionX() == old_vertice.getPosicionX() && vertice.getPosicionY() == old_vertice.getPosicionY()) {
				return false; //Si hay uno igual, retorna falsa para notificar del error;
			}
		}
		vertices.add(vertice);
		return true;
	}
	protected float calcularDistancia(int pos1, int pos2) {
		return (float) Math.sqrt(Math.pow(vertices.get(pos1).getPosicionX() - vertices.get(pos2).getPosicionX(),2) 
				+ Math.pow(vertices.get(pos1).getPosicionY() - vertices.get(pos2).getPosicionY(),2));
	}
}
