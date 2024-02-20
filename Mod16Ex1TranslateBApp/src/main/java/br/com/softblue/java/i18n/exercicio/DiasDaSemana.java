package br.com.softblue.java.i18n.exercicio;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DiasDaSemana extends Application {
	
	@SuppressWarnings("deprecation")
	private static final Locale LOCALE_US = new Locale("en", "US");
	@SuppressWarnings("deprecation")
	private static final Locale LOCALE_BR = new Locale("pt", "BR");
	
	private Locale currentLocale = LOCALE_BR;
	
	private List<Button> buttons = FXCollections.observableArrayList();
	
	@FXML
	private Button btn0;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btnChange;	

	public static void main(String[] args) {
		launch(args);
	}
	
	public void initialize() {
		buttons.addAll(Arrays.asList(btn0, btn1, btn2, btn3, btn4, btn5, btn6));
		
		defineText();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	public void onClick(ActionEvent event) {
		
		if (currentLocale == LOCALE_BR) {
			currentLocale = LOCALE_US;
		} else {
			currentLocale = LOCALE_BR;
		}
		
		defineText();
	}
	
	private void defineText() {
		
		ResourceBundle bundle = ResourceBundle.getBundle("br.com.softblue.java.i18n.exercicio.DiasDaSemana", currentLocale);
		
		for (Button btn : buttons) {
			String dow = bundle.getString(btn.getId());
			btn.setText(dow);
		}
		
		btnChange.setText(bundle.getString("btn_mudar"));
	}

}
