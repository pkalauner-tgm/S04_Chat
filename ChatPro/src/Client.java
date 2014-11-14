import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

	private String hostName;
	private int portNumber;
	private Socket socket;
	private PrintStream out;
	
	public Client(String host, int port) {
		hostName = host;
		portNumber = port;
		System.out.println("Connecting...");
		try {
			socket = new Socket(hostName, portNumber);
			out = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String fromUser) {
		try 
		{
			out.println(fromUser);
			System.out.println("Client:" + fromUser);
			
		} catch (Exception e) {
            System.err.println("ERROR");
        } 
		
	}
	public void setHost(String host)
	{
		hostName = host;
	}
}
