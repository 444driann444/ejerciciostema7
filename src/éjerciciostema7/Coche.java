package éjerciciostema7;

public class Coche {

	private String matricula;
	private int horaLLegada;
	public Coche(String matricula, int horaLLegada) {
		super();
		this.matricula = matricula;
		this.horaLLegada = horaLLegada;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getHoraLLegada() {
		return horaLLegada;
	}
	public void setHoraLLegada(int horaLLegada) {
		this.horaLLegada = horaLLegada;
	}
	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", horaLLegada=" + horaLLegada + "]";
	}
	
	
}
