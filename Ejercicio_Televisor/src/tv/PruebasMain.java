package tv;

public class PruebasMain {

	public static void main(String[] args) {
		Plaqueta p1 = new Plaqueta();
		Televisor tv1 = new Televisor(20,100);
		tv1.asignarPlaqueta(p1);
		tv1.encenderOApagar();
		tv1.sintonizar(tv1.getCanalMaximoTelevisionAire(), tv1.getCanalMaximoTelevisionPorCable());
		tv1.seleccionarEntrada("1");
		tv1.seleccionarEntrada("A");
		tv1.cambiarDeCanal(1,3);
		tv1.subirOBajarAnalogicamente("-");
		System.out.println(tv1.toString());
		
	}

}
