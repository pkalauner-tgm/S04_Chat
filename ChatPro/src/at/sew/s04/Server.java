package at.sew.s04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Diese Klasse erzeugt einen Thread der auf die Nachricht des Partners wartet.
 * 
 * @author Seyyid Tiryaki
 * @version 16.11.2014
 */
public class Server extends Thread {

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
		try (ServerSocket serverSocket = new ServerSocket(portNumber);
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				m.chatAdd("Partner", inputLine);

			}
		} catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}

}
