package de.bussler.tictactoe;

/**
 * Repräsentiert das Spielfeld mit den Spielsymbolen
 */
public class Board {
	/**
	 * 
	 * Represents possible entries on the board.
	 */
	public static enum Symbol {
		/**
		 * Token for one player.
		 */
		Cross, 
		/**
		 * Token for one player.
		 */
		Circle;
	}

	private final int size;
	protected final Symbol[][] content;

	/**
	 * @param size
	 */
	public Board(int size) {
		this.size = size;
		content = new Symbol[size][size];
	}
	
    

	protected Board(int size, Symbol[][] content) {
		this.size = size;
		this.content = content;
	}



	public void set(int x, int y, Symbol value) {
		content[x][y]=value;
	}

	public Symbol get(int x, int y) {
     return content[x][y]; 
	}

	/**
	 * @return number of rows/columns
	 */
	public int getSize() {
		return size;
	}

}