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

	public void connect() {
		client = new Client(ip, port);
	}

	public void send(String text) {
		client.send(text);
		chatAdd("Ich", text);
	}

	public void chatAdd(String from, String text) {
		v.update(from, text);
	}
}
