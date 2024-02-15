package br.com.softblue.javafx.exercicio;

import java.util.Arrays;

import br.com.softblue.javafx.exercicio.Pessoa.Sexo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class EditorDados extends Application {

	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtIdade;
	@FXML
	private ChoiceBox<Sexo> choSexo;
	@FXML
	private CheckBox chkEsportes;

	private Pessoa pessoa;

	@FXML
	public void initialize() {
		ObservableList<Sexo> sexoList = FXCollections.observableArrayList(Arrays.asList(Sexo.values()));
		choSexo.setItems(sexoList);

		loadPessoa();

		txtNome.textProperty().bindBidirectional(pessoa.nomeProperty());
		txtIdade.textProperty().bindBidirectional(pessoa.idadeProperty(), new NumberStringConverter());
		choSexo.valueProperty().bindBidirectional(pessoa.sexoProperty());
		chkEsportes.selectedProperty().bindBidirectional(pessoa.praticaEsportesProperty());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = FXMLLoader.load(getClass().getResource("/Layout.fxml"));

		Scene scene = new Scene(root, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Editor de Dados");
		primaryStage.show();
	}

	@FXML
	public void onConfirm() {
		storePessoa();
		
		Platform.exit();
	}

	public void onCancel() {
		Platform.exit();
	}

	private void loadPessoa() {
		pessoa = new Pessoa();

		if (ConfigFile.hasProperties()) {
			pessoa.setNome(ConfigFile.getProperty(ConfigFile.PROP_NOME));
			pessoa.setIdade(Integer.parseInt(ConfigFile.getProperty(ConfigFile.PROP_IDADE)));
			pessoa.setSexo(Sexo.valueOf(ConfigFile.getProperty(ConfigFile.PROP_SEXO)));
			pessoa.setPraticaEsportes(Boolean.parseBoolean(ConfigFile.getProperty(ConfigFile.PROP_ESPORTES)));
		}
	}

	private void storePessoa() {
		ConfigFile.setProperty(ConfigFile.PROP_NOME, pessoa.getNome());
		ConfigFile.setProperty(ConfigFile.PROP_IDADE, String.valueOf(pessoa.getIdade()));
		ConfigFile.setProperty(ConfigFile.PROP_SEXO, pessoa.getSexo().toString());
		ConfigFile.setProperty(ConfigFile.PROP_ESPORTES, String.valueOf(pessoa.isPraticaEsportes()));
		
		ConfigFile.saveProperties();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
