package precios_irrisorios_test;
import precios_irrisorios.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PreciosTest {

	LectorCsv lector;
	Programa programa;
	@Before
	public void inicializarProgramaYLector() {
		programa = new Programa();
		lector = new LectorCsv();
	}

	@Test
	public void leerArchivoTest() {
		assertTrue(lector.leerArchivo("precios_irrisorios_input.csv"));
	}
	
	@Test
	public void llenarListaTest() {
		lector.leerArchivo("precios_irrisorios_input.csv");
		assertTrue(!lector.getArrayProductos().isEmpty());
	}
	
	@Test
	public void ordenarListaAscendentementeTest() {
		lector.leerArchivo("precios_irrisorios_input.csv");
		programa.setListaProductos(lector.getArrayProductos());
		assertEquals(2306, programa.productosOrdenadosAscendentemente().get(0).getId());
	}
	
	@Test
	public void productoPrecioMasBajoTest() {
		lector.leerArchivo("precios_irrisorios_input.csv");
		programa.setListaProductos(lector.getArrayProductos());
		programa.productosOrdenadosAscendentemente();
		ArrayList<Producto> listaProductoPrecioMasBajo = programa.productoPrecioMasBajo("Pendrive KNGS");
		assertEquals(23741 , listaProductoPrecioMasBajo.get(0).getId());
	}
}
