package de.bussler.tictactoe;

import de.bussler.tictactoe.Board.Symbol;

public interface Player {

	public Pair play(UnmodifiableBoard board);

	public Symbol getSymbol();

}
