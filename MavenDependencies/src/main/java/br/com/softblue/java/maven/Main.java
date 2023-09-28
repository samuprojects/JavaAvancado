package br.com.softblue.java.maven;

import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		
		String test = StringUtils.abbreviate("abcdefg", 5);
		System.out.println(test);
	}

}
