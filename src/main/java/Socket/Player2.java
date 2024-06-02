package Socket;

import java.io.*;
import java.net.Socket;

public class Player2 {
    public static void main(String[] args) {
        String processId = ProcessIdUtil.getProcessId();
        System.out.println("Player 2 Process ID: " + processId);

        try {
            // Sleep for a while to ensure the server is ready
            Thread.sleep(1000);
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Player 2 connected to Player 1");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            for (int i = 0; i < 10; i++) {
                String sentMessage = "Hello from Player 2, message " + (i + 1);
                out.println(sentMessage);
                System.out.println("Player 2 sent: " + sentMessage);
                String receivedMessage = in.readLine();
                System.out.println("Player 2 received: " + receivedMessage);
            }

            in.close();
            out.close();
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
