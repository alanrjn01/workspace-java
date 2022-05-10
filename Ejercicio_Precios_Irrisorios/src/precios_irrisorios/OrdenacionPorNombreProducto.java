package precios_irrisorios;

import java.util.Comparator;

//Creo una clase para manejar la ordenacion de los nombres de los productos

public class OrdenacionPorNombreProducto implements Comparator<Producto> {

	//utilizo el compareto de la clase String
	@Override
	public int compare(Producto o1, Producto o2) {
		return String.valueOf(o1.getNombre()).compareTo(o2.getNombre());
	}

}
