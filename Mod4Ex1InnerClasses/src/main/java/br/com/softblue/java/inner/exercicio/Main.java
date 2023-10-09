package br.com.softblue.java.inner.exercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> numeros = Arrays.asList(5, 2, 8, 6, 7, 4, 0, 3, 1, 9);
		
		runAnonymousInnerClass(new ArrayList<>(numeros));
		runMethodLocalInnerClass(new ArrayList<>(numeros));
		runStaticInnerClass(new ArrayList<>(numeros));
	}
	
	private static void runAnonymousInnerClass(List<Integer> numeros) {
		numeros.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}			
		});
		
		System.out.println("Anonymous inner class: " + numeros);
	}
	
	private static void runMethodLocalInnerClass(List<Integer> numeros) {
		
		class NumberComparator1 implements Comparator<Integer>{
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}			
		}
		
		NumberComparator1 comparator = new NumberComparator1();
		numeros.sort(comparator);
		
		System.out.println("Method-local inner class: " + numeros);
	}
	
	private static void runStaticInnerClass(List<Integer> numeros) {
		NumberComparator2 comparator = new NumberComparator2();
		numeros.sort(comparator);
		
		System.out.println("Static inner class: " + numeros);
	}
	
	private static class NumberComparator2 implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}		
	}
}
