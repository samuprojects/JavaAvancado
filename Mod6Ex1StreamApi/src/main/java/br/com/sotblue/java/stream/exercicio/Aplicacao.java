package br.com.sotblue.java.stream.exercicio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Aplicacao {

	public static void main(String[] args) {
		
		List<Integer> angulosGraus = Arrays.asList(90, 30, 60, 45, 180);
		
		List<Double> angulosRadianos = angulosGraus.stream()
				.map(Math::toRadians)
				.collect(Collectors.toList());
		
		angulosGraus.forEach(System.out::println);
		angulosRadianos.forEach(System.out::println);
				
	}

}
