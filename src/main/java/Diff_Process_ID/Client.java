package Diff_Process_ID;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
        	
        	System.out.println("Client Process ID: " + Util.getProcessId());

        	
        	// Connect to the RMI registry running on localhost at port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
         // Look up the remote object "MessageService" in the registry
            MessageService stub = (MessageService) registry.lookup("MessageService");

            String message = "Hello 1";
            String response;

            // Loop to send and receive messages 10 times
            for (int i = 1; i <= 10; i++) {
                System.out.println("Client send: " + message);
                response = stub.sendMessage(message);
                System.out.println("Client received: " + response);
                message = response;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}