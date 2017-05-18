package de.bussler.tictactoe;

import java.util.Arrays;

import de.bussler.tictactoe.Board.Symbol;

public class Game {

	Board board;
	Player[] players;
	int random;
	Symbol playersymbol;

	public Game(int size, Player... players) { // Symbols?!

		board = new Board(3);

		if (players.length == 0) {
			throw new IllegalArgumentException("There has to be at least one player!");
		}

		final long numberSymbols = Arrays.stream(players).map(p -> p.getSymbol()).distinct().count();
		if (players.length != numberSymbols) {
			throw new IllegalArgumentException("All symbols have to be different!");
		}
		this.players = players;

	}

	public void play() {
		int currentplayer = 0;

		do {
			playTurn(players[currentplayer]);
			final Player gplayer = getWinner();

			if (gplayer != null) {
				System.out.println(gplayer + " hat gewonnen!");
				return;
			}
			if (currentplayer < players.length - 1) {
				currentplayer++;
			} else {
				currentplayer = 0;
			}
		} while (turnPossible());

	}

	private boolean turnPossible() {

		for (int y = 0; y < board.getSize(); y++) {
			for (int x = 0; x < board.getSize(); x++) {
				if (board.get(x, y) == null) {
					return true;
				}
			}

		}

		return false;
	}

	private void playTurn(Player player) {
		Pair turn = null;
		do {
			turn = player.play(new UnmodifiableBoard(board));
		} while (!turnAllowed(turn));

		board.set(turn.getX(), turn.getY(), player.getSymbol());
	}

	public boolean turnAllowed(Pair pair) { // rule: only set on empty fields!
		boolean rule = false;
		if (board.get(pair.getX(), pair.getY()) == null) {
			rule = true;
		}
		return rule;
	}

	public Player getWinner() {
		for (final Player player : players) {
			final Symbol s = player.getSymbol();
			if (findWinningPattern(s)) {
				return player;
			}
		}
		return null;
	}

	private boolean findWinningPattern(Symbol s) {
		// rows
		for (int i = 0; i < board.getSize(); i++) {
			for (int j = 0; j < board.getSize(); j++) {
				int num = 0;
				if (s.equals(board.get(i, j))) {
					num++;
				}
				if (num == board.getSize())
					return true;
			}
		}
		return false;
		// cols

		// diagonals
	}
}
