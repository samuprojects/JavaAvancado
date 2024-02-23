package br.com.softblue.java.chat.client.ui.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConfigUIModel {

	private StringProperty server = new SimpleStringProperty();

	private IntegerProperty port = new SimpleIntegerProperty();

	public StringProperty serverProperty() {
		return this.server;
	}

	public String getServer() {
		return this.serverProperty().get();
	}

	public void setServer(String server) {
		this.serverProperty().set(server);
	}

	public IntegerProperty portProperty() {
		return this.port;
	}

	public int getPort() {
		return this.portProperty().get();
	}

	public void setPort(int port) {
		this.portProperty().set(port);
	}

}
