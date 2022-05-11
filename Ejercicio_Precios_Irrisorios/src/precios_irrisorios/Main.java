package precios_irrisorios;

public class Main {

	public static void main(String[] args) {
		LectorCsv l1 = new LectorCsv();
		l1.leerArchivo("precios_irrisorios_input.csv");
		Programa p1 = new Programa();
		p1.setListaProductos(l1.getArrayProductos());
		p1.productosOrdenadosAscendentemente();
		p1.productoPrecioMasBajo("Pendrive KNGS");
		p1.productoPrecioMasAltoConPromocionYSinPromocion("Mouse Logitech");
		p1.productosEnComerciosConMejorPrecio("Cetrogar");
		p1.precioPromedioParaCadaProducto();
		p1.devolverCantidadDeProductosDeUnComercio("Fravega");
	}

}
