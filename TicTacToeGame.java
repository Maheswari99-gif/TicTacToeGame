//usecase1//
package com.capgemini.tictac;

import java.util.Scanner;

public class TicTacToeGame {
	public static void main(String[] args) {
        char computerLetter;
        char Letter = chooseLetter();
        if(Letter=='X')
        	computerLetter='O';
        else
        	computerLetter='X';
		createBoard();
		
	}

	public static void createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
			board[i] = ' ';
		}
	}
	//usecase2//

	public static char chooseLetter() {
		System.out.println("Enter the Letter:");
		Scanner sc = new Scanner(System.in);
		char computerLetter;
		char letter = sc.next().charAt(0);
		return letter;
}
}
