package at.sew.s04;

public class Main {
	public static void main(String[] args) {
		if (!checkArgs(args))
			System.exit(1);
	}

	/**
	 * Ueberprueft die Konsolenargumente<br>
	 * Hinweis: Diese Methode ist public um sie zu testen.
	 * @param args Argumente
	 * @return true wenn gueltig
	 */
	public static boolean checkArgs(String[] args) {
		if (args.length < 2) {
			System.out.println("Geben Sie die IP und den Port des Chat Partners an:\njava -jar Chat.jar <IP> <Port>");
			return false;
		}
		try {
			int port = Integer.parseInt(args[1]);
			new Control(args[0], port);
			return true;
		} catch (NumberFormatException nfe) {
			System.out.println("Ungültiger Port");
			return false;
		}
	}
}
