package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch chessMatch = new ChessMatch(); //board = new Board(8, 8);
		UI.printBoard(chessMatch.getPieces()); //UI - clase de userinterface  |  chessMatch.getPieces() - retorna matriz mat de pecas
	}

}
