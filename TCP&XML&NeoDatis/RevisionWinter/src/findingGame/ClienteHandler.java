package findingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteHandler implements Runnable {

    private final Socket socket;
    private final Servidor servidor;
    private final BufferedReader br;
    private final PrintWriter pw;
    private final String nombre;

    public ClienteHandler(Socket cliente, Servidor servidor) throws IOException {
        this.socket = cliente;
        this.servidor = servidor;
        this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.pw = new PrintWriter(socket.getOutputStream(), true);
        this.nombre = br.readLine();
    }

    public String getNombre() {
        return nombre;
    }

    public BufferedReader getBr() {
        return br;
    }

    @Override
    public void run() {
        try {
            servidor.chooseSocket(this);
        } catch (InterruptedException | IOException e) {
            System.err.println("Cliente desconectado: " + nombre);
            servidor.handleDisconnect(this, "se desconecto");
        }
    }

    public void sendMSG(String msg) {
        pw.println(msg);
    }

    public void closeConexion() throws IOException {
        br.close();
        pw.close();
        socket.close();
    }
}


