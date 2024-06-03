package Diff_Process_ID;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
 * This class implements the MessageService interface and serves as the RMI server.
 * It receives messages from clients and appends a counter to each message before sending it back.
 */

public class Server implements MessageService {
    private int counter = 2;  // Start the counter at 2 since the client starts with "Hello 1"
    
    /*
     * This method is called remotely by clients to send messages to the server.
     * It receives a message from a client, appends a counter to it, and sends it back.
     */

    @Override
    public synchronized String sendMessage(String message) {
        System.out.println("Server received: " + message);
      
        if(counter == 10) 
        { String response = message + " " + counter;
        System.out.println("Server send: " + response);  return response;}
       
        String response = message + " " + counter++;
        System.out.println("Server send: " + response);  
        
        
        return response;
    
    }
    public static void main(String[] args) {
        try {
            Server obj = new Server();
            MessageService stub = (MessageService) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("MessageService", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}