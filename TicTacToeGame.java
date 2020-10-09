package com.capgemini.tictac;

import java.util.Scanner;

//usecase1//
/**
 * 
 * @author MAHI
 *
 */
public class TicTacToeGame {
	private static final String User = "User";
	private static final String Computer = "Computer";

	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	// usecase2//
	/**
	 * 
	 * @return
	 */

	public static char chooseLetter() {
		System.out.println("Enter the Letter:");
		Scanner sc = new Scanner(System.in);
		char letter = sc.next().charAt(0);
		return letter;
	}

	// usecase3//
	/**
	 * 
	 * @param board
	 */

	public static void showBoard(char[] board) {

		System.out.println("|" + board[0] + "|" + board[1] + "|" + board[2] + "|");
		System.out.println("----------");
		System.out.println("|" + board[3] + "|" + board[4] + "|" + board[5] + "|");
		System.out.println("----------");
		System.out.println("|" + board[6] + "|" + board[7] + "|" + board[8] + "|");
	}

	// usecase5//
	public static void checkMove(char[] board, int index, char playerLetter) {

		board[index] = playerLetter;
	}

	// usecase4//
	/**
	 * 
	 * @param board
	 * @param userinput
	 * @return
	 */
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
	/**
	 * 
	 * @return
	 */
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

	// usecase7//
	/**
	 * 
	 * @param board
	 * @param userinput
	 * @return
	 */
	public static String isWinning(char[] board, char userinput) {
		int count = 0;
		for (int i = 0; i < 10; i++)
			if (board[i] == ' ')
				count++;
		if(count==0)
			return "Tie";
		else if ((board[0] == userinput && board[1] == userinput && board[2] == userinput)
				|| (board[3] == userinput && board[4] == userinput && board[5] == userinput)
				|| (board[6] == userinput && board[7] == userinput && board[8] == userinput)
				|| (board[0] == userinput && board[3] == userinput && board[6] == userinput)
				|| (board[1] == userinput && board[4] == userinput && board[7] == userinput)
				|| (board[2] == userinput && board[5] == userinput && board[8] == userinput)
				|| (board[0] == userinput && board[4] == userinput && board[8] == userinput)
				|| (board[2] == userinput && board[4] == userinput && board[6] == userinput))

			return "Win";
		else 
			return "change";
		

	}

	private static char swapPlayerLetter(char userinput) {
		if (userinput == 'X')
			userinput = 'O';
		else
			userinput = 'X';
		return userinput;
	}

	private static String swapTurn(String firstPlayer) {
		if (firstPlayer == User)
			firstPlayer = Computer;
		else
			firstPlayer = User;
		return firstPlayer;
	}

	// usecase8//
	/**
	 * 
	 * @param board
	 * @param input
	 * @return
	 */
	private static int computerWin(char[] board, char userinput) {
		String computerWinPossibility;
		int computerWinPosition = 0;
        char[] boardCopy=new char[10];
        for(int i=0;i<10;i++) {
        	boardCopy[i]=board[i];
        }
		for (int i = 0; i < 10; i++) {
			if (boardCopy[i] == ' ') {
				boardCopy[i] = userinput;
				computerWinPossibility = isWinning(boardCopy, userinput);
				if (computerWinPossibility.contains("Win")) {
					computerWinPosition = i;
				}
				boardCopy[i] = ' ';
			}
		}
		return computerWinPosition;
	}

	public static void main(String[] args) {
		char computerLetter = ' ';
		char[] board = createBoard();
		showBoard(board);
		createBoard();
		Scanner sc = new Scanner(System.in);
		char playerLetter = chooseLetter();
		if (playerLetter == 'X')
			computerLetter = 'O';
		else
			computerLetter = 'X';
		String firstChance = switchCase();
		System.out.println("First chance : " + firstChance);
		char userinput = ' ';
		if (firstChance == User)
			userinput = playerLetter;
		else
			userinput = computerLetter;
		System.out.println("Input: " + userinput);
		String firstPlayer=firstChance;
		String Status;
		int computerPosition = 0,index;
		do {
			if (firstPlayer == Computer) {
				computerPosition = computerWin(board, userinput);
			}
				if (computerPosition != 0) {
					index = computerPosition;
				}
				 else {
					index=isLocationAvailable(board,userinput);
				}
				checkMove(board, index, userinput);
			System.out.println("\n Updated Board");
			showBoard(board);
			Status=isWinning(board,userinput);
			userinput=swapPlayerLetter(userinput);
			firstPlayer=swapTurn(firstPlayer);
		} while (Status.contains("change"));

	}
	
}
