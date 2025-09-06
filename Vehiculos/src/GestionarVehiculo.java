import java.util.ArrayList;
import java.util.Iterator;

public class GestionarVehiculo {
  private ArrayList<Vehiculo> vehiculo;

  public GestionarVehiculo() {
    vehiculo = new ArrayList<>();
  }

  public boolean addvehiculo(Vehiculo v) {
    return vehiculo.add(v);
  }

  public int removevehiculo(Vehiculo v) {
    if (vehiculo.isEmpty()) {
      System.out.println("Error: No hay ningun vehiculo registrado!!");
      return 1;
    }
    Iterator<Vehiculo> it = vehiculo.iterator();
    while (it.hasNext()) {
      Vehiculo vehiculoExistente = it.next();
      if (vehiculoExistente.equals(v)) {
        it.remove();
        return 2;
      }
    }
    return 3;

  }

  public void mostrarInfo() {
    if (vehiculo.isEmpty()) {
      System.out.println("No hay ningun vehiculo registrado!!");
      return;
    }
    for (Vehiculo v : vehiculo) {
      if (v instanceof Coches)
        System.out.println("Tipo Coche: " + v);
      else if (v instanceof Motos)
        System.out.println("Tipo Moto: " + v);
      System.out.println("--------------------------");
    }
  }

  public int mostrarNumerTotal() {
    if (vehiculo.isEmpty()) {
      System.out.println("No hay ningun vehiculo registrado!!");
    }
    return vehiculo.size();
  }

  public void setVehiculo(ArrayList<Vehiculo> vehiculo) {
    this.vehiculo = vehiculo;
  }

  public ArrayList<Vehiculo> getVehiculo() {
    return vehiculo;
  }

}
