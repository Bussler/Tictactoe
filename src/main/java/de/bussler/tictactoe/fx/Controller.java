package de.bussler.tictactoe.fx;

import java.net.URL;
import java.util.ResourceBundle;

import de.bussler.tictactoe.Board;
import de.bussler.tictactoe.ComputerPlayer;
import de.bussler.tictactoe.Game;
import de.bussler.tictactoe.Pair;
import de.bussler.tictactoe.Player;
import javafx.application.Platform;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller extends Board implements Initializable {

	public Controller() {
		super(3);

	}

	@FXML
	private GridPane grid;
	@FXML
	private javafx.scene.control.TextField input;
	private Pair lastInput;
	private final Button[][] buttonArray = new Button[3][3];

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				buttonArray[y][x] = new Button("");
				final EventType<?> type = null; // Möglicher Fehler
				final int y1 = y;
				final int x1 = x;
				buttonArray[y][x].setOnMouseClicked(e -> clicked(y1, x1));
				grid.add(buttonArray[y][x], y, x);
			}
		}
		System.err.println("FINDME: " + input);
		new Thread(() -> playGame(this)).start();

	}

	private void clicked(int y, int x) {
		input.setText("Button " + y + " " + x + " wurde geklickt");
		System.out.println("Button " + y + " " + x + " wurde geklickt");
		synchronized (this) {

			lastInput = new Pair(y, x);
			notifyAll();
		}

	}

	public synchronized Pair getInput() {
		input.setAccessibleText("It's your turn");
		lastInput = null;
		do {
			try {
				wait();
			} catch (final InterruptedException e) {

				e.printStackTrace();
			}
		} while (lastInput == null);

		return lastInput;
	}

	public void playGame(Controller controller) {
		System.out.println("playGame(); funktioniert");
		input.setText("playGame(); funktioniert!"); // Änderung2

		final Player player1 = new FxPlayer(Symbol.Cross, controller);
		final Player player2 = new ComputerPlayer(Symbol.Circle);
		new Game(this, player1, player2).play();
		System.out.println("Ende");
		input.setText("Ende"); // Änderung2
	}

	@Override
	public void set(int x, int y, Symbol value) {
		super.set(x, y, value);
		Platform.runLater(() -> buttonArray[x][y].setText(value.toString()));
	}
}
