package de.bussler.tictactoe;

import java.util.Random;

import de.bussler.tictactoe.Board.Symbol;

public class ComputerPlayer implements Player {
	private final Symbol playersymbol;
	Random random = new Random();

	public ComputerPlayer(Symbol playersymbol) {
		this.playersymbol = playersymbol;
	}

	@Override
	public Pair play(UnmodifiableBoard board) {
		return new Pair(random.nextInt(board.getSize()), random.nextInt(board.getSize()));
	}

	@Override
	public Symbol getSymbol() {

		return this.playersymbol;
	}

}
