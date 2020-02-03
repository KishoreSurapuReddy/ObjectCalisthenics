/**Gambler is implementing the Gambler game and finding the player winning percentage
 * @author kishorereddy
 * @version 1.0
 * @since 03-02-2020
 * @file Gambler.java
 */
package com.bridgelabz.logicalprograms;

public class Gambler {
	int stackAmount;
	int goalAmount;
	
	//constructor of Gambler
	public Gambler(int stackAmount,int goalAmount) {
		this.stackAmount = stackAmount;
		this.goalAmount = goalAmount;
	}
	
	public int getStackAmount() {
		return this.stackAmount;
	}
	
	public int getGoalAmount() {
		return this.goalAmount;
	}
	
	public static void main(String[] args) {
		Utility util = new Utility();
		System.out.println("Enter intial stack amount of player: ");
		int stack = util.scanner.nextInt();
		System.out.println("Enter goal amount of player :");
		int goal = util.scanner.nextInt();
		Gambler gambler = new Gambler(stack, goal);
		int stackAmount = gambler.getStackAmount();
		int goalAmount = gambler.getGoalAmount();
		util.gamblerWinningCalculation(stackAmount,goalAmount);
	}
}
