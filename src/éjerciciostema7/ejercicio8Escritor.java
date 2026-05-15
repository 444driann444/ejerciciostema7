package éjerciciostema7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ejercicio8Escritor {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		
		try (FileWriter fw = new FileWriter(new File("Ficheros//Ejercicio8.txt"),true);
				BufferedWriter bw = new BufferedWriter(fw); )  {

			do {
				System.out.println("Dime un numero");
				opcion = teclado.nextInt();
				if (opcion == 0) {
					System.out.println("No se guarda");
				}else {
					bw.write(""+opcion+";");
				}
				
			}while(opcion != 0);
			System.out.println("Numeros almacenados en el archivo de 'Ejercicio8.txt'");
		} catch (Exception e) {
			System.out.println("No se pueden almacenar");
		}
		

	}

}
