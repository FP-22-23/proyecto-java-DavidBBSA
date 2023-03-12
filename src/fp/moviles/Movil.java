package fp.moviles;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fp.common.Memorias;
import fp.utiles.Checkers;

public class Movil implements Comparable<Movil>{
	private String nombre;
	private Integer calificaciones;
	private Integer comentarios;
	private Double estrellas;
	private Integer precio;
	private Boolean nfc;
	private LocalDate fSalida;
	private Integer numVentas;
	private Memorias memorias;
	private List<String>paisesMasVendidos;
	
	//Constructor 1
	public Movil(String nombre,Memorias memorias, Integer calificaciones, Integer comentarios, Double estrellas,
			Integer precio, Boolean nfc, LocalDate fSalida, Integer numVentas) {
		checkNombre(nombre);
		this.nombre = nombre;
		this.memorias = memorias;
		this.calificaciones = calificaciones;
		this.comentarios = comentarios;
		this.estrellas = estrellas;
		checkPrecio(precio);
		this.precio = precio;
		this.nfc = nfc;
		this.fSalida = fSalida;
		this.numVentas = numVentas;
		this.paisesMasVendidos = new LinkedList<String>();
	}
	
	//Constructor 2
	public Movil(String nombre, Integer precio, LocalDate fSalida) {
		checkNombre(nombre);
		this.nombre = nombre;
		checkPrecio(precio);
		this.precio = precio;
		this.fSalida = fSalida;
		calificaciones = null;
		comentarios = null;
		estrellas = null;
		nfc = null;
	}
	
	//Checkers
	public void checkNombre(String nombre) {
		Checkers.check("Error en nombre: no puede ser null", nombre!= null);
	}
	
	public void checkPrecio(Integer precio) {
		Checkers.check("Error en precio: no puede ser menor o igual a cero", precio > 0);
	}
	
	//Getters
	public String getNombre() {
		return nombre;
	}

	public Memorias getMemorias() {
		return memorias;
	}
	
	public Integer getNumVentas() {
		return numVentas;
	}

	public Integer getCalificaciones() {
		return calificaciones;
	}

	public Integer getComentarios() {
		return comentarios;
	}

	public Double getEstrellas() {
		return estrellas;
	}

	public Integer getPrecio() {
		return precio;
	}

	public Boolean getNfc() {
		return nfc;
	}

	public LocalDate getfSalida() {
		return fSalida;
	}
	
	public List<String> getPaisesMasVendidos() {
		return paisesMasVendidos;
	}
	
	//Propiedad derivada
	public Generacion getGeneracion(LocalDate fSalida) {
		Generacion res = Generacion.QUINTA;
		if (fSalida.isBefore(LocalDate.of(1990, 1, 1))) {
			res = Generacion.PRIMERA;
		}
		else if (fSalida.isBefore(LocalDate.of(2000, 1, 1)) && fSalida.isAfter(LocalDate.of(1990, 1, 1))){
			
			res = Generacion.SEGUNDA;
		}
		else if (fSalida.isBefore(LocalDate.of(2010, 1, 1)) && fSalida.isAfter(LocalDate.of(2000, 1, 1))){
			
			res = Generacion.TERCERA;
		}
		else if (fSalida.isBefore(LocalDate.of(20022, 1, 1)) && fSalida.isAfter(LocalDate.of(2010, 1, 1))){
			
			res = Generacion.CUARTA;
		}
		return res;
	}
	
	//Setters
	public void setPaisesMasVendidos(List<String> ventaContinentes) {
		this.paisesMasVendidos = ventaContinentes;
	}
	public void añadirPaisMasVendido(String pais) {
		paisesMasVendidos.add(pais);
	}

	public String toString() {
		return "Nombre=" + nombre + ", memorias=" + memorias + ", calificaciones=" + calificaciones + ", comentarios=" + comentarios
				+ ", estrellas=" + estrellas + ", precio=" + precio + "€" + ", NFC=" + nfc + ", fecha de salida=" + fSalida
				+ ", número de ventas=" + numVentas +  ", países más vendidos=" + paisesMasVendidos;
	}

	public int hashCode() {
		return Objects.hash(fSalida, nombre);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movil other = (Movil) obj;
		return Objects.equals(fSalida, other.fSalida) && Objects.equals(nombre, other.nombre);
	}
	//Criterio de orden natural
	public int compareTo(Movil m) {
		int res = this.getNombre().compareTo(m.getNombre ());
		if (res==0) {
			res = this.getPrecio().compareTo(m.getPrecio());
		}
		return res;
	}

	
	
}
