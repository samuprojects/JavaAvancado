package br.com.softblue.java.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Pane root = FXMLLoader.load(getClass().getResource("/Layout.fxml"));

		Scene scene = new Scene(root, 220, 220);

		scene.getStylesheets().add("styles.css");

		primaryStage.setTitle("Calculadora");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
