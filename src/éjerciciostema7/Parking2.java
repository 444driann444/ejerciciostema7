package éjerciciostema7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking2 {

	private List<Coche> coches ;
	private int capacidadParking = 10;
	public Parking2() {
		super();
		this.coches = new ArrayList<Coche>();
		}
	public Coche buscarCoche(String matricula) {
		for(Coche c : coches) {
			if(c.getMatricula().equals(matricula)) {
				return c ;
			}
		}
		return null;
	}
	
	public List<Coche> getCoche() {
		return coches;
	}
	public void setCoche(List<Coche> coche) {
		this.coches = coche;
	}
	public void getCoche(List<Coche> coche) {
		this.coches = coche;
	}
	public int getCapacidadParking() {
		return capacidadParking;
	}
	public void setCapacidadParking(int capacidadParking) {
		this.capacidadParking = capacidadParking;
	}
	@Override
	public String toString() {
		return "Parking [coche=" + coches + ", capacidadParking=" + capacidadParking + "]";
	}
	
	
	
}
