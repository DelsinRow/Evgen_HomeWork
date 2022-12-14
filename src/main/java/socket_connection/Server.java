package socket_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String[] args) throws IOException {
        String exitWord = "exit";
        String str = "";

        ServerSocket serverSocket = new ServerSocket(4999);
        System.out.println("Status: " + ANSI_GREEN + "Server is running..." + ANSI_RESET);
        System.out.println("Status: " + ANSI_GREEN + "Waiting a client" + ANSI_RESET);
        Socket s = serverSocket.accept();
        System.out.println("Status: " + ANSI_GREEN + "Client connected" + ANSI_RESET);
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        while(!str.equals(exitWord)) {
            str = bf.readLine();
            System.out.println("client: " + str);
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println("Good job ;)");
        }

        System.out.println("Status: " + ANSI_GREEN + "Server was disconnected" + ANSI_RESET);
    }
}
