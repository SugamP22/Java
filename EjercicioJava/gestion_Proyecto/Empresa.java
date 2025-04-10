package gestion_Proyecto;

import java.util.ArrayList;	
import java.util.Iterator;

public class Empresa {
	private ArrayList<Proyecto> project;

	Empresa() {
		this.project = new ArrayList<Proyecto>();
	}

	void agregarProyecto(Proyecto proyecto) {
		project.add(proyecto);

	}

	int eliminarProyecto(String nombre) {
		if (project.isEmpty()) {
			return 1;// si en la array list no tinee ningun proyecto registrado
		} else {
			Iterator<Proyecto> it = project.iterator();
			while (it.hasNext()) {
				Proyecto p1 = it.next();//casting
				if (p1.getNombre().equalsIgnoreCase(nombre)) {
					it.remove();
					return 2;// caundo esta eliminado totalmente
				}
			}
		}
		return 3;// cuando core todo y no encuentra proyecto con este nombre

	}

	void listarProyecti() {
		if (project.isEmpty()) {
			System.out.println("No hay ningun Proyecto Para Mostrar");
		} else {
			for (Proyecto pro : project) {
				pro.mostrarInfo();
			}
		}
	}

	void filtrarProyecto(Prioridad perioridad) {
		if (project.isEmpty()) {
		System.out.println("No ningun Proyecto registrado para imprimir");
		} else {
			for (Proyecto p : project) {
				if (p.getPrioridad().equals(perioridad)) {
					p.mostrarInfo();
				}
			}
		}
		
		
	}
	boolean avanzarestado(String nombre) {
		
			for(Proyecto p:project) {
				if(p.getNombre().equalsIgnoreCase(nombre)) {
					 p.avanzarEstado() ;
					 return true;
				}
			}
		return false;
	
	}

}
