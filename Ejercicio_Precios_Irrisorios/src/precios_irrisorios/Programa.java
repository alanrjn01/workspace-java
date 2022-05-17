package precios_irrisorios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Programa {

	ArrayList<Producto> listaProductos;
	ArrayList<Producto> listaProductosOrdenadaAscendente;

	public Programa() {
	}
	
	//Ordeno ascendentemente la lista de productos cargada en el programa y la almaceno en una propiedad del programa
	public ArrayList<Producto> productosOrdenadosAscendentemente(){
		ArrayList<Producto> listaDeProductosAscendentemente = this.listaProductos;
		Collections.sort(listaDeProductosAscendentemente);
		this.listaProductosOrdenadaAscendente=listaDeProductosAscendentemente;
		return listaDeProductosAscendentemente;
	}
	
	//a partir del nombre de un producto ingresado por par�metro obtengo un arraylist con el producto
	//o mas de un producto si es que distintas empresas poseen dicho producto al mismo precio bajo
	public ArrayList<Producto> productoPrecioMasBajo(String nombreProducto) {
		ArrayList<Producto> productoPrecioMasBajo = new ArrayList<Producto>();
		int bandera=0;
		for (Producto producto : this.listaProductosOrdenadaAscendente) {
			if(nombreProducto.equals(producto.getNombre()) && bandera==0) {
				productoPrecioMasBajo.add(producto);
				bandera=1;
			}
			else if (nombreProducto.equals(producto.getNombre()) && productoPrecioMasBajo.get(0).getPrecio()==producto.getPrecio())
				productoPrecioMasBajo.add(producto);
		}
		return productoPrecioMasBajo;
	}
	
	//dado el nombre de un producto busco el precio m�s alto con promoci�n y sin promoci�n
	//la lista al estar ordenada descendentemente el primero que se encuentra es evidentemente el de mayor precio, para agregarlo
	//utilizo una bandera y ya las dem�s comprobaciones se realizan por si existe otro producto con el mismo precio pero de otra empresa
	//el segundo for realiza lo mismo pero buscando el precio mas alto sin promocion
	public ArrayList<Producto> productoPrecioMasAltoConPromocionYSinPromocion(String nombreProducto){
		ArrayList<Producto> productosConPromocionYSinPromocion = new ArrayList<Producto>();
		ArrayList<Producto> listaDeProductosDescendentemente = new ArrayList<Producto>(this.listaProductosOrdenadaAscendente);
		Collections.reverse(listaDeProductosDescendentemente);
		int bandera=0;
		for (Producto producto : this.listaProductosOrdenadaAscendente) {
			if(nombreProducto.equals(producto.getNombre()) && bandera==0 && producto.isPromocion()) {
				productosConPromocionYSinPromocion.add(producto);
				bandera=1;
			}
			if(bandera==0)
				continue;
			else if (nombreProducto.equals(producto.getNombre()) && productosConPromocionYSinPromocion.get(0).getPrecio()==producto.getPrecio() && producto.isPromocion() && !productosConPromocionYSinPromocion.get(0).getComercio().equals(producto.getComercio()) )
				productosConPromocionYSinPromocion.add(producto);
		}
		bandera=0;
		for (Producto producto : this.listaProductosOrdenadaAscendente) {
			if(nombreProducto.equals(producto.getNombre()) && bandera==0 && !producto.isPromocion()) {
				productosConPromocionYSinPromocion.add(producto);
				bandera=1;
			}
			if(bandera==0)
				continue;
			else if (nombreProducto.equals(producto.getNombre()) && productosConPromocionYSinPromocion.get(productosConPromocionYSinPromocion.size()-1).getPrecio()==producto.getPrecio() && !producto.isPromocion() && !productosConPromocionYSinPromocion.get(productosConPromocionYSinPromocion.size()-1).getComercio().equals(producto.getComercio()) )
				productosConPromocionYSinPromocion.add(producto);
		}
		bandera=0;
		return productosConPromocionYSinPromocion;
	}
	
	//System.out.println("Variable I:" + this.listaProductosOrdenadaAscendente.get(i).getComercio()+" "+this.listaProductosOrdenadaAscendente.get(i).getNombre()+" "+this.listaProductosOrdenadaAscendente.get(i).getPrecio()+" "+this.listaProductosOrdenadaAscendente.get(i).isPromocion());
	//M�todo 4
	//recorro la lista de productos ordenada de manera ascendente (menor a mayor).
	//luego entro en el condicional if que comprueba si el nombre del comercio de la posici�n que estoy iterando de la lista de productos
	//es igual al que se ingresa por par�metro.
	//creo otro for para iterar sobre la lista de productos y asi comparar el elemento de la primera iteraci�n con el de la segunda iteraci�n.
	//el siguiente if hace compara que los elementos concuerden con los par�metros que busco:
	//(nombres iguales, que el elemento "i" tenga precio menor a "j" y que sean de empresas distintas).
	//Utilizo una bandera la cual en la primera vez agrega un elemento a la lista de productosConMejorPrecio:
	//(esto funciona porque la lista esta ordenada de menor a mayor, por lo cual el primer elemento que encuentre y
	//haya pasado las validaciones anteriores, siempre ser� el de mejor precio por producto de la empresa en cuesti�n)
	//en el else if (que se ejecutar� luego de la primera vez) compruebo que el elemento que haya pasado las validaciones no tenga el mismo nombre que el �ltimo
	//agregado en la lista de productosConMejorPrecio para evitar repetir productos
	public ArrayList<Producto> productosEnComerciosConMejorPrecio(String nombreComercio){
		ArrayList<Producto> productosConMejorPrecioPorEmpresa = new ArrayList<Producto>();
		Collections.sort(this.listaProductosOrdenadaAscendente);
		int bandera=0;
		for (int i = 0; i < this.listaProductosOrdenadaAscendente.size(); i++) {
			if(this.listaProductosOrdenadaAscendente.get(i).getComercio().equals(nombreComercio)) {
				for (int j = 0; j < this.listaProductosOrdenadaAscendente.size(); j++) {
					if(this.listaProductosOrdenadaAscendente.get(i).getNombre().equals(listaProductosOrdenadaAscendente.get(j).getNombre()) && this.listaProductosOrdenadaAscendente.get(i).getPrecio()<=this.listaProductosOrdenadaAscendente.get(j).getPrecio() && !this.listaProductosOrdenadaAscendente.get(i).getComercio().equals(listaProductosOrdenadaAscendente.get(j).getComercio())) {
						if(bandera==0) {
							productosConMejorPrecioPorEmpresa.add(this.listaProductosOrdenadaAscendente.get(i));
							bandera=1;
						}
						else if(!productosConMejorPrecioPorEmpresa.get(productosConMejorPrecioPorEmpresa.size()-1).getNombre().equals(this.listaProductosOrdenadaAscendente.get(i).getNombre())) {
							productosConMejorPrecioPorEmpresa.add(this.listaProductosOrdenadaAscendente.get(i));
						}
					}
				}
			}
		}
		return productosConMejorPrecioPorEmpresa;	
	}
	
	//retorno un linkedhashmap con estados booleanos como key (indica si est� en promoci�n o no)
	//y valores con un linkedhashmap que posee como clave el nombre de producto y como valor el precio promedio para dicho producto
	//con el primer for agrego en el map precios promedio con promoci�n por cada producto y en el segundo los que no tengan promocion
	public LinkedHashMap<Boolean,LinkedHashMap<String,Double>> precioPromedioParaCadaProducto(){
		LinkedHashMap<String,Double> mapaConPreciosPromedioPromocion = new LinkedHashMap<String,Double>();
		LinkedHashMap<String,Double> mapaConPreciosPromedioSinPromocion = new LinkedHashMap<String,Double>();
		LinkedHashMap<Boolean,LinkedHashMap<String,Double>> mapas = new LinkedHashMap<Boolean,LinkedHashMap<String,Double>>();
		for (int i = 0; i < this.listaProductosOrdenadaAscendente.size(); i++) {
			if(this.listaProductosOrdenadaAscendente.get(i).isPromocion())
				mapaConPreciosPromedioPromocion.put(this.listaProductosOrdenadaAscendente.get(i).getNombre(), this.getPrecioPromedioPromocion(this.listaProductosOrdenadaAscendente.get(i).getNombre()));
		}
		for (int i = 0; i < this.listaProductosOrdenadaAscendente.size(); i++) {
			if(!this.listaProductosOrdenadaAscendente.get(i).isPromocion())
				mapaConPreciosPromedioSinPromocion.put(this.listaProductosOrdenadaAscendente.get(i).getNombre(), this.getPrecioPromedioSinPromocion(this.listaProductosOrdenadaAscendente.get(i).getNombre()));
		}
		mapas.put(true,mapaConPreciosPromedioPromocion);
		mapas.put(false,mapaConPreciosPromedioSinPromocion);
		return mapas;
	}
	
	
	//Devuelve la cantidad de productos que posee un comercio
	public int devolverCantidadDeProductosDeUnComercio(String nombreComercio) {
		int contador=0;
		for (Producto producto : this.listaProductos) {
			if(producto.getComercio().equals(nombreComercio))
				contador++;
		}
		return contador;
	}
	
	//getters de precios con promoci�n y sin promoci�n
	
	public double getPrecioPromedioPromocion(String nombreProducto) {
		double almacenador=0;
		double contador=0;
		for (Producto producto : this.listaProductos) {
			if(producto.getNombre().equals(nombreProducto) && producto.isPromocion()) {
				almacenador+=producto.getPrecio();
				contador++;
			}
		}
		return Math.round((almacenador/contador)*100.0)/100.0;
	}
	
	public double getPrecioPromedioSinPromocion(String nombreProducto) {
		double almacenador=0;
		double contador=0;
		for (Producto producto : this.listaProductos) {
			if(producto.getNombre().equals(nombreProducto) && !producto.isPromocion()) {
				almacenador+=producto.getPrecio();
				contador++;
			}
		}
		return Math.round((almacenador/contador)*100.0)/100.0;
	}
	

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> arrayListCargado) {
		this.listaProductos = arrayListCargado;
	}
	
}
