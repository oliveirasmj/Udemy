package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { //Classe que contem as regras
	
	private Board board; //uma partida de xadrez contem um tabuleiro
	
	public ChessMatch() {
		board = new Board(8, 8); //definir a dimensao do tabuleiro
		initialSetup(); //colocar as peças no inicio do jogo
	}
	
	public ChessPiece[][] getPieces(){  //retorna uma matriz das pecas de xadrez correspondentes à partida - mas a matriz era to tipo Piece e nao ChessPiece
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; //criar uma matriz ChessPiece
		//percorrer matriz e fazer um downcast para Chesspiece
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j); //matriz mat(tipo ChessPiece) =  matriz de Piece -------> (upcasting)
			}	
		}
		return mat; //retornar a nova matriz de pecas
	}
	
	private void initialSetup() { //colocar as peças no tabuleiro
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
}
