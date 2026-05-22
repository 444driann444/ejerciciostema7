package ejercicioAdaptadoAbinario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Album implements Serializable{

	private String nombre;
	private List<Cancion> canciones;
	public Album(String nombre) {
		super();
		this.nombre = nombre;
		this.canciones = new ArrayList<Cancion>();
	}
	public Cancion buscarCancion (String nombre) {
		for(Cancion c : canciones) {
			if(c.getTitulo().equals(nombre)) {
				return c;
			}
		}
		return null;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Cancion> getCanciones() {
		return canciones;
	}
	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	@Override
	public String toString() {
		return "Album [nombre=" + nombre + ", canciones=" + canciones + "]";
	}
	
	
}
