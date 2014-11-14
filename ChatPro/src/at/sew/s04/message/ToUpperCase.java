package at.sew.s04.message;

public class ToUpperCase extends MessageDecorator {
	Message msg;

	public ToUpperCase(Message msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg.getMessage().toUpperCase();
	}
}
