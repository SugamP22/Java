package findingGame;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

    private final Socket socket;
    private final int port = 8080;

    public Cliente() throws IOException {
        socket = new Socket("localhost", port);
    }

    private void iniciar() throws IOException {
        new Thread(new Listner(socket)).start();
    }

    public static void main(String[] args) {
        try {
            new Cliente().iniciar();
        } catch (IOException e) {
            System.err.println("Conexion cerrada");
        }
    }
}


