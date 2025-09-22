
import java.util.Objects;

public class Poderes {
  private int id;
  private String nombre;

  public Poderes(String nombre) {
    this.nombre = nombre;
  }

  public Poderes(int id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 41 * hash + Objects.hashCode(this.nombre);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Poderes other = (Poderes) obj;
    return Objects.equals(this.nombre, other.nombre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Poderes{");
    sb.append("id=").append(id);
    sb.append(", nombre=").append(nombre);
    sb.append('}');
    return sb.toString();
  }

}
