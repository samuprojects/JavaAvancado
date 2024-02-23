package br.com.softblue.java.chat.client.ui.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.softblue.java.chat.client.config.ClientConfigFile;
import br.com.softblue.java.chat.client.ui.model.ConfigUIModel;
import br.com.softblue.java.chat.common.utils.FXUtils;
import br.com.softblue.java.chat.common.utils.StageAwareController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ConfigController implements StageAwareController {

	@FXML
	private TextField txtServer;
	
	@FXML
	private TextField txtPort;
	
	private Stage stage;
	
	private ConfigUIModel configModel = new ConfigUIModel();
	
	@FXML
	private void initialize() {

		@SuppressWarnings("deprecation")
		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
		nf.setGroupingUsed(false);
		
		txtServer.textProperty().bindBidirectional(configModel.serverProperty());
		txtPort.textProperty().bindBidirectional(configModel.portProperty(), new NumberStringConverter(nf));
		
		configModel.setServer(ClientConfigFile.getServer());
		configModel.setPort(ClientConfigFile.getPort());
	}

	@Override
	public void onStageDefined(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
	public void confirm() {

		String server = configModel.getServer();
		
		if (server == null || server.trim().isEmpty()) {
			FXUtils.showErrorDialog("Forneça um nome de servidor.");
			return;
		}
		
		int port = configModel.getPort();
		
		if (port == 0) {
			FXUtils.showErrorDialog("Forneça uma porta.");
			return;
		}
		
		ClientConfigFile.setServer(server);
		ClientConfigFile.setPort(port);
		try {
			ClientConfigFile.save();
		} catch (IOException e) {
			FXUtils.showExceptionDialog(e);
		}
		
		stage.close();
	}
	
	@FXML
	public void cancel() {
		stage.close();
	}
}