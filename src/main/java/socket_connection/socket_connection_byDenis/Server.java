package socket_connection.socket_connection_byDenis;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // initialize client socket
    private Socket clientSocket = null;
    // initialize server socket
    private ServerSocket serverSocket = null;
    // initialize input stream
    private DataInputStream inputStream = null;

    // constructor takes port as parameter
    public Server(int port) {
        try {
            // Starting server
            serverSocket = new ServerSocket(port);
            System.out.println("MyServerClass#constructor()>>>>>>> Server has been started");

            System.out.println("MyServerClass#constructor()>>>>>>> Waiting for a client ...");
            clientSocket = serverSocket.accept();
            System.out.println("MyServerClass#constructor()>>>>>>> Client has been joined");

            // for input purposes (from the client)
            inputStream = new DataInputStream(clientSocket.getInputStream());

            String string = "";

            // until Finish string has been received from the client
            while (!string.equals("finish")) {
                try {
                    string = inputStream.readUTF();
                    System.out.println("MyServerClass#constructor()>>>>>>> " + string + " message has been received from the client");

                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            System.out.println("\"MyServerClass#constructor()>>>>>>> Closing connection");

            // close the resources
            clientSocket.close();
            serverSocket.close();
            inputStream.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        Server server = new Server(9876);
    }
}

