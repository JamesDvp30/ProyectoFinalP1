package logico;

import java.util.ArrayList;

public class Cuadrado extends Prisma {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6184343429074930682L;

	public Cuadrado(float altura3d) {
		super(altura3d);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float area() {
		//A = lado ^ 2
		//A = (perimetro/ 4)^2
		return (float) Math.pow(perimetro() / 4, 2);
	}
	@Override
	public float perimetro() {
		//Como de los cuadrados solo tenemos 2 lados, se multiplica por 2
		return super.perimetro() * 2;
	}
	
	public ArrayList<Vertice> getVertices() {
	//Array usado para rellenar los vertices que faltan para facilitar la grafica 3D
		ArrayList<Vertice> nuevos_vertices = new ArrayList<>();
		
		nuevos_vertices.addAll(vertices);
		
		float distancia = calcularDistancia(0,1);
		
		Vertice vertice_viejo = vertices.get(1);
		
		Vertice vertice1 = new Vertice(vertice_viejo.getPosicionX() + distancia ,vertice_viejo.getPosicionY());
		Vertice vertice2 = new Vertice(vertice1.getPosicionX(),vertice1.getPosicionY() - distancia);
		
		nuevos_vertices.add(vertice1);
		nuevos_vertices.add(vertice2);
		
		return nuevos_vertices;
	}
}



