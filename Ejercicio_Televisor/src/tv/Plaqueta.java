package tv;

import java.util.UUID;

public class Plaqueta {
	
	//id:
	private String id=null;
	//estados:
	private boolean estado=false;
	private int volumen;
	private int canal=1;
	private Entrada entradaActiva;
	private int canalAnterior;
	public int canalMaximoAire;
	public int canalMaximoCable;
	
	//Cada plaqueta que se crea se inicializa por defecto con un id único proporcionado por UUID
	public Plaqueta() {
		this.id= generarId();
	}
	
	//Uso la clase UUID para crear un identificador único para las plaquetas
	public String generarId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	//recibe un valor booleano que representa el botón del control
	//si llega en true la plaqueta se pasa al estado true (prendido)
	//si llega en false el estado pasa a false (apagado)
	public void encenderOApagar() {
		this.estado=(this.estado)?false:true;
	}
	
	//simulo una sintonización para conocer el canal maximo de aire y de cable
	//y asi utilizarlo como valores maximos al momento de cambiar de canal
	public void sintonizar(int maximoCanalAire, int maximoCanalCable) {
		if(this.estado)
			this.canalMaximoAire= maximoCanalAire;
			this.canalMaximoCable= maximoCanalCable;
	}
	
	
	@Override
	public String toString() {
		if(this.estado)
			return "Estado: " + this.estado + "\n Volumen: " + this.volumen + "\n Canal: " + this.canal + "\n Entrada activa " + this.entradaActiva;
		return null;
	}
	
	//recibo un string que indica la entrada a la cual cambiar dentro de la plaqueta
	public void seleccionarEntrada(String valor) {
		if(this.estado)
			if(valor.equals("A")) {
				this.entradaActiva=Entrada.TELEVISION_AIRE;
			}
			else if(valor.equals("C")) {
				this.entradaActiva=Entrada.TELEVISION_CABLE;
			}
			else if(valor.equals("1")) {
				this.entradaActiva=Entrada.HDMI1;
			}
			else if(valor.equals("2")) {
				this.entradaActiva=Entrada.HDMI2;
			}
			else if(valor.equals("U")) {
				this.entradaActiva=Entrada.USB;
			}
			else {
				System.err.println("valor incorrecto");
			}
	}

	//recibe el comando a ejecutar por parámetro y realiza
	//la acción correspondiente a partir de los if
	public void subirOBajarAnalogicamente(String valor) {
		if(this.estado)
			if(this.entradaActiva==Entrada.TELEVISION_AIRE || this.entradaActiva==Entrada.TELEVISION_CABLE) {
				if(valor.equals("+")) {
					this.volumen=(this.volumen>=0 && this.volumen<100)?this.volumen+1:this.volumen;
				}
				else if(valor.equals("-")) {
					this.volumen=(this.volumen>=0 && this.volumen<100)?this.volumen-1:this.volumen;
				}
				else if(valor.equals(">")) {
					this.canalAnterior = this.canal;
					if(this.entradaActiva==Entrada.TELEVISION_AIRE)
						this.canal=(this.canal>=1 && this.canal<this.canalMaximoAire+1)?this.canal+1:this.canal;
					if(this.entradaActiva==Entrada.TELEVISION_CABLE)
						this.canal=(this.canal>=1 && this.canal<this.canalMaximoCable+1)?this.canal+1:this.canal;
				}
				else if(valor.equals("<")) {
					this.canalAnterior = this.canal;
					if(this.entradaActiva==Entrada.TELEVISION_AIRE)
						this.canal=(this.canal>=1 && this.canal<this.canalMaximoAire+1)?this.canal-1:this.canal;
					if(this.entradaActiva==Entrada.TELEVISION_CABLE)
						this.canal=(this.canal>=1 && this.canal<this.canalMaximoCable+1)?this.canal-1:this.canal;
				}
			}
			else {
				System.err.println("valor incorrecto pete");
			}
	}
	
	//recibe por parametro una cantidad x de valores enteros
	//posteriormente se juntan para formar el número
	//se parsea y setea el valor final en volumen
	public void cambiarDeCanal(int ...cambioCanal) {
		if(this.estado)
			if(this.entradaActiva==Entrada.TELEVISION_AIRE || this.entradaActiva==Entrada.TELEVISION_CABLE) {
				this.canalAnterior = this.canal;
				String canalIngresado = "";
				for (int i = 0; i < cambioCanal.length; i++) {
					canalIngresado+= cambioCanal[i];
				}
				if(this.entradaActiva==Entrada.TELEVISION_AIRE)
					this.canal=(Integer.parseInt(canalIngresado)>=0 && Integer.parseInt(canalIngresado)<=this.canalMaximoAire)?Integer.parseInt(canalIngresado):this.canal;
				if(this.entradaActiva==Entrada.TELEVISION_CABLE)
					this.canal=(Integer.parseInt(canalIngresado)>=0 && Integer.parseInt(canalIngresado)<this.canalMaximoCable)?Integer.parseInt(canalIngresado):this.canal;
			}
		
	}
	
	//almacena en el canal activo el valor cargado en canal anterior
	public void volverAlCanalAnterior() {
		if(this.estado)
			this.canal=this.canalAnterior;
	}
	
	//establezco el volumen en 0
	public void silenciar() {
		if(this.estado)
			this.volumen=0;
	}
	
	//
	//getters obligatorios de la consigna
	//
	
	public String getNumeroDeSerie() {
			return id;
	}

	public boolean isEncendido() {
		return estado;
	}

	public int getVolumenActual() {
		return volumen;
	}

	public int getCanalActual() {
		return canal;
	}

	public Entrada getEntradaActual() {
		return entradaActiva;
	}
	
	

}
