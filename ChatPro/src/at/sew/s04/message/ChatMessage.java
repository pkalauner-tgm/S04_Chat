package at.sew.s04.message;

/**
 * Implementierung von {@code Message}
 * 
 * @author Paul Kalauner 4AHIT
 * @version 20141114.1
 *
 */
public class ChatMessage extends Message {
	/**
	 * Initialisiert ein ChatMessage Objekt
	 * 
	 * @param msg
	 *            Nachrichteninhalt
	 */
	public ChatMessage(String msg) {
		content = msg;
	}
}
