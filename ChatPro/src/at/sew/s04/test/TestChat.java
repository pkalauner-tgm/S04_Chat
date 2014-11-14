package at.sew.s04.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import at.sew.s04.Control;
import at.sew.s04.View;

public class TestChat {
	private Control c = new Control("localhost", 1555);
	private View v = c.getV();

	@Test
	public void testSendNormal() {
		v.bhost.doClick();
		v.setMsg("Hallo");
		v.send.doClick();
		assertEquals(true, v.getChat().contains("Ich: HHAALLLLOO"));
	}

	@Test
	public void testSendBadwordOn() {
		v.bhost.doClick();
		v.setMsg("Hallo fuck");
		// set on
		v.send.doClick();
		assertEquals(true, v.getChat().contains("Ich: HHAALLLLOO ****"));
	}

	@Test
	public void testSendBadwordOff() {
		v.bhost.doClick();
		v.setMsg("Hallo fuck");
		// set off
		v.send.doClick();
		assertEquals(true, v.getChat().contains("Ich: HHAALLLLOO FFUUCCKK"));
	}

	@Test
	public void testSendLol() {
		Control c = new Control("localhost", 1555);
		View v = c.getV();
		v.bhost.doClick();
		v.setMsg("Hallo :)");
		v.send.doClick();
		assertEquals(true, v.getChat().contains("Ich: HHAALLLLOO *lol*"));
	}

}
