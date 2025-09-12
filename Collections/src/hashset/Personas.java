package hashset;

import java.util.Objects;

public class Personas {
  private String nombre;
  private int edad;

  public Personas(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;

  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  @Override
  public String toString() {
    return "Personas:::>\n{Nombre: " + getNombre() + "|| Edad: " + getEdad() + "} ";
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + Objects.hashCode(this.nombre);
    hash = 53 * hash + this.edad;
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
    final Personas other = (Personas) obj;
    if (this.edad != other.edad) {
      return false;
    }
    return Objects.equals(this.nombre, other.nombre);
  }
}
