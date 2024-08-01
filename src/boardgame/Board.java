package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; 
	
	
	public Board(int rows, int columns) {
		// program defensive 
		if (rows < 1 || columns < 1) {
			throw new BoardException("Eroor creating board: there must bea t least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
		
	}

	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}

public Piece piece(int row, int column) {
	// program defensive 
	if(!positionExists(row,column)) {
		throw new BoardException("Position not on the board");
	}
	return pieces[row][column];
}

public Piece piece(Position position) {
	// program defensive 
	if(!positionExists(position)) {
		throw new BoardException("Position not on the board");
	}
	return pieces[position.getRow()][position.getColum()];
	
}

public void placepiece(Piece piece, Position position) {
	if(thereIsAPiece(position)) {
		throw new BoardException("There is already a pice on position"+ position);
	}
	pieces [position.getRow()][position.getColum()] = piece;
	piece.position = position;
}

private boolean positionExists(int row, int column) {
	return row>= 0 && row < rows && column >= 0 && column< columns;
}

public boolean positionExists(Position position) {
	return positionExists(position.getRow(),position.getColum());
}

public boolean thereIsAPiece(Position position) {
	if(!positionExists(position)) {
		throw new BoardException("Position not on the board");
	}
	
	return piece(position) != null;
}

}
