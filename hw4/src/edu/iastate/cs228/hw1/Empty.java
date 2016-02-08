package edu.iastate.cs228.hw1;

/**
 * @author Fahmida
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	/**
	 * Constructor 
	 * @param w: world
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Empty (World w, int r, int c) 
	{
		// TODO 
		super(w,r,c);
	}
	/**
	 *  the square is Empty. 	 
	 */
	public State who()
	{
		// TODO 
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or 
	 * remain empty. 
	 * @param wNew     world of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(World wNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for corresponding survival rules. 
		//create a new empty array
		int[] array = new int [5];
		// call census method and pass that array
		// census method fills up the array
		census(array);
		if (array[RABBIT]>1){
			Rabbit r = new Rabbit (wNew,row,column,0);
			return r;	
		}
		else if (array[FOX]>1){
			Fox f = new Fox (wNew,row,column,0);
			return f;
		}
		else if (array[BADGER]>1){
			Badger b =  new Badger (wNew,row,column,0);
			return b;
		}
		else if (array[GRASS]>=1){
			Grass g = new Grass (wNew,row,column);
			return g;
		}
		
		else {
			Empty e = new Empty (wNew,row,column);
			return e; }
		
	}
	/**
	 *  
	 * returns String implementation of the Empty object
	 *  
	 */
	public String toString(){
		return "E"+" ";
	}
}
