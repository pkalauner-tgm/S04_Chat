package at.sew.s04;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import at.sew.s04.message.BadWordFilter;
import at.sew.s04.message.ChatMessage;
import at.sew.s04.message.DoubleLetters;
import at.sew.s04.message.Message;
import at.sew.s04.message.TextToLol;
import at.sew.s04.message.ToUpperCase;

/**
 * @author Seyyid Tiryaki
 * @version 16.11.2014
 * 
 */
public class View extends JPanel {
	private static final long serialVersionUID = 1L;

	private Control c;
	private JButton bSend, bConnect;
	private JCheckBox cbBadwordFilter;
	private JPanel panelSend, panelConnect;
	private JTextField ownMessage;
	private JTextArea taChat;
	private JScrollPane sp;

	/**
	 * 
	 * @param m
	 *            Model
	 * @param c
	 *            Control
	 */
	public View(Model m, Control c) {
		panelSend = new JPanel();
		panelConnect = new JPanel();
		ownMessage = new JTextField(40);
		taChat = new JTextArea();
		bConnect = new JButton("verbinden");
		taChat.setEditable(false);
		ownMessage.setSize(100, 1100);
		sp = new JScrollPane(taChat, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.c = c;
		this.cbBadwordFilter = new JCheckBox("Badword-Filter an");
		bSend = new JButton("senden");
		bSend.setEnabled(false);
		ownMessage.setEnabled(false);
		panelSend.add(ownMessage);
		panelSend.add(bSend);
		panelConnect.add(cbBadwordFilter);
		panelConnect.add(bConnect);
		DefaultCaret caret = (DefaultCaret) taChat.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		this.ownMessage.setText("Bitte verbinden sie sich zuerst mit ihrem Partner...");
		this.setLayout(new BorderLayout());
		this.add(panelConnect, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		this.add(panelSend, BorderLayout.SOUTH);
		bConnect.addActionListener(this.c);
		bSend.addActionListener(this.c);
	}

	/**
	 * @return Der Button der zum Senden der Nachricht gedrückt wird, wird
	 *         zurückgegeben
	 */
	public JButton getBSend() {
		return bSend;
	}

	/**
	 * @return Der Button der zum Verbinden gedrueckt wird, wird zurückgegeben
	 */
	public JButton getBConnect() {
		return bConnect;
	}

	/**
	 * @return Die Nachricht die geschickt werden soll, wird zurückgegeben
	 */
	public String getMsg() {
		return ownMessage.getText();
	}

	/**
	 * @return Der gesamte Chatverlauf wird zurückgegeben
	 */
	public String getChat() {
		return taChat.getText();
	}

	/**
	 * @param on
	 *            Stellt den BadWordFilter an oder aus
	 */
	public void setBadWordFilterOn(boolean on) {
		cbBadwordFilter.setSelected(on);
	}

	/**
	 * Setzt den Inhalt des Nachricht-Textfelds
	 * 
	 * @param msg
	 *            neuer Inhalt
	 */
	public void setMsg(String msg) {
		this.ownMessage.setText(msg);
	}

	/**
	 * wird nach dem Verbinden aufgerufen<br>
	 * Alle Textfelder werden fuer das Chatten zurueckgesetzt
	 */
	public void chatin() {
		this.ownMessage.setEnabled(true);
		this.ownMessage.setText("");
		this.bConnect.setEnabled(false);
		this.bSend.setEnabled(true);
	}

	/**
	 * Fuegt eine Nachricht in das Chatfenster hinzu
	 * 
	 * @param from
	 *            Sender der Nachricht
	 * @param content
	 *            Inhalt der Nachricht
	 */
	public void update(String from, String content) {
		Message msg = new ChatMessage(content);
		if (cbBadwordFilter.isSelected())
			msg = new BadWordFilter(msg);

		msg = new ToUpperCase(msg);
		msg = new DoubleLetters(msg);
		msg = new TextToLol(msg);

		this.taChat.append(from + ": " + msg.getMessage() + "\n");
	}
}
