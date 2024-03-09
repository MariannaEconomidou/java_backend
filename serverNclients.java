package N_CLIENT_SERVER;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class serverNclients {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try( ServerSocket server=new ServerSocket(1234)){
    	  ExecutorService es=Executors.newFixedThreadPool(1000);
    	  System.out.println("Server is ready....");
    	
    	  
       // Server's While loop is endless and does to things 1 accepts connection requests and
      // assigns the newly created sockets to new threads
     while(true) {
    	 Socket newClient=server.accept();
    	 es.execute(()->{
    		 
    		 try {
				Scanner readFromClient=new Scanner(newClient.getInputStream(),StandardCharsets.UTF_8);
				PrintWriter writeToClient=new PrintWriter(newClient.getOutputStream(),true,StandardCharsets.UTF_8);
				//Establishing username for client
				String usrn=readFromClient.nextLine();
				System.out.println("Connected with client: " +usrn+ "\n");
				//exchanging messages between client server
				while(true) {
					String request=readFromClient.nextLine();
				    if(request.equals("quit")) {
				    	System.out.println("Ended Communication with user: "+usrn);
				    	break;
				    }
				    System.out.println("User "+usrn+" requested "+ request);
				    String response="Server says :"+request+" is completed";
				    writeToClient.println(response);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 
    		 
    	 });
     }	  
    	  
    	  
    	  
    	 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }

}
