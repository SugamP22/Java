
import java.util.InputMismatchException;
import java.util.Scanner;

public class MetodosBasicos {
  private static final Scanner sc = new Scanner(System.in);
  private static final Scanner sn = new Scanner(System.in);

  public String comproString(String str) {
    while (true) {
      String res = sc.nextLine().trim().toLowerCase();
      return res;
    }
  }

  public int comprobarInt(String str) {
    while (true) {
      try {
        int res = sn.nextInt();
        return res;
      } catch (InputMismatchException e) {
        System.err.println("Error: Ingresa un numero valido!!");
        sn.next();
      }

    }
  }

  public boolean comprobarBoolean(String str) {
    while (true) {
      boolean res = sc.next().trim().equalsIgnoreCase("s");
      return res;
    }
  }
}
