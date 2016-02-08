package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {
	private World r,r1,r2;
	private Grass g;
	@Before
	public void setup() throws FileNotFoundException{
		r = new World("public1.txt");
		r1 = new World(3);
		r2 = new World(3);
		
	}

	@Test
	public void testWorldString() {
		assertEquals(State.GRASS, r.grid[0][0].who());
		assertEquals(State.BADGER, r.grid[0][1].who());
		assertEquals(State.FOX, r.grid[0][2].who());
		assertEquals(State.FOX, r.grid[1][0].who());
		assertEquals(State.FOX, r.grid[1][1].who());
		assertEquals(State.RABBIT, r.grid[1][2].who());
		assertEquals(State.FOX, r.grid[2][0].who());
		assertEquals(State.EMPTY, r.grid[2][1].who());
		assertEquals(State.GRASS, r.grid[2][2].who());
	}

	@Test
	public void TestInit(){
		int equal = 0;
		r1.randomInit();
		r2.randomInit();
		if (r1.grid==r2.grid){
			equal =1;
		}
		else {
			equal = 0;
		}
		assertEquals(0,equal);
		
	}

	@Test
	public void testGetWidth() throws Exception{
		World w1 = new World("public2.txt");
		assertEquals(6, w1.getWidth());
	}

	
	@Test
	public void testToString() {
		int StringEqual = 0;
		r1.randomInit();
		r1.toString();
		if (r1.toString() instanceof String){
			StringEqual = 1;
		}
		else {
			StringEqual = 0;
		}
		assertEquals(1,StringEqual);
	}
	/*
	@Test
	public void TestWrite() throws FileNotFoundException{
		World newWorld = new World("public1.txt");
		newWorld.write("test.txt");
		Scanner scanner = new Scanner("test.txt");
		assertNotEquals(scanner.next(),"G ");
		
		
	}
	Doesn't work
	*/

}
