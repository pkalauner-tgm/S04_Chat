import java.awt.GridLayout;

import javax.swing.*;

public class View extends JPanel{
	
	private Model m;
	private Control c;
	private JButton send,bhost; 
	private JPanel p1,p2;
	private JTextField t1,host;
	private JTextArea t2;
	public View(Model m, Control c)
	{
		p1 = new JPanel();
		p2 = new JPanel();
		t1 = new JTextField("");
		t2 = new JTextArea("");
		bhost = new JButton("verbinden");
		host = new JTextField("127.0.0.1          ");
		t2.setEditable(false);
		t1.setSize(100,1100);
		JScrollPane sp = new JScrollPane(t2);   
		this.m = m;
		this.c = c;
		send = new JButton("senden");
		p2.add(host);
		p2.add(bhost);
		this.t1.setText("Bitte verbinden sie sich zuerst mit ihrem Partner...");
		this.setLayout(new GridLayout(2,2));
		this.add(sp);
		this.add(p2);
		this.add(t1);
		this.add(send);
		bhost.addActionListener(c);
		send.addActionListener(c);
		
	}
	
	public String getHost()
	{
		return host.getText();
	}
	
	public JButton getSend()
	{
		return send;
	}
	public JButton getBhost()
	{
		return bhost;
	}
	
	public String getMsg()
	{
		return t1.getText();
	}
	
	public void chatin()
	{
		this.t1.setText("");
	}
	public void update(String chat)
	{
		this.t2.setText("");
		this.t2.append(chat+"\n");
	}
}
