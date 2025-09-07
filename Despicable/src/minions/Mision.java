package minions;

public class Mision {
  private String nombreMision;
  private String discripcion;
  private int puntuacionNecesario;

  public Mision(String nombreMision, String discripcion, int puntuacionNecesario) {
    this.nombreMision = nombreMision;
    this.discripcion = discripcion;
    if (puntuacionNecesario > 400) {
      this.puntuacionNecesario = 400;
    } else if (puntuacionNecesario < 10) {
      this.puntuacionNecesario = 10;
    } else {
      this.puntuacionNecesario = puntuacionNecesario;
    }
  }

  public String getNombreMision() {
    return nombreMision;
  }

  public void setNombreMision(String nombreMision) {
    this.nombreMision = nombreMision;
  }

  public String getDiscripcion() {
    return discripcion;
  }

  public void setDiscripcion(String discripcion) {
    this.discripcion = discripcion;
  }

  public int getPuntuacionNecesario() {
    return puntuacionNecesario;
  }

  public void setPuntuacionNecesario(int puntuacionNecesario) {
    this.puntuacionNecesario = puntuacionNecesario;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "Mision: { Nombre Misión: " + getNombreMision() + "| Discripción: " + getDiscripcion() + "| Puntuación: "
        + getPuntuacionNecesario() + " }";
  }
}
