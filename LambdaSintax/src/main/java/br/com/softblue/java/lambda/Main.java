package br.com.softblue.java.lambda;

public class Main {

	public static void main(String[] args) {
		
//		Calculator calc = new Calculator() {
//
//			@Override
//			public void calculate(int x) {
//
//				x = x * x;
//				System.out.println(x);
//			}			
//		};
		
		Calculator2 calc = p -> p * p;
		
		System.out.println(calc.calculate(9));
	}
}
