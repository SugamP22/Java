import java.util.HashSet;

public class Personaje {
  private int id;
  private String nombre;
  private HashSet<Poderes> poderes;
  private boolean mascara;
  private boolean capa;
  private Tipo tipo;

  public Personaje(boolean capa, boolean mascara, String nombre, Tipo tipo) {
    poderes = new HashSet<>();
    this.capa = capa;
    this.mascara = mascara;
    this.nombre = nombre;
    this.tipo = tipo;
  }

  public Personaje(boolean capa, int id, boolean mascara, String nombre, Tipo tipo) {
    poderes = new HashSet<>();
    this.capa = capa;
    this.id = id;
    this.mascara = mascara;
    this.nombre = nombre;
    this.tipo = tipo;
  }

  public boolean addpoder(Poderes p) {
    return poderes.add(p);
  }

  public boolean quitarPoder(Poderes p) {
    return poderes.remove(p);
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

  public HashSet<Poderes> getPoderes() {
    return poderes;
  }

  public void setPoderes(HashSet<Poderes> poderes) {
    this.poderes = poderes;
  }

  public boolean isMascara() {
    return mascara;
  }

  public void setMascara(boolean mascara) {
    this.mascara = mascara;
  }

  public boolean isCapa() {
    return capa;
  }

  public void setCapa(boolean capa) {
    this.capa = capa;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Personaje{");
    sb.append("id=").append(id);
    sb.append(", nombre=").append(nombre);
    sb.append(", poderes=").append(poderes);
    sb.append(", mascara=").append(mascara);
    sb.append(", capa=").append(capa);
    sb.append(", tipo=").append(tipo);
    sb.append('}');
    return sb.toString();
  }

}
