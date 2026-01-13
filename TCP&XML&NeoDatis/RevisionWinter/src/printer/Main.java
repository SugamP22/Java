package printer;

/*
 * 
 * 	Implementar un programa en Java que simule la siguiente situación:
 *	Una impresora admite documentos para imprimir de distintos procesos que
 *	son gestionados por prioridades, siendo la prioridad 1 la más baja y la 5 la
 *	más alta.
 *	La impresión de un documento depende de la longitud del mismo.
 *	Cuando un proceso solicita imprimir se pone en cola de impresión según el
 *	orden de la prioridad que tenga.
 *	Un proceso no podrá imprimir mientras que la impresora esté imprimiendo
 *	otro documento o no le corresponda porque haya trabajos con más
 *	prioridad. En caso de que haya dos procesos con la misma prioridad, el
 *	primero que haya solicitado imprimir será el que haga uso de la impresora.
 *	Notas:
 *	Visualizar el momento en el que el proceso entra en el sistema y la
 *	prioridad que tiene.
 *	Visualizar la cola de impresión siempre que un proceso entre o salga de
 *	ella.
 *	Visualizar el momento en el que el proceso comienza a imprimir.
 *	Visualizar el momento en el que el proceso finaliza de imprimir.
 *	Visualizar el momento en el que un proceso intenta colarse en la
 *	impresión.
 *	Simular la entrada de procesos de manera aleatoria entre 1 y 3
 *	segundos.
 *	Simular el tiempo que tarda en imprimir un proceso de manera aleatoria
 *	entre 2 y 4 segundos.
 *	Simular la ejecución con 20 procesos.
 *
 * */
public class Main {
	public static void main(String[] args) {
		System.out.println("======== Empresora abierto para Imprimir ========");
		Empresora empresora = new Empresora();
		Thread[] lista = new Thread[10];
		for (int i = 0; i < 10; i++) {
			Documento d = new Documento("Doc-" + (i + 1), empresora);
			lista[i] = new Thread(d);
			lista[i].start();

		}
		for (Thread thread : lista) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("======== Processos completado cerrando la empressora =======");
	}
}
