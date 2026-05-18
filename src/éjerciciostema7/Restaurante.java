package éjerciciostema7;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {

	private String nombre;
	private List<Plato> platos;
	private int capacidad;
	public Restaurante(String nombre, int capacidad) {
		super();
		this.nombre = nombre;
		this.platos = new ArrayList<Plato>();
		this.capacidad = capacidad;
	}
	public float calcularPrecioMedio () {
		if(platos.isEmpty()) {
			return 0;
		}
		float sumaplatos = 0;
		for(Plato p: platos) {
			sumaplatos += p.getPrecio();
		}
		float media = sumaplatos / platos.size();
		return media;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	@Override
	public String toString() {
		return "\n\tRestaurante [nombre=" + nombre + ", capacidad=" + capacidad + " Precio medio Plato= " + calcularPrecioMedio() +  ", platos=" + platos +  "]";
	}
	
	
}
