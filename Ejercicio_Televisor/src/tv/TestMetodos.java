package tv;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMetodos {
	
	@Test
	public void crearTelevisorTest() {
		Televisor tv1 = new Televisor();
		assertNotNull(tv1);
	}
	
	@Test
	public void crearTelevisorConCanalesTest() {
		Televisor tv1 = new Televisor(50,12550);
		assertNotNull(tv1);
	}
	
	@Test
	public void encenderOApagarTest() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		assertTrue(tv1.isEncendido());
	}
	
	@Test
	public void toStringTest() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		assertNotNull(tv1.toString());
		
	}
	
	@Test
	public void seleccionarEntradaTest() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		tv1.seleccionarEntrada("C");
		assertEquals(Entrada.TELEVISION_CABLE, tv1.getEntradaActual());
		
	}
	
	@Test
	public void subirOBajarAnalogicamenteTest() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		tv1.sintonizar(tv1.getCanalMaximoTelevisionAire(), tv1.getCanalMaximoTelevisionPorCable());
		tv1.seleccionarEntrada("A");
		tv1.subirOBajarAnalogicamente(">");
		tv1.subirOBajarAnalogicamente(">");
		tv1.subirOBajarAnalogicamente(">");
		assertEquals(4, tv1.getCanalActual());
		tv1.subirOBajarAnalogicamente("<");
		tv1.subirOBajarAnalogicamente("<");
		assertEquals(2, tv1.getCanalActual());
		tv1.subirOBajarAnalogicamente("+");
		tv1.subirOBajarAnalogicamente("+");
		tv1.subirOBajarAnalogicamente("+");
		assertEquals(3, tv1.getVolumenActual());
		tv1.subirOBajarAnalogicamente("-");
		assertEquals(2, tv1.getVolumenActual());
	}
	
	@Test
	public void cambiarDeCanalTest() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		tv1.seleccionarEntrada("C");
		tv1.sintonizar(tv1.getCanalMaximoTelevisionAire(), tv1.getCanalMaximoTelevisionPorCable());
		tv1.cambiarDeCanal(8);
		assertEquals(8, tv1.getCanalActual());
		tv1.cambiarDeCanal(7,5);
		assertEquals(75, tv1.getCanalActual());
		tv1.cambiarDeCanal(2,6,3);
		assertEquals(263, tv1.getCanalActual());
		tv1.cambiarDeCanal(3,5,0,4);
		assertEquals(3504, tv1.getCanalActual());
	}
	
	@Test
	public void volverAlCanalAnterior() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		tv1.seleccionarEntrada("C");
		tv1.sintonizar(tv1.getCanalMaximoTelevisionAire(), tv1.getCanalMaximoTelevisionPorCable());
		tv1.cambiarDeCanal(4,5,5);
		tv1.cambiarDeCanal(4,7,5,4);
		tv1.volverAlCanalAnterior();
		assertEquals(455, tv1.getCanalActual());
	}
	
	@Test
	public void silenciarTest() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		tv1.seleccionarEntrada("C");
		tv1.sintonizar(tv1.getCanalMaximoTelevisionAire(), tv1.getCanalMaximoTelevisionPorCable());
		tv1.cambiarDeCanal(4,5,5);
		tv1.subirOBajarAnalogicamente("+");
		tv1.subirOBajarAnalogicamente("+");
		tv1.subirOBajarAnalogicamente("+");
		tv1.subirOBajarAnalogicamente("+");
		tv1.subirOBajarAnalogicamente("+");
		tv1.silenciar();
		assertEquals(0, tv1.getVolumenActual());
	}
	
	@Test
	public void getNumeroDeSerie() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		assertNotNull(tv1.getNumeroDeSerie());
	}
	
	@Test
	public void isEncendidoTest() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		assertTrue(tv1.isEncendido());
	}
	
	@Test
	public void getVolumenActualTest() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		tv1.seleccionarEntrada("A");
		tv1.subirOBajarAnalogicamente("+");
		tv1.subirOBajarAnalogicamente("+");
		tv1.subirOBajarAnalogicamente("+");
		tv1.subirOBajarAnalogicamente("+");
		assertEquals(4, tv1.getVolumenActual());
	}
	
	@Test
	public void getCanalActualTest() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		tv1.sintonizar(tv1.getCanalMaximoTelevisionAire(), tv1.getCanalMaximoTelevisionPorCable());
		tv1.seleccionarEntrada("A");
		tv1.cambiarDeCanal(27);
		assertEquals(27, tv1.getCanalActual());
	}
	
	@Test
	public void getEntradaActual() {
		Televisor tv1 = new Televisor(50,12550);
		Plaqueta p1 = new Plaqueta();
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		tv1.seleccionarEntrada("U");
		assertEquals(Entrada.USB, tv1.getEntradaActual());
	}
	
	
	
	

}
