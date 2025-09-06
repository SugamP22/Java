
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  @SuppressWarnings("FieldMayBeFinal")
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    iniciarMain();
    sc.close();
  }

  /*  */
  private static void iniciarMain() {
    dialogo();
    int opcion = 0;
    do {
      menu();
      try {
        opcion = sc.nextInt();
        mainSwitch(opcion);
      } catch (InputMismatchException e) {
        System.err.println("Error: Numero introducido es incorrecto!!");
        sc.next();
      }

    } while (opcion != 5 && opcion != 4);
  }

  private static void dialogo() {

    System.out.println(
        "Tu Vecino- Vecino. Vecino. Vecino.\n---------------------\nTu- Eh... hola,¿puedo ayudarte?\n-----------------------------------\nTu Vecino- !Ah, excelente! Me presento: soy el Dr. Sheldon Cooper, fisico teorico del instituto Technologico de California. Según las normas del edificio, es mi deber conocer a los nuevos inquilinos.¿Cual es tu nombre?\n----------------------------------\nTu- Oh,eh...soy "
            + nombre() + "\n----------------------------------\nTu Vecino- Perfecto," + nombre()
            + ". Ahora que hemos establecido una relacion cordial basada en normas sociales minimas, creo ques es un momento adecuado para desafiarte intelectualmente. Tengo preparado un par de actividades para poner a prueba tus habilidades. ¿Estas listo?\n-----------------------------------------\nTu- Supongo que si. ¿Que tienes en mente?\n");
  }

  private static String nombre() {
    System.out.print(":::>");
    String nombrePersona = sc.nextLine().toUpperCase();
    return nombrePersona;
  }

  private static void mainSwitch(int opcion) {
    switch (opcion) {
      case 1 -> apostar();
      case 2 -> adivinar();
      case 3 -> jugar();
      case 4 -> pelear();
      case 5 -> {
        System.out.println("Saliendo de la sistema!!");
        sc.close();
      }
      default -> System.err.println("Error: Numero introducido es incorrecto!!");
    }
  }

  private static void pelear() {
    System.out.println(
        "¿De verdad esperas que participe en una demostracion primitiva de fuerza bruta?\nEso seria como pedirle a un premio Nobel que compita en un concurso de comer hot dogs. No, gracias.");
    System.out.println("Saliendo de la sistema!!");
  }

  private static void jugar() {
    // lets make a menu wher if i selct one its scissor ,2 then its paper and 3 its
    // rock and according to that logic we will win or loos the game against sheldon
    int numEmpate = 0;
    int numGanadoSugam = 0;
    int numGanadoSheldon = 0;

    for (int i = 0; i < 3; i++) {
      System.out.printf("   ---- Ronda %d ----\n", i + 1);
      int numSheldon = (int) (Math.random() * 3) + 1;
      menuJuego();
      try {
        int numSugam = sc.nextInt();
        switch (numSugam) {
          case 1 -> {
            switch (numSheldon) {
              case 1 -> {
                System.out.printf("La ronda %d termina en un empate los dos tenidendo %s \n", i + 1, "Tijeras");
                numEmpate++;
              }
              case 2 -> {
                System.out.printf("Sugam gana la ronda %d donde el tiene %s y sheldon %s\n", i + 1, "Tijeras", "Papel");
                numGanadoSugam++;
              }
              default -> {
                System.out.printf("Sheldon gana la ronda %d donde el tiene %s y Sugam %s\n", i + 1, "Piedras",
                    "Tijeras");
                numGanadoSheldon++;
              }
            }
          }
          case 2 -> {
            switch (numSheldon) {
              case 1 -> {
                System.out.printf("Sheldon gana la ronda %d donde el tiene %s y Sugam %s\n", i + 1, "Tijeras", "Papel");
                numGanadoSheldon++;
              }
              case 2 -> {
                System.out.printf("La ronda %d termina en un empate los dos tenidendo %s \n", i + 1, "Papel");
                numEmpate++;
              }
              case 3 -> {
                System.out.printf("Sugam gana la ronda %d donde el tiene %s y sheldon %s\n", i + 1, "Papel", "Piedras");
                numGanadoSugam++;
              }
            }
          }
          case 3 -> {
            switch (numSheldon) {
              case 1 -> {
                System.out.printf("Sugam gana la ronda %d donde el tiene %s y sheldon %s\n", i + 1, "Piedras",
                    "Tijeras");
                numGanadoSugam++;
              }
              case 2 -> {
                System.out.printf("Sheldon gana la ronda %d donde el tiene %s y Sugam %S\n", i + 1, "Papel", "Piedra");
                numGanadoSheldon++;
              }
              case 3 -> {
                System.out.printf("La ronda %d termina en un empate los dos tenidendo %s \n", i + 1, "Piedra");
                numEmpate++;

              }
            }
          }
          default -> {
            System.err.println("Error: INtroduce un numero entre 1 y 3");
            i--;
          }
        }
      } catch (InputMismatchException e) {
        System.err.println("Error: Introduce un numero!!");
        i--;
        sc.next();
      }

    }
    if (numEmpate > numGanadoSheldon && numEmpate > numGanadoSugam) {
      System.out.printf(
          "Despues de 3 ronda la juego termina en empate teniendo numero toal de empate %d numero total de ganado %d y num total de perdido %d\n",
          numEmpate, numGanadoSugam, numGanadoSheldon);
    } else if (numGanadoSugam > numGanadoSheldon) {
      System.out.printf(
          "Despues de 3 ronda sugam gana la juego con numero toal de empate %d numero total de ganado %d y num total de perdido %d\n",
          numEmpate, numGanadoSugam, numGanadoSheldon);
    } else {
      System.out.printf(
          "Despues de 3 ronda Sheldon gana la juego con numero toal de empate %d numero total de ganado %d y num total de perdido %d\n",
          numEmpate, numGanadoSugam, numGanadoSheldon);

    }
  }

  private static void menuJuego() {
    System.out.println("1. TiJeras");
    System.out.println("2. Papel");
    System.out.println("3. Piedras");
    System.out.print(":::::>");
  }

  private static void adivinar() {
    boolean adivinado = false;
    int turno = 1;
    int numSheldon = (int) (Math.random() * 10) + 1;
    do {
      System.out.printf("Adivinar el numero(1-10) turno %d ::>", turno);
      try {
        int numAdivinado = sc.nextInt();
        if (numAdivinado > 10 || numAdivinado < 1) {
          throw new IllegalArgumentException("Error: Ingresa un numero entre 1-10");
        }
        if (numAdivinado == numSheldon) {
          System.out.printf("NUmero adivinado con exito!! numero correcto es: %d\n", numSheldon);
          return;
        }
        if (turno == 2 && numSheldon != numAdivinado) {
          System.out.printf("NO eres capaz de adivinar ni un numero JAjajaja! El numero correcto era %d\n", numSheldon);
          return;
        }
        if (numAdivinado > numSheldon) {
          System.out.println("Jajaja, tu numero es demasiado alto");
        } else {
          System.out.println("Jajaja, tu numero es demasiado bajo!!");
        }
        turno++;
      } catch (InputMismatchException e) {
        System.err.println("Error: Numero introducido no es un numero!!");
        sc.next();
      } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
      }

    } while ((!adivinado) && turno <= 2);

  }

  private static void apostar() {
    int[] arrayNumeros = new int[10];
    rellanarArray(arrayNumeros);
    int posicionAheldon;
    int posicionSugam;
    while (true) {
      try {
        System.out.println("Shedon selecciona un posicion:::>   ");
        posicionAheldon = sc.nextInt();
        System.out.println("Sugam selecciona un posicion:::>   ");
        posicionSugam = sc.nextInt();
        if ((posicionAheldon > 10 || posicionAheldon < 1) || (posicionSugam > 10 || posicionSugam < 1)) {
          throw new IllegalArgumentException("Error: Introduce un posicion entre 1 a 10");
        }
        if (arrayNumeros[posicionAheldon] > arrayNumeros[posicionSugam]) {
          System.out.printf("Sheldon gano con con exitó!! con %d cuando sugam tenia %d\n",
              arrayNumeros[posicionAheldon],
              arrayNumeros[posicionSugam]);
        } else if (arrayNumeros[posicionAheldon] < arrayNumeros[posicionSugam]) {
          System.out.printf("Sugam gano con con exitó!! con %d cuando Sheldon tenia %d\n", arrayNumeros[posicionSugam],
              arrayNumeros[posicionAheldon]);
        } else {
          System.out.printf("Juego termina en empate!! con los dos teniendo %d\n", arrayNumeros[posicionAheldon]);
        }
        return;
      } catch (InputMismatchException e) {
        System.err.println("Error: Numero introducido es incorrecto!!");
        sc.next();
      } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
      }

    }
  }

  private static void rellanarArray(int[] arrayNumeros) {

    for (int i = 0; i < arrayNumeros.length; i++) {
      arrayNumeros[i] = (int) (Math.random() * 100) + 1;
    }
    System.out.println("Array rellanado con exito!!");
  }

  private static void menu() {
    System.out.println("--- Menú Principal ---- ");
    System.out.println("1. Apostar");
    System.out.println("2. Adivinar");
    System.out.println("3. Jugar");
    System.out.println("4. Pelear");
    System.out.println("5. Salir");
    System.out.println("::::::::>");

  }
}
