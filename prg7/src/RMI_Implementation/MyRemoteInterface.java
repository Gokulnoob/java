package RMI_Implementation;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteInterface extends Remote {
    // Declared remote method 1
    String sayHello() throws RemoteException; 
    
    // Declared remote method 2
    String sendMessage(String message) throws RemoteException;
}