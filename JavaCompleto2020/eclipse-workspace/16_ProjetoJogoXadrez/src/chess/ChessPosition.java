package chess;

import boardgame.Position;

//classe que converte posicao normal de array para posicoes de xadrez - primeiro a letra e depois o numero
public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char column, int i) {
		if (column < 'a' || column > 'h' || i < 1 || i > 8) {
			throw new ChessException("Error insstantiating ChessPosition. Valid values are from a1 to h8");
		}
		this.column = column;
		this.row = i;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	//metodo para converter para posicao de array [a1]=[0,0]
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	//metodo para converter para posicao de letras
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
