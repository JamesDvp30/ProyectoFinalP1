package logico;

public class Triangulo extends Prisma {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5325596378792549454L;

	public Triangulo(float altura3d) {
		super(altura3d);
	}

	@Override
	public float area() {
		//Area en base al perimetro = Raiz(S(S-ladoA)(S-ladoB)(S - ladoC))
		//S = Perimetro / 2
		
		float s = perimetro()/2;
		
		//Se calcula la distancia de cada lado en base a sus vertices
		float ladoA = calcularDistancia(0,1);
		float ladoB = calcularDistancia(1,2);
		float ladoC = calcularDistancia(0,2);
		
		return (float) Math.sqrt(s * (s - ladoA)*(s - ladoB)*(s - ladoC));
		
	
	}

}
