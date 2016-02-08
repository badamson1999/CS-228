package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
import java.io.FileNotFoundException;
import java.util.Scanner; 


/**
 * 
 * The PredatorPrey class performs the predator-prey simulation over a grid world 
 * with squares occupied by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class PredatorPrey 
{
	/**
	 * Update the new world from the old world in one cycle. 
	 * @param wOld  old world
	 * @param wNew  new world 
	 */
	public static void updateWorld(World wOld, World wNew)
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
	
	/**
	 * Repeatedly generates worlds either randomly or from reading files. 
	 * Over each world, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		// TODO 
		// 
		// Generate predator-prey simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random world, 2 to read a world from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 
		// 2. Print out standard messages as given in the project description. 
		// 
		// 3. For convenience, you may define two worlds even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the world 
		//    odd from the world even; in an odd numbered cycle, generate even 
		//    from odd. 
		int i = 0;
		
		while (true){
			System.out.println("The Predator-Prey Stimulator keys: 1(random world) 2(file input) 3(exit)");
			Scanner input = new Scanner(System.in);
			int key = input.nextInt();
			// if key =1 generate a random world by calling randomInit method
			if (key==1){
			
			i++;
			System.out.println("Trial i : "+1);
			System.out.println("Random world");
			System.out.println("Enter grid width : ");
			int width = input.nextInt();
			World oldWorld = new World(width);
			// generate a random world
			oldWorld.randomInit();
			System.out.println("Enter the number of cycles : ");
			int cycles = input.nextInt();
			// print the intitial world
			System.out.print ("Initial World\n"+oldWorld.toString());
			
			for (int j = 0; j<cycles;j++){
			
				
				 World newWorld = new World(width);
				updateWorld(oldWorld,newWorld);
			
				
				oldWorld=newWorld;
				
				}
			//outputs the final world
			System.out.print("Final World\n"+oldWorld.toString());
			}
		
			
				
				
			
		
		else if (key == 2){
			i++;
			System.out.println("Trial i : "+2);
			System.out.println("World input from a file");
			System.out.println("Enter name of file : ");
			String filename = input.next();
			World oldWorld = new World(filename);
			System.out.println("Enter the number of cycles : ");
			
			int cycles = input.nextInt();
			//outputs the old world
			System.out.println(oldWorld);
			for (int j = 0; j<cycles;j++){
				
				World newWorld = new World(oldWorld.getWidth());
				
				updateWorld(oldWorld,newWorld);
				
				oldWorld=newWorld;
				
				
					
				
			
			
		}
			// outputs the final world after the cycles
			System.out.print("Final World\n"+oldWorld.toString());	
		
		}
		else if (key == 3){
			// Exits the program 
			break;
			
		}
		}
		
		                // the world after an odd number of cycles
		
		// 4. Print out initial and final worlds only.  No intermediate worlds should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate worlds.)
		// 
		// 5. You may save some randomly generated worlds as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated. 
	}
}
