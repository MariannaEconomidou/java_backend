package clientSocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class clientSocket {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		try(Socket client=new Socket("127.0.0.1",1234)){
			//communication with user only inputs
			Scanner readFromUser=new Scanner(System.in);//()WHERE I GET THE STREAM FROM
			//communication with server inputas and outputs
			Scanner readFromServer=new Scanner(client.getInputStream(),StandardCharsets.UTF_8);
			PrintWriter writeToServer=new PrintWriter(client.getOutputStream(),true,StandardCharsets.UTF_8);
			
		System.out.println("Client Ready");
		while(true)
		{
			//READS FROM USER WHAT TO SEND
			System.out.println(">");
			String userRequest=readFromUser.nextLine();
			writeToServer.println(userRequest);
			if(userRequest.equals("quit"))
			{
				System.out.println("Ended Connection");
				break;
			}
			//READS SERVER'S RESPONSE
			String serverResponse=readFromServer.nextLine();
			System.out.println("Server Responded \n"+serverResponse);
		}
		}
		catch(IOException e)
		{e.printStackTrace();}
		
	}

}
