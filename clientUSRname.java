package clientUsrName;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class clientUSRname {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Socket client=new Socket("127.0.0.1",1234))
		{
		  //Reads from user
			Scanner readFromUser=new Scanner(System.in);
			
		  //Creates communication Streams between client and Server		
			Scanner readFromServer=new Scanner(client.getInputStream(),StandardCharsets.UTF_8);
			PrintWriter writeToServer=new PrintWriter(client.getOutputStream(),true,StandardCharsets.UTF_8);
		    //Establishing a user name
			System.out.println("Provide a username");
			String usrn=readFromUser.nextLine();
			writeToServer.println(usrn);
		//Communication Loop
			while(true)
			{   System.out.println("Provide Request");
				String userRequest=readFromUser.nextLine();
				writeToServer.println(userRequest);
				if(userRequest.equals("quit")) {
					System.out.println("User ended communication...");
					break;}
				String response=readFromServer.nextLine();
				System.out.println(response);
				
			}
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
