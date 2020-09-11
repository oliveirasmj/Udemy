package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces; //um tabuleiro tem varias pecas (com position la dentro)
	
	public Board(int rows, int columns) {
		if (rows<1 || columns <1) { //se quantidade de linhas e colunas for menor que um
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column"); //lançar excepcao
		}
		
		this.rows = rows;					//cria as linha - futuramente 8
		this.columns = columns;				//cria as colunas - futuramente 8
		pieces = new Piece[rows][columns];  //cria uma matriz de peças com x posicoes - - futuramente 64
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {	//deolve uma peça pela linha e coluna
		if(!positionExists(row, column)) { //se posicao nao existir
			throw new BoardException("Position not on the board");
		}
		
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {		//devolve uma peça pela posicao
		if(!positionExists(position)) { //se posicao nao existir
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
	
	private boolean positionExists(int row, int column) { //ve se posicao existe
		return row>=0 && rows<rows || column>=0 && column<columns; //retorna true se a posição se estiver dentro dos limites
	}
	
	public boolean positionExists(Position position) { //ve se posicao existe
		return positionExists(position.getRow(), position.getColumn()); //retorna true se a posição se estiver dentro dos limites
	}
	
	public boolean thereIsAPiece(Position position) { //ver se tem uma peça
		if(!positionExists(position)) { //se posicao nao existir OU se retornar false
			throw new BoardException("Position not on the board"); //lancar excepcao
		}

		return piece(position) != null; //se for diferente de nulo tem uma peca e retorna
	}
	
	public Piece removePiece (Position position) {
		if(!positionExists(position)) { //se posicao nao existir
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux; //retornar a peca que foi retirada
	}
}
