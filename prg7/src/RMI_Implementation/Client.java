package RMI_Implementation;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            // Look up the remote object by its name
            MyRemoteInterface remoteObject = (MyRemoteInterface)
                    // Corrected lookup to include the port if a registry was explicitly created
                    Naming.lookup("rmi://localhost:1099/MyRemoteObject");

            // Invoke the remote method
            String result = remoteObject.sendMessage("Hello from RMI Client!");
            System.out.println("Server Response: " + result);

            // Invoke the other remote method
            String helloResult = remoteObject.sayHello();
            System.out.println("Server Hello: " + helloResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}