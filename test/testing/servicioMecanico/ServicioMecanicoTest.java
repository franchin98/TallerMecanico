package testing.servicioMecanico;

import static org.junit.Assert.*;

import org.junit.Test;

import com.unlam.taller.TallerMecanico;
import com.unlam.taller.cliente.Cliente;
import com.unlam.taller.exceptions.SinClientesException;

public class ServicioMecanicoTest {

	@Test
	public void quePuedaAgregarUnCliente() {
		TallerMecanico loDePepe = dadoQueExisteElTallerMecanico();
		cuandoAgregoClientesEnElTaller(loDePepe);
		entoncesExisteClientesEnEsperaEnElTaller(loDePepe);
	}
	
	@Test
	public void quePuedaAtenderUnCliente() throws SinClientesException {
		TallerMecanico loDePepe = dadoQueExisteElTallerMecanico();
		cuandoAgregoClientesEnElTaller(loDePepe);
		entoncesPuedenAtenderClientesDelTaller(loDePepe);
	}
	
	@Test (expected = SinClientesException.class)
	public void queNoPuedaAtenderClientesSiNoHayClientesEnEspera() throws SinClientesException {
		TallerMecanico loDePepe = dadoQueExisteElTallerMecanico();
		loDePepe.atenderCliente();
	}
	
	@Test
	public void quePuedaCalcularElTiempoMedioDeEspera() {
		TallerMecanico loDePepe = dadoQueExisteElTallerMecanico();
		cuandoAgregoClientesEnElTaller(loDePepe);
		entoncesPuedoCalcularElTiempoMedioEnMinutos(loDePepe);
	}
	
	@Test
	public void quePuedaCalcularElTiempoDeEsperaDeClientesAtendidos() throws SinClientesException {
		TallerMecanico loDePepe = dadoQueExisteElTallerMecanico();
		cuandoAgregoClientesEnElTaller(loDePepe);
		entoncesPuedenAtenderClientesDelTaller(loDePepe);
		entoncesPuedoCalcularElTiempoDeEsperaDeLosClientesAtendidos(loDePepe);
	}
	
	@Test
	public void quePuedaConsultarLaCantidadDeClientesEnEspera() {
		TallerMecanico loDePepe = dadoQueExisteElTallerMecanico();
		cuandoAgregoClientesEnElTaller(loDePepe);
		entoncesLaCantidadDeClientesEnEsperaEs(6, loDePepe);
	}
	
	@Test
	public void quePuedaConsultarLaCantidadDeClientesAtendidos() throws SinClientesException {
		TallerMecanico loDePepe = dadoQueExisteElTallerMecanico();
		cuandoAgregoClientesEnElTaller(loDePepe);
		entoncesPuedenAtenderClientesDelTaller(loDePepe);
		entoncesPuedenAtenderClientesDelTaller(loDePepe);
		entoncesLaCantidadDeClientesEnEsperaEs(4, loDePepe);
		entoncesLaCantidadDeClientesAtendidosEs(2, loDePepe);
	}

	private void entoncesLaCantidadDeClientesAtendidosEs(Integer cantidadEsperada, TallerMecanico taller) {
		assertEquals(cantidadEsperada, Integer.valueOf(taller.getClientesAtendidos().size()));
		
	}

	private void entoncesLaCantidadDeClientesEnEsperaEs(Integer cantidadEsperada, TallerMecanico taller) {
		assertEquals(cantidadEsperada, Integer.valueOf(taller.getClientesEnListaDeEspera().size()));
	}

	private void entoncesPuedoCalcularElTiempoDeEsperaDeLosClientesAtendidos(TallerMecanico taller) {
		assertEquals(Double.valueOf(0.0), taller.calcularTiempoMedioDeLaListaDeClientesAtendidosEnMinutos());
		
	}

	private void entoncesPuedoCalcularElTiempoMedioEnMinutos(TallerMecanico loDePepe) {
		assertEquals((Double)0.0 , loDePepe.calcularTiempoMedioDeLaListaDeEsperaEnMinutos());
	}

	private void entoncesPuedenAtenderClientesDelTaller(TallerMecanico taller) throws SinClientesException {
		assertNotNull(taller.atenderCliente()); // se espera que se atienda al primero
		
	}

	private void entoncesExisteClientesEnEsperaEnElTaller(TallerMecanico taller) {
		assertTrue(taller.getClientesEnListaDeEspera().size() > 0);
		
	}

	private void cuandoAgregoClientesEnElTaller(TallerMecanico loDePepe) {
		loDePepe.agregarCliente(new Cliente("Jose", 1));
		loDePepe.agregarCliente(new Cliente("marcos", 2));
		loDePepe.agregarCliente(new Cliente("miguel", 3));
		loDePepe.agregarCliente(new Cliente("francisco", 4));
		loDePepe.agregarCliente(new Cliente("martin", 5));
		loDePepe.agregarCliente(new Cliente("carlos", 6));
	}

	private TallerMecanico dadoQueExisteElTallerMecanico() {
		return new TallerMecanico("Lo de pepe");
	}
	
	
	
}
