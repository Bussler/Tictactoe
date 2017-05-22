package de.bussler.tictactoe;

import java.util.Arrays;

import de.bussler.tictactoe.Board.Symbol;

public class Game {

	Board board;
	Player[] players;

	public Game(Board board, Player... players) { // Symbols?!

		this.board = board;

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
			int num = 0;
			for (int j = 0; j < board.getSize(); j++) {

				if (s.equals(board.get(i, j))) {
					num++;
				}
				if (num == board.getSize())
					return true;
			}
		}

		// cols
		for (int k = 0; k < board.getSize(); k++) {
			int num = 0;
			for (int l = 0; l < board.getSize(); l++) {

				if (s.equals(board.get(l, k))) {
					num++;
				}
				if (num == board.getSize())
					return true;
			}
		}

		// diagonals

		int num2 = 0;
		for (int x = 0; x < board.getSize(); x++) {

			if (s.equals(board.get(x, x))) {
				num2++;
			}
			if (num2 == board.getSize())
				return true;

		}

		int num3 = 0;
		for (int x = 0; x < board.getSize(); x++) {

			if (s.equals(board.get(x, board.getSize() - 1 - x))) {
				num3++;
			}
			if (num3 == board.getSize())
				return true;
		}

		return false;
	}
}
