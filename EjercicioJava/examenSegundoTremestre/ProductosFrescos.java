package examenSegundoTremestre;

import java.time.LocalDate;

public class ProductosFrescos extends Productos {
	private LocalDate fechaDeEnvasado;
	private String paisDeOrigin;

	public ProductosFrescos(LocalDate fechaDeCaducidad, int numeroLote, LocalDate fechaDeEnvasado,
			String paisDeOrigin) {
		super(fechaDeCaducidad, numeroLote);
		this.fechaDeCaducidad = fechaDeCaducidad;
		this.paisDeOrigin = paisDeOrigin;

		
	}

	public LocalDate getFechaDeEnvasado() {
		return fechaDeEnvasado;
	}

	public void setFechaDeEnvasado(LocalDate fechaDeEnvasado) {
		this.fechaDeEnvasado = fechaDeEnvasado;
	}

	public String getPaisDeOrigin() {
		return paisDeOrigin;
	}

	public void setPaisDeOrigin(String paisDeOrigin) {
		this.paisDeOrigin = paisDeOrigin;
	}

	@Override
	public String toString() {
		return "ProductosFrescos ["+super.toString()+"fechaDeEnvasado=" + fechaDeEnvasado + ", paisDeOrigin=" + paisDeOrigin + "]";
	}
	

}
