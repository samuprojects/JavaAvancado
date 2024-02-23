package br.com.softblue.java.chat.client.ui.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MainUIModel {

	private BooleanProperty connected = new SimpleBooleanProperty();

	private StringProperty name = new SimpleStringProperty();

	private StringProperty message = new SimpleStringProperty();

	private StringProperty messages = new SimpleStringProperty();

	private StringProperty windowTitle = new SimpleStringProperty();

	public BooleanProperty connectedProperty() {
		return this.connected;
	}

	public boolean isConnected() {
		return this.connectedProperty().get();
	}

	public void setConnected(final boolean connected) {
		this.connectedProperty().set(connected);
	}

	public StringProperty nameProperty() {
		return this.name;
	}

	public String getName() {
		return this.nameProperty().get();
	}

	public void setName(String name) {
		this.nameProperty().set(name);
	}

	public StringProperty messageProperty() {
		return this.message;
	}

	public String getMessage() {
		return this.messageProperty().get();
	}

	public void setMessage(String message) {
		this.messageProperty().set(message);
	}

	public StringProperty messagesProperty() {
		return this.messages;
	}

	public String getMessages() {
		return this.messagesProperty().get();
	}

	public void setMessages(String messages) {
		this.messagesProperty().set(messages);
	}

	public StringProperty windowTitleProperty() {
		return this.windowTitle;
	}

	public String getWindowTitle() {
		return this.windowTitleProperty().get();
	}

	public void setWindowTitle(String windowTitle) {
		this.windowTitleProperty().set(windowTitle);
	}
	
	public void appendMessage(String message) {
		setMessages(getMessages() + message + "\n");
	}
}
