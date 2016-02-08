package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class RabbitTest {
	private Rabbit r;
	private World w;
	@Before
	public void setUp() throws FileNotFoundException {
		w = new World("public1.txt");
		r=(Rabbit)w.grid[1][2];
	}

	@Test
	public void testWho() {
		assertEquals(State.RABBIT, r.who());
	}

	@Test
	public void testNext() {
		assertEquals(State.FOX, r.next(w).who());
	}

	@Test
	public void testToString() {
		String expected = "R0 ";
		assertEquals(expected,r.toString());
	}

}
