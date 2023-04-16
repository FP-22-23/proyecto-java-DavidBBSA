package fp.moviles.test;


import java.time.LocalDate;
import fp.common.Memorias;
import fp.moviles.Movil;


public class TestMovil {

	public static void main(String[] args) {
		Memorias m = new Memorias("4 GB", "64 GB");
		LocalDate f1 = LocalDate.of(2009, 3, 4);
		Movil m1 = new Movil("Redmi 8 (Onyx Black, 64 GB)", m, 674638, 50064, 4.4, 1360, false, f1, 128224);
		m1.añadirPaisMasVendido("China");
		m1.añadirPaisMasVendido("España");
		System.out.println(m1);
		System.out.println("El móvil " + m1.getNombre() + " pertenece a la " + m1.getGeneracion(m1.getFSalida()) + " generación");
		
		Movil m2 = m1;
		System.out.println("¿Es m1 = m2?: " + m1.equals(m2));
		System.out.println("Hash code de m1: " + m1.hashCode());
		System.out.println("Hash code de m2: " + m2.hashCode());
		
		Movil m3 = new Movil("Redmi 8 (Onyx Black, 64 GB)", 1200, f1);
		System.out.println(m3);
		System.out.println(m1.compareTo(m3));
	}

}
