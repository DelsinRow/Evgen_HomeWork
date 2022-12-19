package socket_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket ("localhost", 4999);
//        Thread secondClient = new Thread(new SecondClient());
//        secondClient.start();
        String clientEnter = "";
        String exitWord = "exit";

        PrintWriter pr = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(!clientEnter.equals(exitWord)){
            System.out.print("client: ");
            clientEnter = reader.readLine();
            pr.println(clientEnter);
        }

        InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        System.out.println("server: " + str);
    }
}

//class SecondClient implements Runnable {
//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_RED = "\u001B[31m";
//    @Override
//    public void run() {
//        sleepSpeak();
//        try {
//            Socket socket2 = new Socket("localhost", 4999);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(ANSI_RED + "I'm second client. I'm here..." + ANSI_RESET);
//        sleepSpeak();
//        System.out.println(ANSI_RED + "Can write instead of you?" + ANSI_RESET);
//        sleepSpeak();
//        System.out.println(ANSI_RED + "Thanks, man" + ANSI_RESET);
//        sleepSpeak();
//        System.out.println(ANSI_RED + "Please don't get distracted on me" + ANSI_RESET);
//    }
//
//    static void sleepSpeak(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}