package at.sew.s04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Diese Klasse erzeugt einen Thread der auf die Nachricht des Partners wartet.
 * 
 * @author Seyyid Tiryaki
 * @version 16.11.2014
 */
public class Server extends Thread {
	private static final Logger LOG = LogManager.getLogger(Server.class);
	private int portNumber;
	private Model m;

	/**
	 * @param port
	 *            Der Port an dem Der Thread auf die Nachricht wartet.
	 * @param m
	 *            Model
	 */
	public Server(int port, Model m) {
		portNumber = port;
		this.m = m;
		super.start();
	}

	public void run() {
		
		try (ServerSocket serverSocket = new ServerSocket(portNumber); Socket clientSocket = serverSocket.accept(); BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				m.chatAdd("Partner", inputLine);
			}
			LOG.info("Ihr Partner hat die Verbindung getrennt!");
			System.exit(1);
		} catch (IOException e) {
		}
	}

}
