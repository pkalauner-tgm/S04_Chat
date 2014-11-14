package at.sew.s04.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import at.sew.s04.message.BadWordFilter;
import at.sew.s04.message.ChatMessage;
import at.sew.s04.message.DoubleLetters;
import at.sew.s04.message.Message;
import at.sew.s04.message.TextToLol;
import at.sew.s04.message.ToUpperCase;

/**
 * Testklasse fuer die verschiedenen Nachrichtenfilter
 * 
 * @author Paul Kalauner 4AHIT
 * @version 20141114.1
 */
public class TestMessageFilters {

	/**
	 * Testet, ob der BadwordFilter boese Woerter zensiert.
	 */
	@Test
	public void testBadwordFilter() {
		Message msg = new ChatMessage("aaa scheiße bbb");
		msg = new BadWordFilter(msg);
		assertEquals("aaa ** bbb", msg.getMessage());
	}

	/**
	 * Testet, ob der BadwordFilter boese Woerter zensiert.<br>
	 * (In diesem Fall kommt kein boeses Wort vor)
	 */
	@Test
	public void testBadwordFilterNoBadword() {
		Message msg = new ChatMessage("aaa bbb ccc");
		msg = new BadWordFilter(msg);
		assertEquals("aaa bbb ccc", msg.getMessage());
	}

	/**
	 * Testet, ob der Smiley ":)" zu "*lol*" wird
	 */
	@Test
	public void testLol() {
		Message msg = new ChatMessage("aaa :) ccc");
		msg = new TextToLol(msg);
		assertEquals("aaa *lol* ccc", msg.getMessage());
	}

	/**
	 * Testet, ob der Smiley ":)" zu "*lol*" wird<br>
	 * (In diesem Fall kommt kein Smiley vor)
	 */
	@Test
	public void testLolNoSmiley() {
		Message msg = new ChatMessage("aaa bbb ccc");
		msg = new TextToLol(msg);
		assertEquals("aaa bbb ccc", msg.getMessage());
	}
	
	/**
	 * Testet, ob Buchstaben "geschrien" werden
	 */
	@Test
	public void testToUpperCase() {
		Message msg = new ChatMessage("aaa bbb ccc");
		msg = new ToUpperCase(msg);
		assertEquals("AAA BBB CCC", msg.getMessage());
	}
	
	/**
	 * Testet, ob Buchstaben verdoppelt werden<br>
	 * Leerzeichen sollen nicht verdoppelt werden
	 */
	@Test
	public void testDoubleLetters() {
		Message msg = new ChatMessage("abc def ghi");
		msg = new DoubleLetters(msg);
		assertEquals("aabbcc ddeeff gghhii", msg.getMessage());
	}
}
