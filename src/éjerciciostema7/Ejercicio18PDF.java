package éjerciciostema7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class Ejercicio18PDF {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Ejercicio18Parking parking = new Ejercicio18Parking();
		int opcion = 0;
		do {
			System.out.println("--------");
			System.out.println("--Menu--");
			System.out.println("--------");
			System.out.println("0)Salir Parking");
			System.out.println("1) Annadir Parking");
			System.out.println("2) Eliminar Parking");
			System.out.println("3) Mostrar Parking");
			opcion = teclado.nextInt();
			teclado.nextLine();
			
			switch (opcion) {
			case 0:
				System.out.println("Saliendo del parking.....");
				break;
			case 1:
				System.out.println("Entrar coche: ");
				if(parking.getCoches().size() > parking.getCapacidadParking()) {
					System.out.println("El parking esta lleno");
				}else {
					System.out.println("Introduce la matriucla");
					String matricula = teclado.nextLine();
					if(parking.buscarCoche(matricula) != null) {
						System.out.println("El coche ya esta registrado");
					}else {
						try {
							System.out.println("Introduce la hora entre 0 y 23");
							int hora = teclado.nextInt();
							teclado.nextLine();
							System.out.println("Introduce los minutos entre 0 y 59");
							int minutos = teclado.nextInt();
							teclado.nextLine();
							if(hora < 0 || hora > 23 || minutos < 0 || minutos > 59) {
								System.out.println("Hora incorrecta");
							}else {
								Ejercicio18Coche coche = new Ejercicio18Coche(matricula, hora, minutos);
								parking.getCoches().add(coche);
								parking.setCapacidadParking(parking.getCapacidadParking() -1);
								escribirFichero("Ficheros//parking.bin", parking);
								System.out.println("Añadido correctamente");
							}
						}catch (Exception e) {
							System.out.println(e);
						}
					}
				}
				break;
			case 2:
				System.out.println("Salir Coche: ");
				if(parking.getCoches().isEmpty()) {
					System.out.println("El parking esta vacio");
				}else {
					System.out.println("Introduce la matricula del coche");
					String matricula = teclado.nextLine();
					Ejercicio18Coche cocheBuscar = parking.buscarCoche(matricula);
				if(cocheBuscar != null) {
					parking.getCoches().remove(cocheBuscar);
					parking.setCapacidadParking(parking.getCapacidadParking() +1);
					try {
						escribirFichero("Ficheros//parking.bin", parking);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Coche eliminado perfectamente");
				}else {
					System.out.println("No existe coche con esa matricula");
				}
				}
				break;
			case 3:
				System.out.println("Listar Coche: ");
				try {
					parking = leerFichero("Ficheros//parking.bin");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(parking);
				break;

			default:
				System.out.println("Error opcion no reconocida");
				break;
			}
			
		}while (opcion != 0);

	}
	public static Ejercicio18Parking leerFichero(String ruta) throws IOException, ClassNotFoundException {
		Ejercicio18Parking parking = new Ejercicio18Parking();
		try(FileInputStream fis = new FileInputStream(ruta);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			parking = (Ejercicio18Parking) ois.readObject();
		}
		return parking;
	}
	public static void escribirFichero (String ruta, Ejercicio18Parking parking) throws IOException {
		try(FileOutputStream fos = new FileOutputStream(ruta);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(parking);
		}
	}

}
