package br.com.softblue.java.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.converter.NumberStringConverter;

public class Controller {

	@FXML
	private Label lblResult;

	@FXML
	private Label lblError;

	private CalcModel calcModel = new CalcModel();

	@FXML
	private void initialize() {
		lblResult.textProperty().bindBidirectional(calcModel.currentValueProperty(),
				new NumberStringConverter(CalcModel.NUMBER_FORMAT));
		lblError.visibleProperty().bind(calcModel.errorProperty());
	}

	@FXML
	public void onNumber(javafx.event.ActionEvent event) {
		Button button = (Button) event.getSource();
		int number = Integer.parseInt(button.getText());
		calcModel.appendNumber(number);
	}

	@FXML
	public void onClear() {
		calcModel.clear();
	}

	@FXML
	public void onComma() {
		calcModel.appendComma();
	}

	@FXML
	public void onOperation(ActionEvent event) {
		Button button = (Button) event.getSource();
		Operation operation = Operation.fromSymbol(button.getText().charAt(0));
		calcModel.doOperation(operation);
	}

}
