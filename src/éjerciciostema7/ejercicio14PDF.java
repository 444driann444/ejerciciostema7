package éjerciciostema7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ejercicio14PDF {

	public static void main(String[] args) {
		List<Ciudad> ciudades = leerCiudades("Ficheros//Restaurantes.csv");
		System.out.println(ciudades);
		System.out.println();
		System.out.println("Ordenador por precio Medio de ciudades");
		Collections.sort(ciudades, new OrdenarPorPrecio());
		System.out.println(ciudades);
		
	}

	public static Ciudad buscarCiudad(String nombre, List<Ciudad> ciudades) {
		for (Ciudad c : ciudades) {
			if (c.getNombre().equals(nombre)) {
				return c;
			}
		}
		return null;
	}

	public static void imprimirPrecioMedioCiudades(List<Ciudad> ciudades) {
		
	}

	public static List<Ciudad> leerCiudades(String ruta) {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();

		try (FileReader fr = new FileReader(ruta); BufferedReader br = new BufferedReader(fr)) {
			String lineaLeida;
			br.readLine();

			do {

				lineaLeida = br.readLine();
				if (lineaLeida == null) {
					break;
				}
				String partes[] = lineaLeida.split(",");
				String nombreCiudad = partes[0];
				int habitantes = Integer.parseInt(partes[1]);
				String nombreRestaurante = partes[2];
				int capacidad = Integer.parseInt(partes[3]);
				String nombrePlato = partes[4];
				float precioPlato = Float.parseFloat(partes[5]);
				Ciudad ciudadBuscar = buscarCiudad(nombreCiudad, ciudades);
				if (ciudadBuscar == null) {
					ciudadBuscar = new Ciudad(nombreCiudad, habitantes);
					ciudades.add(ciudadBuscar);
				}

				Restaurante restaurantesBuscar = ciudadBuscar.buscarRestaurante(nombreRestaurante);
				if (restaurantesBuscar == null) {
					restaurantesBuscar = new Restaurante(nombreRestaurante, capacidad);
					ciudadBuscar.getRestaurantes().add(restaurantesBuscar);
				}
				
				
				restaurantesBuscar.getPlatos().add(new Plato(nombrePlato,precioPlato));

			} while (lineaLeida != null);

		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}

		return ciudades;
	}

}
