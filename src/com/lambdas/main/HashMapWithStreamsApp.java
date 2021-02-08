package com.lambdas.main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapWithStreamsApp {

	public static void main(String[] arg) {

		Map<String, Integer> list1 = new HashMap<>();
		
		list1 = Map.of("Llimones",223,"Pomes",53,"Cireres",134,"Alvocats",65);
		
		// Bonus:
		
		//3 primeres demandes del nivell2 amb un HashMap
				
		list1 = sortByKeyLength(list1);
		
		System.out.println("Ordenar Strings per longitud (de menor a major):\n" + list1 +"\n");
		
		list1 = sortByKeyLengthReversed(list1);
		
		System.out.println("Ordenar Strings per longitud (de menor a major):\n" + list1 +"\n");

		list1 = sortyByKeyAlphabetically(list1);
		
		System.out.println("Ordenar Strings per orde alfabètic:\n" + list1 +"\n");
	}


	public static Map<String, Integer> sortByKeyLength(Map<String, Integer> list1) {
			
		return list1.entrySet().stream()
		.sorted(Map.Entry.<String, Integer> comparingByKey(
				Comparator.comparing(s->s.length())))
		.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), 
		 	(e1, e2) -> e2, LinkedHashMap::new));

	}
	
	public static Map<String, Integer> sortByKeyLengthReversed(Map<String, Integer> list1) {
		
		return list1.entrySet().stream()
		.sorted(Map.Entry.<String, Integer> comparingByKey(
				Comparator.comparing(s->s.length())).reversed())
		.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), 
		 	(e1, e2) -> e2, LinkedHashMap::new));

	}
	

	public static Map<String, Integer> sortyByKeyAlphabetically(Map<String, Integer> list1) {
		
		return list1.entrySet().stream()
		.sorted(Map.Entry.<String, Integer> comparingByKey())
		.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), 
		 	(e1, e2) -> e2, LinkedHashMap::new));

	}
	
}
