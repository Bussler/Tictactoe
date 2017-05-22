package de.bussler.tictactoe.fx;

import de.bussler.tictactoe.Board;
import de.bussler.tictactoe.Pair;
import de.bussler.tictactoe.Player;
import de.bussler.tictactoe.UnmodifiableBoard;
import de.bussler.tictactoe.Board.Symbol;

public class FxPlayer implements Player {

	private final Symbol playersymbol;
	private final Controller playercontroller;

	public FxPlayer(Symbol symbol, Controller controller) {
		this.playersymbol = symbol;
		this.playercontroller = controller;
	}

	@Override
	public synchronized Pair play(UnmodifiableBoard board) {

		return playercontroller.getInput();
	}

	@Override
	public Symbol getSymbol() {

		return playersymbol;
	}

}
