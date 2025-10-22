package RMI_Implementation;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            // Instantiate the remote object implementation
            MyRemoteInterface remoteObject = new ServerImple();

            // Create an RMI registry on the default port (1099)
            // Use try-catch to handle the registry creation
            try {
                LocateRegistry.createRegistry(1099);
            } catch (Exception e) {
                // Registry already exists, ignore exception
                if (!e.getMessage().contains("already in use")) {
                    throw e;
                }
            }

            // Bind the remote object to a name in the RMI registry
            Naming.rebind("rmi://localhost:1099/MyRemoteObject", remoteObject);
            System.out.println("RMI Server is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}