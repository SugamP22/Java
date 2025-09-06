public class Motos extends Vehiculo {
  private boolean casco;

  public void setCasco(boolean casco) {
    this.casco = casco;
  }

  public Motos(String nombre, EstadoAccleracion accleracion, boolean casco) {
    super(nombre, accleracion);
    this.casco = casco;
  }

  public boolean isCasco() {
    return casco;
  }

  @Override
  public String toString() {
    return super.toString() + " Casco: " + (isCasco() ? "Esta Puesto" : "No Esta Puesto ") + " }";
  }

}
