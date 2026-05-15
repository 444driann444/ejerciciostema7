package éjerciciostema7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio7PDF {

	public static void main(String[] args) {
	     String ruta1 = "Ficheros//ListaPalabras.txt";
	        String ruta2 = "Ficheros//ListaPalabrasCopia.txt";
	 
	        try {
	 
	            if (sonContenidosIguales(ruta1, ruta2)) {
	                System.out.println("Los contenidos de los archivos son iguales.");
	            } else {
	                System.out.println("Los contenidos de los archivos son diferentes.");
	            }
	 
	        } catch (IOException e) {
	        	System.out.println("Error de lectura");
	            System.out.println(e);
	        }
			
		}
	 
		    public static boolean sonContenidosIguales(String ruta1, String ruta2) throws IOException {
	 
		        FileReader fr1 = new FileReader(ruta1);
		        FileReader fr2 = new FileReader(ruta2);
	 
		        int c1 = fr1.read();
		        int c2 = fr2.read();
	 
		        while (c1 != -1 && c2 != -1) {
	 
		            if (c1 != c2) {
		                fr1.close();
		                fr2.close();
		                return false;
		            }
	 
		            c1 = fr1.read();
		            c2 = fr2.read();
		        }
	 
		        fr1.close();
		        fr2.close();
	 
		        return true;
		    }
}
