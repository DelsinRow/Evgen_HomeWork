package socket_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 4999);
        String clientEnter = null;
        String exitWord = "exit";

        PrintWriter pr = new PrintWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("client: ");
        clientEnter = reader.readLine();

        pr.println(clientEnter);
        pr.flush();


        InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("server: " + str);

    }
}