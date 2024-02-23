package br.com.softblue.java.chat.client.ui;

import br.com.softblue.java.chat.common.utils.FXUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChatClient extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setMinWidth(380);
		primaryStage.setMinHeight(250);

		FXMLLoader loader = new FXMLLoader(ChatClient.class.getResource("/MainLayout.fxml"));
		Pane root = loader.load();
		FXUtils.initLayout(loader, primaryStage);

		Scene scene = new Scene(root, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
