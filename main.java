package inetaddr;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.net.Socket;
import java.io.IOException;

public class main {
	public static void print(InetAddress address) {
		System.out.println(address);
		System.out.println(address.getHostAddress());
		System.out.print(address.getHostName());
		System.out.println(Arrays.toString(address.getAddress()));
		System.out.println("=".repeat(20));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try {
    	  InetAddress address=InetAddress.getLocalHost();
    	  print(address);
    	  address=InetAddress.getByName("www.google.com");
    	  System.out.println(address);
          byte[] byteAddress=address.getAddress();
          print(address);
          
          
    	  
       }
       catch(UnknownHostException e) {
    	   System.out.println(e);	}
       
       
       try(Socket s=new Socket("www.google.com",80)){
    	   System.out.println(s.getInetAddress());
       }
       catch(UnknownHostException e) {
    	   e.printStackTrace();
       }
       catch(IOException e) {
    	   e.printStackTrace();
       }

}}
