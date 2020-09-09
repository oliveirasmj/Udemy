package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; //um tabuleiro tem varias pecas (com position la dentro)
	
	public Board(int rows, int columns) {
		if (rows<1 || columns <1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		
		this.rows = rows;					//cria 8 linha
		this.columns = columns;				//cria 8 colunas
		pieces = new Piece[rows][columns]; //cria 64 peças???
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {	//deolve uma peça pela linha e coluna
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {		//deolve uma peça pela posicao
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) { //metodo para colocar uma peça num local
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece; //posicao da matriz = peca
		piece.position = position; //peca deixa de estar nula e passa a ter a posicao do argumento
		//System.out.println(piece); //Imprime a letra de cada peça - toString
	}
	
	private boolean positionExists(int row, int column) {
		return row>=0 && rows<rows || column>=0 && column<columns; //retorna a posição se estiver dentro dos limites
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return piece(position) != null; //se for diferente de nulo tem uma peca e retorna
	}
}
