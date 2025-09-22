
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Batalla {
  private int id;
  private String lugar;
  private LocalDate date;
  private Personaje ganador;
  private Personaje perdedor;

  public Batalla(String date, Personaje ganador, String lugar, Personaje perdedor) {

    this.date = validarFecha(date);
    this.lugar = lugar;
    if (ganador.getTipo() == perdedor.getTipo()) {
      throw new IllegalArgumentException("No puede luchar entre mismo tipo");
    }
    this.ganador = ganador;
    this.perdedor = perdedor;
  }

  public Batalla(int id, LocalDate date, String lugar, Personaje ganador, Personaje perdedor) {
    this.id = id;
    this.date = date;
    this.lugar = lugar;
    this.ganador = ganador;
    this.perdedor = perdedor;
  }

  private LocalDate validarFecha(String date) {
    try {
      return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    } catch (DateTimeException e) {
      return LocalDate.now();
    }
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getLugar() {
    return lugar;
  }

  public void setLugar(String lugar) {
    this.lugar = lugar;
  }

  public Personaje getGanador() {
    return ganador;
  }

  public void setGanador(Personaje ganador) {
    this.ganador = ganador;
  }

  public Personaje getPerdedor() {
    return perdedor;
  }

  public void setPerdedor(Personaje perdedor) {
    this.perdedor = perdedor;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Batalla{");
    sb.append("date=").append(date);
    sb.append(", lugar=").append(lugar);
    sb.append(", ganador=").append(ganador);
    sb.append(", perdedor=").append(perdedor);
    sb.append('}');
    return sb.toString();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
