package eje02;
//clase main donde hacemos la operaciones
public class Main {
	public static void main(String[] args) {
		PedidoOnline pedido1 = new PedidoOnline("Carlos", 99);
		pedido1.procesarPedido();
		//creo un objeto PedidoOnline llamando el contructor
		PedidoOnline pedido2 = new PedidoOnline("Carlos", 101);
		//llamo el metodo procecsarPedido que tengo creado en clase PedidoOnline
		pedido2.procesarPedido();
	}
}
