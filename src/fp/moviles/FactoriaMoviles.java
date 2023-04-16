package fp.moviles;


import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.stream.Stream;

import fp.common.Memorias;
import fp.utiles.Checkers;

public class FactoriaMoviles {

	public static Moviles leerMoviles(String rutaFichero) {
		
		Moviles res = null;
		try{
			Stream<Movil> sv = 
					Files.lines(Paths.get(rutaFichero)).skip(1).map(FactoriaMoviles::parsearMovil);
			res = new MovilesImpl(sv);
				}catch(IOException e) {
						System.out.println("No se ha encontrado el fichero" + rutaFichero);
						e.printStackTrace();
					}
		return res;
	}

	public static Movil parsearMovil(String lineaCSV) {
		String[] campos = lineaCSV.split(";");
		System.out.println(campos);
		Checkers.check("Error en elementos movil", campos.length == 10);
		String nombre = campos[0].trim();
		String ram = campos[1].trim();
		String rom = campos[2].trim();
		Memorias memoria = new Memorias(ram, rom);
		Integer calificaciones = Integer.valueOf(campos[3].trim());
		Integer comentarios = Integer.valueOf(campos[4].trim());
		Double estrellas = Double.valueOf(campos[5].trim());
		Integer precio = Integer.valueOf(campos[6].trim());
		Boolean nfc = Boolean.valueOf(campos[7].trim());
		LocalDate fSalida=LocalDate.parse(campos[8].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer vendidos = Integer.valueOf(campos[9].trim());
		
		return new Movil(nombre, memoria, calificaciones, comentarios, estrellas, precio, nfc, fSalida, vendidos);
		}
}

