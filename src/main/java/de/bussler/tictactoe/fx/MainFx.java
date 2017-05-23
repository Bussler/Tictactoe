package de.bussler.tictactoe.fx;

import java.net.URL;

import de.bussler.tictactoe.text.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFx extends Application {
	private static Controller controller;

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Tictactoe");
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/Tictactoe.fxml"));
		final Parent rootLayout = loader.load();
		MainFx.controller = loader.getController();
		final Scene scene = new Scene(rootLayout);
		final URL url = MainFx.class.getResource("/style.css");
		scene.getStylesheets().add(url.toExternalForm());
		stage.setScene(scene);

		stage.show();

	}

}
