package logico;

public class Rombo extends Prisma {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2433241166673451783L;

	public Rombo(float altura3d) {
		super(altura3d);
	}

	@Override
	public float area() {
		//A = (Diagonal(A,C) * Diagonal(B,D))/2 
		// TODO Auto-generated method stub
		float DiagonalAC = calcularDistancia(0,2);
		float DiagonalBD = calcularDistancia(1,3);
	
		return (DiagonalAC * DiagonalBD)/2;
	}

}

