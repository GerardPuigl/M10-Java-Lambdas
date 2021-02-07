package com.lambdas;

import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamOfArrayApp {

	public static void main(String[] arg) {

				
		String[] array = {"Llimones","223","Pomes","53","Cireres","134","Alvocats","1265","Enciams"};
		
		// Nivell2

		List<String> list;
		
		
		//list= sortByLength(array);
		
		//list = sortByLengthRevesed(array);
		
		//list = sortAlphabetically(array);
		
		//list = sortFirtsE(array);
		
		//list = changeAto4(array);
		
		list = filterNumbers(array);
		
		System.out.println(list);
	}
	
	private static List<String> filterNumbers(String[] array) {
		return Stream.of(array)
				.filter(s -> s.matches("[0-9]+"))
				.collect(Collectors.toList());
	}

	public static List<String> sortByLength(String[] array) {
			
		return Stream.of(array).sorted(Comparator.comparing(String::length)).collect(Collectors.toList());

	}
	
	public static List<String> sortByLengthRevesed(String[] array) {
		
		return Stream.of(array).sorted(Comparator.comparing(String::length).reversed())
				.collect(Collectors.toList());

	}
	
	public static List<String> sortAlphabetically(String[] array) {
		
		return Stream.of(array).sorted().collect(Collectors.toList());

	}

	public static List<String> sortFirtsE(String[] array) {
		return Stream.of(array).sorted(Comparator.comparing(s -> s.charAt(0)!='E'))
				.collect(Collectors.toList());
	}
	
	public static List<String> changeAto4(String[] array) {
		
		return Stream.of(array)
				.map(s->s.replaceAll("(?i)a", "4"))
				.collect(Collectors.toList());
	}

	
	
}
