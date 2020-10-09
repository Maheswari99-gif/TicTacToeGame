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
	static Scanner sc = new Scanner(System.in);

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
	public static void checkMove(char[] board, int index, char userinput) {

		while (true) {
			if (isLocationAvailable(board, index)) {
				System.out.println("Position is free");
				board[index] = userinput;
				showBoard(board);
				break;

			} else {
				System.out.println("Position isnt free, enter another position");
				showBoard(board);
				index = sc.nextInt();
				checkMove(board, index, userinput);
				break;
			}

		}
	}

	// usecase4//
	/**
	 * 
	 * @param board
	 * @param userinput
	 * @return
	 */
	public static boolean isLocationAvailable(char[] board, int index) {
		if (board[index] == ' ')
			return true;

		else
			return false;

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
		if (count == 0)
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
			return "Change";

	}

	public static char swapPlayerLetter(char userinput, char playerLetter, char computerLetter) {
		if (userinput == playerLetter)
			userinput = computerLetter;
		else
			userinput = playerLetter;
		return userinput;
	}

	public static String swapTurn(String firstPlayer) {
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
		int computerWinPosition = 10;
		char[] boardCopy = new char[10];
		for (int i = 0; i < 10; i++) {
			boardCopy[i] = board[i];
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

	// usecase9//
	/**
	 * 
	 * @param board
	 * @param userinput
	 * @param playerLetter
	 * @param computerLetter
	 * @return
	 */

	public static int computerBlock(char[] board, char userinput, char playerLetter, char computerLetter) {
		String playerWinPossibility;
		int positionForPlayerWin = 10;
		char previousInput = swapPlayerLetter(userinput, playerLetter, computerLetter);
		for (int i = 0; i < 10; i++) {
			if (board[i] == ' ') {
				board[i] = previousInput;
				playerWinPossibility = isWinning(board, previousInput);
				if (playerWinPossibility.contains("Win")) {
					positionForPlayerWin = i;
					board[i] = ' ';
					break;
				}
				board[i] = ' ';
			}
		}
		return positionForPlayerWin;
	}

	/**
	 * 
	 * @param board
	 * @return
	 */

	public static int availableCorner(char[] board) {
		int indexOfCorner = 10;
		if (board[0] == ' ')
			indexOfCorner = 0;
		else if (board[2] == ' ')
			indexOfCorner = 2;
		else if (board[6] == ' ')
			indexOfCorner = 6;
		else if (board[8] == ' ')
			indexOfCorner = 8;
		return indexOfCorner;
	}

	// usecase10//
	/**
	 * 
	 * @param board
	 * @param indexC
	 * @param computerLetter
	 */
	public static void computerMove(char[] board, int indexC, char computerLetter) {
		while (true) {
			if (isLocationAvailable(board, indexC)) {
				System.out.println("Index is free");
				board[indexC] = computerLetter;
				showBoard(board);
				break;

			} else {
				System.out.println("Index isnt free, enter another index");
				showBoard(board);
				indexC = (int) (Math.floor(Math.random() * 10 % 9));
				System.out.println("Computer choose " + indexC);
				computerMove(board, indexC, computerLetter);
				break;
			}

		}
	}
	//usecase11//
	/**
	 * 
	 * @param board
	 * @return
	 */
	public static int availableCentreOrSide(char[] board) {
		int indexOfSide = 0;
		if(board[4]==' ')
			indexOfSide = 4;
		else if(board[3]==' ')
			indexOfSide = 3;
		else if(board[1]==' ')
			indexOfSide = 1;
		else if(board[5]==' ')
			indexOfSide = 5;
		else if(board[7]==' ')
			indexOfSide = 7;
		return indexOfSide;
	}

	public static void main(String args[]) {

		char[] board = createBoard();
		showBoard(board);
		char playerLetter = chooseLetter();
		char computerLetter = ' ';
		if (playerLetter == 'X') {
			computerLetter = 'O';
			System.out.println("Players symbol is " + playerLetter + " and Computers lettter is " + computerLetter);
		} else {
			computerLetter = 'X';
			System.out.println("Players symbol is " + playerLetter + " and Computers lettter is " + computerLetter);
		}
		String firstPlayer = switchCase();
		System.out.println("First chance " + firstPlayer);
		char userinput = ' ';
		if (firstPlayer == User)
			userinput = playerLetter;
		else
			userinput = computerLetter;

		System.out.println("Input taken for firstPlayer is " + userinput);
		int turn = 0;
		do {
			int positionComputer = 0;
			int blockPlayer = 0;
			int cornerPosition = 0;
			int centreSidePosition = 0;
			if (firstPlayer == Computer) {
				showBoard(board);
				positionComputer = computerWin(board, userinput);
				blockPlayer = computerBlock(board, userinput, playerLetter, computerLetter);
				if (positionComputer != 10) {
					System.out.println("Computer will win if " + positionComputer + " is choosen");
					board[positionComputer] = userinput;
					showBoard(board);
				} else if (blockPlayer != 10) {
					System.out.println("Player will win if " + blockPlayer + " is choosen.  Block that");
					board[blockPlayer] = userinput;
					showBoard(board);
				} else if (cornerPosition != 10) {
					System.out.println("Computer choose corner position " + cornerPosition);
					board[cornerPosition] = userinput;
					showBoard(board);
				} 
				else if(centreSidePosition != 10) {
					System.out.println("Computer choose position "+cornerPosition);
					board[centreSidePosition] = userinput;
					showBoard(board);
				}
				else {
					System.out.println("Enter computer position ");
					int indexC = (int) (Math.floor(Math.random() * 10 % 9));
					System.out.println("Computer choose position " + indexC);
					checkMove(board, indexC, userinput);
					showBoard(board);
				}
			} else {
				System.out.println("Enter player position");
				int index = sc.nextInt();
				checkMove(board, index, userinput);
			}
			String output = isWinning(board, userinput);
			System.out.println("Output is " + output);
			if (output == "Win")
				turn = 1;//usecase12//
			else if (output == "Change") {
				userinput = swapPlayerLetter(userinput, playerLetter, computerLetter);
				firstPlayer = swapTurn(firstPlayer);
				turn = 0;
			} else
				turn = 1;
		} while (turn != 1);
	}

}
