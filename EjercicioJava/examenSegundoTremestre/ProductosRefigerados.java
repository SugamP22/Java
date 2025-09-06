package examenSegundoTremestre;

import java.time.LocalDate;

public class ProductosRefigerados extends Productos {
	private int codigo;
	private LocalDate fechaEnvasado;
	private double temperatura;
	private String pais;

	public ProductosRefigerados(LocalDate fechaDeCaducidad, int numeroLote, int codigo, double temperatura,
			String pais) {
		super(fechaDeCaducidad, numeroLote);
		this.codigo = codigo;
		this.fechaDeCaducidad = fechaDeCaducidad;
		this.temperatura = temperatura;
		this.pais = pais;

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "ProductosRefigerados [" + super.toString() + "codigo=" + codigo + ", fechaEnvasado=" + fechaEnvasado
				+ ", temperatura=" + temperatura + ", pais=" + pais + "]";
	}

}
