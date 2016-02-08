package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
import static org.junit.Assert.*;

import java.io.*;

import org.junit.Before;
import org.junit.Test;

public class LivingTest {
	
	private World r,r1;
	@Before
	public void setup() throws FileNotFoundException{
		r = new World("public1.txt");
		r1 = new World("public2.txt");
	}
	

	@Test
	public void testCensus() throws Exception{
		int a1[] = new int[5];
		int a2[]= {1,0,2,1,0};
		r.grid[0][0].census(a1);
		
		assertEquals(a2[0], a1[0]);
		assertEquals(a2[1], a1[1]);
		assertEquals(a2[2], a1[2]);
		assertEquals(a2[3], a1[3]);
		assertEquals(a2[4], a1[4]);
		
	}
	@Test
	public void testCensus1() throws Exception{
		int a1[] = new int[5];
		int a2[]= {2,3,2,0,2};
		r1.grid[1][1].census(a1);
		assertEquals(a2[0], a1[0]);
		assertEquals(a2[1], a1[1]);
		assertEquals(a2[2], a1[2]);
		assertEquals(a2[3], a1[3]);
		assertEquals(a2[4], a1[4]);
		
	}
	
}
