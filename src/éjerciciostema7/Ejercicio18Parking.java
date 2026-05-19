package éjerciciostema7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio18Parking implements Serializable{

	private List<Ejercicio18Coche> coches;
	private int capacidadParking = 10;
	
	public Ejercicio18Parking() {
		super();
		this.coches = new ArrayList<Ejercicio18Coche>();
		this.capacidadParking = capacidadParking;
	}
	public Ejercicio18Coche buscarCoche(String maticula) {
		for (Ejercicio18Coche c: coches) {
			if(c.getMatricula().equals(maticula)) {
				return c;
			}
		}
		return null;
	}
	public List<Ejercicio18Coche> getCoches() {
		return coches;
	}
	public void setCoches(List<Ejercicio18Coche> coches) {
		this.coches = coches;
	}
	public int getCapacidadParking() {
		return capacidadParking;
	}
	public void setCapacidadParking(int capacidadParking) {
		this.capacidadParking = capacidadParking;
	}
	
	@Override
	public String toString() {
		return "\nEjercicio18Parking [coches=" + coches + ", capacidadParking=" + capacidadParking + "]";
	}
	
	
	
}
