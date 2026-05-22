package ejercicioAdaptadoAbinario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Artista implements Serializable{

	private String nombre;
	private String nacionalidad;
	private List<Album> albumes;
	public Artista(String nombre, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.albumes = new ArrayList<Album>();
	}
	public Album buscarAlbum (String nombre) {
		for(Album a : albumes) {
			if(a.getNombre().equals(nombre)) {
				return a;
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
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public List<Album> getAlbumes() {
		return albumes;
	}
	public void setAlbumes(List<Album> albumes) {
		this.albumes = albumes;
	}
	@Override
	public String toString() {
		return "Artista [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", albumes=" + albumes + "]";
	}
	
	
}
