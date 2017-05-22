package de.bussler.tictactoe;

import org.junit.Ignore;
import org.junit.Test;

import de.bussler.tictactoe.Board.Symbol;
import de.bussler.tictactoe.text.TextbasedInteractivePlayer;

public class TestInteractivePlayer {

	@Test
	public void test() {
		final Board board = new Board(3);
		board.set(0, 0, Symbol.Cross);
		board.set(0, 1, Symbol.Circle);
		new TextbasedInteractivePlayer(Symbol.Cross).paint(board);

	}

	@Test
	@Ignore
	public void playtest() {
		final Board board = new Board(3);
		final UnmodifiableBoard uboard = new UnmodifiableBoard(board);
		board.set(1, 1, Symbol.Cross);
		new TextbasedInteractivePlayer(Symbol.Cross).play(uboard);
	}

}
