package éjerciciostema7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ejercicio2PDF {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		List<Character> letras = new ArrayList<Character>();
		letras.add('A');
		letras.add('B');
		letras.add('C');
		letras.add('D');
		letras.add('E');
		int indice = -1;
		do {
			try {
				System.out.println("Que valor de la lista quieres eliminar");
				indice = teclado.nextInt();
				letras.remove(indice);
				System.out.println(letras);
			}catch (NumberFormatException e) {
				System.out.println("Introduce un numero que sea entero");
				teclado.nextLine();
			}catch (IndexOutOfBoundsException e) {
				System.out.println("Fuera de limites " + e.getMessage());
			}catch (InputMismatchException e) {
				System.out.println("Ltras no");
			}
		}while(!letras.isEmpty());
		

	}

}