package fp.moviles.test;


import fp.moviles.FactoriaMoviles;
import fp.moviles.Moviles;

public class TestFactoriaMoviles {

	public static void main(String[] args) {
		
		Moviles m = FactoriaMoviles.leerMoviles("data/Móviles.csv");
		
		System.out.println("\nTestLeerPartidas =============");
		System.out.println("Móviles: "+ m);
		
		System.out.println("\nTestExisteMovil =============");
		Integer anyo = 2018;
		System.out.println("Existe algún móvil con fecha de salida en el año " + anyo + ": " + m.existeMovil(2000));
		
		System.out.println("\nTestMediaPrecioMoviles =============");
		System.out.println("La media de los precios es de " + m.mediaPrecioMoviles() + "€");
		
		System.out.println("\nTestFiltrarNFC =============");
		Boolean nfc = true;
		System.out.println("Los móviles que contienen NFC son: " + m.filtrarNFC(nfc));
		
		System.out.println("\nTestFiltrarMovilesPorAnyo =============");
		System.out.println("Nombre de movilés con fecha de salida en cada año " + m.filtrarMovilesPorAnyo());
		
		System.out.println("\nTestConteoSegunNFC =============");
		System.out.println("Número de moviles con y sin NFC: " + m.conteoSegunNFC());
		
	}
}
	
