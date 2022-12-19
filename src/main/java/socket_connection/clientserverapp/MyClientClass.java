package socket_connection.clientserverapp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClientClass {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    String exitWord = "exit";

    private Socket socket = null;
    private BufferedReader reader = null;
    private DataOutputStream outputStream = null;


    public static void main(String args[]) throws IOException {
        MyClientClass client = new MyClientClass("localhost", 9876);
    }


    public MyClientClass(String address, int port) throws IOException {
        try {
            socket = new Socket(address, port);
            System.out.println("Status [" + ANSI_GREEN + getDate() + ANSI_RESET + "]: " + ANSI_GREEN + "Client connected" + ANSI_RESET);

            reader = new BufferedReader(new InputStreamReader(System.in));
            outputStream = new DataOutputStream(socket.getOutputStream());

            String string = "";
            System.out.println("Chat activated [" + ANSI_GREEN + getDate() + ANSI_RESET + "]: ");

            while (!string.equals(exitWord)) {
                try {
                    string = reader.readLine();
                    outputStream.writeUTF(string);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
        } catch (IOException ex) {
            socket.close();
            reader.close();
            outputStream.close();
            System.out.println(ex);
        }

        System.out.println("Status [" + ANSI_GREEN + getDate() + ANSI_RESET + "]: " + ANSI_GREEN + "...disconnect" + ANSI_RESET);
    }

    public String getDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(date);
    }

}

