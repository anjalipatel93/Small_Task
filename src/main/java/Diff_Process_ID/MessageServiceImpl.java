package Diff_Process_ID;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageServiceImpl extends UnicastRemoteObject implements MessageService {

    private static final long serialVersionUID = 1L;

    protected MessageServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sendMessage(String message) throws RemoteException {
        System.out.println("Server received: " + message);

        // Check if the message contains "10", if so, stop appending
        if (message.endsWith("10")) {
            System.out.println("Server received the final message: " + message);
            return message; // Return the final message without appending further
        }

        // Extract the last number, increment it, and concatenate it to the message
        int nextNumber = getNextNumber(message);

        // Check if the next number exceeds 10, if so, stop appending
        if (nextNumber > 10) {
            System.out.println("Server reached the limit of 10 messages.");
            return message; // Return the final message without appending further
        }

        // Concatenate " " with the incremented number
        String response = message + " " + nextNumber;

        System.out.println("Server sends: " + response);
        return response;
    }


    /**
     * This method extracts the last character of the given string,
     * converts it into an integer, and increments it by 1.
     *
     * @param message The input string.
     * @return The incremented integer.
     */
    public int getNextNumber(String message) {
        // Split the message by space and get the last number
        String[] parts = message.split(" ");
        int lastNumber = Integer.parseInt(parts[parts.length - 1]);

        // Increment the number
        return lastNumber + 1;
    }
    
    public String getProcessId() 
    {
    	RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
    	String name = runtime.getName();
    	return name.split("@")[0]; // PID is before the '@' symbol
    }

}
