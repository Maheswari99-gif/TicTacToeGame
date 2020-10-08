//usecase1//
package com.capgemini.tictac;

import java.util.Scanner;

public class TicTacToeGame {
	 public static void main(String[] args) {
		 TicTacToeGame obj =new TicTacToeGame();
		 obj.createBoard();
		obj.chooseLetter();
		 
	 }
	 public static void createBoard() {
		 char[] board =new char[10];
		 for(int i=0;i<10;i++) {
			 board[i]=' ';
		 }
	 }
     public static void chooseLetter() {
    	 System.out.println("Enter the Letter:");
    	 Scanner s= new Scanner(System.in);
    	 char c=s.next().charAt(0);
    	 if(c=='X') {
    		 System.out.println("Computer has choosen O");
    	 }
    	 else
    		 System.out.println("Computer has choosen X");
    		 
    	 
    	 
     }
}
