package RMI_Implementation;

// ServerImple implements the remote interface

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImple extends UnicastRemoteObject implements MyRemoteInterface {
    // Constructor must declare RemoteException
    public ServerImple() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello from RMI Server!";
    }

    @Override
    public String sendMessage(String message) throws RemoteException {
        // Corrected to return a proper message
        return "Message received by the server: " + message;
    }
}