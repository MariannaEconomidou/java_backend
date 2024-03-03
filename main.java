package Sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
     
		try(   //establish scoket communtication and wrap input and output streams to specific wrappers
				Socket s=new Socket("www.google.com",80);
				Scanner in=new Scanner(s.getInputStream());
				DataOutputStream out=new DataOutputStream(s.getOutputStream());
				)
		{
			out.writeUTF("hey"); //send message that does not apply to http protocol
			String response=in.nextLine(); // get answer by just reading the input stream
			System.out.println(response);
			//other Socket methods
			System.out.println(s.isClosed());
			System.out.println(s.isConnected());
			System.out.println(s.isInputShutdown());
			System.out.println(s.isOutputShutdown());
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("===================2====================================");
	 //Server Connection with Timeout for simple connection
		try(Socket s2=new Socket())
		{
			//connection attempt inside 
			s2.connect(new InetSocketAddress("www.google.gr",90081),1000);
		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			System.out.print("Connection time expired");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		System.out.println("========================3===============================");
		//Establish two way connection with timeout for reads
		
		try(Socket s3=new Socket("www.google.com",80);
			Scanner in=new Scanner(s3.getInputStream());
			DataOutputStream out=new DataOutputStream(s3.getOutputStream());)
		{
		  s3.setSoTimeout(10);
		  out.writeUTF("Blue");
		  System.out.println(in.nextLine());
		}catch(Exception e)
		{System.out.println(e);}
		
		
		
	}

}
