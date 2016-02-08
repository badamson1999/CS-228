package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	/**
	 * Constructor 
	 * @param w: world
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	
	public Badger (World w, int r, int c, int a) 
	{
		// TODO 
		super(w,r,c,a);
		
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		// TODO 
		return State.BADGER;
	}
	
	/**
	 * A badger dies of old age or hunger, from isolation and attack by a group of foxes. 
	 * @param wNew     world of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(World wNew)
	{
		 //create a new empty array
		int[] array = new int [5];
		// call census method and pass that array
		// census method fills up the array
		census(array);
		if (age== BADGER_MAX_AGE){
			 Empty e = new Empty(wNew,row,column);
			 return e;
		}
		else if (array[BADGER]==1&&array[FOX]>1){
			Fox f =  new Fox(wNew,row,column,0);
			return f;
			
		}
		else if (array[BADGER]+array[FOX]>array[RABBIT]){
			Empty e = new Empty(wNew,row,column);
			return e;
		}
		else {
			Badger b = new Badger (wNew,row,column,age+1);
			return b;}
	}
	/**
	 *  
	 * returns String implementation of the Badger object
	 *  
	 */
	public String toString(){
		return "B" +this.age+" ";
	}
}
