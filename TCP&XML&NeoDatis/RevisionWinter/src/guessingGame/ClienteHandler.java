package guessingGame;

import java.io.*;
import java.net.Socket;

public class ClienteHandler implements Runnable {
    private final Servidor servidor;
    private final Socket socket;
    private final PrintWriter wr;
    private final BufferedReader br;
    private String nombre;

    public ClienteHandler(Socket socket, Servidor servidor) throws IOException {
        this.servidor = servidor;
        this.socket = socket;
        this.wr = new PrintWriter(socket.getOutputStream(), true);
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Read the player name once
        this.nombre = br.readLine();
        servidor.broadcastToAll("Nuevo jugador añadido: " + nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void sendMSG(String msg) {
        wr.println(msg);
    }

    @Override
    public void run() {
        String msg;
        try {
            while ((msg = br.readLine()) != null) {
                // send input to server for processing
                servidor.processGuess(this, msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            wr.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
