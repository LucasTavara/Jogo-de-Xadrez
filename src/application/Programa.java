package application;


import chess.chessMath;

public class Programa {

	public static void main(String[] args) {
		
		chessMath chessmath = new chessMath();
		UI.printBoard(chessmath.getPieces());
		
		

	}

}
