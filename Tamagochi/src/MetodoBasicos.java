import java.util.InputMismatchException;
import java.util.Scanner;

public class MetodoBasicos {
  private static final Scanner sc = new Scanner(System.in);
  private static final Scanner sn = new Scanner(System.in);

  public static String comprobarString(String str) {
    while (true) {
      System.out.println(str);
      String res = sc.nextLine().trim().toLowerCase();
      return res;

    }
  }

  public static int comprobarInt(String str) {
    while (true) {
      try {
        System.out.println(str);
        int res = sn.nextInt();
        return res;
      } catch (InputMismatchException e) {
        System.err.println("Error: Valor introduciod es incorrecto!!");
        sn.next();
      }
    }
  }

  public static boolean comprobarBoolean(String str) {
    while (true) {
      System.out.println(str);
      boolean res = sc.nextLine().trim().equalsIgnoreCase("s");
      return res;
    }
  }

}
