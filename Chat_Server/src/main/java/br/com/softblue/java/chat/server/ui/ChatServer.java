package br.com.softblue.java.chat.server.ui;

import br.com.softblue.java.chat.common.utils.FXUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChatServer extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(ChatServer.class.getResource("/ServerWindow.fxml"));
		Pane root = loader.load();
		
		FXUtils.initLayout(loader, primaryStage);
		
		primaryStage.setTitle("Servidor de Chat");
		primaryStage.setResizable(false);
		Scene scene = new Scene(root, 300, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
