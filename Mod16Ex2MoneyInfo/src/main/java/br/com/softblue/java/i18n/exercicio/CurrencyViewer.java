package br.com.softblue.java.i18n.exercicio;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CurrencyViewer extends Application {
	
	@FXML
	private TextField txtValor;
	
	@FXML
	private ChoiceBox<String> choLocale;
	
	@FXML
	private Text txtResultado;

	public static void main(String[] args) {
		launch(args);
	}
	
	public void initialize() {
		List<String> locales = Stream.of(Locale.getAvailableLocales())
				.filter(l -> !l.getCountry().isEmpty())
				.map(l -> l.getLanguage() + "-" + l.getCountry())
				.sorted()
				.collect(Collectors.toList());
		
		choLocale.setItems(FXCollections.observableArrayList(locales));
		
		choLocale.valueProperty().addListener((event, oldValue, newValue) -> formatCurrency());
		
		txtValor.textProperty().addListener((event, oldValue, newValue) -> formatCurrency());
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
		
		Scene scene = new Scene(root, 370, 120);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Visualizador de Valores Monetários");
		
		primaryStage.show();
	}
	
	private void formatCurrency() {
		
		String value = txtValor.getText();
		
		Locale locale = Locale.forLanguageTag(choLocale.getSelectionModel().getSelectedItem());
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		
		try {
			String formattedValue = nf.format(Double.parseDouble(value));
			
			txtResultado.setText(formattedValue);
			
		} catch (NumberFormatException e) {
			
			txtResultado.setText("");
		}
	}
}
