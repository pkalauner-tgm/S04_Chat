package at.sew.s04.message;

/**
 * TextToLol-Decorator<br>
 * Ersetzt ein ":)" mit "*lol*"
 * 
 * @author Paul Kalauner 4AHIT
 * @version 20141114.1
 *
 */
public class TextToLol extends MessageDecorator {
	private Message msg;

	/**
	 * Initialisiert TextToLol mit Angabe des Message Objektes
	 * 
	 * @param msg
	 *            das Message Objekt
	 */
	public TextToLol(Message msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		// Es muss sowohl ":)" als auch "::))" mit "*lol*" ersetzt werden, da es
		// möglich ist, dass der DoubleLetters Filter bereits angewandt wurde
		return msg.getMessage().replace("::))", "*lol*").replace(":)", "*lol*");
	}
}
