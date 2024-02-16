package br.com.softblue.javafx.exercicio;

import java.lang.reflect.Method;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML
	private TextField txtClassName;
	
	@FXML
	private ListView<Method> lstClasses;
	
	@FXML
	public void search() {
		try {
			Class<?> clazz = Class.forName(txtClassName.getText());
			
			Method[] methods = clazz.getDeclaredMethods();
			
			ObservableList<Method> list = FXCollections.observableArrayList(methods);
			
			lstClasses.setItems(list);
			
		} catch (ClassNotFoundException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("A classe " + txtClassName.getText() + " não foi encontrada");
			alert.showAndWait();
		}
	}
}
