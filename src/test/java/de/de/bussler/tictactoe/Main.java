package de.bussler.tictactoe;

import de.bussler.tictactoe.Board.Symbol;

public class Main {

	public static void main(String[] args) {
		final Player player1 = new TextbasedInteractivePlayer(Symbol.Cross);
		final Player player2 = new TextbasedInteractivePlayer(Symbol.Circle);
		new Game(3, player1, player2).play();
	}
}
