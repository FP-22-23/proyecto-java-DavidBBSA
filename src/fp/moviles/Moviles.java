package fp.moviles;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public interface Moviles {

	List<Movil> getMoviles();

	void añadirMovil(Movil m);
	
	void eliminarMovil(Movil m);
	
	Integer getNumeroMoviles();

	String toString();

	int hashCode();

	boolean equals(Object obj);

	Boolean existeMovil(Integer anyo);
	
	Double mediaPrecioMoviles();
	
	List<String> filtrarNFC(Boolean nfc);
	
	Map<Integer, List<String>> filtrarMovilesPorAnyo();
	
	Map<Boolean, Integer> conteoSegunNFC();
	
	Boolean existeMovilStream (Integer anyo);
	
	Double mediaPrecioStream();
	
	Map<String, Long> numeroDeMovilesSegunRam();
	
	List<String> filtrarNfcStream();
	
	Integer precioMovilMasVendidoAntesDelAnyo(Integer anyo);
	
	List<Movil> ordenarPorEstrellas(String ram);
	
	Map<Integer,Set<String>> movilPorAnyo();
	
	Map<String,Integer> movilMasBaratoPorRom();
	
	Map<String, List<Double>> topMejoresValoracionesPorRam(Integer n);
	
	String movilMasVendido();
}