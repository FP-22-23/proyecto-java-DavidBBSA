package fp.moviles;

import java.util.List;
import java.util.Map;

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
	
	List<Movil> filtrarNFC(Boolean nfc);
	
	Map<Integer, List<String>> filtrarMovilesPorAnyo();
	
	Map<Boolean, Integer> conteoSegunNFC();
}