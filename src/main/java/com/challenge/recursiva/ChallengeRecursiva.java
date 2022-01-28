package com.challenge.recursiva;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ChallengeRecursiva {

	public static void main(String[] args) throws Exception {
		List<Socio> socios = SocioParser.parse(args[0]);
		print("Total de personas registradas: ", String.valueOf(socios.size()));
		print("Promedio de edad de hinchas de Racing: ", calcularEdadPromedioHinchas(socios, "Racing"));
		print("Primeras 100 personas casadas, universitarias, ordenadas de menor a mayor: ",
				buildStringCienSocios(cienPersonas(socios)));
		print("Nombres más comunes entre los hinchas de River: ",
				buildStringHinchasDeRiver(nombresRepetidosPorEquipo(socios, "River")));
		print("Promedio, mayor y menor edad por equipo: ",
				buildStringEdad(promedioEdadPorEquipo(socios), menorEdadPorEquipo(socios), mayorEdadPorEquipo(socios)));
	}

	private static void print(String encabezado, String valor) {
		System.out.print("######");
		System.out.print("\n");
		System.out.print("\t" + encabezado);
		System.out.print("\n");
		System.out.print("\t\t" + valor);
		System.out.print("\n");
	}

	protected static String calcularEdadPromedioHinchas(List<Socio> socios, String equipo) {
		return DOUBLE_FORMAT.format(
				socios.stream().filter(x -> x.equipo().equals(equipo)).mapToInt(x -> x.edad()).average().orElse(0));
	}

	protected static List<Socio> cienPersonas(List<Socio> socios) {
		return socios.stream().sorted(Comparator.comparing(Socio::edad).thenComparing(Socio::nombre))
				.filter(x -> x.esCasado() && x.esUniversitario()).limit(100).collect(Collectors.toList());
	}

	private static String buildStringCienSocios(List<Socio> cienPersonas) {
		StringBuilder sb = new StringBuilder();
		for(Socio socio : cienPersonas) {
			sb.append("- ");
			sb.append(socio.nombre());
			sb.append(", ");
			sb.append(socio.edad());
			sb.append(", ");
			sb.append(socio.equipo());
			sb.append("\n\t\t");
		}
		return sb.toString();
	}

	protected static List<String> nombresRepetidosPorEquipo(List<Socio> socios, String equipo) {
		Map<String, Integer> frecuenciaDeNombres = new HashMap<>();
		for (Socio socio : socios) {
			putOrMerge(frecuenciaDeNombres, socio, equipo, 1);
		}

		Set<Entry<String, Integer>> entrySet = frecuenciaDeNombres.entrySet();
		List<Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
		Collections.sort(entryList,
				(o1, o2) -> o2.getValue().compareTo(o1.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey())
						: o2.getValue().compareTo(o1.getValue()));
		List<String> cincoNombresMasComunes = entryList.subList(0,5).stream().map(x -> x.getKey()).collect(Collectors.toList());
		return cincoNombresMasComunes;
	}

	private static void putOrMerge(Map<String, Integer> frecuenciaDeNombres, Socio socio, String equipo,
			Integer valorDefault) {
		if (socio.equipo().equals(equipo)) {
			if (frecuenciaDeNombres.containsKey(socio.nombre())) {
				frecuenciaDeNombres.put(socio.nombre(), frecuenciaDeNombres.get(socio.nombre()) + valorDefault);
			} else {
				frecuenciaDeNombres.put(socio.nombre(), valorDefault);
			}
		}
	}

	private static String buildStringHinchasDeRiver(List<String> hinchasDeRiver) {
		StringBuilder sb = new StringBuilder();
		for (String hinchaDeRiver : hinchasDeRiver) {
			sb.append("- ");
			sb.append(hinchaDeRiver);
			sb.append("\n\t\t");
		}
		return sb.toString();
	}

	protected static Map<String, String> promedioEdadPorEquipo(List<Socio> socios) {
		Map<String, String> promedioPorEquipo = new HashMap<>();
		for (Socio socio : socios) {
			if (!promedioPorEquipo.containsKey(socio.equipo())) {
				promedioPorEquipo.put(socio.equipo(), calcularEdadPromedioHinchas(socios, socio.equipo()));
			}
		}
		return promedioPorEquipo;
	}

	protected static Map<String, Integer> menorEdadPorEquipo(List<Socio> socios) {
		Map<String, Integer> menorEdadPorEquipo = new HashMap<>();
		for (Socio socio : socios) {
			if (!menorEdadPorEquipo.containsKey(socio.equipo())) {
				menorEdadPorEquipo.put(socio.equipo(), Collections.min(socios.stream().filter(x -> x.equipo().equals(socio.equipo())).map(x -> x.edad()).collect(Collectors.toList())));
			}
		}
		return menorEdadPorEquipo;
	}

	protected static Map<String, Integer> mayorEdadPorEquipo(List<Socio> socios) {
		Map<String, Integer> mayorEdadPorEquipo = new HashMap<>();
		for (Socio socio : socios) {
			if (!mayorEdadPorEquipo.containsKey(socio.equipo())) {
				mayorEdadPorEquipo.put(socio.equipo(), Collections.max(socios.stream().filter(x -> x.equipo().equals(socio.equipo())).map(x -> x.edad()).collect(Collectors.toList())));
			}
		}
		return mayorEdadPorEquipo;
	}

	private static String buildStringEdad(Map<String, String> promedioPorEquipo, Map<String, Integer> menorEdadEquipo,
			Map<String, Integer> mayorEdadEquipo) {
		StringBuilder sb = new StringBuilder();
		sb.append("Promedio por equipo: \n\t\t");
		for (Entry<String, String> entryPromedio : promedioPorEquipo.entrySet()) {
			sb.append("- ");
			sb.append(entryPromedio.getKey());
			sb.append(" -> promedio: ");
			sb.append(entryPromedio.getValue());
			sb.append(", menor edad: ");
			sb.append(menorEdadEquipo.get(String.valueOf(entryPromedio.getKey())));
			sb.append(", mayor edad: ");
			sb.append(mayorEdadEquipo.get(String.valueOf(entryPromedio.getKey())));
			sb.append("\n\t\t");
		}

		return sb.toString();
	}

	private static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("#.##");

}
