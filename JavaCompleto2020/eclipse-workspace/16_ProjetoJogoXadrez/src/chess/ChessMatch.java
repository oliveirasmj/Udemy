package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { //Classe que contem as regras
	
	private Board board; //uma partida de xadrez contem um tabuleiro
	
	public ChessMatch() {
		board = new Board(8, 8); //definir a dimensao do tabuleiro 8x8
		initialSetup(); //colocar as peças no inicio do jogo
	}
	
	public ChessPiece[][] getPieces(){  //retorna uma matriz das pecas de xadrez correspondentes à partida - mas a matriz era to tipo Piece e nao ChessPiece
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; //criar uma matriz ChessPiece com as pecas todas
		//percorrer matriz e fazer um downcast para Chesspiece
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j); //matriz mat(tipo ChessPiece) =  matriz de Piece -------> (upcasting)
			}	
		}
		return mat; //retornar a nova matriz de pecas
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) { //executar movimento e retornar capturada caso haja
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target); //realizar movimento
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) { //realizar movimento
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) { //validar posicao de origem
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) { //colocar nova peça
		board.placePiece(piece, new ChessPosition(column, row).toPosition()); //converter para posicao de array
	}
	
	private void initialSetup() { //colocar as peças no tabuleiro
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
