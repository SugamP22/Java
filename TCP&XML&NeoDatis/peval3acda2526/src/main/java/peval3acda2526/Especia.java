package peval3acda2526;

import java.util.ArrayList;

public class Especia {
	private String nombre;
	private String origenGeografico;
	private double stockGramos;
	private int intensidadPicante;
	private ArrayList<PerfilSabor> usos;

	public Especia() {
	}

	public Especia(String nombre, String origenGeografico, double stockGramos, int intensidadPicante,
			ArrayList<PerfilSabor> usos) {
		super();
		this.nombre = nombre;
		this.origenGeografico = origenGeografico;
		this.stockGramos = stockGramos;
		setIntensidadPicante(intensidadPicante);
		this.usos = usos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOrigenGeografico() {
		return origenGeografico;
	}

	public void setOrigenGeografico(String origenGeografico) {
		this.origenGeografico = origenGeografico;
	}

	public double getStockGramos() {
		return stockGramos;
	}

	public void setStockGramos(double stockGramos) {
		this.stockGramos = stockGramos;
	}

	public int getIntensidadPicante() {
		return intensidadPicante;
	}

	public void setIntensidadPicante(int intensidadPicante) {
		boolean correcto = (intensidadPicante >= 0 && intensidadPicante <= 10);
		if (correcto) {
			this.intensidadPicante = intensidadPicante;
			return;
		}
		this.intensidadPicante = 0;

	}

	public ArrayList<PerfilSabor> getUsos() {
		return usos;
	}

	public void setUsos(ArrayList<PerfilSabor> usos) {
		this.usos = usos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int num = 0;
		for (PerfilSabor perfilSabor : usos) {
			num++;
			builder.append(perfilSabor.getTipoCocina());
			if (num == usos.size())
				continue;
			builder.append(",");
		}

		return String.format(
				"Origen Geográfico: %s%n  Especias encontradas:%n    Nombre: %s%n"
						+ "    Stock: %.1fg | Picante: %d	%n" + "    Usos (Tipos de Cocina): %s%n",
				origenGeografico, nombre, stockGramos, intensidadPicante, builder);
	}

}
