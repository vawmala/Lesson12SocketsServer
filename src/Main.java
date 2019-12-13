

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        try (

                ServerSocket serverSocket = new ServerSocket(7050); // создание Сервера
                Socket socket = serverSocket.accept(); // прием клиента на стороне Сервера
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // InputStreamReader - перевод байт в символы
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {

            while (true) {
                String messageFromClient = bufferedReader.readLine();
                System.out.println(messageFromClient);
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                bufferedWriter.write(message + "\n");
                bufferedWriter.flush();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
