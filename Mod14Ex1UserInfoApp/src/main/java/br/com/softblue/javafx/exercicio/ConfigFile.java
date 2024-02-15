package br.com.softblue.javafx.exercicio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigFile {
	public static final String PROP_NOME = "nome";
	public static final String PROP_IDADE = "idade";
	public static final String PROP_SEXO = "sexo";
	public static final String PROP_ESPORTES = "esportes";
	
	private static final Path CONFIG_FILE = Paths.get("config.txt");

	private static Properties props = new Properties();

	static {
		try {
			if (!Files.exists(CONFIG_FILE)) {
				Files.createFile(CONFIG_FILE);
			} else {
				try (InputStream in = Files.newInputStream(CONFIG_FILE)) {
					props.load(in);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private ConfigFile() {
	}
	
	public static boolean hasProperties() {
		return props.size() > 0;
	}

	public static String getProperty(String name) {
		return props.getProperty(name);
	}

	public static void setProperty(String name, String value) {
		props.setProperty(name, value);
	}

	public static void saveProperties() {
		try (OutputStream out = Files.newOutputStream(CONFIG_FILE)) {
			props.store(out, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
