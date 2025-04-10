package arrayList;

import java.util.ArrayList;
import java.util.Iterator;


public class Main {
	public static void main(String[] args) {
		Persona.persona = new ArrayList<>();
		Persona.persona.add(new Persona("Pratikshay"));
		Persona.persona.add(new Persona("sushil"));
		Persona.persona.add(new Persona("Pratikshay"));
		Persona.persona.add(new Persona("Suman"));
		Persona.persona.add(new Persona("subham"));
		Persona.persona.add(new Persona("Deep"));
		Iterator<Persona> it = Persona.persona.iterator();
		boolean flag = false;
		while (!flag && it.hasNext()) {
			Persona p = it.next();
			if (p.getNombre().equalsIgnoreCase("Pratikshay")) {
				it.remove();
				System.out.println("Eliminado correctamente");
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("No hay ninguna persona con este nombre");
		}

		
	}
}
