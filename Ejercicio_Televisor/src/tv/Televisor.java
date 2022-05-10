package tv;

public class Televisor extends Plaqueta {
	private Plaqueta plaqueta;
	private int canalMaximoTelevisionAire;
	private int canalMaximoTelevisionPorCable;
	
	public Televisor() {
		
	}
	
	public Televisor(int canalMaximoTelevisionAire, int canalMaximoTelevisionPorCable) {
		this.canalMaximoTelevisionAire = canalMaximoTelevisionAire;
		this.canalMaximoTelevisionPorCable = canalMaximoTelevisionPorCable;
	}
	
	public void asignarPlaqueta(Plaqueta p) {
		this.plaqueta=p;
	}

	public void setCanalMaximoTelevisionAire(int canalMaximoTelevisionAire) {
		this.canalMaximoTelevisionAire = canalMaximoTelevisionAire;
	}

	public void setCanalMaximoTelevisionPorCable(int canalMaximoTelevisionPorCable) {
		this.canalMaximoTelevisionPorCable = canalMaximoTelevisionPorCable;
	}

	public int getCanalMaximoTelevisionAire() {
		return canalMaximoTelevisionAire;
	}

	public int getCanalMaximoTelevisionPorCable() {
		return canalMaximoTelevisionPorCable;
	}

	public Plaqueta getPlaqueta() {
		return plaqueta;
	}
	
	
	
	
	

}
