package de.bussler.tictactoe.text;

import de.bussler.tictactoe.Board;
import de.bussler.tictactoe.ComputerPlayer;
import de.bussler.tictactoe.Game;
import de.bussler.tictactoe.Player;
import de.bussler.tictactoe.Board.Symbol;

public class Main {

	public static void main(String[] args) {

		final Player player1 = new TextbasedInteractivePlayer(Symbol.Cross);
		final Player player2 = new ComputerPlayer(Symbol.Circle);
		new Game(new Board(3), player1, player2).play();
	}
}
