package br.com.softblue.java.chat.common.utils;

import javafx.scene.control.TextField;

public class NumericTextField  extends TextField {
	
	@Override
	public void replaceText(int start, int end, String text) {
		System.out.println(text);
		if (validate(text)) {
			super.replaceText(start, end, text);
		}		
	}
	
	@Override
	public void replaceSelection(String text) {
		if (validate(text)) {
			super.replaceSelection(text);
		}
	}
	
	private boolean validate(String text) {
		if (text.trim().length() == 0) {
			return true;
		}
		
		try {
			Integer.parseInt(text);
			return true;
			
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
