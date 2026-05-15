package éjerciciostema7;

public class ejercicio3PDF {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("Iker", "7086475L", 675544283);
		CuentaCorriente cuenta = new CuentaCorriente("ES90855334", 1000, cliente);

		
		System.out.println("Estado inicial de la cuenta");
		System.out.println(cuenta);
		
		try {
			cuenta.ingreso(500);
			System.out.println("Despues del ingreso de 500:");
			System.out.println(cuenta);
			
			cuenta.reintegro(200);
			System.out.println("Despues del reintegro de 200:");
			System.out.println(cuenta);
			
			cuenta.reintegro(2000);
		}catch (SaldoInsuficienteException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
