package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class chessMath {
	
	private Board board;
	
	public chessMath() {
		board = new Board(8,8);
		initialSetup();
	}
	
	public chessPiece[][] getPieces(){
		chessPiece[][] mat = new chessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i< board.getRows();i++) {
			for(int j=0; j<board.getColumns();j++) {
				mat[i][j]= (chessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	private void initialSetup() {
		board.piece(new Rook(board,Color.WHITE),new Position(2,1));
		board.piece(new King(board,Color.BLACK),new Position(0,4));
		board.piece(new King(board,Color.WHITE),new Position(7,4));
	}
}
