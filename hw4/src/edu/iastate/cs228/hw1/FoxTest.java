package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
public class FoxTest {

	
	private Fox f;
	private World r;
	@Before
	public void setup() throws FileNotFoundException{
		r = new World("public1.txt");
		f=(Fox)r.grid[0][2];
	}
	@Test
	public void testWho() {
		assertEquals(State.FOX, f.who());
	}
	@Test
	public void testNext() {
		assertEquals(State.EMPTY, f.next(r).who());
	}

	@Test
	public void testToString() {
		String expected = "F0 ";
		assertEquals(expected,f.toString());
	}


}
