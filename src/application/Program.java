package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch partida = new ChessMatch(); 
		
		/**
		 * Interface do usuário
		 */
		UI.printBoard(partida.getPieces());
		
		
		
	}

}
