package at.sew.s04.message;

/**
 * DoubleLetters-Decorator<br>
 * Verdoppelt jeden Buchstaben
 * 
 * @author Paul Kalauner 4AHIT
 * @version 20141114.1
 *
 */
public class DoubleLetters extends MessageDecorator {
	private Message msg;

	/**
	 * Initialisiert DoubleLetters mit Angabe des Message Objektes
	 * 
	 * @param msg
	 *            das Message Objekt
	 */
	public DoubleLetters(Message msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return doubleLetters(msg.getMessage());
	}

	/**
	 * verdoppelt jeden Buchstaben
	 * 
	 * @param msg
	 *            die urspruengliche Nachricht
	 * @return Nachricht mit verdoppelten Buchstaben
	 */
	private static String doubleLetters(String msg) {
		StringBuilder sb = new StringBuilder();

		for (char c : msg.toCharArray())
			sb.append(c + "" + (c == ' ' ? "" : c));

		return sb.toString();
	}
}