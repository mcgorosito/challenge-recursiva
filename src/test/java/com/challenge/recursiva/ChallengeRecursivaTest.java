package com.challenge.recursiva;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ChallengeRecursivaTest {

	@Test
	public void promedioHinchasTest() {
		List<Socio> socios = new ArrayList<>();
		Socio socio1 = new Socio("Carolina", 22, "Boca Jrs", EstadoCivil.SOLTERO, NivelDeEstudios.SECUNDARIO);
		Socio socio2 = new Socio("Franco", 29, "River", EstadoCivil.SOLTERO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio3 = new Socio("Matias", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		socios.add(socio1);
		socios.add(socio2);
		socios.add(socio3);

		assertEquals(ChallengeRecursiva.calcularEdadPromedioHinchas(socios, "River"), "32");
	}

	@Test
	public void promedioNingunHinchaTest() {
		List<Socio> socios = new ArrayList<>();
		Socio socio1 = new Socio("Carolina", 22, "Boca Jrs", EstadoCivil.SOLTERO, NivelDeEstudios.SECUNDARIO);
		Socio socio2 = new Socio("Franco", 29, "River", EstadoCivil.SOLTERO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio3 = new Socio("Matias", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		socios.add(socio1);
		socios.add(socio2);
		socios.add(socio3);

		assertEquals(ChallengeRecursiva.calcularEdadPromedioHinchas(socios, "Estudiantes"), "0");
	}

	@Test
	public void personasCasadasMenorAMayorTest() {
		List<Socio> socios = new ArrayList<>();
		Socio socio1 = new Socio("Carolina", 22, "Boca Jrs", EstadoCivil.SOLTERO, NivelDeEstudios.SECUNDARIO);
		Socio socio3 = new Socio("Matias", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio2 = new Socio("Franco", 29, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		socios.add(socio1);
		socios.add(socio2);
		socios.add(socio3);

		List<Socio> sociosOrdenados = new ArrayList<>();
		sociosOrdenados.add(socio2);
		sociosOrdenados.add(socio3);

		assertEquals(ChallengeRecursiva.cienPersonas(socios), sociosOrdenados);
	}

	@Test
	public void nombresRepetidosPorEquipoTest() {
		List<Socio> socios = new ArrayList<>();
		Socio socio1 = new Socio("Carolina", 22, "River", EstadoCivil.SOLTERO, NivelDeEstudios.SECUNDARIO);
		Socio socio2 = new Socio("Matias", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio3 = new Socio("Franco", 29, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio4 = new Socio("Leonel", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio5 = new Socio("Maria", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio6 = new Socio("Carolina", 22, "River", EstadoCivil.SOLTERO, NivelDeEstudios.SECUNDARIO);
		Socio socio7 = new Socio("Matias", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio8 = new Socio("Franco", 29, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio9 = new Socio("Leonel", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio10 = new Socio("Maria", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio11 = new Socio("Blas", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio12 = new Socio("Gianluca", 35, "Boca Jrs", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio13 = new Socio("Gianluca", 35, "Boca Jrs", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio14 = new Socio("Gianluca", 35, "Boca Jrs", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);

		socios.add(socio1);
		socios.add(socio2);
		socios.add(socio3);
		socios.add(socio4);
		socios.add(socio5);
		socios.add(socio6);
		socios.add(socio7);
		socios.add(socio8);
		socios.add(socio9);
		socios.add(socio10);
		socios.add(socio11);
		socios.add(socio12);
		socios.add(socio13);
		socios.add(socio14);

		List<String> nombresRepetidos = new ArrayList<>();
		nombresRepetidos.add("Carolina");
		nombresRepetidos.add("Franco");
		nombresRepetidos.add("Leonel");
		nombresRepetidos.add("Maria");
		nombresRepetidos.add("Matias");


		assertEquals(ChallengeRecursiva.nombresRepetidosPorEquipo(socios, "River"), nombresRepetidos);
	}

	@Test
	public void promedioEdadPorEquiposTest() {
		List<Socio> socios = new ArrayList<>();
		Socio socio1 = new Socio("Carolina", 22, "Boca Jrs", EstadoCivil.SOLTERO, NivelDeEstudios.SECUNDARIO);
		Socio socio2 = new Socio("Matias", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio3 = new Socio("Franco", 29, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio4 = new Socio("Leonel", 25, "Racing", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio5 = new Socio("Maria", 78, "Racing", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio6 = new Socio("Blas", 42, "Racing", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		socios.add(socio1);
		socios.add(socio2);
		socios.add(socio3);
		socios.add(socio4);
		socios.add(socio5);
		socios.add(socio6);

		Map<String, String> promedioEdadPorEquipos = new HashMap<>();
		promedioEdadPorEquipos.put("Boca Jrs", "22");
		promedioEdadPorEquipos.put("River", "32");
		promedioEdadPorEquipos.put("Racing", "48.33");

		assertEquals(ChallengeRecursiva.promedioEdadPorEquipo(socios), promedioEdadPorEquipos);
	}

	@Test
	public void menorEdadPorEquipoTest() {
		List<Socio> socios = new ArrayList<>();
		Socio socio1 = new Socio("Carolina", 22, "Boca Jrs", EstadoCivil.SOLTERO, NivelDeEstudios.SECUNDARIO);
		Socio socio2 = new Socio("Matias", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio3 = new Socio("Franco", 29, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio4 = new Socio("Leonel", 25, "Racing", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio5 = new Socio("Maria", 78, "Racing", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio6 = new Socio("Blas", 42, "Racing", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		socios.add(socio1);
		socios.add(socio2);
		socios.add(socio3);
		socios.add(socio4);
		socios.add(socio5);
		socios.add(socio6);

		Map<String, Integer> menorEdadPorEquipos = new HashMap<>();
		menorEdadPorEquipos.put("Boca Jrs", 22);
		menorEdadPorEquipos.put("River", 29);
		menorEdadPorEquipos.put("Racing", 25);

		assertEquals(ChallengeRecursiva.menorEdadPorEquipo(socios), menorEdadPorEquipos);
	}

	@Test
	public void mayorEdadPorEquiposTest() {
		List<Socio> socios = new ArrayList<>();
		Socio socio1 = new Socio("Carolina", 22, "Boca Jrs", EstadoCivil.SOLTERO, NivelDeEstudios.SECUNDARIO);
		Socio socio2 = new Socio("Matias", 35, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio3 = new Socio("Franco", 29, "River", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio4 = new Socio("Leonel", 25, "Racing", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio5 = new Socio("Maria", 78, "Racing", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		Socio socio6 = new Socio("Blas", 42, "Racing", EstadoCivil.CASADO, NivelDeEstudios.UNIVERSITARIO);
		socios.add(socio1);
		socios.add(socio2);
		socios.add(socio3);
		socios.add(socio4);
		socios.add(socio5);
		socios.add(socio6);

		Map<String, Integer> mayorEdadPorEquipos = new HashMap<>();
		mayorEdadPorEquipos.put("Boca Jrs", 22);
		mayorEdadPorEquipos.put("River", 35);
		mayorEdadPorEquipos.put("Racing", 78);

		assertEquals(ChallengeRecursiva.mayorEdadPorEquipo(socios), mayorEdadPorEquipos);
	}

}
