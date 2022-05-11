package precios_irrisorios;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class LectorCsv {
	private Scanner sc; //lector de archivo
	private String lineaProducto[]; //lector de lineas para almacenar cada linea spliteada
	private ArrayList<Producto> arrayProductos = new ArrayList<Producto>(); //arraylist que almacenará objetos de tipo Producto
	
	public LectorCsv() {
		
	}
	
	public boolean leerArchivo(String archivo) {
		//contador para saltear las dos primeras iteraciones del while
		int contador=0;
		try {
			// instancio el scanner con el archivo recibido por parámetros
			sc = new Scanner(new File(archivo)); 
			//mientras que exista una siguiente linea en el scanner ejecuto el while
			while(sc.hasNext()) {
				// en este if leemos la linea del producto y sus datos y luego creamos un objeto con sus propiedades
				if(contador>=2) {
					//spliteo separado por coma en el array lineaProducto la linea de texto leída 
					lineaProducto= sc.nextLine().split(",");
					//en el arraylist de productos agrego un producto instanciandolo con sus propiedades a través de los elementos
					//del array lineaProducto
					arrayProductos.add(new Producto(Long.parseLong(lineaProducto[0]),lineaProducto[1],Double.parseDouble(lineaProducto[2]),lineaProducto[3],(lineaProducto[4].equals("Si"))?true:false));
				}
				//este else se ejecuta las dos primeras veces y omite los encabezados
				else {
					sc.nextLine();
				}
				contador++;
			}
			sc.close();
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
		return true;
	}

	
	public ArrayList<Producto> getArrayProductos() {
		return arrayProductos;
	}
}
