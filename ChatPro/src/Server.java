import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends Thread{
	
	private int portNumber;
	private Model m;
	
	public Server(int port, Model m)
	{
		portNumber = port;
		this.m = m;
		super.start();
		
	}
	
	public void run()
	{
		 try(
		         ServerSocket serverSocket = new ServerSocket(portNumber);
		         Socket clientSocket = serverSocket.accept();
	             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		         ){
		        
		            String inputLine;

		            while ((inputLine = in.readLine()) != null) {
		            	m.chatAdd("Partner:" + inputLine);
		                
		            }
		        } catch (IOException e) {
	                System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
		            System.out.println(e.getMessage());
		        }
	}
	
}
