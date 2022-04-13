package logico;

public class Rectangulo extends Prisma {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2160964019487119569L;
	public Rectangulo(float altura3d) {
		super(altura3d);
	}

	@Override
	public float area() {
		//A = b * h
		
		int i;
		float lados[] = {0,0}; 
		//Se sacan los lados y a partir de los vertices
		for(i = 0; i < 2; i++) {
			lados[i] =  calcularDistancia(i,i+1);
		}
		
		return lados[0] * lados[1];
	}
	public float perimetro() {
		
		int i;
		float lados[] = {0,0}; 
		
		//Se sacan los lados y a partir de los vertices
		for(i = 0; i < 2; i++) {
			lados[i] =  calcularDistancia(i,i+1);
		}
		//Se suman los dados y se multiplica por 2 
		return 2 * (lados[0] + lados[1]);

	}

}
