/** StackBalancedParenthesis is used to add the characters into stack and checking arthemetic
 * expression is balanced or not
 * @author kishorereddy
 * @vesrion 1.0
 * @since 04-03-2020
 * @file StackBalancedParenthesis
*/
package com.bridgelabz.datastructures;
import com.bridgelabz.util.Stack;

public class StackBalancedParenthesis {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<Character>();
		//given string expression
		String expression = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/*(4+3))";
		for (int index = 0; index < expression.length(); index++) {
			char character = expression.charAt(index);
			if (character == '(' || character == ')') {
				stack.pushCharacter(character);
			}
		}
		stack.popCharacter();
		boolean result = stack.balancedStack();
		if (result == true) {
			System.out.println("given arthemetic expression was balanced ");
			return;
		} 
		System.out.println(" given arthemetic expression was not balanced");
	}
}
