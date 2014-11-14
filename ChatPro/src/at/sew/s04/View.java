package at.sew.s04;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import at.sew.s04.message.BadWordFilter;
import at.sew.s04.message.ChatMessage;
import at.sew.s04.message.DoubleLetters;
import at.sew.s04.message.Message;
import at.sew.s04.message.TextToLol;
import at.sew.s04.message.ToUpperCase;

public class View extends JPanel {
	private static final long serialVersionUID = 1L;

	private Model m;
	private Control c;
	private JButton send, bhost;
	private JPanel p1, p2;
	private JTextField t1, host;
	private JTextArea t2;
	private boolean badWordFilterOn = true; // TODO

	public View(Model m, Control c) {
		p1 = new JPanel();
		p2 = new JPanel();
		t1 = new JTextField("");
		t2 = new JTextArea("");
		bhost = new JButton("verbinden");
		host = new JTextField("127.0.0.1");
		t2.setEditable(false);
		t1.setSize(100, 1100);
		JScrollPane sp = new JScrollPane(t2);
		this.m = m;
		this.c = c;
		send = new JButton("senden");
		p2.add(host);
		p2.add(bhost);
		this.t1.setText("Bitte verbinden sie sich zuerst mit ihrem Partner...");
		this.setLayout(new GridLayout(2, 2));
		this.add(sp);
		this.add(p2);
		this.add(t1);
		this.add(send);
		bhost.addActionListener(c);
		send.addActionListener(c);

	}

	public String getHost() {
		return host.getText();
	}

	public JButton getSend() {
		return send;
	}

	public JButton getBhost() {
		return bhost;
	}

	public String getMsg() {
		return t1.getText();
	}

	public void chatin() {
		this.t1.setText("");
	}

	public void update(String from, String content) {
		Message msg = new ChatMessage(content);
		if (badWordFilterOn)
			msg = new BadWordFilter(msg);
		
		msg = new ToUpperCase(msg);
		msg = new DoubleLetters(msg);
		msg = new TextToLol(msg);

		this.t2.append(from + ": " + msg.getMessage() + "\n");
	}
}
