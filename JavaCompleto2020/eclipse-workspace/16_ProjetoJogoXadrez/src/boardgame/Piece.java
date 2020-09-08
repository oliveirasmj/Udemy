package boardgame;

public class Piece {
	
	protected Position position;
	private Board board; //uma peca esta contida num tabuleiro
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

}
