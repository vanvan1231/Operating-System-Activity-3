import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args){
        try {
            ServerSocket server = new ServerSocket(6549);
            Socket client = server.accept();
            while(true){
                if(client.isConnected()){
                    System.out.println("Server status: Connected");
                    PrintWriter print = new PrintWriter(client.getOutputStream(), true);

                    InputStream input = client.getInputStream();
                    BufferedReader read = new BufferedReader(new InputStreamReader(input));
                    String message = read.readLine();

                    print.println("Server: "+message);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
