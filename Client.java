import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1",6549);
            while(true){
                PrintWriter print = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter message: ");
                String message = in.readLine();
                
                print.println(message);

                InputStream input = socket.getInputStream();
                BufferedReader read = new BufferedReader(new InputStreamReader(input));
                String serverResponse = read.readLine();
                System.out.println(serverResponse); 

                System.out.print("Do you want to enter another message? (y/n) "); 
                String resp = in.readLine();
                if(!(resp.equals("y"))){
                    in.close();
                    socket.close();
                    break;
                }   
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
