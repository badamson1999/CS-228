package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.Random; 




/**
 * 
 * The world is represented as a square grid of size width X width. 
 *
 */
public class World 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public World(String inputFileName) throws FileNotFoundException
	{		
        // TODO 
		// 
		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid world in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done. 
		File file = new File(inputFileName);
		Scanner scanner = new Scanner(file);
		int count = 0;

		count = (scanner.nextLine().length())/3;
		scanner.close();
		scanner = new Scanner(file);
		grid = new Living[count][count];
		width = count;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				String living = scanner.next();
				if (living.charAt(0) == 'G'){
					Grass g = new Grass(this,i,j);
					grid[i][j] = g;
				}
				//
				else if (living.charAt(0)=='E'){
					Empty e = new Empty(this,i,j);
					grid[i][j] = e;
				}
				else if (living.charAt(0)=='F'){
					int age = (Integer.parseInt(living.substring(1))) ;
					Fox f = new Fox(this,i,j,age);
					grid[i][j] = f;
					
				}
				else if (living.charAt(0)=='R'){
					int age = (Integer.parseInt(living.substring(1))) ;
					Rabbit r = new Rabbit(this,i,j,age);
					grid[i][j] = r;
					
				}
				else if (living.charAt(0)=='B'){
					int age = (Integer.parseInt(living.substring(1)));
					Badger b = new Badger (this,i,j,age);
					grid[i][j] = b;
				}
				
	}
		}
		}
	
	/**
	 * Constructor that builds a w X w grid without initializing it. 
	 * @param width  the grid 
	 */
	public World(int w)
	{
		// TODO 
		width = w;
		grid = new Living[w][w];
	}
	
	
	public int getWidth()
	{
		// TODO  
		return width;
	}
	
	/**
	 * Initialize the world by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random();
		for (int i = 0; i<width;i++){
				for (int j =0;j<width;j++ ){
			int animal = generator.nextInt(5);
			if (animal==0){
				grid[i][j] = new Badger(this,i,j,0);
			}
			else if (animal==1){
				grid[i][j] = new Empty(this,i,j);
			}
			else if (animal == 2){
				grid[i][j] = new Fox (this,i,j,0);
			}
			else if (animal == 3){
				grid[i][j] = new Grass(this,i,j);
			}
			else if (animal == 4){
				grid[i][j] = new Rabbit(this,i,j,0);
			} 
				}
		}
		 
		// TODO 
	}
	
	
	/**
	 * Output the world grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		// TODO
		String world = "";
		// TODO
		for (int i = 0;i<width;i++ ){
			for (int j = 0;j<width;j++){
				
				world = world+grid[i][j].toString();
			
			}
			world = world +"\n";
		}
		return world;
	}
	

	/**
	 * Write the world grid to an output file.  Also useful for saving a randomly 
	 * generated world for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		// TODO 
		// 
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// PPO'P;
		
		// 3. Close the file. 
		File outFile = new File("outputFileName");
		PrintWriter in = new PrintWriter(outFile);
		in.write(this.toString());  
		
		in.close();
	}			
}
