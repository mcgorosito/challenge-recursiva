package com.challenge.recursiva;

public class Socio {

	public Socio(String nombre, Integer edad, String equipo, EstadoCivil estadoCivil, NivelDeEstudios nivelDeEstudios) {
		this.nombre = nombre;
		this.edad = edad;
		this.equipo = equipo;
		this.estadoCivil = estadoCivil;
		this.nivelDeEstudios = nivelDeEstudios;
	}

	public String nombre() {
		return nombre;
	}

	public Integer edad() {
		return edad;
	}

	public String equipo() {
		return equipo;
	}

	public EstadoCivil estadoCivil() {
		return estadoCivil;
	}

	public NivelDeEstudios nivelDeEstudios() {
		return nivelDeEstudios;
	}

	public boolean esUniversitario() {
		return nivelDeEstudios.equals(NivelDeEstudios.UNIVERSITARIO);
	}

	public boolean esCasado() {
		return estadoCivil.equals(EstadoCivil.CASADO);
	}

	private final String nombre;
	private final Integer edad;
	private final String equipo;
	private final EstadoCivil estadoCivil;
	private final NivelDeEstudios nivelDeEstudios;
}
