/**purpose:Utility class have a different function and it used for reusability
 * @author kishorereddy
 * @version 1.0
 * @since 03-02-2020
 * @file Utility.java
*/
package com.bridgelabz.logicalprograms;
import java.util.Scanner;

public class Utility {
	Scanner scanner = new Scanner(System.in);
	
	/**this function is used to find winning percentage of player
	 * @param stack
	 * @param goal
	 */
	public void gamblerWinningCalculation(int stack,int goal) {
		int playerWins = 0;
		int noOftimes = 0;
		int playerLosses = 0;
		while (stack > 0 && stack <= goal) {
			double res = Math.random();
			if (res >= 0.5) {
				playerWins++;
				stack++;
			} else if (res < 0.5) {
				playerLosses++;
				stack--;
			}
			noOftimes++;
		}
		System.out.println(playerWins + " times won out of " + noOftimes);
		double winningPercentage = playerWins / (double) noOftimes * 100;
		double lossPercentage = playerLosses / (double) noOftimes * 100;
		System.out.println("win % is: " + String.format("%.2f", winningPercentage));
		System.out.println("loss % is: " + String.format("%.2f", lossPercentage));
		return;
	}
	
	/**this method is used to generate couponcodes
	 * @param charactersOfCoupon
	 * @return String couponcode
	 */
	public String couponCodeGenerator(char[] charactersOfCoupon) {
		int couponLength = 10000000;
		double randomNumber = Math.random();
		int random = (int) (randomNumber * couponLength);
		String couponCode = "";
		while (random > 0) {
			couponCode = couponCode + (charactersOfCoupon[random % charactersOfCoupon.length]);
			random /= charactersOfCoupon.length;
		}
		return couponCode;
	}
}


