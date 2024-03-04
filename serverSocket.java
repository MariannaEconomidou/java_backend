package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class serverSocket {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     
		try(ServerSocket server=new ServerSocket(1234)){//DEFINE MY PORT
		System.out.println();
		///InetAddress address=InetAddress.getLocalHost();
  	    // System.out.println(address);
	 	Socket sockClient=server.accept();	//ACCEPT INCOMING CONNECTION
	 	Scanner clientInput=new Scanner(sockClient.getInputStream(),StandardCharsets.UTF_8);//ESTABLISH INPUT STREAM
	 	PrintWriter serverOutput=new PrintWriter(sockClient.getOutputStream(),true,StandardCharsets.UTF_8);//ESTABLISH OUTPUT STREAM
	 	while(true)
	 	{
	 		String request=clientInput.nextLine();
	 		System.out.println("READ"+request);
	 		if(request.equals("quit"))
	 		{System.out.println("Client is done");
	 		 break;}
	 	
	 	String response="<Server echoing "+request+">";
	 	serverOutput.println(response);
	 	}
		}catch(IOException e)
		{e.printStackTrace();}
	}

}
