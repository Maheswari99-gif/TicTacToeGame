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

	// public static void checkMove(char[] board,int index,char userinput) {
	// if(board[index]==' ') {
	// board[index]=userinput;
	// showBoard(board);
	// }
	// else
	// System.out.println("Not Empty");
	// }
	// usecase4//
	public static boolean isLocationAvailable(char[] board, int index, char userinput) {
		boolean emptyStatus;
		if (board[index] == ' ') {
			emptyStatus = true;
			System.out.println("Index is available");
		} else {
			emptyStatus = false;
			System.out.println("Index is not available");
		}
		return emptyStatus;
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
		boolean emptyStatus;
		do {
			System.out.println("Enter the index from 1 to 9");
			int index = sc.nextInt();
			emptyStatus = isLocationAvailable(board, index, userinput);
		}while (emptyStatus==false);
	}

	private static void showBoard(Object board) {

	}
}
