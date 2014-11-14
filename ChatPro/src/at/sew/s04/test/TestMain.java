package at.sew.s04.test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.sew.s04.Main;

public class TestMain {

	@Test
	public void testNoArguments() {
		assertEquals(false, Main.checkArgs(new String[] {}));
	}
	
	@Test
	public void testInvalidPort() {
		assertEquals(false, Main.checkArgs(new String[] {"localhost", "blabla"}));
	}
	
	@Test
	public void testValid() {
		assertEquals(true, Main.checkArgs(new String[] {"localhost", "1234"}));
	}

}
