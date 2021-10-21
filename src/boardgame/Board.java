package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro criando tabuleiro: É necessário que aja pelo penos 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece [rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	
	public Piece piece(int row, int column) {
		if( !positionExists(row, column)) {
			throw new BoardException("A posição não existe no tabuleiro");
		}
		return pieces[row][column];
	}
	
	/**
	 * Retorna a peça que estiver na matriz nessa posição
	 * 
	 * @param position
	 * @return
	 */
	public Piece piece(Position position) {
		if( !positionExists(position)) {
			throw new BoardException("A posição não existe no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma peça nesta posição " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	/**
	 * metodo auxiliar: Verifica se a "row" (linha) do Position está contida em "rows" (linhas) do tabuleiro (board) e 
	 * verifica se a "column" (coluna) do Position está contida em "columns" (colunas) do tabuleiro (board)
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	/**
	 * Verifica a existencia de uma posição
	 * 
	 * @param position
	 * @return
	 */
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if( !positionExists(position)) {
			throw new BoardException("A posição não existe no tabuleiro");
		}
		return piece(position) != null;
	}
	
}
