package at.sew.s04.message;

public class DoubleLetters extends MessageDecorator {
	Message msg;

	public DoubleLetters(Message msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return doubleLetters(msg.getMessage());
	}

	private static String doubleLetters(String msg) {
		StringBuilder sb = new StringBuilder();

		for (char c : msg.toCharArray())
			sb.append(c + "" + (c == ' ' ? "" : c));

		return sb.toString();
	}
}