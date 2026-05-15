package éjerciciostema7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ejercicio11version2PDF {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcion = -1;
		Parking2 parking = new Parking2();

		do {
			System.out.println("---MENU---");
			System.out.println("0) Salir");
			System.out.println("1) Entra coche");
			System.out.println("2) Salir coche");
			System.out.println("3) Listar coches");
			System.out.println("Introduzca una opcion");
			try {
			opcion = teclado.nextInt();
			teclado.nextLine();
			}catch (InputMismatchException e) {
				teclado.nextLine();
				System.out.println("La opcion debe ser numerica");
				System.out.println(e);
				opcion = -1;
			}
			
			
			switch (opcion) {
			case 0:
				System.out.println("Salir parking");
				break;
			case 1:
				System.out.println("Entrar Coche: ");
				if(parking.getCoche().size() >= parking.getCapacidadParking()) {
					System.out.println("El parking esta lleno");
				}else {
					System.out.println("Introduce la matricula del coche");
					String matricula = teclado.nextLine();
					if (parking.buscarCoche(matricula) != null) {
						System.out.println("El coche esta añadido");
					}else {
						try {
						
						System.out.println("Introduce una hora entre 0 y 23");
						int hora = teclado.nextInt();
						teclado.nextLine();
						if(hora < 0 || hora > 23) {
							System.out.println("Hora incorrecta");
						}else {
							Coche coche = new Coche(matricula, hora);
							parking.getCoche().add(coche);
							parking.setCapacidadParking(parking.getCapacidadParking() -1);
							escribirListaenelFichero(parking.getCoche());
							System.out.println("Añadido correctamente");
						}
						}catch (InputMismatchException e) {
							System.out.println("Tiene que ser numerico");
							teclado.nextLine();
						}catch (NullPointerException e) {
							// TODO: handle exception
						}

					}

				}
				break;
			case 2:
				System.out.println("Salir Coche: ");
				if(parking.getCoche().isEmpty()) {
					System.out.println("El parking esta vacio");
				}else {
					System.out.println("Introduce la matricula del coche");
					String matricula = teclado.nextLine();
					Coche cocheBuscar = parking.buscarCoche(matricula);
				if(cocheBuscar != null) {
					parking.getCoche().remove(cocheBuscar);
					parking.setCapacidadParking(parking.getCapacidadParking() +1);
					escribirListaenelFichero(parking.getCoche());
					System.out.println("Coche eliminado perfectamente");
				}else {
					System.out.println("No existe coche con esa matricula");
				}
				}
				break;
			case 3:
				System.out.println("Listar Coche: ");
				System.out.println(parking);
				break;

			default:
				System.out.println("Opcion no reconocida");
				break;
			}
		}while(opcion != 0);

	}
	private static Map<String, Integer> leerCoches() {
		   Map<String, Integer> coches = new HashMap<>();

		    try (FileReader fr = new FileReader("parking.txt");
		         BufferedReader br = new BufferedReader(fr)) {

		        String lineaLeida;

		        while ((lineaLeida = br.readLine()) != null) {

		            String[] partes = lineaLeida.split(",");

		            String matricula = partes[0];
		            int hora = Integer.parseInt(partes[1]);

		            coches.put(matricula, hora);
		        }

		    } catch (Exception e) {

		        System.out.println("Error al leer el fichero");
		    }

		    return coches;
		}
	public static void escribirListaenelFichero(List<Coche> coches) {
		
		try(FileWriter fw = new FileWriter("Ficheros//parking.txt",false); BufferedWriter bw = new BufferedWriter(fw)) {

			for(Coche c : coches) {
				bw.write(c.getMatricula() + ";" + c.getHoraLLegada());
				bw.newLine();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void escribirMapaEnfichero(Map<String, Integer> coche) {
		try(FileWriter fw = new FileWriter("Ficheros//parking.txt",false); BufferedWriter bw = new BufferedWriter(fw)){
			for(Entry<String, Integer> entrada : coche.entrySet()) {
				bw.write(entrada.getKey() + "," + entrada.getValue());
				bw.newLine();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
