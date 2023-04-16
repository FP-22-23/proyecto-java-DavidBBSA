package fp.moviles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;




public class MovilesImpl implements Moviles {
	
	private List<Movil> moviles;

	//Constructor 1
	public MovilesImpl() {
		this.moviles = new ArrayList<Movil>();
	}

	//Constructor 2
	public MovilesImpl(Collection<Movil> moviles) {
		this.moviles = new ArrayList<Movil>(moviles);
	}

	//Constructor 3
	public MovilesImpl(Stream<Movil> m) {
		this.moviles = m.collect(Collectors.toList());
	}
	
	//Devuelve la lista de móviles
	public List<Movil> getMoviles(){
		return this.moviles;
	}

	//Devuelve el tamaño de la lista
	public Integer getNumeroMoviles() {
		return moviles.size();
	}
	
	//Añade un elemento al final de la lista
	public void añadirMovil(Movil m) {
		moviles.add(m);
	}
	
	/*
	 * Elimina el elemento de la lista indicado en el parametro.
	 * En caso de no existir muestra un error.
	*/
	public void eliminarMovil(Movil m) {
		if(!moviles.contains(m)) {
			throw new IllegalArgumentException("El movil no existe");
		}else {
			moviles.remove(m);
			
		}
	}
	
	
	
	@Override
	public String toString() {
		return "MovilesImpl [moviles=" + moviles + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(moviles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovilesImpl other = (MovilesImpl) obj;
		return Objects.equals(moviles, other.moviles);
	}

	/*
	 * Recibe como parámetro un año(Integer). Si encuentra en la lista algún
	 * móvil que su fecha de salida coincida con el año indicado,
	 * devuelve true(Boolean)
	 */
	
	@Override
	public Boolean existeMovil(Integer anyo) {
		Boolean res = false;
		for (Movil m:moviles) {
			if(m.getFSalida().getYear() == anyo) {
				res = true;
			}
		}
		return res;
	}
	
	/*
	 * Método que se encarga de calcular la media de los precios de todos
	 * los móviles que componen la lista. Devuelve la media(Double)
	 */
	@Override
	public Double mediaPrecioMoviles() {
		List<Integer> precios = new ArrayList<>();
		Double res = 0.0;
		for(Movil m:moviles) {
			precios.add(m.getPrecio());
			res += m.getPrecio();
		}
		
		return res/precios.size();
	}

	/*
	 * Recibe como parámetro nfc(Boolean). Según el valor del parámetro
	 * devuelve una lista con los elementos que contienen o no NFC.
	 */
	@Override
	public List<Movil> filtrarNFC(Boolean nfc) {
		List<Movil> res = new ArrayList<>();
		for(Movil m:moviles) {
			if(m.getNfc() == nfc) {
				res.add(m);
				}
			}
		return res;
	}

	/*
	 * Crea un diccionario en el cual las claves son los años en los cuáles
	 * se ha lanzado algún móvil y como valor tiene una lista con los nombre
	 * de los moviles lanzados dicho año.
	 */
	@Override
	public Map<Integer, List<String>> filtrarMovilesPorAnyo() {
		Map<Integer, List<String>> res = new HashMap<>();
		for(Movil m:moviles) {
			Integer clave = m.getFSalida().getYear();
			if(res.containsKey(clave)) {
				List<String>lista = res.get(clave);
				lista.add(m.getNombre());
			}else {
				List<String> lista = new ArrayList<String>();
				lista.add(m.getNombre());
				res.put(clave, lista);
			}
		}
		return res;
	}

	/*
	 * Devuelve un diccionario en el que la clave es true y false,
	 *  y el valor es el conteo del número de móviles que aparecen
	 *  con dicho valor de la clave
	 */
	@Override
	public Map<Boolean, Integer> conteoSegunNFC() {
		Map<Boolean, Integer> res = new HashMap<>();
		for(Movil m:moviles) {
			Boolean clave = m.getNfc();
			if(res.containsKey(clave)) {
				res.put(clave, res.get(clave) + 1);
			}else {
				res.put(clave, 1);
			}
		}
		return res;
	}
	
	
	
}
