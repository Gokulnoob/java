import java.net.*;
import java.io.*;

class MyClient {
    public static void main(String args[]) throws Exception {
        // Client connects to the server on localhost:3333
        Socket s = new Socket("localhost", 3333);

        // Data streams for output/input with the server
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        // Stream for reading input from the console
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";

        // Communication loop until "stop" is entered
        while (!str.equals("stop")) {
            // Read client message from console
            str = br.readLine();

            // Send client message to server
            dout.writeUTF(str);
            dout.flush();

            // Read server response
            str2 = din.readUTF();
            System.out.println("Server says:" + str2);
        }

        // Close all resources
        dout.close();
        s.close();
    }
}