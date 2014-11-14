
public class Model {
	private Server server;
	private Client client;
	private String chat;
	private View v;
	
	public Model(View v)
	{
		this.v = v;
		server = new Server(1555,this);
		chat = "";
	}
	public void verbinden(String host)
	{
		client = new Client(host,1555);
	}
	public void send(String text)
	{
		client.send(text);
		chatAdd("Ich:" + text);
		
	}
	public void chatAdd(String text)
	{
		chat += text + "\n";
		v.update(chat);
	}
	
	public String getChat()
	{
		return chat;
	}
}
