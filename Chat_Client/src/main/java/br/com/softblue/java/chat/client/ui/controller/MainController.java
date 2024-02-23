package br.com.softblue.java.chat.client.ui.controller;

import br.com.softblue.java.chat.client.business.ServerInvoker;
import br.com.softblue.java.chat.client.business.ServerRequestHandler;
import br.com.softblue.java.chat.client.config.ClientConfigFile;
import br.com.softblue.java.chat.client.ui.model.MainUIModel;
import br.com.softblue.java.chat.common.ChatException;
import br.com.softblue.java.chat.common.utils.FXUtils;
import br.com.softblue.java.chat.common.utils.StageAwareController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController implements ServerRequestHandler, StageAwareController {
	
	public static final String TITLE = "Aplicativo Chat";
	
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtMessages;
	@FXML
	private TextField txtMessage;
	@FXML
	private Button btnConnect;
	@FXML
	private Button btnDisconnect;
	@FXML
	private Button btnSend;
	
	private ServerInvoker serverInvoker;
	
	private MainUIModel mainModel = new MainUIModel();
	
	@FXML
	private void initialize() {
		btnConnect.disableProperty().bind(mainModel.connectedProperty());
		btnDisconnect.disableProperty().bind(mainModel.connectedProperty().not());
		txtMessage.disableProperty().bind(mainModel.connectedProperty().not());
		txtNome.disableProperty().bind(mainModel.connectedProperty());
		btnSend.disableProperty().bind(mainModel.connectedProperty().not());
		mainModel.nameProperty().bindBidirectional(txtNome.textProperty());
		mainModel.messageProperty().bindBidirectional(txtMessage.textProperty());
		mainModel.messagesProperty().bindBidirectional(txtMessages.textProperty());
	}
	
	@FXML
	public void connect() {
		try {
			String name = mainModel.getName();
			
			if (name != null && !name.trim().isEmpty()) {
				
				String server = ClientConfigFile.getServer();

				int port = ClientConfigFile.getPort();

				serverInvoker = new ServerInvoker(server, port, name, this);

				serverInvoker.connect();

				mainModel.setConnected(true);

				mainModel.setWindowTitle(String.format("%s [Conectado em %s:%s]", TITLE, ClientConfigFile.getServer(), ClientConfigFile.getPort()));
				
				txtMessage.requestFocus();

			} else {
				txtNome.requestFocus();
			}

		} catch (Exception e) {
			FXUtils.showExceptionDialog(e);
		}
	}

	@FXML
	public void disconnect() {
		try {
			if (serverInvoker != null) {
				serverInvoker.disconnect();
			}
			
			mainModel.setConnected(false);
			mainModel.setName("");
			mainModel.setMessages("");
			mainModel.setMessage("");
			mainModel.setWindowTitle(TITLE);
			txtNome.requestFocus();

		} catch (ChatException e) {
			FXUtils.showExceptionDialog(e);
		}
	}

	@FXML
	public void sendMessage() {
		try {
			String message = mainModel.getMessage();

			if (message != null && !message.trim().isEmpty()) {
				serverInvoker.sendMessage(message);

				mainModel.setMessage("");

				txtMessage.requestFocus();

			} else {
				
				txtMessage.requestFocus();
			}

		} catch (ChatException e) {
			FXUtils.showExceptionDialog(e);
		}
	}

	public void onStageDefined(Stage stage)  {

		stage.titleProperty().bind(mainModel.windowTitleProperty());
		mainModel.setWindowTitle(TITLE);
		
		stage.setOnCloseRequest(event -> exit());
	}
	
	@FXML
	public void exit() {
		if (serverInvoker != null) {
			try {
				serverInvoker.disconnect();
			} catch (Exception e) {
			}
		}
		
		Platform.exit();
		System.exit(0);
	}

	@Override
	public void onServerShutdown() {
		
		Platform.runLater(() -> {
			serverInvoker = null;
			
			disconnect();
	
			FXUtils.showErrorDialog("A conexão com o servidor foi finalizada");
		});
	}

	/**
	 * @see br.com.softblue.java.chat.client.business.ServerRequestHandler#onMessageReceived(java.lang.String)
	 */
	@Override
	public void onMessageReceived(String message) {

		mainModel.appendMessage(message);
		
		txtMessages.positionCaret(txtMessages.getText().length());
	}

	@FXML
	public void openPreferencesWindow() throws Exception {

		Stage configStage = new Stage();
		
		configStage.setTitle("Preferências");
		
		configStage.initModality(Modality.APPLICATION_MODAL);
		
		configStage.setResizable(false);
		
		Pane root = FXUtils.loadLayout("/br/com/softblue/java/chat/client/ui/Config.fxml", configStage);
		
		Scene scene = new Scene(root, 300, 120);
		configStage.setScene(scene);
		configStage.show();
	}
}