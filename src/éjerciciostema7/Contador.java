package éjerciciostema7;

public class Contador {

	private int valor;
	private int minimo;
	private int maximo;
	
	public Contador(int valor, int minimo, int maximo) {
		super();
		this.valor = valor;
		this.minimo = minimo;
		this.maximo = maximo;
	}
	
	public int incrementar() throws ExcesoMaximoExcepcion {
		if(valor+1 > maximo ) {
			throw new ExcesoMaximoExcepcion("Se pasa del maximo");
		}else {
			valor = valor+1;
		}
		return valor;
	}
	
	public int decrementar() throws ExcesoMinimoExcepcion {
		if (valor -1 < minimo) {
			throw new ExcesoMinimoExcepcion("No puede bajar del minimo");
		}else {
			valor = valor -1;
		}
		return valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	@Override
	public String toString() {
		return "Contador [valor=" + valor + ", minimo=" + minimo + ", maximo=" + maximo + "]";
	}
	
	
}
