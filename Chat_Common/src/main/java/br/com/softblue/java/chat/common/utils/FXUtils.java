package br.com.softblue.java.chat.common.utils;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class FXUtils {

	public static void initLayout(FXMLLoader loader, Stage stage) throws IOException {
		
		Object controllerObj = loader.getController();
		
		if (controllerObj != null & controllerObj instanceof StageAwareController) {
			StageAwareController controller = (StageAwareController) controllerObj;
			controller.onStageDefined(stage);
		}
	}
	
	public static void showExceptionDialog(Throwable t) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Ocorreu uma Exceção");
		alert.setHeaderText("A exceção é do tipo " + t.getClass().getName());
		alert.setContentText(t.getMessage());
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);

		TextArea textArea = new TextArea(sw.toString());
		textArea.setEditable(false);
		textArea.setWrapText(true);
		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		
		GridPane extendedPane = new GridPane();
		extendedPane.setMaxWidth(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		extendedPane.add(textArea, 0, 0);

		alert.getDialogPane().setExpandableContent(extendedPane);
		alert.showAndWait();
	}
	
	public static void showErrorDialog(String message) {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText(message);
		alert.showAndWait();
	}
}