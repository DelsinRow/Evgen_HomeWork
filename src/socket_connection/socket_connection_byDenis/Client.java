package socket_connection.socket_connection_byDenis;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    // initialize socket
    private Socket socket = null;
    // initialize input stream
    private BufferedReader reader = null;
    // initialize output stream
    private DataOutputStream outputStream = null;

    // constructor takes address and port as parameters
    public Client(String address, int port) {
        try {
            // establish a connection
            socket = new Socket(address, port);
            System.out.println("MyClientClass#constructor()>>>>>>> Client has been connected");

            // for input purposes (from terminal)
            reader = new BufferedReader(new InputStreamReader(System.in));
            // for output purposes (send to the socket)
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println(ex);
        }

        // string to persist data from input
        String string = "";
        System.out.println("MyClientClass#constructor()>>>>>>> Enter messages:");

        while (!string.equals("finish")) {
            try {
                string = reader.readLine();
                outputStream.writeUTF(string);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        // close the resources
        try {
            socket.close();
            outputStream.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        System.out.println("MyClientClass#constructor()>>>>>>> Client has been disconnected");
    }

    public static void main(String args[]) {
        Client client = new Client("localhost", 9876);
    }
}

