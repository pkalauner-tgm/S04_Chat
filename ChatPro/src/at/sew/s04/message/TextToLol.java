package at.sew.s04.message;

public class TextToLol extends MessageDecorator {
	Message msg;

	public TextToLol(Message msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg.getMessage().replace("::))", "*lol*").replace(":)", "*lol*");
	}
}
