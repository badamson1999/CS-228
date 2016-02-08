package edu.iastate.cs228.hw1;
/**
 * @author Fahmida
 */
/*
 * This class is to be extended by the Badger, Fox, and Rabbit classes. 
 */
public abstract class Animal extends Living implements MyAge
{
	protected int age;   // age of the animal 

	/**
	   * Constructs an animal object with the given world,row,column and age
	   * @param world 
	   *   the world animal is occupying
	   *  @param row
	   *  	the row in the grid which the animal occupies
	   *   @param column 
	   *   	the column in the grid which the animal occupies
	   *   @param age
	   *   the age of the animal
	   */
	public Animal(World w,int row,int column,int age){
		super(w,row,column);
		this.age = age;
		
	}
	 /**
	   * Returns the age of Animal
	   * @return
	   *   age of animal
	   */
	
	public int myAge()
	{
		// TODO 
		
		return age;
	}
}
