package socket_connection.clientserverapp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHandler extends Thread{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    String exitWord = "exit";
    static int threadCount = 0;

    private Socket clientSocket;
    private DataInputStream inputStream;

    public ClientHandler(Socket clientSocket, DataInputStream inputStream) {
        this.clientSocket = clientSocket;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            String string = "";
            while (!string.equals(exitWord)) {
                try {
                    string = inputStream.readUTF();
                    System.out.println("Client [" + ANSI_GREEN + getDate() + ANSI_RESET + "]: " + string);
                } catch (IOException ex) {
                    System.out.println(ex);
            }
        }
        System.out.println("Status [" + ANSI_GREEN + getDate() + ANSI_RESET + "]: " + ANSI_GREEN + "Client was disconnected" + ANSI_RESET);
            threadCount--;
            System.out.println("Handler: Client on server: " + threadCount);

        // close the resources
        } finally {
            try {
                clientSocket.close();
                inputStream.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public String getDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(date);
    }

}
