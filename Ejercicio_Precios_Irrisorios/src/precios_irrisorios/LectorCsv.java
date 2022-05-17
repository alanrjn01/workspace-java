package precios_irrisorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class LectorCsv {
	private Scanner sc; //lector de archivo
	private String lineaProducto[]; //lector de lineas para almacenar cada linea spliteada
	private ArrayList<Producto> arrayProductos = new ArrayList<Producto>(); //arraylist que almacenar� objetos de tipo Producto
	private PrintWriter pw;
	
	public LectorCsv() {
		
	}
	
	public boolean leerArchivo(String archivo) {
		//contador para saltear las dos primeras iteraciones del while
		int contador=0;
		try {
			// instancio el scanner con el archivo recibido por par�metros
			sc = new Scanner(new File(archivo)); 
			//mientras que exista una siguiente linea en el scanner ejecuto el while
			while(sc.hasNext()) {
				// en este if leemos la linea del producto y sus datos y luego creamos un objeto con sus propiedades
				if(contador>=2) {
					//spliteo separado por coma en el array lineaProducto la linea de texto le�da 
					lineaProducto= sc.nextLine().split(",");
					//en el arraylist de productos agrego un producto instanciandolo con sus propiedades a trav�s de los elementos
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
	
	public void escribirArchivoArrayList(ArrayList<Producto> lista,String ruta) throws FileNotFoundException {
		pw = new PrintWriter(ruta + "/salida.csv");
		for (Producto producto : lista) {
			//System.out.println("" + producto.getComercio()+" "+producto.getNombre()+" "+producto.getPrecio()+" "+producto.isPromocion());
			pw.println(producto.getId()+","+producto.getNombre()+","+producto.getPrecio()+","+producto.getComercio()+","+producto.isPromocion());
		}
		pw.close();
	}
	
	public void escribirArchivoLinkedHashMap(LinkedHashMap<Boolean,LinkedHashMap<String,Double>> mapa,String ruta) throws FileNotFoundException {
		pw = new PrintWriter(ruta + "/salida.csv");
		int bandera=0;
		for (Map.Entry<Boolean,LinkedHashMap<String,Double>> entry : mapa.entrySet()) {
				if(bandera==0) {
					pw.println("Precios promedio con promocion: " + entry.getValue());
					bandera=1;
				}else {
					pw.println("Precios promedio sin promocion: " + entry.getValue());
				}
			}
		pw.close();
	}
	
	public void escribirArchivoEntero(String nombreComercio, int contador,String ruta) throws FileNotFoundException {
		pw = new PrintWriter(ruta + "/salida.csv");
		pw.println("Cantidad de productos de la empresa "+nombreComercio+": "+contador);
		pw.close();
	}

	
	public ArrayList<Producto> getArrayProductos() {
		return arrayProductos;
	}
}
