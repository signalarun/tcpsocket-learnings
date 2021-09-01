import java.io.*;
import java.net.*;

/**
 * Server for continously accepting messages
 */
public class MyServer {

public static void main(String[] args){

 try{
 
  ServerSocket serverSocket = new ServerSocket(6666);
  // Listen for incoming connections
  while(!serverSocket.isClosed()){
    // Open socket for incoming connections
    Socket socket = serverSocket.accept();
    System.out.println("Client " + socket.getInetAddress().getCanonicalHostName()+" connected");

    // Buffer input stream
    BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    // Listen for input from connection
    while(!(socket.isClosed())){
        
        // Check for client disconnection
        if(inputStream.read() == -1){

            // Notify via terminal, close connection
            System.out.println("Client " + socket.getInetAddress().getCanonicalHostName() + " disconnected. Socket closing...");
            socket.close();
        }
        // Listen for user input
        String input = inputStream.readLine();
        if (input != null && !input.trim().equals("")){
            
            // Stream valid input to console
            System.out.println("new message: " + input);
        }

    }
    // Close socket input stream
    inputStream.close();

  }  

 }catch(Exception e){
     System.out.println(e);
    }

}

}
