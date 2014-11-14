package at.sew.s04.message;

public class BadWordFilter extends MessageDecorator {
	private static final String[] badwords = { "scheiße", "fuck", "arschloch" };
	Message msg;

	public BadWordFilter(Message msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return filterBadWords(msg.getMessage());
	}

	private static String filterBadWords(String msg) {
		String out = msg;
		for (String cur : badwords)
			out = out.replaceAll("(?i)" + cur, "**");
		return out;
	}
}