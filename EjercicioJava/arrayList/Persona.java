package arrayList;

import java.util.ArrayList;

public class Persona {
	private String nombre;
	public static ArrayList<Persona> persona;

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void listarInfo() {
		if (persona.isEmpty()) {
			System.out.println("No hay ningun persona registrado");
		} else {
			for (Persona p : persona) {
				System.out.println(p);
			}
		}
	}

	public static ArrayList<Persona> getPersona() {
		return persona;
	}

	public static void setPersona(ArrayList<Persona> persona) {
		Persona.persona = persona;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}
	

}
