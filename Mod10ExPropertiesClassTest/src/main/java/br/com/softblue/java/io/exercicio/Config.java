package br.com.softblue.java.io.exercicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	private Properties props;
	private File file;

	public Config(String file) throws IOException {
		this(new File(file));
	}

	public Config(File file) throws IOException {
		if (file == null) {
			throw new IllegalArgumentException("File cannot be null");
		}

		this.file = file;

		this.props = new Properties();

		if (file.exists()) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				props.load(fis);
			} finally {
				fis.close();
			}
		} else {
			file.createNewFile();
		}
	}
	
	public String getPropertyAsString(String name) {
		return props.getProperty(name);
	}
	
	public Integer getPropertyAsInteger(String name) {
		String prop = props.getProperty(name);
		
		if (prop == null) {
			return null;
		}
		
		return Integer.valueOf(prop);
	}
	
	public Boolean getPropertyAsBoolean(String name) {
		String prop = props.getProperty(name);
		
		if (prop == null) {
			return null;
		}
		
		return Boolean.valueOf(prop);
	}
	
	public void setProperty(String name, String value) throws IOException {
		props.setProperty(name, value);
		
		FileOutputStream fos = null;
		
		fos = new FileOutputStream(file);
		
		props.store(fos, null);
	}
	
	public void setProperty(String name, Integer value) throws IOException {
		setProperty(name, value.toString());
	}
	
	public void setProperty(String name, Double value) throws IOException {
		setProperty(name, value.toString());
	}
	
	public void setProperty(String name, Boolean value) throws IOException {
		setProperty(name, value.toString());
	}
	
	
}