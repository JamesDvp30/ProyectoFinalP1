package logico;

public class Trapecio extends Prisma {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7959816042132181442L;
	private float altura;
	public Trapecio(float altura3d, float altura) {
		super(altura3d);
		this.altura = altura;
	}

	@Override
	public float area() {
		//A = (baseA + baseC)/2  * altura
		float baseA = calcularDistancia(0,3);
		float baseB = calcularDistancia(1,2);
		return ((baseA + baseB)/2) * altura;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	

}
