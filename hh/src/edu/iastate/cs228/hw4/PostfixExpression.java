package edu.iastate.cs228.hw4;

/**
 *  
 * @author Fahmida
 *
 */

/**
 * 
 * This class evaluates a postfix expression using one stack.    
 *
 */

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PostfixExpression extends Expression {
	private int leftOperand; // left operand for the current evaluation step
	private int rightOperand; // right operand for the current evaluation step

	private PureStack<Integer> operandStack; // stack of operands

	/**
	 * Constructor stores the input postfix string and initializes the operand
	 * stack.
	 * 
	 * @param st
	 *            input postfix string.
	 * @param varTbl
	 *            hash map that stores variables from the postfix string and
	 *            their values.
	 */
	public PostfixExpression(String st, HashMap<Character, Integer> varTbl) {
		super(st, varTbl);
		operandStack = new ArrayBasedStack();
		postfixExpression = super.removeExtraSpaces(st);
	}

	/**
	 * Constructor supplies a default hash map.
	 * 
	 * @param s
	 */
	public PostfixExpression(String s) {
		// TODO
		super(s);
		operandStack = new ArrayBasedStack();
		postfixExpression = super.removeExtraSpaces(s);
	}

	/**
	 * Outputs the postfix expression according to the format in the project
	 * description. Needs to first call the method toStringHelper() from the
	 * class Expression.
	 */
	@Override
	public String toString() {
		// TODO
		return postfixExpression.replace("( ", "(").replace(" )", ")");
	}

	/**
	 * Resets the postfix expression.
	 * 
	 * @param st
	 */
	public void resetPostfix(String st) {
		postfixExpression = st;
	}

	/**
	 * Scan the postfixExpression and carry out the following:
	 * 
	 * 1. Whenever an integer is encountered, push it onto operandStack. 2.
	 * Whenever an operator is encountered, invoke it on the two elements popped
	 * from operandStack, and push the result back onto the stack. 3. On
	 * encountering a character that is not a digit, an operator, or a blank
	 * space, stop the evaluation.
	 * 
	 * @return value of the postfix expression
	 * @throws ExpressionFormatException
	 *             with one of the messages below:
	 * 
	 *             -- "Invalid character" if encountering a character that is
	 *             not a digit, an operator or a whitespace (blank, tab); --
	 *             "Too many operands" if operandStack is non-empty at the end
	 *             of evaluation; -- "Too many operators" if getOperands()
	 *             throws NoSuchElementException; -- "Divide by zero" if
	 *             division or modulo is the current operation and rightOperand
	 *             == 0; -- "0^0" if the current operation is "^" and
	 *             leftOperand == 0 and rightOperand == 0; -- self-defined
	 *             message if the error is not one of the above.
	 * 
	 *             UnassignedVariableException if the operand as a variable does
	 *             not have a value stored in the hash map. In this case, the
	 *             exception is thrown with the message
	 * 
	 *             -- "Variable <name> was not assigned a value", where <name>
	 *             is the name of the variable.
	 * @throws UnassignedVariableException
	 * 
	 */
	public int evaluate() throws ExpressionFormatException,
			UnassignedVariableException {
		// TODO
		Scanner scan = new Scanner(postfixExpression);
		while (scan.hasNext()) {
			String token = scan.next();
			if (isInt(token)) {
				int item = Integer.parseInt(token);
				operandStack.push(item);
				
				continue;
			} else if (token.length() > 1) {
				throw new ExpressionFormatException("Invalid string");
			}

			char c = token.charAt(0);
			if (isOperator(c)) {
				try {
					getOperands();
				} catch (NoSuchElementException Exception) {

					throw new ExpressionFormatException("Too many operators");

				}

				int result = compute(c);
				operandStack.push(result);
			} 
			else if (isVariable(c)) {
				
				if (varTable.get(c) == null) {
					throw new UnassignedVariableException("" + c
							+ "was not assigned a value");
				} 
				
					//System.out.println(varTable.get(c));
					operandStack.push(varTable.get(c));
					//System.out.println(operandStack.peek());
				

			} else {

				throw new ExpressionFormatException("Invalid character " + c);

			}

		}
		
		int ret = operandStack.pop();
		
		if (!operandStack.isEmpty()) {
			throw new ExpressionFormatException("Too many operands "+operandStack.size());
		}

		scan.close();
		return ret;
	}

	/**
	 * Pops the right and left operands from operandStack, and assign them to
	 * rightOperand and leftOperand, respectively. The stack must have at least
	 * two entries. Otherwise, throws NoSuchElementException.
	 */
	private void getOperands() throws NoSuchElementException {
		// TODO
		if (operandStack.size() < 2)
			throw new NoSuchElementException();
		rightOperand = operandStack.pop();
		leftOperand = operandStack.pop();
	}

	/**
	 * Computes "leftOperand op rightOprand".
	 * 
	 * @param op
	 *            operator that acts on leftOperand and rightOperand.
	 * @return
	 * @throws ExpressionFormatException
	 */
	private int compute(char op) throws ExpressionFormatException {
		// TODO
		int value = 0;
		
		if (op == '+')
			value = rightOperand + leftOperand;
		if (op == '-')
			value =  leftOperand-rightOperand;
		if (op == '*')
			value = rightOperand * leftOperand;
		if (op == '/') {
			if (rightOperand == 0) {
				throw new ExpressionFormatException("Divide by zero");
			}
			value = leftOperand / rightOperand;
		}

		if (op == '%')
			value =  leftOperand%rightOperand;
		if (op == '^') {

			if (rightOperand == 0 && leftOperand == 0)
				throw new ExpressionFormatException("Both operands are zero");
			double operand1 = (double)leftOperand;
			double operand2 = (double)rightOperand;
			value =(int) Math.pow(operand1,operand2 ) ;
		}

		return value; // TO MODIFY
	}
}
