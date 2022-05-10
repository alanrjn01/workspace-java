package precios_irrisorios;

public class Main {

	public static void main(String[] args) {
		LectorCsv l1 = new LectorCsv();
		l1.leerArchivo("precios_irrisorios_input.csv");
		Programa p1 = new Programa();
		p1.setListaDeProductos(l1.getArrayProductos());
		p1.listadoOrdenadoAscendente();
		p1.traerPrecioMasBajo("Pendrive KNGS");
		p1.traerProductoPrecioMasAlto("Mouse Logitech");
		p1.productosMejorPrecioSegunComercio("Cetrogar");
		p1.precioPromedioProductoPromocionNoPromocion();
	}

}
