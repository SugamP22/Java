
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MetodosBasicos {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static String comnproString(String str) {
    while (true) {
      System.out.print(str);
      try {
        String res = br.readLine().trim().toLowerCase();
        return res;
      } catch (IOException e) {
        System.err.println("Error" + e.getMessage());
      }

    }
  }

  public static int comprobarInt(String str) {
    while (true) {
      System.out.print(str);
      try {
        int res = Integer.parseInt(br.readLine());
        return res;
      } catch (NumberFormatException | IOException e) {
        System.err.println("Error" + e.getMessage());
      }

    }
  }

  static Boolean comprobarBoolean(String str) {
    while (true) {
      System.out.print(str);
      try {
        boolean res = br.readLine().trim().equalsIgnoreCase("s");
        return res;
      } catch (IOException e) {
        System.err.println("Error" + e.getMessage());
      }
    }
  }

  public static Tipo comprobarTipo(String str) {
    while (true) {
      System.out.print(str);
      try {
        String res = br.readLine().trim().toUpperCase();
        Tipo tipo = Tipo.valueOf(res);
        return tipo;
      } catch (IllegalArgumentException | IOException e) {
        System.err.println("Error" + e.getMessage());
      }
    }
  }
}
