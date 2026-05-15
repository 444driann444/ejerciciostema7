package éjerciciostema7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ejercicio9PDF {
	
	static final String RUTA_FICHERO = "Ficheros//Usuarios.txt";
	public static void main(String[] args) {
		
		int opcion = -1;
		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("---MENÚ---");
			System.out.println("0) Salida");
			System.out.println("1) Registro");
			System.out.println("2) Login");
			System.out.println("3) Eliminar usuario");
			System.out.print("Introduzca una opción: ");

			try {
				opcion = teclado.nextInt();
				teclado.nextLine();
			} catch (InputMismatchException e) {
				teclado.nextLine();
				System.out.println("La opción debe ser numérica");
				System.out.println(e);
				opcion = -1;
			}

			switch (opcion) {
			case 0:
				System.out.println("Hasta otra");
				break;
			case 1:
				System.out.println("Registro:");

				System.out.println("Introduzca el nombre:");
				String nombre = teclado.nextLine();
				System.out.println("Introduzca la contraseña:");
				String clave = teclado.nextLine();

				try {
					escribirUsuarioEnElFichero(nombre, clave);
				} catch (IOException e) {
					System.out.println("Error escribiendo el fichero");
					System.out.println(e);
				}

				break;
			case 2:
				System.out.println("LogIn:");

				try {
					Map<String, String> usuarios = leerMapa(RUTA_FICHERO);

					System.out.println("Introduzca el nombre:");
					nombre = teclado.nextLine();
					System.out.println("Introduzca la contraseña:");
					String contrasena = teclado.nextLine();

					if (!usuarios.containsKey(nombre)) {
						System.out.println("El usuario no existe.");
					} else if (usuarios.get(nombre).equals(cifrarCesar(contrasena, 2))) {
						System.out.println("Usuario autenticado");
					} else {
						System.out.println("La contraseña no es correcta");
					}

				} catch (FileNotFoundException e) {
					System.out.println("El fichero no existe");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Error leyendo el fichero");
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("Borrar usuario:");

				try {
					Map<String, String> usuarios = leerMapa(RUTA_FICHERO);

					System.out.println("Introduzca el nombre:");
					nombre = teclado.nextLine();

					if (!usuarios.containsKey(nombre)) {
						System.out.println("El usuario no existe.");
					} else {
						usuarios.remove(nombre);
						escribirFicheroCompleto(usuarios);
						System.out.println("Usuario eliminado");
					}

				} catch (FileNotFoundException e) {
					System.out.println("El fichero no existe");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Error leyendo el fichero");
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Opción no reconocida");
				break;
			}

		} while (opcion != 0);
	}
	private static void escribirFicheroCompleto(Map<String, String> usuarios) throws IOException {
		// TODO Auto-generated method stub
		try (FileWriter fw = new FileWriter(RUTA_FICHERO, false); BufferedWriter bw = new BufferedWriter(fw)) {
			for (Entry<String, String> entrada : usuarios.entrySet()) {
				bw.write(entrada.getKey() + "," + cifrarCesar(entrada.getValue(), 2));
				bw.newLine();
			}
		}
	}

	private static void escribirUsuarioEnElFichero(String nombre, String clave) throws IOException {
		try (FileWriter fw = new FileWriter(RUTA_FICHERO, true); BufferedWriter bw = new BufferedWriter(fw)) {
			bw.write(nombre + "," + cifrarCesar(clave, 2));
			bw.newLine();
		}
	}

	@SuppressWarnings("unused")
	private static String leer(String ruta) throws FileNotFoundException, IOException {
		String texto = "";

		try (FileReader fr = new FileReader(ruta); BufferedReader br = new BufferedReader(fr)) {

			String lineaLeida;

			do {
				lineaLeida = br.readLine();

				if (lineaLeida != null) {
					texto += lineaLeida + "\n";
				}

			} while (lineaLeida != null);

		}

		return texto;
	}

	private static Map<String, String> leerMapa(String ruta) throws FileNotFoundException, IOException {
		Map<String, String> mapa = new HashMap<String, String>();

		try (FileReader fr = new FileReader(ruta); BufferedReader br = new BufferedReader(fr)) {

			String lineaLeida;

			do {
				lineaLeida = br.readLine();

				if (lineaLeida != null) {
					String[] partes = lineaLeida.split(",");
					mapa.put(partes[0], partes[1]);
				}

			} while (lineaLeida != null);

		}

		return mapa;
	}

	public static String cifrarCesar(String palabra, int desfase) {
		String resultado = "";

		for (char caracter : palabra.toCharArray()) {

			if (Character.isLetter(caracter)) {
				char nuevaLetra = (char) (caracter + desfase);
				if (Character.isUpperCase(caracter)) {
					if (nuevaLetra > 'Z') {
						nuevaLetra = (char) ('A' + (nuevaLetra - 'Z') - 1);
					}
				} else {
					if (nuevaLetra > 'z') {
						nuevaLetra = (char) ('a' + (nuevaLetra - 'z') - 1);
					}

				}
				resultado = resultado + nuevaLetra;
			} else {
				resultado = resultado + caracter;
			}

		}

		return resultado.toString();
	}

	public static String desCifrarCesar(String palabraCifrada, int desfase) {
		String resultado = "";

		for (char caracter : palabraCifrada.toCharArray()) {

			if (Character.isLetter(caracter)) {
				char nuevaLetra = (char) (caracter - desfase);
				if (Character.isUpperCase(caracter)) {
					if (nuevaLetra < 'A') {
						nuevaLetra = (char) ('Z' - ('A' - nuevaLetra) + 1);
					}
				} else {
					if (nuevaLetra < 'a') {
						nuevaLetra = (char) ('z' - ('a' - nuevaLetra) + 1);
					}

				}
				resultado = resultado + nuevaLetra;
			} else {
				resultado = resultado + caracter;
			}

		}

		return resultado.toString();
	}

}
