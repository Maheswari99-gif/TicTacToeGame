//usecase1//
package com.capgemini.tictac;

import java.util.Scanner;

public class TicTacToeGame {
	
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}
	// usecase2//

	public static char chooseLetter() {
		System.out.println("Enter the Letter:");
		Scanner sc = new Scanner(System.in);
		char letter = sc.next().charAt(0);
		return letter;
	}

	public static void showBoard(char[] board) {

		System.out.println("|" + board[0] + "|" + board[1] + "|" + board[2] + "|");
		System.out.println("----------");
		System.out.println("|" + board[3] + "|" + board[4] + "|" + board[5] + "|");
		System.out.println("----------");
		System.out.println("|" + board[6] + "|" + board[7] + "|" + board[8] + "|");
	}
	public static void main(String[] args) {
		char computerLetter;
		char[] board=createBoard();
		char userinput = chooseLetter();
		if (userinput == 'X')
			computerLetter = 'O';
		else
			computerLetter = 'X';
		createBoard();
		showBoard(board);
	}
	private static void showBoard(Object board) {
		
	}
}
