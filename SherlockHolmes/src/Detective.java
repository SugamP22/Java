public class Detective {
  private int id;
  private String nombre;
  private String especialidad;

  public Detective(String especialidad, int id, String nombre) {
    this.especialidad = especialidad;
    this.id = id;
    this.nombre = nombre;
  }

  public Detective(String especialidad, String nombre) {
    this.especialidad = especialidad;
    this.nombre = nombre;
  }

  public Detective() {
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

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Detective{");
    sb.append("id=").append(id);
    sb.append(", nombre=").append(nombre);
    sb.append(", especialidad=").append(especialidad);
    sb.append('}');
    return sb.toString();
  }

}
