public class Tamagochi {
    private static int contador = 0;
    private final int id;
    private String nombre;
    private int hambre;
    private int suenyo;
    private int higiene;
    private int diversion;

    public Tamagochi(String nombre, int hambre, int suenyo, int higiene, int diversion) {
        this.nombre = nombre;
        this.hambre = (hambre > 100 || hambre < 0) ? 50 : hambre;
        this.suenyo = (suenyo > 100 || suenyo < 0) ? 50 : suenyo;
        this.higiene = (higiene > 100 || higiene < 0) ? 50 : higiene;
        this.diversion = (diversion > 100 || diversion < 0) ? 50 : diversion;
        this.id = ++contador;

    }

    public int getId() {
        return id;
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

    public void jugar() {
        setHambre(Math.max(getHambre() - 10, 0));
        setSuenyo(Math.max(getSuenyo() - 10, 0));
        setHigiene(Math.max(getHigiene() - 10, 0));
        setDiversion(Math.min(getDiversion() + 20, 100));
    }

    public void comer() {
        setHambre(Math.min(getHambre() + 20, 100));
        setSuenyo(Math.max(getSuenyo() - 10, 0));
        setHigiene(Math.max(getHigiene() - 10, 0));
        setDiversion(Math.max(getDiversion() - 10, 0));
    }

    public void duchar() {
        setHambre(Math.max(getHambre() - 10, 0));
        setSuenyo(Math.max(getSuenyo() - 10, 0));
        setHigiene(Math.min(getHigiene() + 20, 100));
        setDiversion(Math.max(getDiversion() - 10, 0));
    }

    public void dormir() {
        setHambre(Math.max(getHambre() - 10, 0));
        setSuenyo(Math.min(getSuenyo() + 20, 100));
        setHigiene(Math.max(getHigiene() - 10, 0));
        setDiversion(Math.max(getDiversion() - 10, 0));
    }

    @Override
    public String toString() {
        return "Tamagochi [id=" + id + ", nombre=" + nombre + ", hambre=" + hambre + ", suenyo=" + suenyo + ", higiene="
                + higiene + ", diversion=" + diversion + "]";
    }

}
