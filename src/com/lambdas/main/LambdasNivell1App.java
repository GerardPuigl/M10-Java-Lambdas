package com.lambdas.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.lambdas.FunctionalInterfaces.INumeroPI;
import com.lambdas.FunctionalInterfaces.IReverse;

public class LambdasNivell1App {

	public static void main(String[] arg) {

		// Nivell1_Fase1
		
		lambda1(); //filtrar per 2 condicions "AND"
		
		lambda2(); //fer acció per 2 condicions
		
		lambda3(); //filtrar per 1 condicions
		
		lambda4(); //filtrar per 2 condicions "OR"
		
		lambda5(); //imprimeix llista Strings
		
		lambda6(); //imprimeix llista Strings amb reference

		// Nivell1_Fase2

		lambda7(); 	// utiliza lambda en un mètode abstracte sense paràmetre

		
	}

	// filtrar per 2 condicions "AND"
	public static void lambda1() {

		List<String> list1 = Arrays.asList("Ana", "Adelaila", "Antonia", "Bea", "Carla");

		List<String> list2 = list1.stream().filter(str -> str.contains("A") && str.length() == 3)
				.collect(Collectors.toList());

		System.out.println("\nArray original:\n"+list1);
		System.out.println("\nParaules iniciades amb A i que tenen 3 lletres:\n"+list2);

	}

	
	// fer acció per 2 condicions
	public static void lambda2() {

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

		StringBuilder sb = new StringBuilder();

		list1.stream().forEach(number -> {
			if (number % 2 == 0) {
				sb.append("e" + number.toString());
			} else {
				sb.append("o" + number.toString());
			}
			sb.append(",");
		});

		sb.setLength(sb.length() - 1);
		
		System.out.println("\nArray original:\n"+list1);
		System.out.println("\nAfegir 'e' als nombres senars i 'o' als nombres parells: \n"+sb);

	}

	
	// filtrar per 1 condicions
	public static void lambda3() {

		List<String> list1 = Arrays.asList("Oscar", "Adelaila", "Antonia", "Bea", "Carla");

		List<String> list2 = list1.stream()
				.filter(str -> str.toUpperCase()	
				.contains("O"))
				.collect(Collectors
				.toList());

		System.out.println("\nArray original:\n"+list1);
		
		System.out.println("\nRetorna totes les paraules que tenen la paraula 'o'\n"+list2);

	}

	// filtrar per 2 condicions "OR"
	public static void lambda4() {

		List<String> list1 = Arrays.asList("Oscar", "Adelaila", "Antonia", "Bea", "Carla");

		List<String> list2 = list1.stream()
				.filter(str -> str.toUpperCase().contains("O") || str.length() > 5)
				.collect(Collectors.toList());

		System.out.println("\nArray original:\n"+list1);
		
		System.out.println("\nRetorna totes les paraules que tenen la paraula 'o' o més de 5 lletres\n"+list2);

	}

	// imprimeix llista Strings
	public static void lambda5() {

		List<String> list1 = Arrays.asList("Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost",
				"Setembre", "Octubre", "Novembre", "Desembre");

		System.out.println("\nArray original:\n"+list1
				+"\n\nImprimeix els mesos mitjançant lambda:");
		
		list1.stream().forEach(str -> System.out.println(str));

	}

	// imprimeix llista Strings amb reference
	public static void lambda6() {

		List<String> list1 = Arrays.asList("Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost",
				"Setembre", "Octubre", "Novembre", "Desembre");

		System.out.println("\nArray original:\n"+list1
				+"\n\nImprimeix els mesos mitjançant mètode réference:");
		
		list1.stream().forEach(System.out::println);

	}

	// utiliza lambda en un mètode abstracte sense paràmetre
	public static void lambda7() {

		INumeroPI pi = ()->3.1415;
		
		System.out.println("\nInjectar mitjançant lambda un mètode a una interfície funcional que no rep paràmetre:"
				+ "\nReusltat: " + pi.getPiValue());

	}
}
