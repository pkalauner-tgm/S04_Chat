package at.sew.s04;

public class Model {
	private Client client;
	private View v;
	private String ip;
	private int port;

	public Model(View v, String ip, int port) {
		this.v = v;
		this.ip = ip;
		this.port = port;
		new Server(port, this);
	}
	
	/*
	 * @description Stellt eine Verbindung mit dem Partner her.
	 */
	public void connect() {
		client = new Client(ip, port);
	}
	
	/*
	 * @description Sendet die Nachricht an den Partner.
	 */
	public void send(String text) {
		client.send(text);
		chatAdd("Ich", text);
	}
	/*
	 * @param from Die Person die die Nachricht geschickt hat
	 * @param text Die Nachricht die geschickt oder empfangen wurde
	 */
	public void chatAdd(String from, String text) {
		v.update(from, text);
	}
}
