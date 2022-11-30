package socket_connection.clientserverapp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyServerClass {
    private ServerSocket serverSocket = null;
    private DataInputStream inputStream = null;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String args[]) throws IOException {
        MyServerClass server = new MyServerClass(9876);
    }

    public MyServerClass(int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Status [" + ANSI_GREEN + getDate() + ANSI_RESET + "]: " + ANSI_GREEN + "Server is running..." + ANSI_RESET);

            while (!serverSocket.isClosed()) {
                Socket clientSocket = null;
                Thread thread = null;
//                do {
                    try {
                        System.out.println("Status [" + ANSI_GREEN + getDate() + ANSI_RESET + "]: " + ANSI_GREEN + "Waiting a client" + ANSI_RESET);
                        clientSocket = serverSocket.accept();
                        System.out.println("Status [" + ANSI_GREEN + getDate() + ANSI_RESET + "]: " + ANSI_GREEN + "Client connected" + ANSI_RESET);
                        inputStream = new DataInputStream(clientSocket.getInputStream());

                        thread = new ClientHandler(clientSocket, inputStream);
                        thread.start();
                        ClientHandler.threadCount++;
                        System.out.println("Server: Client on server: " + ClientHandler.threadCount);

                    } catch (IOException i) {
                        System.out.println(i);
                    }
//                } while (!(ClientHandler.threadCount == 0));
//                serverSocket.close();
            }
        }
    }

    public String getDate () {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(date);
    }

}
