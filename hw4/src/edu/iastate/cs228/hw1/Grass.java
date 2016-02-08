package edu.iastate.cs228.hw1;

/**
 * @author Fahmida
 */

/**
 * Grass remains if more than rabbits in the neighborhood;
 * otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	/**
	 * Constructor 
	 * @param w: world
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Grass (World w, int r, int c) 
	{
		// TODO 
		super(w,r,c);
		
	}
	/**
	 * The square is covered by grass
	 */
	
	public State who()
	{
		// TODO  
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits in the neighborhood. Rabbits may also 
	 * multiply fast enough to take over Grass. 
	 */
	public Living next(World wNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for grass. 
		int[] array = new int [5];
		census(array);
		if (array[RABBIT]>= 3 * array[GRASS]){
			Empty e = new Empty (wNew,row,column);
			return e;
		}
		else if (array[RABBIT]>=3){
			Rabbit r = new Rabbit (wNew,row,column,0);
			return r;
		}
		else{
			Grass g = new Grass(wNew,row,column);
			return g; }
	}
	/**
	 * return string representation of the Grass object 
	 * 
	 */
	 public String toString(){
		 return "G ";
	 }
}
