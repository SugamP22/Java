package examenPrsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private ServerSocket server;

    public Servidor(ServerSocket server) {
        this.server = server;
    }

    // Start accepting clients
    public void iniciar() {
        try {
            System.out.println("[Server] Esperando conexiones en puerto " + server.getLocalPort() + "...");

            // Main loop to accept multiple clients
            while (true) {
                Socket cliente = server.accept();
                System.out.println("[Server] " + cliente.getInetAddress() + " conectado");

                // Handle each client in a separate thread
                new Thread(() -> manejarCliente(cliente)).start();
            }
        } catch (IOException e) {
            System.err.println("[Server] Error en el servidor");
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Handle communication with a single client
    private void manejarCliente(Socket cliente) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()))) {
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println("[Server] " + msg);
            }
        } catch (IOException e) {
            System.err.println("[Server] Cliente desconectado: " + cliente.getInetAddress());
        } finally {
            try {
                cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Main method to start the server
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            new Servidor(serverSocket).iniciar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
