package com.challenge.recursiva;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class SocioParser {

	public static List<Socio> parse(String filePath)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		File file = new File(filePath);
		CSVParser parser = CSVFormat.RFC4180.withDelimiter(';')
				.parse(new InputStreamReader(new FileInputStream(file), "CP1252"));

		List<Socio> socios = new ArrayList<>();
		for (CSVRecord record : parser) {
			String nombre = record.get(0);
			Integer edad = Integer.valueOf(record.get(1));
			String equipo = record.get(2);
			EstadoCivil estadoCivil = EstadoCivil.valueOf(record.get(3).toUpperCase());
			NivelDeEstudios nivelDeEstudios = NivelDeEstudios.valueOf(record.get(4).toUpperCase());
			Socio socio = new Socio(nombre, edad, equipo, estadoCivil, nivelDeEstudios);
			socios.add(socio);
		}
		
		return socios;
	}

}
