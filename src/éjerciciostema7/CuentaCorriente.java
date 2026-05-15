package éjerciciostema7;

public class CuentaCorriente {

	private String iban;
	private double saldo;
	private Cliente titular;
	
	public CuentaCorriente(String iban, double saldo, Cliente titular) {
		super();
		this.iban = iban;
		this.saldo = saldo;
		this.titular = titular;
	}

	public double ingreso(double cantidad) {
		saldo = saldo + cantidad;
		return saldo ;
	}
	
	public double reintegro(double cantidad) throws SaldoInsuficienteException  {
		if (saldo - cantidad <= 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}else {
			saldo = saldo - cantidad;
		}
		return saldo;
	}
	
	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [iban=" + iban + ", saldo=" + saldo + ", titular=" + titular + "]";
	}
	
	
}
