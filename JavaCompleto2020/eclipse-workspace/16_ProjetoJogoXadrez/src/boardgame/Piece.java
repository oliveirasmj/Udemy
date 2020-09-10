package boardgame;

public class Piece {
	
	protected Position position; //tem uma posicao - este tipo de posicao não é posicao do xadrez, é uma posicao simples de matriz - nao é visivel nao camada de xadrez
	private Board board; //uma peca esta contida num tabuleiro
	
	public Piece(Board board) {
		this.board = board;
		position = null; //opcional pois as pecas sao sempre criadas nulas por omissao
	}

	protected Board getBoard() {
		return board;
	}

}
