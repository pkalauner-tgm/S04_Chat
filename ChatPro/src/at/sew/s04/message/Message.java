package at.sew.s04.message;

public abstract class Message {
	String content;

	/**
	 * Liefert die Nachricht zurueck
	 * 
	 * @return die Nachricht
	 */
	public String getMessage() {
		return this.content;
	}
}
