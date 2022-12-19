package socket_connection.newserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestAsServer {

    public static void main(String[] args) throws InterruptedException {
        try	(ServerSocket server= new ServerSocket(3345)){
// становимся в ожидание подключения к сокету под именем - "client" на серверной стороне
            Socket client = server.accept();
// канал записи в сокет
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            System.out.println("DataOutputStream  created");
// канал чтения из сокета (Server <- Client)
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("DataInputStream created");

            while(!client.isClosed()){
                String entry = in.readUTF();

// после получения данных считывает их и выводит в консоль
                System.out.println("READ from client message - "+entry);

// инициализация проверки условия продолжения работы с клиентом по этому сокету	по кодовому слову		- quit
                if(entry.equalsIgnoreCase("quit")){
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Bye");
//                    Thread.sleep(3000);
                    break;
                }

// если условие окончания работы не верно - продолжаем работу - отправляем эхо-ответ  обратно клиенту
//                out.writeUTF("Server reply - "+entry + " - OK");

// освобождаем буфер сетевых сообщений (по умолчанию сообщение не сразу отправляется в сеть,
// а сначала накапливается в специальном буфере сообщений, размер которого определяется конкретными
// настройками в системе, а метод  - flush() отправляет сообщение не дожидаясь наполнения
// буфера согласно настройкам системы
                out.flush();

            }

// если условие выхода - верно выключаем соединения
            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");

            // закрываем сначала каналы сокета !
            in.close();
            out.close();

            // потом закрываем сам сокет общения на стороне сервера!
            client.close();

            // потом закрываем сокет сервера который создаёт сокеты общения
            // хотя при многопоточном применении его закрывать не нужно
            // для возможности поставить этот серверный сокет обратно в ожидание нового подключения

            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

