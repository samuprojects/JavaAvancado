package br.com.softblue.java.lambda.exercicio;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(7);
		list.add(0);
		list.add(4);
		list.add(8);
		list.add(6);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(9);

		list.sort((n1, n2) -> -n1.compareTo(n2));
		list.forEach(System.out::println);
	}

}
