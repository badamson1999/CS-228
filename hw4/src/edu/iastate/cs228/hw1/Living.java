package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */


/**
 * 
 * Living refers to the life form occupying a square in a world grid. It is a 
 * superclass of Empty, Grass, and Animal, the latter of which is in turn a superclass
 * of Badger, Fox, and Rabbit. Living has two abstract methods awaiting implementation. 
 *
 */
public abstract class Living 
{
	protected World world; // the world in which the life form resides
	protected int row;     // location of the square on which 
	protected int column;  // the life form resides
	
	// constants to be used as indices. 
	protected static final int BADGER = 0; 
	protected static final int EMPTY = 1; 
	protected static final int FOX = 2; 
	protected static final int GRASS = 3; 
	protected static final int RABBIT = 4; 
	
	public static final int NUM_LIFE_FORMS = 5; 
	
	// life expectancies 
	public static final int BADGER_MAX_AGE = 4; 
	public static final int FOX_MAX_AGE = 6; 
	public static final int RABBIT_MAX_AGE = 3; 
	
	
	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a world. 
	 * @param population  counts of all life forms
	 * 
	 */
	/**
	 * Constructor 
	 * @param w: world
	 * @param r: row position 
	 * @param c: column position
	 * @param a:  
	 */
	public Living(World world,int row, int column){
		this.world = world;
		this.row = row;
		this.column = column;
	}
	/**
	 *Count the numbers of Badgers, Empties, Foxes, Grasses, and Rabbits  
  	*	in the 3 by 3 neighborhood centered at this Living object.  Store the 
	 *counts in the array population[] at indices 0, 1, 2, 3, 4, respectively.
	  
	 */
	protected void census(int population[ ])
	{		
		// TODO 
		// iterate through the neighbor elements to count the number of neighboring objects
		//  
		// 
		// 
		
		for (int i =row-1;i<=row+1;i++){
			for (int j = column -1;j<=column+1;j++){
				//if its going out of bounds then just start over again
				 if (i>=world.getWidth() || i<0 || j>=world.getWidth() || j<0){
					
					 continue;
				 }
				 //check the neighboring elements and increase the number of living objects occupying the square
				if (world.grid[i][j].who()==State.BADGER){
					population[BADGER]++;}
				if (world.grid[i][j].who()==State.EMPTY){
					population[EMPTY]++;
					
				}
				if (world.grid[i][j].who()==State.FOX){
					population[FOX]++;
					
				}
				if (world.grid[i][j].who()==State.RABBIT){
					population[RABBIT]++;
				}
				if (world.grid[i][j].who()==State.GRASS){
					population[GRASS]++;
				}
				
				
				
			}
		}
	}

	/**
	 * Gets the identity of the life form on the square.
	 * @return State
	 */
	public abstract State who();
	// To be implemented in each class of Badger, Empty, Fox, Grass, and Rabbit. 
	// 
	// There are five states given in State.java. Include the prefix State in   
	// the return value, e.g., return State.Fox instead of Fox.  
	
	/**
	 * Determines the life form on the square in the next cycle.
	 * @param  wNew  world of the next cycle
	 * @return Living 
	 */
	public abstract Living next(World wNew); 
	// To be implemented in the classes Badger, Empty, Fox, Grass, and Rabbit. 
	// 
	// For each class (life form), carry out the following: 
	// 
	// 1. Obtains counts of life forms in the 3X3 neighborhood of the class object. 

	// 2. Applies the survival rules for the life form to determine the life form  
	//    (on the same square) in the next cycle.  These rules are given in the  
	//    project description. 
	// 
	// 3. Generate this new life form at the same location in the world wNew.      

}
