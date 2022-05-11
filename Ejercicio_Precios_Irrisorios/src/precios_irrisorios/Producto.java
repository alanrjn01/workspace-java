package precios_irrisorios;

public class Producto implements Comparable<Producto> {

	private long id;
	private String nombre;
	private double precio;
	private String comercio;
	private boolean promocion;
	public Producto(long id, String nombre, double precio, String comercio, boolean promocion) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.comercio = comercio;
		this.promocion = promocion;
	}
	
	public long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public String getComercio() {
		return comercio;
	}
	public boolean isPromocion() {
		return promocion;
	}
	
	//compare to de productos:
	//los productos se van a comparar por precio
	//por defecto la salida almacena un -1 (menor)
	//si son iguales el valor de salida pasa a 0
	//si es mayor el valor de salida pasa a 1
	
	@Override
	public int compareTo(Producto o) {
		int salida = -1;
		if(this.getPrecio() == o.getPrecio())
			salida = 0;
		if(this.getPrecio() >o.getPrecio())
			salida = 1;
		return salida;
	}
	
	
	
}
