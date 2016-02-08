package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
import static org.junit.Assert.*;


import java.io.FileNotFoundException;

import org.junit.*;

public class BadgerTest  {
private Badger b;
private World r;
//private World w;
	@Before
	public void setup() throws FileNotFoundException{
		r = new World("public1.txt");
		b=(Badger)r.grid[0][1];
	}
	@Test
	public void whoTest(){
		assertEquals(State.BADGER, b.who());
		
		}
			
		
		
		
		

	@Test
	public void wNextTest() throws Exception{
		
		assertEquals(State.FOX, b.next(r).who());
		
		
	}
	
}