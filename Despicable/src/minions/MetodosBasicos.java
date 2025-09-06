package minions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MetodosBasicos {
  private static Scanner sc = new Scanner(System.in);
  private static Scanner sn = new Scanner(System.in);

  public static String comprobarString(String str) {
    while (true) {

      System.out.println(str);
      String res = sc.nextLine().toLowerCase().trim();
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
        System.err.println("Error: Numero ingresado invalido!!");
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

  public static char comprobarChare(String str) {
    while (true) {

      System.out.println(str);
      char letra;
      String res = sc.nextLine().trim().toLowerCase();
      if (res.length() > 0 && res.length() < 2) {
        letra = res.charAt(0);
        return letra;
      }
      System.err.println("Error: Valor invalido, Ingresa de nuevo!!");

    }
  }

}
