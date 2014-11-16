package at.sew.s04;

/**
 * @author Seyyid Tiryaki
 * @version 16.11.2014
 */
public class Model {
	private Client client;
	private View v;
	private String ip;
	private int port;

	/**
	 * 
	 * @param v View
	 * @param ip IP des Partners
	 * @param port Port des Partners
	 */
	public Model(View v, String ip, int port) {
		this.v = v;
		this.ip = ip;
		this.port = port;
		new Server(port, this);
	}

	/**
	 * Stellt eine Verbindung mit dem Partner her.
	 */
	public void connect() {
		client = new Client(ip, port);
	}

	/**
	 * Sendet die Nachricht an den Partner.
	 * @param text die zu sendende Nachricht
	 */
	public void send(String text) {
		client.send(text);
		chatAdd("Ich", text);
	}

	/**
	 * Fuegt eine Nachricht in das Textfeld hinzu
	 * 
	 * @param from
	 *            Die Person die die Nachricht geschickt hat
	 * @param text
	 *            Die Nachricht die geschickt oder empfangen wurde
	 */
	public void chatAdd(String from, String text) {
		v.update(from, text);
	}
}
