package edu.iastate.cs228.hw1;

/**
 * @author Fahmida
 */
/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param w: world
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	
	public Fox (World w, int r, int c, int a) 
	{
		// TODO
		super(w,r,c,a);
		
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		// TODO 
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param wNew     world of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(World wNew)
	{
		// TODO 
		 // call census method and pass that array
		// census method fills up the array
		int[] array = new int [5];
		census(array);
		if (age ==FOX_MAX_AGE ){
			Empty e = new Empty(wNew,row,column);
			return e;
		}
		else if (array[BADGER]>array[FOX]){
			Badger b  = new Badger (wNew,row,column,0);
			return b;
		}
		else if (array[BADGER]+array[FOX]>array[RABBIT]){
			Empty e = new Empty(wNew,row,column);
			return e;
		}
		
		else {
			Fox f = new Fox (wNew,row,column,age+1);
			return f; }
	}
	/**
	 *  
	 * returns String implementation of the Fox object
	 *  
	 */
	public String toString(){
		return "F"+this.age+" ";
	}
}
