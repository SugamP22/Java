package minions;

import java.util.Arrays;

public class Villano {
  private String nombre;
  private int maldad;
  private Minions[] minions;
  private int nivelDeVictorias;

  public Villano(String nombre, int maldad) {
    this.nombre = nombre;
    if (maldad > 4) {
      this.maldad = 4;
    } else if (maldad < 1) {
      this.maldad = 1;
    } else {
      this.maldad = maldad;
    }
    this.minions = new Minions[getMaldad() * 10];
    this.nivelDeVictorias = 0;
    reclutarMinions();
  }

  public void reclutarMinions() {
    for (int i = 0; i < getMinions().length; i++) {
      getMinions()[i] = new Minions();
    }
  }

  public void registrarVictorias() {
    setNivelDeVictorias(nivelDeVictorias + 1);
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getNivelDeVictorias() {
    return nivelDeVictorias;
  }

  public void setNivelDeVictorias(int nivelDeVictorias) {
    this.nivelDeVictorias = nivelDeVictorias;
  }

  public void setMinions(Minions[] minions) {
    this.minions = minions;
  }

  public Minions[] getMinions() {
    return minions;
  }

  public int getMaldad() {
    return maldad;
  }

  @Override
  public String toString() {
    return "Villano: \nNombre: " + getNombre() + "\nNivel Maldad: " + getMaldad() + "\nEjercito: "
        + Arrays.toString(getMinions()) + "\nNivel victorias: " + getNivelDeVictorias();
  }

}
