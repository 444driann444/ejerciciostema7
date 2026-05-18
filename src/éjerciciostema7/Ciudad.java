package éjerciciostema7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ciudad {

	private String nombre;
	private int habitantes;
	private List<Restaurante> restaurantes;
	public Ciudad(String nombre, int habitantes) {
		super();
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.restaurantes = new ArrayList<Restaurante>();
	}
	
	public Restaurante buscarRestaurante (String nombre) {
		for (Restaurante r : restaurantes) {
			if(r.getNombre().equals(nombre)) {
				return r;
			}
		}
		return null;
	}
	public float calcularPrecioMedioRestaurantes() {
		if(restaurantes.isEmpty()) {
			return 0;
		}
		float sumaRestaurantes = 0;
		for(Restaurante t : restaurantes) {
			sumaRestaurantes += t.calcularPrecioMedio();
		}
		float media = sumaRestaurantes / restaurantes.size();
		return media;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}
	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}
	@Override
	public String toString() {
		return "\nCiudad [nombre=" + nombre + ", habitantes=" + habitantes + ", precio medio= "+ calcularPrecioMedioRestaurantes() + ", restaurantes=" + restaurantes + "]";
	}
	
	
}

