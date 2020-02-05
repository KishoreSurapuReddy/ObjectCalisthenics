/** StackBalancedParenthesis is used to add the characters into stack and checking arthemetic
 * expression is balanced or not
 * @author kishorereddy
 * @vesrion 1.0
 * @since 04-03-2020
 * @file StackBalancedParenthesis
*/
package com.bridgelabz.datastructures;
import com.bridgelabz.util.Stack;

public class StackBalancedParenthesis<T> {
	static Stack<Character> stack = new Stack<Character>();
	static int openbrace=0;
	static int closebrace=0;
	
	//method to check expression is balanced or not
	public static boolean balancedStack() {
		boolean isbalanced = false;
		if (openbrace == closebrace) {
			isbalanced = true;
		}
		return isbalanced;
	}

	public static void main(String[] args) throws Exception {
		//given string expression
		String expression = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/*(4+3)";
		for (int index = 0; index < expression.length(); index++) {
			char character = expression.charAt(index);
			if (character == '(' || character == ')') {
				stack.pushCharacter(character);
			}
		}
		char data = 0;
		System.out.println(stack.sizeOfStack());
		for (int index = 0; index < stack.sizeOfStack(); index++) {
			char character = expression.charAt(index);
			if (character == '(' || character == ')') {
				data = stack.popCharacter(character);
			}
			if(data == '(') {
				openbrace++;
				System.out.print("count is:"+openbrace);
			}else if(data == ')') {
				closebrace++;
				System.out.print(closebrace);
			}
		}
		boolean result = balancedStack();
		if (result == true) {
			System.out.println("given arthemetic expression was balanced ");
			return;
		} 
		System.out.println(" given arthemetic expression was not balanced");
	}
}
