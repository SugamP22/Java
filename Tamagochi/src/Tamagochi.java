public class Tamagochi {
    private String nombre;
    private int hambre;
    private int suenyo;
    private int higiene;
    private int diversion;

    public Tamagochi(String nombre, int hambre, int suenyo, int higiene, int diversion) {
        this.nombre = nombre;
        this.hambre = hambre;
        this.suenyo = suenyo;
        this.higiene = higiene;
        this.diversion = diversion;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public int getSuenyo() {
        return suenyo;
    }

    public void setSuenyo(int suenyo) {
        this.suenyo = suenyo;
    }

    public int getHigiene() {
        return higiene;
    }

    public void setHigiene(int higiene) {
        this.higiene = higiene;
    }

    public int getDiversion() {
        return diversion;
    }

    public void setDiversion(int diversion) {
        this.diversion = diversion;
    }

    @Override
    public String toString() {
        return "Tamagochi >>>>[Nombre: " + "]\n";
    }

}
