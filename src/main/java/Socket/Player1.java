package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Player1 {
    public static void main(String[] args) {
        String processId = ProcessIdUtil.getProcessId();
        System.out.println("Player 1 Process ID: " + processId);

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Player 1 is listening on port 8080");
            Socket socket = serverSocket.accept();
            System.out.println("Player 2 connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            for (int i = 0; i < 10; i++) {
                String receivedMessage = in.readLine();
                System.out.println("Player 1 received: " + receivedMessage);
                String sentMessage = "Hello from Player 1, message " + (i + 1);
                out.println(sentMessage);
                System.out.println("Player 1 sent: " + sentMessage);
            }

            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}