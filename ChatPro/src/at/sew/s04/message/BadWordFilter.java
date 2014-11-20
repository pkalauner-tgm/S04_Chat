package at.sew.s04.message;

/**
 * BadWordFilter-Decorator<br>
 * Filtert boese Woerter
 * 
 * @author Paul Kalauner 4AHIT
 * @version 20141114.1
 *
 */
public class BadWordFilter extends MessageDecorator {
	/**
	 * kann erweitert werden
	 */
	private static final String[] badwords = { "fuck", "arschloch", "asshole" };
	private Message msg;

	/**
	 * Initialisiert BadWordFilter mit Angabe des Message Objektes
	 * 
	 * @param msg
	 *            das Message Objekt
	 */
	public BadWordFilter(Message msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return filterBadWords(msg.getMessage());
	}

	/**
	 * Filtert boese Woerter
	 * 
	 * @param msg
	 *            die urspruengliche Nachricht
	 * @return die gefilterte Nachricht
	 */
	private static String filterBadWords(String msg) {
		String out = msg;
		for (String cur : badwords)
			// (?i) fuer case insensitivity
			out = out.replaceAll("(?i)" + cur, "**");
		return out;
	}
}