public class Coches extends Vehiculo {
  private int puertas;

  public Coches(String nombre, EstadoAccleracion accleracion, int puertas) {

    super(nombre, accleracion);
    this.puertas = puertas;
  }

  public int getPuertas() {
    return puertas;
  }

  public void setPuertas(int puertas) {
    this.puertas = puertas;
  }

  @Override
  public String toString() {
    return super.toString() + " Puertas: " + getPuertas() + " }";
  }
}
