import java.net.*;
import java.io.*;

class MyServer {
    public static void main(String args[]) throws Exception {
        // Server listens on port 3333
        ServerSocket ss = new ServerSocket(3333);
        // Server accepts the client connection
        Socket s = ss.accept();

        // Data streams for input/output with the client
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        // Stream for reading input from the console
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";

        // Communication loop until "stop" is entered
        while (!str.equals("stop")) {
            // Read client message
            str = din.readUTF();
            System.out.println("client says:" + str);

            // Read server response from console
            str2 = br.readLine();

            // Send server response to client
            dout.writeUTF(str2);
            dout.flush();
        }

        // Close all resources
        din.close();
        s.close();
        ss.close();
    }
}