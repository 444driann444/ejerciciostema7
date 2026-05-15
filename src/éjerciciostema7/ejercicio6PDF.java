package éjerciciostema7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class ejercicio6PDF {

	public static void main(String[] args) {
		String texto = LeerFichero("Ficheros//ListaPalabras.txt");

		System.out.println(texto);
		
		System.out.println("Palabras mas grandes: ");
		imprimirPalabrasMasGrandes(texto);
		System.out.println();
		System.out.println("Palabras con mas A");
		imprimirPalabrasConMasA(texto);
		System.out.println();
		System.out.println("Palabras sin I y sin A");
		imprimirPalabrasSinAySinI(texto);
	}

	public static void imprimirPalabrasMasGrandes(String Palabras) {
		String[] palabra = Palabras.split(" ");
		int tamanoMaximo = 0;
		
		Set<String> repetidas = new TreeSet<String>();
		for(String p : palabra) {
			if(p.length() > tamanoMaximo) {
				tamanoMaximo = p.length();
			}
				
		}
		for(String p : palabra) {
			if(p.length() == tamanoMaximo) {
				repetidas.add(p);
			}
		}
		
		for(String p : repetidas) {
			System.out.println(p);
		}
		
		
	}
	public static void imprimirPalabrasSinAySinI(String palabras) {
		String[] palabra = palabras.split(" ");
		Set<String> sinRepetir = new TreeSet<String>();
		
		for(String p : palabra) {
			if(!p.contains("a") && !p.contains("i")) {
				sinRepetir.add(p);
			}
		}
		for(String p : sinRepetir) {
			System.out.println(p);
		}
	}
	public static void imprimirPalabrasConMasA(String palabras) {
		String[] palabra = palabras.split(" ");
		int numA = 0;
		Set<String> sinRepetir = new TreeSet<String>();
		for(String p : palabra) {
			int contador = 0;
			
			for(int i = 0; i < p.length(); i++) {
				if(p.charAt(i) == 'a' || p.charAt(i) == 'A') {
					contador++;
				}
			}
			if(contador > numA) {
				numA = contador;
			}
		}
	    for (String p : palabra) {

	        int contador = 0;

	        for (int i = 0; i < p.length(); i++) {

	            if (p.charAt(i) == 'a' || p.charAt(i) == 'A') {
	                contador++;
	            }
	        }

	        if (contador == numA) {
	        	
	           sinRepetir.add(p);
	        }
	    }
	    for(String p : sinRepetir) {
	    	System.out.println(p);
	    }
	}
	public static String LeerFichero(String ruta) {
		String texto = "";
		try (FileReader fr = new FileReader("Ficheros//ListaPalabras.txt");
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
