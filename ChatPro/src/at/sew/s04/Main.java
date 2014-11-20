package at.sew.s04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hier wird das Programm gestartet
 * 
 * @author Paul Kalauner 4AHIT
 * @version 20141114.1
 *
 */
public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);
	
	/**
	 * Eintrittspunkt des Programmes
	 * 
	 * @param args
	 *            [IP] [Port]
	 */
	public static void main(String[] args) {
		if (!checkArgs(args))
			System.exit(1);
	}

	/**
	 * Ueberprueft die Konsolenargumente<br>
	 * Hinweis: Diese Methode ist public um sie zu testen.
	 * 
	 * @param args
	 *            Argumente
	 * @return true wenn gueltig
	 */
	public static boolean checkArgs(String[] args) {
		if (args.length < 2) {
			LOG.info("Geben Sie die IP und den Port des Chat Partners an:\njava -jar Chat.jar <IP> <Port>");
			return false;
		}
		try {
			int port = Integer.parseInt(args[1]);
			new Control(args[0], port);
			return true;
		} catch (NumberFormatException nfe) {
			LOG.info("Ungueltiger Port");
			return false;
		}
	}
}
