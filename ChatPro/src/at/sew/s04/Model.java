package at.sew.s04;

public class Model {
	private Client client;
	private View v;

	public Model(View v, String ip, int port) {
		this.v = v;
		new Server(port, this);
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
