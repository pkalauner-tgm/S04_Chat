package at.sew.s04.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import at.sew.s04.Control;
import at.sew.s04.Model;
import at.sew.s04.View;

public class TestChat {

	@Test
	public void testSend() {
		Control c = new Control("localhost", 1555);
		View v = c.getV();
		Model m = c.getM();
		v.setMsg("Hallo");
		//v.send.
		//assertEquals("Partner: HHALLLLO\nIch: HHALLLLOO", v.getChat());
	}

}
