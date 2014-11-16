package at.sew.s04.test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.sew.s04.Main;

/**
 * Testklasse fuer die Main-Klasse
 * 
 * @author Paul Kalauner 4AHIT
 * @version 20141114.1
 */
public class TestMain {

	/**
	 * Testet ob keine angegebenen Argumente erkannt werden
	 */
	@Test
	public void testNoArguments() {
		assertEquals(false, Main.checkArgs(new String[] {}));
	}

	/**
	 * Testet, ob ein ungueltiger Port erkannt wird
	 */
	@Test
	public void testInvalidPort() {
		assertEquals(false, Main.checkArgs(new String[] { "localhost", "blabla" }));
	}

	/**
	 * Testet, ob gueltige Argumente erkannt werden
	 */
	@Test
	public void testValid() {
		assertEquals(true, Main.checkArgs(new String[] { "localhost", "1234" }));
	}

}
