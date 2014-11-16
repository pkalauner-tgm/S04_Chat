package at.sew.s04.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import at.sew.s04.Control;
import at.sew.s04.View;

/**
 * Testet die GUI
 * 
 * @author Paul Kalauner 4AHIT
 * @version 20141114.1
 *
 */
public class TestChat {
	private Control c = new Control("localhost", 1555);
	private View v = c.getV();

	/**
	 * Testet das Senden einer Nachricht
	 */
	@Test
	public void testSendNormal() {
		v.getBConnect().doClick();
		v.setMsg("Hallo");
		v.getBSend().doClick();
		assertEquals(true, v.getChat().contains("Ich: HHAALLLLOO"));
	}

	/**
	 * Testet die Funktion des BadWordFilters
	 */
	@Test
	public void testSendBadwordOn() {
		v.getBConnect().doClick();
		v.setMsg("Hallo fuck");
		v.setBadWordFilterOn(true);
		v.getBSend().doClick();
		assertEquals(true, v.getChat().contains("Ich: HHAALLLLOO ****"));
	}

	/**
	 * Testet den ausgeschaltenen BadWordFilter
	 */
	@Test
	public void testSendBadwordOff() {
		v.getBConnect().doClick();
		v.setMsg("Hallo fuck");
		v.setBadWordFilterOn(false);
		v.getBSend().doClick();
		assertEquals(true, v.getChat().contains("Ich: HHAALLLLOO FFUUCCKK"));
	}

	/**
	 * Testet, ob ein ":)" zu "*lol*" umgewandelt wird
	 */
	@Test
	public void testSendLol() {
		Control c = new Control("localhost", 1555);
		View v = c.getV();
		v.getBConnect().doClick();
		v.setMsg("Hallo :)");
		v.getBSend().doClick();
		assertEquals(true, v.getChat().contains("Ich: HHAALLLLOO *lol*"));
	}

}
