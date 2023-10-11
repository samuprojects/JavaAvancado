package br.com.softblue.java.lambda.exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		List<Integer> newList1 = transform(list, x -> x * 2);
		System.out.println("List 1: " + newList1);
		
		List<Integer> newList2 = transform(list, x -> -x);
		System.out.println("List 2: " + newList2);
	}
	
	private static List<Integer> transform(List<Integer> list, Function<Integer, Integer> function){
		List<Integer> newList = new ArrayList<Integer>(list.size());
		
		for (Integer i : list) {
			newList.add(function.apply(i));
		}
		return newList;
	}
}
