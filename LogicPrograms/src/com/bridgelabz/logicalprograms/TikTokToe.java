/**TikTokToe have different functions and it will be used to implement the game
 * @author kishorereddy
 * @version 1.0
 * @since 03-02-2020
 * @file TikTokToe
 */
package com.bridgelabz.logicalprograms;

public class TikTokToe {
	private char[][] board;
	private char currentPlayer;
	
	//constructor for TikTokToe
	public TikTokToe() {
		board = new char[3][3];
		currentPlayer = 'X';
		initializeBoard();
	}
    
	//to initialize the board
	public void initializeBoard() {
		printRow();
	}
	
    //initializing row of board
	public void printRow() {
		for(int row = 0 ; row < board.length ; row++) {
			printColoumn(row);
		}
	}
    
	//initializing coloumn of board
	public void printColoumn(int row) {
		for(int coloumn = 0 ; coloumn < board.length ; coloumn++) {
			board[row][coloumn] = '-';
		}
	}
	
	//printing board
	public void printBoard() {
		System.out.println("-------------");
		printBoardRow();
	}
    
	//printing row of board
	public void printBoardRow() {
		for(int row = 0 ; row < board.length ; row++) {
			System.out.print("|");
			printColoumnBoard(row);
		}
	}
    
	//printing coloumn of board
	public void printColoumnBoard(int row) {
		for(int coloumn=0 ; coloumn < board.length ; coloumn++) {
			System.out.print(board[row][coloumn]+" |");
		}
		System.out.println();
		System.out.println("-------------");
	}
	
	//method to changePlayer
	public void changePlayer() {
		if(currentPlayer == 'X') {
			currentPlayer = 'O';
			return;
		}
		currentPlayer = 'X';
	}
	
	//to return currentPlayer
	public char currentPlayer() {
		return currentPlayer;
	}
	
	//method to check wheather board is full or not
	@SuppressWarnings("unused")
	public boolean isBoardFull() {
		for(int row = 0 ; row < board.length ; row++) {
			return checkColoumn(row);
		}
		return true;
	}
	
	public boolean checkColoumn(int row) {
		for(int coloumn = 0 ; coloumn < board.length ; coloumn++) {
			if(board[row][coloumn] == '-') {
				return false;
			}
		}
		return true;
	}
	
	//method to check player won or not
	public boolean isWinner() {
		return (checkRows() || checkColoumns() || checkDiagonals());
	}
    
	//checking diagonals of board
	public boolean checkDiagonals() {
		return ((checkRowColoumn(board[0][0],board[1][1],board[2][2]) == true) || (checkRowColoumn(board[0][2],board[1][1],board[2][0]) == true));
	}
    
	//checkin coloumns of board
	public boolean checkColoumns() {
		for(int coloumn = 0 ; coloumn < board.length ; coloumn++) {
			if(checkRowColoumn(board[0][coloumn],board[1][coloumn],board[2][coloumn]) == true) {
				return true;
			}
		}
		return false;
	}
    
	//checking rows of board
	public boolean checkRows() {
		for(int row = 0 ; row < board.length ; row++) {
			if(checkRowColoumn(board[row][0],board[row][1],board[row][2]) == true) {
				return true;
			}
		}
		return false;
	}
	
	//checking position of row and coloumn
	public boolean checkRowColoumn(char positionone, char positiontwo, char positionthree) {
		return ((positionone != '-') && (positiontwo == positionone) && (positionthree == positiontwo));
	}
	
	//method to place mark by player
	@SuppressWarnings("unused")
	public boolean placeMark(int rowposition , int coloumnposition) {
		for(int row = 0 ; row < board.length ; row++) {
			return placeMarkColoumn(row);
		}
		return false;
	}

	private boolean placeMarkColoumn(int row) {
		for(int coloumn = 0 ; coloumn < board.length ; coloumn++) {
			if(board[row][coloumn] == '-') {
				board[row][coloumn] = currentPlayer;
				return true;
			}
		}
		return false;
	}
}

