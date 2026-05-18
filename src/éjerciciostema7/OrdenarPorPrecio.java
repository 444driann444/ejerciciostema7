package éjerciciostema7;

import java.util.Comparator;

public class OrdenarPorPrecio  implements Comparator<Ciudad>{

	@Override
	public int compare(Ciudad o1, Ciudad o2) {
		if(o1.calcularPrecioMedioRestaurantes() < o2.calcularPrecioMedioRestaurantes()) {
			return 1;
		}else if(o1.calcularPrecioMedioRestaurantes() > o2.calcularPrecioMedioRestaurantes()) {
			return -1;
		}else {
			return 0;
		}
		
	}
	

}
