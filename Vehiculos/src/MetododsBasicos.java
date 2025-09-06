import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MetododsBasicos {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static String comprobarString(String str) {
    while (true) {
      System.out.println(str);
      try {
        String res = br.readLine().trim().toLowerCase();
        return res;
      } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
  }

  public static char comChar(String str) {
    while (true) {
      char letra;
      System.out.println(str);
      try {
        String res = br.readLine().trim().toLowerCase();
        if (res.length() > 0 && res.length() < 2) {
          letra = res.charAt(0);
          return letra;
        } else {
          System.err.println("Error: Introduce una solo Caracter!!");
        }
      } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
  }

  public static boolean comprobarBoolean(String str) {
    while (true) {
      System.out.println(str);
      try {
        boolean res = br.readLine().trim().equalsIgnoreCase("s");
        return res;
      } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
      }

    }
  }

  public static int comprobarInt(String str) {
    while (true) {
      System.out.println(str);
      try {
        int res = Integer.parseInt(br.readLine().trim());
        return res;
      } catch (IOException | NumberFormatException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
  }

  public static EstadoAccleracion comprobarEnum(String str) {
    while (true) {
      System.out.println(str);
      try {
        String nombre = br.readLine().trim().toUpperCase();
        EstadoAccleracion estado = EstadoAccleracion.valueOf(nombre);
        return estado;
      } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
      } catch (IllegalArgumentException e) {
        System.err.println("Error: valor Invalido. Debes Introducir (BAJO, MEDIO, ALTO)");
      }
    }
  }
}
