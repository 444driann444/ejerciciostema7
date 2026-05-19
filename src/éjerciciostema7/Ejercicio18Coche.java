package éjerciciostema7;

import java.io.Serializable;

public class Ejercicio18Coche implements Serializable{

	private String matricula;
	private int horaDeLLegada;
	private int minutoDeLLegada;
	public Ejercicio18Coche(String matricula, int horaDeLLegada, int minutoDeLLegada) {
		super();
		this.matricula = matricula;
		this.horaDeLLegada = horaDeLLegada;
		this.minutoDeLLegada = minutoDeLLegada;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getHoraDeLLegada() {
		return horaDeLLegada;
	}
	public void setHoraDeLLegada(int horaDeLLegada) {
		this.horaDeLLegada = horaDeLLegada;
	}
	public int getMinutoDeLLegada() {
		return minutoDeLLegada;
	}
	public void setMinutoDeLLegada(int minutoDeLLegada) {
		this.minutoDeLLegada = minutoDeLLegada;
	}
	@Override
	public String toString() {
		return "Ejercicio18Coche [matricula=" + matricula + ", horaDeLLegada=" + horaDeLLegada + ", minutoDeLLegada="
				+ minutoDeLLegada + "]";
	}
	
	
}
