package minions;

public class Minions {
  private int fuerza;
  private int torpeza;

  public Minions() {
    fuerza = (int) (Math.random() * 10) + 1;
    torpeza = (int) (Math.random() * 10) + 1;
  }

  public int getTorpeza() {
    return torpeza;
  }

  public int getFuerza() {
    return fuerza;
  }

  @Override
  public String toString() {
    return "Minion: {Fuerza :" + fuerza + " | Torpeza: " + torpeza + " }";
  }

}
