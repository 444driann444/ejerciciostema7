package ejercicioAdaptadoAbinario;

import java.io.Serializable;

public class Cancion implements Serializable{

	private String titulo;
	private int duracionSec;
	private String genero;
	private boolean favoritas;
	public Cancion(String titulo, int duracion, String genero, boolean favoritas) {
		super();
		this.titulo = titulo;
		this.duracionSec = duracion;
		this.genero = genero;
		this.favoritas = favoritas;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracionSec;
	}
	public void setDuracion(int duracion) {
		this.duracionSec = duracion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public boolean isFavoritas() {
		return favoritas;
	}
	public void setFavoritas(boolean favoritas) {
		this.favoritas = favoritas;
	}
	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", duracion=" + duracionSec + ", genero=" + genero + ", favoritas="
				+ favoritas + "]";
	}
	
	
}
