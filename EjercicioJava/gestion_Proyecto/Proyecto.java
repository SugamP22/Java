 	package gestion_Proyecto;
	
	public class Proyecto {
		private String nombre;
		private Estado estado;
		private Prioridad prioridad;
	
		Proyecto(String nombre, Prioridad prioridad) {
			this.nombre = nombre;
			setEstado(estado);
			this.prioridad = prioridad;
		}
	
		public String getNombre() {
			return nombre;
		}
	
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	
		public Estado getEstado() {
			return estado;
		}
	
		public void setEstado(Estado estado) {
			this.estado = Estado.NO_INICIADO;
		}
	
		public Prioridad getPrioridad() {
			return prioridad;
		}
	
		public void setPrioridad(Prioridad prioridad) {
			this.prioridad = prioridad;
		}
	
		public void avanzarEstado() {
			if (estado == Estado.NO_INICIADO) {
				estado = Estado.EN_PROGRESO;
			} else if (estado == Estado.EN_PROGRESO) {
				estado = Estado.COMPLETADO;
			} else {
				System.out.println("El  proyecto esta Completado!! w");
				;
			}
	
		}
		
		public void mostrarInfo() {
			System.out.println(this.toString());
			
		}
	
		@Override
		public String toString() {
			return "Proyecto [nombre=" + nombre + ", estado=" + estado + ", prioridad=" + prioridad + "]";
		}
		
	
	}
