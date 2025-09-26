
import java.time.LocalDate;

public class Casos {
  private int id;
  private String titulo;
  private String discrpcion;
  private LocalDate fecha;
  private Sospechoso sospechoso;
  private Detective detective;
  private boolean resuelto;

  public Casos(int id, String titulo, String discrpcion, LocalDate fecha, Sospechoso sospechoso, Detective detective,
      boolean resuelto) {
    this.id = id;
    this.titulo = titulo;
    this.discrpcion = discrpcion;
    this.fecha = fecha;
    this.sospechoso = sospechoso;
    this.detective = detective;
    this.resuelto = resuelto;
  }

  public Casos() {
  }

  public Casos(String titulo, String discrpcion, LocalDate fecha, Sospechoso sospechoso, Detective detective,
      boolean resuelto) {
    this.titulo = titulo;
    this.discrpcion = discrpcion;
    this.fecha = fecha;
    this.sospechoso = sospechoso;
    this.detective = detective;
    this.resuelto = resuelto;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDiscrpcion() {
    return discrpcion;
  }

  public void setDiscrpcion(String discrpcion) {
    this.discrpcion = discrpcion;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public Sospechoso getSospechoso() {
    return sospechoso;
  }

  public void setSospechoso(Sospechoso sospechoso) {
    this.sospechoso = sospechoso;
  }

  public Detective getDetective() {
    return detective;
  }

  public void setDetective(Detective detective) {
    this.detective = detective;
  }

  public boolean isResuelto() {
    return resuelto;
  }

  public void setResuelto(boolean resuelto) {
    this.resuelto = resuelto;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Casos{");
    sb.append("id=").append(id);
    sb.append(", titulo=").append(titulo);
    sb.append(", discrpcion=").append(discrpcion);
    sb.append(", fecha=").append(fecha);
    sb.append(", sospechoso=").append(sospechoso);
    sb.append(", detective=").append(detective);
    sb.append(", resuelto=").append(resuelto);
    sb.append('}');
    return sb.toString();
  }

}
