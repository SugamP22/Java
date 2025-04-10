package eje02;

public class Pago {
	// declarando un variable instante
	private boolean pago;// guarda el condicion de pago esta Pagado "si" o "no"

//un constructor para Clase donde inicializo pago como falso

	public Pago() {

		this.pago = false;
	}

//un getter para pago para puede llamar por otro clase
	public boolean isPago() {
		return pago;
	}

//un setter para que puede cambiarlo
	public void setPago(boolean pago) {
		this.pago = pago;
	}

//para mostrar informacion de los datos que tengo en esta clae 	
	@Override
	public String toString() {
		return "Pago [pago=" + pago + "]";
	}

}
