package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GrassTest {
	private Grass g;
	private World r;
	@Before
	public void setUp() throws Exception {
		r = new World("public1.txt");
		g=(Grass)r.grid[0][0];
	}

	@Test
	public void testWho() {
		assertEquals(State.GRASS, g.who());
	}

	@Test
	public void testNext() {
		assertEquals(State.GRASS, g.next(r).who());
	}

	@Test
	public void testToString() {
		String expected = "G ";
		assertEquals(expected,g.toString());
	}

}
