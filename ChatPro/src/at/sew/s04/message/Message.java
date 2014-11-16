package at.sew.s04.message;

/**
 * Stellt eine Nachricht dar
 * 
 * @author Paul Kalauner 4AHIT
 * @version 20141114.1
 *
 */
public abstract class Message {
	protected String content;

	/**
	 * Liefert die Nachricht zurueck
	 * 
	 * @return die Nachricht
	 */
	public String getMessage() {
		return this.content;
	}
}
