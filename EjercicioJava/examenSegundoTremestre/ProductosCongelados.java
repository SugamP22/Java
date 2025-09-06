package examenSegundoTremestre;

import java.time.LocalDate;

public class ProductosCongelados extends Productos {

	private LocalDate fechaDeEnvasado;
	private String paisOrigin;
	private double temperaturaMantenimiento;
	

	public ProductosCongelados(LocalDate fechaDeCaducidad, int numeroLote, LocalDate fechaDeEnvasado, String paisOrigin,
			double temperaturaMantenimiento) {
		super(fechaDeCaducidad, numeroLote);
		this.fechaDeCaducidad = fechaDeCaducidad;
		this.paisOrigin = paisOrigin;
		this.temperaturaMantenimiento = temperaturaMantenimiento;
		
	}

	

	public LocalDate getFechaDeEnvasado() {
		return fechaDeEnvasado;
	}

	public void setFechaDeEnvasado(LocalDate fechaDeEnvasado) {
		this.fechaDeEnvasado = fechaDeEnvasado;
	}

	public String getPaisOrigin() {
		return paisOrigin;
	}

	public void setPaisOrigin(String paisOrigin) {
		this.paisOrigin = paisOrigin;
	}

	public double getTemperaturaMantenimiento() {
		return temperaturaMantenimiento;
	}

	public void setTemperaturaMantenimiento(double temperaturaMantenimiento) {
		this.temperaturaMantenimiento = temperaturaMantenimiento;
	}

	@Override
	public String toString() {
		return "ProductosCongelados [" + super.toString() + "fechaDeEnvasado=" + fechaDeEnvasado + ", paisOrigin="
				+ paisOrigin + ", temperaturaMantenimiento=" + temperaturaMantenimiento + "]";
	}

}
