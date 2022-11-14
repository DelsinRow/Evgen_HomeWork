package socket_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4999);
        System.out.println("Status: " + ANSI_GREEN + "Server is running..." + ANSI_RESET);
        System.out.println("Status: " + ANSI_GREEN + "Waiting a client" + ANSI_RESET);
        Socket s = serverSocket.accept();

        System.out.println("Status: " + ANSI_GREEN + "Client connected" + ANSI_RESET);

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("client: " + str);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Good job ;)");
        pr.flush();

        System.out.println("Status: " + ANSI_GREEN + "Server was disconnected" + ANSI_RESET);
    }
}
