package éjerciciostema7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio8PDF {

	public static void main(String[] args) {
		
		String texto = LeerFichero("Ficheros//Ejercicio8.txt");
		System.out.println(texto);

		String[] numero = texto.split(";");
		
		for (int i = 0; i < numero.length - 1; i++) {

				int n = Integer.parseInt(numero[i]);
				if(esPrimo(n) == true) {
					System.out.println("El numero: " + n + " es primo");
				}else {
					System.out.println("El numero: " + n + " no es primo");
				}
		}
	}
	

	public static boolean esPrimo(int numero) {

	    if (numero < 2) {
	        return false;
	    }

	    for (int i = 2; i < numero; i++) {

	        if (numero % i == 0) {
	            return false;
	        }
	    }

	    return true;
	}

	public static String LeerFichero(String ruta) {
		String texto = "";
		try (FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);){
			
			String lineaLeida;
			
			do {
				lineaLeida = br.readLine();
				if(lineaLeida != null) {
					texto = texto + lineaLeida + "\n";
				}
				
			}while(lineaLeida != null);
			
			return texto;
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

}
