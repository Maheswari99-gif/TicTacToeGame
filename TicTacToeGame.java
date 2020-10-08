//usecase1//
package com.capgemini.tictac;

import java.util.Scanner;

public class TicTacToeGame {
	private static final String User = null;
	private static final String Computer = null;

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
	// usecase5//

	public static void checkMove(char[] board, int index, char userinput) {

		board[index] = userinput;
	}

	// usecase4//
	public static int isLocationAvailable(char[] board, char userinput) {
		Scanner sc = new Scanner(System.in);
		int index;
		boolean emptyStatus;
		do {
			System.out.println("Enter index to place letter " + userinput);
			index = sc.nextInt();
			if (board[index] == ' ') {
				emptyStatus = true;
				System.out.println("Index available");
			} else {
				emptyStatus = false;
				System.out.println("Index not available");
			}
		} while (emptyStatus == false);
		return index;
	}

	// usecase6//
	public static String switchCase() { 
		String userTurn = " ";
		int user = (int) Math.floor(Math.random() * 10) % 2;
		System.out.println("User turn");
		if (user == 0)
			userTurn = User;
		else
			userTurn = Computer;
		return userTurn;
	}

	public static void main(String[] args) {
		char computerLetter;
		char[] board = createBoard();
		Scanner sc = new Scanner(System.in);
		char userinput = chooseLetter();
		if (userinput == 'X')
			computerLetter = 'O';
		else
			computerLetter = 'X';
		createBoard();
		showBoard(board);
		int index = isLocationAvailable(board, userinput);
		checkMove(board, index, userinput);
	}

	private static void showBoard(Object board) {

	}
}
