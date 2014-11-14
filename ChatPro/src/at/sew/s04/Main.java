package at.sew.s04;

public class Main {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Geben Sie die IP und den Port des Chat Partners an:\njava -jar Chat.jar <IP> <Port>");
			System.exit(0);
		}
		try {
			int port = Integer.parseInt(args[1]);
			new Control(args[0], port);
		} catch (NumberFormatException nfe) {
			System.out.println("Ungültiger Port");
			System.exit(0);
		}
	}
}
