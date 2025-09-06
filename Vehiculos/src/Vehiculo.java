public abstract class Vehiculo {
  private String nombre;
  private EstadoAccleracion acceleracion;

  public Vehiculo(String nombre, EstadoAccleracion accleracion) {
    this.nombre = nombre;
    this.acceleracion = accleracion;

  }

  public EstadoAccleracion getAcceleracion() {
    return acceleracion;
  }

  public void setAcceleracion(EstadoAccleracion acceleracion) {
    this.acceleracion = acceleracion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "Vehiculo{ Nombre: " + getNombre() + " EstadoAcceleracion: " + getAcceleracion();
  }

}
