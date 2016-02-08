package edu.iastate.cs228.hw4;

/**
 *  
 * @author Fahmida
 *
 */

/**
 * 
 * This class evaluates input infix and postfix expressions. 
 *
 */

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
public class InfixPostfix 
{

	/**
	 * Repeatedly evaluates input infix and postfix expressions.  See the project description
	 * for the input description. It constructs a HashMap object for each expression and passes it 
	 * to the created InfixExpression or PostfixExpression object. 
	 *  
	 * @param args
	 * @throws UnassignedVariableException 
	 * @throws ExpressionFormatException 
	 * @throws FileNotFoundException 
	 **/
	public static void main(String[] args) throws ExpressionFormatException, UnassignedVariableException, FileNotFoundException 
	{
		// TODO 
		 HashMap<Character,Integer> variableTable = new HashMap<Character, Integer>();
		 
		
		 System.out.println("Evaluation of Infix and Postfix Expressions");
		 System.out.println("keys:1(standard input) 2(file input) 3(exit)");
		 while (true){
			 int trial =0;
			
			 System.out.println("Enter I before an infix expression ,P before a postfix expression");
				Scanner input = new Scanner(System.in);
				int key = input.nextInt();
				if (key==1){
					trial++;
					System.out.println("Trial i : "+trial);
					System.out.print("Expression : ");
					String first = input.next();
					
					if (first.equals("I")){
						String expression = input.nextLine().trim();
						InfixExpression exp = new InfixExpression(expression);
						System.out.println("Infix form: "+ exp.toString());
						System.out.println("Postfix form:"+exp.postfixString());
						exp.setVarTable(getValue(exp.toString()));
						System.out.println("Value:"+exp.evaluate());
					}
					
					
					else if (first.equals("P")){
						String expression = input.nextLine().trim();
						PostfixExpression ep = new PostfixExpression(expression);
						System.out.println("Postfix form:"+ep.toString());
						ep.setVarTable(getValue(ep.toString()));
						System.out.println("Value:"+ep.evaluate());
						
						
						
					}
					
					trial++;
					 
				}
				else if (key==2){
					trial++;
					System.out.println("Trial i : "+2);
					System.out.println("Input from a file");
					System.out.println("Enter name of file : ");
					String filename = input.next();
					File file = new File (filename);
					Scanner scan = new Scanner(file);
					boolean flag = true;
					while (scan.hasNextLine()){
						
						String line	=	scan.nextLine();
						
						System.out.println(line);
						Scanner temp = new Scanner(line);
						while (temp.hasNext()){
							String first = temp.next();
							if (first.equals("I")){
								
								String in = temp.nextLine();
								
								in.trim();
								InfixExpression exp = new InfixExpression(in);
								String express = exp.toString();
								
								for (int i = 0;i<express.length();i++){
									 char c = express.charAt(i);
									 
									 if (c>='a'&&c<='z'){
										 if (flag){
										 System.out.println("where ");}
										 System.out.print(""+scan.next());
										 
										 System.out.print(""+scan.next());
										 int value = Integer.parseInt(scan.next());
										 System.out.print(value);
										 
										 variableTable.put(c, value);
										 System.out.println();
										flag = false;
									 }
								}
								exp.setVarTable(variableTable);
								System.out.println();
								System.out.println("Infix form: "+ exp.toString());
								System.out.println("Postfix form:"+exp.postfixString().trim());
								System.out.println("Value:"+exp.evaluate());
								
								
							}
							else if (first.equals("P")) {
								String in = temp.nextLine();
								in.trim();
								System.out.println(in);
								PostfixExpression ep = new PostfixExpression(in);
								System.out.println("Postfix form:"+ep.postfixExpression);
								String express = ep.toString();
								flag = true;
								for (int i = 0;i<express.length();i++){
									 char c = express.charAt(i);
									 
									 if (c>='a'&&c<='z'){
										 if (flag){
											 System.out.println("where ");}
											System.out.print(""+scan.next());
											 
											System.out.print(""+scan.next());	
										 int value = Integer.parseInt(scan.next());
										 System.out.print(value);
										 variableTable.put(c, value);
										 System.out.println();
										flag = false; 
									 }
								}
								ep.setVarTable(variableTable);
								System.out.println("Value:"+ep.evaluate());
							}
							
						

}
					}
					scan.close();
					
					
				}
				else if (key==3){
					break;
				}
		 }
		
	}
	
	// helper methods if needed
	public static HashMap<Character,Integer> getValue(String input){
		 HashMap<Character,Integer> variableTable = new HashMap<Character, Integer>();
		boolean flag = true;
		 Scanner ep = new Scanner (System.in);
		 for (int i = 0; i<input.length();i++){
			 char c = input.charAt(i);
			 if (Character.isLowerCase(c)){
				 if (flag){
				 System.out.println("where ");}
				 System.out.print(c+"=");
				 int value = ep.nextInt();
				 variableTable.put(c, value);
				 flag = false;
			 }
		 }
		 
		 return variableTable;
	}
	
}
