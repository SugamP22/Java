
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class MetodosBasicos {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static String comprobarString(String str) {
    while (true) {
      System.out.print(str);
      try {
        String res = br.readLine().trim().toLowerCase();
        return res;
      } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
  }

  public static int comprobarint(String str) {
    while (true) {
      System.out.print(str);
      try {
        int res = Integer.parseInt(br.readLine());
        return res;
      } catch (IOException | InputMismatchException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
  }
}
