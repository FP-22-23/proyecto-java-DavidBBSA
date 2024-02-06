package fp.moviles.test;


import java.util.Collection;


import fp.moviles.FactoriaMoviles;
import fp.moviles.Movil;
import fp.moviles.Moviles;

public class TestFactoriaMoviles {
	
	private static void mostrarMoviles(Moviles m) {
		for (Movil movil : m.getMoviles()) {
		    System.out.println(movil);
		}
	}
	
	private static <T> void mostrarColeccion(Collection<T> col) {
		col.stream()
		    .map(Object::toString)
		    .forEach(System.out::println);

	}

	public static void main(String[] args) {
		
		Moviles m = FactoriaMoviles.leerMoviles("data/Móviles.csv");
		
		System.out.println("TestLeerPartidas =============");
		mostrarMoviles(m);
		
		System.out.println("\nTestExisteMovil =============");
		Integer anyo = 2018;
		System.out.println("Existe algún móvil con fecha de salida en el año " + anyo + ": " + m.existeMovil(2000));
		
		System.out.println("\nTestMediaPrecioMoviles =============");
		System.out.println("La media de los precios es de " + m.mediaPrecioMoviles() + "€");
		
		System.out.println("\nTestFiltrarNFC =============");
		Boolean nfc = true;
		System.out.println("Los móviles que contienen NFC son: ");
		mostrarColeccion(m.filtrarNFC(nfc));
		
		System.out.println("\nTestFiltrarMovilesPorAnyo =============");
		System.out.println("Nombre de movilés con fecha de salida en cada año " + m.filtrarMovilesPorAnyo());
		
		System.out.println("\nTestConteoSegunNFC =============");
		System.out.println("Número de moviles con y sin NFC: " + m.conteoSegunNFC());
		
		System.out.println("\nTestExisteMovilStream =============");
		System.out.println("Existe algún móvil con fecha de salida en el año " + anyo + ": " + m.existeMovilStream(2000));
		
		System.out.println("\nTestMediaPrecioStream =============");
		System.out.println("La media de las estrellas de todos los móviles es " + m.mediaPrecioStream() + "€");
		
		System.out.println("\nTestFiltrarNfcStreams =============");
		System.out.println("Los móviles que tienen nfc son: " + m.filtrarNfcStream());
		
		System.out.println("\nTestPrecioMovilMasVendidoAntesDelAnyo =============");
		anyo = 2015;
		System.out.println("El precio del móvil más vendido antes del año " + anyo + " es de " + m.precioMovilMasVendidoAntesDelAnyo(anyo) + "€");
		
		System.out.println("\nTestOrdenarPorEstrellas =============");
		String ram = "4 GB";
		System.out.println("Móviles con " + ram + " de memoria ram ordenados de mayor a menor valoración de estrellas:");
		mostrarColeccion(m.ordenarPorEstrellas(ram));
		
		System.out.println("\nTestNumeroDeMovilesSegunRam =============");
		System.out.println("Contador de móviles según la ram: " + m.numeroDeMovilesSegunRam());
		
		System.out.println("\nTestMovilMasBaratoPorRom() =============");
		System.out.println("Precio del móvil mas barato por Rom: " + m.movilMasBaratoPorRom());
		
		System.out.println("\nTestMovilPorAnyo =============");
		System.out.println("Móviles por año: " + m.movilPorAnyo());
		
		System.out.println("\nTesTopMejoresValoracionesPorRam =============");
		Integer n = 2;
		System.out.println("Las " + n + " mejores valoraciones(estrellas) según la ram: " + m.topMejoresValoracionesPorRam(n));
	
		System.out.println("\nTestMovilMasVendido =============");
		System.out.println("El móvil más vendido es: " + m.movilMasVendido());
		
	}
}
	
