//usecase1//
package com.capgemini.tictac;

public class TicTacToeGame {
	 public static void main(String[] args) {
		 TicTacToeGame obj =new TicTacToeGame();
		 obj.createBoard();
		 System.out.println();
		 
	 }
	 public static void createBoard() {
		 char[] board =new char[10];
		 for(int i=0;i<10;i++) {
			 board[i]=' ';
		 }
	 }

}
