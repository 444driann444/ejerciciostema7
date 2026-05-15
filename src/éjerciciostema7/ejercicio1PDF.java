package éjerciciostema7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio1PDF {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcion = -1;
		List<Integer> numeros = new ArrayList<Integer>();
		
		do {
			try {
				System.out.println("Dime un numero");
				opcion = teclado.nextInt();
				if(opcion != 0) {
					numeros.add(opcion);
				}
			}catch (Exception e) {
				System.out.println("El valor introducido no es numerico");
				teclado.nextLine();
			}
			
		}while(opcion != 0);
		System.out.println(numeros);

	}

}
