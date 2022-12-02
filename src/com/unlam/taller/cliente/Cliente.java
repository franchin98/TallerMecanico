package com.unlam.taller.cliente;

import java.time.LocalDateTime;
import java.util.Objects;

public class Cliente {
	private String nombre;
	private Integer numeroDeMovil;
	private LocalDateTime fechaYHoraDeIngreso;
	private LocalDateTime fechaYHoraDeAtencion;
	
	public Cliente(String nombre, Integer numeroDeMovil) {
		this.nombre = nombre;
		this.numeroDeMovil = numeroDeMovil;
		fechaYHoraDeIngreso = LocalDateTime.now();
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNumeroDeMovil() {
		return numeroDeMovil;
	}

	public LocalDateTime getFechaYHoraDeIngreso() {
		return fechaYHoraDeIngreso;
	}

	public LocalDateTime getFechaYHoraDeAtencion() {
		return fechaYHoraDeAtencion;
	}

	public void setFechaYHoraDeAtencion(LocalDateTime fechaYHoraDeAtencion) {
		this.fechaYHoraDeAtencion = fechaYHoraDeAtencion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, numeroDeMovil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(numeroDeMovil, other.numeroDeMovil);
	}
	
	
	
	
	
}
