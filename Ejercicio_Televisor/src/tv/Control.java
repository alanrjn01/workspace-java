package tv;

public class Control {
	
	private boolean btnPower=false;
	private boolean btnDisplay;
	private boolean btnInput;
	private boolean btnPrev;
	private boolean btnMute;
	
	
	
	public Control() {
	}
	
	
	public boolean isBtnpower() {
		return btnPower;
	}
	
	//este set lo que hace es almacenar en la propiedad btnPower
	//un valor booleano que se invierte a partir del estado actual
	//del boton
	public void setBtnpower() {
		this.btnPower=(this.btnPower)?false:true;
	}
	public boolean isBtndisplay() {
		return btnDisplay;
	}
	public void setBtndisplay(boolean btndisplay) {
		this.btnDisplay = btndisplay;
	}
	public boolean isBtninput() {
		return btnInput;
	}
	public void setBtninput(boolean btninput) {
		this.btnInput = btninput;
	}
	public boolean isBtnprev() {
		return btnPrev;
	}
	public void setBtnprev(boolean btnprev) {
		this.btnPrev = btnprev;
	}
	public boolean isBtnmute() {
		return btnMute;
	}
	public void setBtnmute(boolean btnmute) {
		this.btnMute = btnmute;
	}
	
	

}
