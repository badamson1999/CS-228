package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PredatorPreyTest {
	private World w,w1;
	
	@Before
	public void setUp() throws Exception {
		w = new World("public2.txt");
		w1 = new World(w.getWidth());
		
	}
	private static void updateWorld(World wOld, World wNew)
	{
		// TODO 
		// 
		// For every life form (i.e., a Living object) in the grid wOld, generate  
		// a Living object in the grid wNew at the corresponding location such that 
		// the former life form changes into the latter life form. 
		// 
		// Employ the method next() of the Living class.
		for (int i= 0;i<wOld.getWidth();i++){
			for (int j = 0; j<wOld.getWidth();j++){
				wNew.grid[i][j] = wOld.grid[i][j].next(wNew);
			
				
			}
		}
	}
	@Test
	public void testUpdateWorld() {
		updateWorld(w,w1);
		//Checks for objects returned in the first row in new world
		assertEquals(State.EMPTY, w1.grid[0][0].who());
		assertEquals(State.FOX, w1.grid[0][1].who());
		assertEquals(State.FOX, w1.grid[0][2].who());
		assertEquals(State.EMPTY, w1.grid[0][3].who());
		assertEquals(State.RABBIT, w1.grid[0][4].who());
		assertEquals(State.GRASS, w1.grid[0][5].who());
		//Checks for objects returned in the second row in new world
		assertEquals(State.FOX, w1.grid[1][0].who());
		assertEquals(State.EMPTY, w1.grid[1][1].who());
		assertEquals(State.EMPTY, w1.grid[1][2].who());
		assertEquals(State.BADGER, w1.grid[1][3].who());
		assertEquals(State.GRASS, w1.grid[1][4].who());
		assertEquals(State.RABBIT, w1.grid[1][5].who());
		assertEquals(State.EMPTY, w1.grid[2][0].who());
		assertEquals(State.RABBIT, w1.grid[2][1].who());
		assertEquals(State.EMPTY, w1.grid[2][2].who());
		assertEquals(State.EMPTY, w1.grid[2][3].who());
		assertEquals(State.BADGER, w1.grid[2][4].who());
		assertEquals(State.GRASS, w1.grid[2][5].who());
		//Checks for objects returned in the third row in new world
		assertEquals(State.EMPTY, w1.grid[3][0].who());
		assertEquals(State.RABBIT, w1.grid[3][1].who());
		assertEquals(State.RABBIT, w1.grid[3][2].who());
		assertEquals(State.RABBIT, w1.grid[3][3].who());
		assertEquals(State.BADGER, w1.grid[3][4].who());
		assertEquals(State.GRASS, w1.grid[3][5].who());
		//Checks for objects returned in the fourth row in new world
		assertEquals(State.EMPTY, w1.grid[4][0].who());
		assertEquals(State.BADGER, w1.grid[4][1].who());
		assertEquals(State.GRASS, w1.grid[4][2].who());
		assertEquals(State.GRASS, w1.grid[4][3].who());
		assertEquals(State.RABBIT, w1.grid[4][4].who());
		assertEquals(State.EMPTY, w1.grid[4][5].who());
		//Checks for objects returned in the fifth row in new world
		assertEquals(State.GRASS, w1.grid[5][0].who());
		assertEquals(State.GRASS, w1.grid[5][1].who());
		assertEquals(State.GRASS, w1.grid[5][2].who());
		assertEquals(State.BADGER, w1.grid[5][3].who());
		assertEquals(State.RABBIT, w1.grid[5][4].who());
		assertEquals(State.RABBIT, w1.grid[5][5].who());
		
	
		
	}

	

}
