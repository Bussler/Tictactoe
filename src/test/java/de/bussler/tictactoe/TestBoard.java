package de.bussler.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

import de.bussler.tictactoe.Board.Symbol;

public class TestBoard {

	@Test
	public void test() {
		Board testBoard= new Board(3);
		assertEquals(testBoard.getSize(), 3);
		testBoard.set(1, 1, Symbol.Cross);
		assertEquals(Symbol.Cross, testBoard.get(1, 1));
		assertEquals(null, testBoard.get(1, 0));
		testBoard.set(1, 1, Symbol.Circle);
		assertEquals(Symbol.Circle, testBoard.get(1, 1));


	}

}
