package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Fahmida
 */
public class EmptyTest {
	private Empty e;
	private World r;
	@Before
	public void setup() throws FileNotFoundException{
		r = new World("public1.txt");
		e=(Empty)r.grid[2][1];
	}
	
	@Test
	public void testWho() {
		assertEquals(State.EMPTY, e.who());
	}

	@Test
	public void testNext() {
		
		assertEquals(State.FOX, e.next(r).who());
	}

	@Test
	public void testToString() {
		String expected = "E ";
		assertEquals(expected,e.toString());
	}

}
