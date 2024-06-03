package Diff_Process_ID;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface defines the remote service for sending messages.
 * It extends the Remote interface, which marks it as a remote interface.
 */	
public interface MessageService extends Remote {
    String sendMessage(String message) throws RemoteException;
}