package application;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessPosition;
import chess.chessMath;
import chess.chessPiece;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chessMath chessMath = new chessMath();
		List<chessPiece> captured = new ArrayList<>();
		
		while(true) {
			try {
			 UI.clearScreen();
			 UI.printMatch(chessMath, captured);
			 System.out.println();
			 System.out.print("Source: ");
			 ChessPosition source = UI.readChessPosition(sc);
			 System.out.println();
		
			 boolean[][] possibleMoves = chessMath.possibleMoves(source);
			 UI.clearScreen();
			 UI.printBoard(chessMath.getPieces(), possibleMoves);
			 
			 System.out.println();
			 System.out.print("Target: ");
			 ChessPosition target = UI.readChessPosition(sc);
			 chessPiece CapturedPiece = chessMath.performChessMove(source, target);
			 
			 if(captured != null) {
				 captured.add(CapturedPiece);
			 }
		
		}
		catch(ChessException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			
		}
		catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
			
		
	  }
    }
  }
}
