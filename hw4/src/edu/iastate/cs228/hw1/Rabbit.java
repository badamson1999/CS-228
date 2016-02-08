package edu.iastate.cs228.hw1;

/**
 * @author Fahmida
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param w: world  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 * 
	 */
	
	public Rabbit (World w, int r, int c, int a) 
	{
		// TODO 
		super(w,r,c,a);
	}
		
	// Rabbit occupies the square.
	public State who()
	{
		// TODO  
		return State.RABBIT;  
	}
	
	/**
	 * A rabbit dies of old age or hunger, or it is eaten if there are as many 
	 * foxes and badgers in the neighborhood.  
	 * @param wNew     world of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(World wNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a rabbit. 
		int[] array = new int [5];
		census(array);
		if (age ==RABBIT_MAX_AGE){
			Empty e = new Empty(wNew,row,column);
			return e;
		}
		else if (array[GRASS]==0){
			
			Empty e = new Empty(wNew,row,column);
			return e;
			
		}
		
		else if (array[BADGER]+array[FOX]>=array[RABBIT]&&array[FOX]>array[BADGER]){
			Fox f = new Fox (wNew,row,column,0);
			return f;
		}
		else if (array[BADGER]>array[RABBIT]) {
			Badger b = new Badger(wNew,row,column,0);
			return b;
			
			
		}
		else{
			Rabbit r = new Rabbit (wNew,row,column,age+1);
			return r; }
 
	}
	/**
	 * return string representation of the Rabbit object 
	 * 
	 */
	public String toString(){
		return "R"+this.age+" ";
	}
}
