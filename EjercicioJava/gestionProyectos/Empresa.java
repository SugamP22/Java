package gestionProyectos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Empresa {
    private List<Proyecto> proyectos;

    public Empresa() {
        this.proyectos = new ArrayList<>();
    }

    public void agregarProyectos(Proyecto proyecto) {
        proyectos.add(proyecto);
    }

    public boolean eliminarProyecto(String nombre) {
        Iterator<Proyecto> iterador = proyectos.iterator();
        while (iterador.hasNext()) {
            Proyecto p = iterador.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                iterador.remove();
                return true;
            }
        }
        return false;
    }

    public void listProyecto() {
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos registrados.");
        } else {
            System.out.println("==== Lista de Proyectos ====");
            for (Proyecto p : proyectos) {
                System.out.println(p);
            }
        }
    }

    public void filtrarPorEstado(EstadoProyecto estado) {
        boolean encontrado = false;
        for (Proyecto p : proyectos) {
            if (p.getEstado() == estado) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron proyectos con este estado.");
        }
    }

    public void filtrarPorPrioridad(Prioridad prioridad) {
        boolean encontrado = false;
        for (Proyecto p : proyectos) {
            if (p.getPrioridad() == prioridad) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron proyectos con esta prioridad.");
        }
    }

    public boolean buscarProyecto(String nombre) {
        for (Proyecto p : proyectos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                 p.avanzarEstado();
                 return true;
            }
        }
        return false;
    }
}
