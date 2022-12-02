package com.unlam.taller;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import com.unlam.taller.cliente.Cliente;
import com.unlam.taller.exceptions.SinClientesException;

public class TallerMecanico {

	private String nombre;
	private Set<Cliente> clientesEnListaDeEspera;
	private Set<Cliente> clientesAtendidos;

	public TallerMecanico(String nombreDelTaller) {
		this.setNombre(nombreDelTaller);
		clientesEnListaDeEspera = new LinkedHashSet<Cliente>();
		clientesAtendidos = new LinkedHashSet<Cliente>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarCliente(Cliente cliente) {
		clientesEnListaDeEspera.add(cliente);
		
	}

	public Set<Cliente> getClientesEnListaDeEspera() {
		return clientesEnListaDeEspera;
	}

	public Cliente atenderCliente() throws SinClientesException{
		if(clientesEnListaDeEspera.isEmpty())
			throw new SinClientesException("No hay clientes para atender.");
		
		LinkedList<Cliente> clientesEnEspera = new LinkedList<Cliente>(clientesEnListaDeEspera);
		Cliente atendido = clientesEnEspera.getFirst();
		clientesEnListaDeEspera.remove(atendido);
		atendido.setFechaYHoraDeAtencion(LocalDateTime.now());
		clientesAtendidos.add(atendido);
		return atendido;
	}

	public Set<Cliente> getClientesAtendidos() {
		return clientesAtendidos;
	}

	public Double calcularTiempoMedioDeLaListaDeEsperaEnMinutos() {
		Integer sumaHoras = 0;
		for(Cliente actual: getClientesEnListaDeEspera()) {
			sumaHoras += actual.getFechaYHoraDeIngreso().getMinute() - LocalDateTime.now().getMinute();
		}
		return (double) (sumaHoras / getClientesEnListaDeEspera().size());
	}
	
	public Double calcularTiempoMedioDeLaListaDeClientesAtendidosEnMinutos() {
		Integer sumaHoras = 0;
		for(Cliente actual: getClientesAtendidos()) {
			sumaHoras += actual.getFechaYHoraDeAtencion().getMinute() - LocalDateTime.now().getMinute();
		}
		return (double) (sumaHoras / getClientesAtendidos().size());
	}
	
	
	
	
}
