package de.bussler.tictactoe;

import java.util.Scanner;

import de.bussler.tictactoe.Board.Symbol;

public class TextbasedInteractivePlayer implements Player {

	private final Symbol playersymbol;

	public TextbasedInteractivePlayer(Symbol symbol) {
		this.playersymbol = symbol;
	}

	@Override
	public Pair play(UnmodifiableBoard board) {

		paint(board);

		System.out.print(getSymbol() + " ,please type in your turn! ");
		while (true) {
			final String userinput = getuserinput();
			try {

				final Pair result = parse(userinput);

				return result;
			} catch (final IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private String getuserinput() {
		String turn; // Eingabe Konsole, it's your turn! <|=)
		final Scanner turnin = new Scanner(System.in);
		turn = turnin.nextLine();
		System.out.println(getSymbol() + " ,your turn was " + turn + "!");
		return turn;
	}

	private Pair parse(String userinput) {
		final char posZ = userinput.charAt(0); // Eingabe Konsole in char
												// umwandeln
		final char posS = userinput.charAt(1);
		final int Zeile = posZ - 65; // Letter
		final int Spalte = posS - 49; // Number

		if (Zeile > 3 || Zeile < 0 || Spalte > 3 || Spalte < 0) // Abbruch
		{

			throw new IllegalArgumentException(getSymbol()
					+ " Please follow the rules, first type in the letter, then the number of your turn. E.g A2"); // break
																													// out
		}

		final Pair pturn = new Pair(Zeile, Spalte);
		return pturn;
	}

	@Override
	public Symbol getSymbol() {

		return playersymbol;
	}

	void paint(Board board) {
		final String line = "+---+---+---+";
		for (int y = 0; y < board.getSize(); y++) {
			System.out.println(line);
			System.out.print("|");

			for (int x = 0; x < board.getSize(); x++) {

				System.out.print(toString(board.get(x, y)));
				System.out.print("|");
			}

			System.out.println(abc(y)); // Abc variabel an size anpassen >=(
			System.out.println("");
		}
		System.out.println(line);
	}

	private static String toString(Symbol symbol) {
		if (symbol == null) {
			return "   ";
		}

		switch (symbol) {
		case Cross:
			return " X ";
		case Circle:
			return " O ";
		default:
			throw new IllegalArgumentException("Unsupported Case: " + symbol);
		}

	}

	public String abc(int y) { // To do: immer noch anpassen an size >=(
		final String buchstabe = "";

		return buchstabe;
	}

}
