public class Sospechoso {
  private int id;
  private String nombre;
  private int nivelDePeligro;
  private String arma;

  public Sospechoso(int id, String nombre, int nivelDePeligro, String arma) {
    this.id = id;
    this.nombre = nombre;
    this.nivelDePeligro = nivelDePeligro;
    this.arma = arma;
  }

  @SuppressWarnings("OverridableMethodCallInConstructor")
  public Sospechoso(String nombre, int nivelDePeligro, String arma) {
    this.nombre = nombre;
    setNivelDePeligro(nivelDePeligro);
    this.arma = arma;
  }

  public Sospechoso() {
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

  public int getNivelDePeligro() {
    return nivelDePeligro;
  }

  public void setNivelDePeligro(int nivelDePeligro) {
    this.nivelDePeligro = (nivelDePeligro > 10 || nivelDePeligro < 1) ? 5 : nivelDePeligro;
  }

  public String getArma() {
    return arma;
  }

  public void setArma(String arma) {
    this.arma = arma;
  }

  @Override
  public String toString() {
    return "Sospechoso [id=" + id + ", nombre=" + nombre + ", nivelDePeligro=" + nivelDePeligro + ", arma=" + arma
        + "]";
  }

}
