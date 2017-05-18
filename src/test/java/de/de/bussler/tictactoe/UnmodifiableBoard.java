package de.bussler.tictactoe;

public class UnmodifiableBoard extends Board {

	public UnmodifiableBoard(Board original) {
	super(original.getSize(), original.content);	
		
	}
@Override
public void set(int x, int y, Symbol value) {
	throw new UnsupportedOperationException("Cannot set fields");	
}

}
