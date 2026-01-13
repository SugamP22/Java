package exa1acda2425;

import java.util.Date;

public class Vuelos {
	private String id;
	private String origen;
	private String destino;
	private String Tipo_vuelo;
	private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getTipo_vuelo() {
		return Tipo_vuelo;
	}

	public void setTipo_vuelo(String tipo_vuelo) {
		Tipo_vuelo = tipo_vuelo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Vuelos(String id, String origen, String destino, String tipo_vuelo, Date date) {
		super();
		this.id = id;
		this.origen = origen;
		this.destino = destino;
		Tipo_vuelo = tipo_vuelo;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Vuelos [id=" + id + ", origen=" + origen + ", destino=" + destino + ", Tipo_vuelo=" + Tipo_vuelo
				+ ", date=" + date + "]";
	}

}
