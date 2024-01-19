package br.com.softblue.javafx.exercicio;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane borderPane = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("Arquivo");
		menuBar.getMenus().add(menuFile);
		borderPane.setTop(menuBar);
		
		Label lblStatus = new Label("Barra de status");
		lblStatus.setPadding(new Insets(5));
		borderPane.setBottom(lblStatus);
		
		TextArea txtContent = new TextArea();
		borderPane.setCenter(txtContent);
		
		BorderPane.setMargin(txtContent, new Insets(0, 10, 0, 0));
		
		ListView<String> listView = new ListView<String>();
		
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("A", "B", "C", "D", "E");
		listView.setItems(items);
		
		listView.setPrefWidth(100);
		borderPane.setRight(listView);
		
		Scene scene = new Scene(borderPane, 640, 480);
		
		primaryStage.setTitle("Login?");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
