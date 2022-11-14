package socket_connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4999);
        System.out.println("Server running. Wait a client");

        Socket s = serverSocket.accept();
        System.out.println("Client connected");
    }
}
