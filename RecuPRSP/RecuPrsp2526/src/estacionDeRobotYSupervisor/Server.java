package estacionDeRobotYSupervisor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket servidor;

    public Server() throws IOException {
        this.servidor = new ServerSocket(5001);
    }

    void iniciar() throws IOException {
        System.out.println("Servidor iniciado con éxito.. Esperando clientes...");

        while (true) {
            Socket socket = servidor.accept(); // Local socket for each client
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private void handleClient(Socket socket) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // First message (could be a name or hello message)
            String firstMsg = br.readLine();
            System.out.println(firstMsg + " conectado al servidor");

            // Read messages continuously
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (IOException e) {
            System.out.println("Cliente desconectado o error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.iniciar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
