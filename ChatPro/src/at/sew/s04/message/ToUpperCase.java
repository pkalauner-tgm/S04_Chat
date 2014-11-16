package at.sew.s04.message;

/**
 * ToUpperCase-Decorator<br>
 * Wandelt den gesamten Text in Grossbuchstaben um
 * 
 * @author Paul Kalauner 4AHIT
 * @version 20141114.1
 *
 */
public class ToUpperCase extends MessageDecorator {
	private Message msg;

	/**
	 * Initialisiert ToUpperCase mit Angabe des Message Objektes
	 * 
	 * @param msg
	 *            das Message Objekt
	 */
	public ToUpperCase(Message msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg.getMessage().toUpperCase();
	}
}
