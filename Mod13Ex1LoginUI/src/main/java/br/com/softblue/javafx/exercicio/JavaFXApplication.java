package br.com.softblue.javafx.exercicio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			GridPane grid = new GridPane();
			grid.setHgap(5);
			grid.setVgap(5);
			grid.setPadding(new Insets(5));
			grid.setAlignment(Pos.CENTER);
			
			Label lblUser = new Label("Usuario:");
			GridPane.setRowIndex(lblUser, 0);
			GridPane.setColumnIndex(lblUser, 0);
			
			TextField txtUser = new TextField();
			txtUser.setPrefWidth(190);
			GridPane.setRowIndex(txtUser, 0);
			GridPane.setColumnIndex(txtUser, 1);
			
			grid.getChildren().addAll(lblUser, txtUser);
			
			Label lblPassword = new Label("Senha:");
			GridPane.setRowIndex(lblPassword, 1);
			GridPane.setColumnIndex(lblPassword, 0);
			
			TextField txtPassword = new TextField();
			txtPassword.setPrefWidth(190);
			GridPane.setRowIndex(txtPassword, 1);
			GridPane.setColumnIndex(txtPassword, 1);
			
			grid.getChildren().addAll(lblPassword, txtPassword);
			
			HBox hbox = new HBox(5);
			hbox.setAlignment(Pos.CENTER_RIGHT);
			
			GridPane.setRowIndex(hbox, 2);
			GridPane.setColumnIndex(hbox, 0);
			GridPane.setColumnSpan(hbox, 2);
			
			Button btnLogin = new Button("Login");
			btnLogin.setPrefWidth(80);
			Button btnCancel = new Button("Cancelar");
			btnCancel.setPrefWidth(80);
			hbox.getChildren().addAll(btnLogin, btnCancel);
			
			grid.getChildren().add(hbox);
			
			Scene scene = new Scene(grid, 280, 180);
			
			primaryStage.setTitle("Login");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
