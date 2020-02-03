/**TiKTokToe class is implementing the tikToktoe game
 * @author kishorereddy
 * @version 1.0
 * @since 03-02-2020
 * @file TikTokToe.java
 */
package com.bridgelabz.logicalprograms;
import java.util.Scanner;

public class TikToktoeGame {
    
	//main method to start execution from here
	public static void main(String[] args) {
		TikTokToe game = new TikTokToe();
		Scanner scanner = new Scanner(System.in);
		game.initializeBoard();
		System.out.println("---- TikToktoe ----");
		do {
			game.printBoard();
			int rowposition;
			int coloumnposition;
			do {
				System.out.println("Player "+game.currentPlayer()+" place a mark at empty position ");
				rowposition = scanner.nextInt();
				coloumnposition = scanner.nextInt();
			}while(!game.placeMark(rowposition, coloumnposition));
			game.changePlayer();
		}while(!(game.isBoardFull()) && !(game.isWinner()));
		if((game.isBoardFull()) && !(game.isWinner())) {
			System.out.println("the game was tie!");
		}
		System.out.println("current board layout ");
		game.printBoard();
		game.changePlayer();
		System.out.println(game.currentPlayer()+" WINS..");
		scanner.close();
	}
}
