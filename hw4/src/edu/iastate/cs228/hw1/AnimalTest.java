package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class AnimalTest {
private Animal a;
private World r;
	@Before
	public void setUp() throws FileNotFoundException {
		r = new World("public1.txt");
		a=(Badger)r.grid[0][1];
	}

	@Test
	public void testAnimal() {
		assertEquals(0,a.row);
		assertEquals(1,a.column);
	}

	@Test
	public void testMyAge() {
		
		assertEquals(0,a.age);
	}

}
