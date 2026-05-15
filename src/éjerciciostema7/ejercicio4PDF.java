package éjerciciostema7;

public class ejercicio4PDF {

	public static void main(String[] args) {
		Contador contador = new Contador(5, 0, 10);
		
		try {
			while(true) {
				contador.incrementar();
				System.out.println("Incremento: " + contador.getValor());
			}
		}catch (ExcesoMaximoExcepcion e) {
			System.out.println("Error :" + e.getMessage());
		}
		
		try {
			while(true) {
				contador.decrementar();
				System.out.println("Decremento: " + contador.getValor());
			}
		}catch (ExcesoMinimoExcepcion e) {
			System.out.println("Error :" + e.getMessage());
		}
	}
	

}
