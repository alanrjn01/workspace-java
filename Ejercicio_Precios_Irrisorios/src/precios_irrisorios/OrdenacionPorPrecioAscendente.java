package precios_irrisorios;

import java.util.Comparator;

//Creo una clase para manejar la ordenacion de forma ascendente a través de la interfaz Comparator

public class OrdenacionPorPrecioAscendente implements Comparator<Producto> {
	
	//soobrescribo el método compare usando el compareTo de la clase Double para ordenar los precios de mayor a menor
	@Override
	public int compare(Producto o1, Producto o2) {
		return Double.valueOf(o1.getPrecio()).compareTo(o2.getPrecio());
	}
	
}
