package at.sew.s04;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Verbindet sich zum Partner
 * 
 * @author Seyyid Tiryaki
 * @version 16.11.2014
 */
public class Client {

	private String hostName;
	private int portNumber;
	private Socket socket;
	private PrintStream out;
	private static final Logger LOG = LogManager.getLogger(Client.class);

	/**
	 * Verbindet sich zum Partner
	 * 
	 * @param host
	 *            IP des Partners
	 * @param port
	 *            Port des Partners
	 */
	public Client(String host, int port) {
		hostName = host;
		portNumber = port;
		try {
			socket = new Socket(hostName, portNumber);
			out = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			LOG.error("Keine Verbindung zum Partner!");
			System.exit(1);
		}
	}

	/**
	 * sendet eine Nachricht
	 * 
	 * @param fromUser
	 *            Sender
	 */
	public void send(String fromUser) {
		out.println(fromUser);
	}
}
