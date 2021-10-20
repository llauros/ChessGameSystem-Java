package application;

import boardgame.Board;
import boardgame.Position;

public class Program {

	public static void main(String[] args) {
		
		Position pos = new Position(1, 2);
		Board bo = new Board(8,8); 
		
		System.out.println(pos);
	}

}
