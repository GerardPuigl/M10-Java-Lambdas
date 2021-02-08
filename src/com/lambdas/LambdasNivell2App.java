package com.lambdas;

import java.util.Arrays;
import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdasNivell2App {

	public static void main(String[] arg) {

		// Nivell2
		// declaració d'una matriu amb de Strings i "números"
		
		String[] array = { "Llimones", "20", "Pomes", "5", "Cireres", "3", "Alvocats", "4", "Enciams" };

		System.out.println("Array original:\n"+ Arrays.toString(array) +"\n");
		
		
		// ordenar per longitud (de menor a major)

		sortByLength(array);

		
		// ordenar per longitud (de major a menor

		sortByLengthRevesed(array);

		
		// Ordenar Strings per orde alfabètic

		sortAlphabetically(array);

		
		// Les cadenes que contenen "e" primer, tota la resta en segon lloc.

		sortFirtsE(array);

		
		// Modifica tots els elements de la matriu per canviar els caracters “a” a “4”

		changeAto4(array);

		
		// Mostra només els elements que siguin 100% numerics.

		filterNumbers(array);

		
		// injecta mitjançant una lambda el cos del mètode a una interficie,
		// de manera que pugis transformar la operació a una
		// suma, resta, multiplicació i divisio.

		operationsWithFunctionalInterface();

		
		// bonus: operacions suma, resta, multiplicació i divisio
		// sobre una array amb Streams

		operationsWithStream(array);

	}

	public static void sortByLength(String[] array) {
			
		List<String> list= Stream.of(array)
				.sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
				
		System.out.println("Ordenar Strings per longitud (de menor a major):\n" + list +"\n");
	}
	
	public static void sortByLengthRevesed(String[] array) {
		
		List<String> list= Stream.of(array)
				.sorted(Comparator.comparing(String::length).reversed())
				.collect(Collectors.toList());
		
		System.out.println("Ordenar Strings per longitud (de menor a major):\n" + list +"\n");

	}
	
	public static void sortAlphabetically(String[] array) {
		
		List<String> list= Stream.of(array)
				.sorted()
				.collect(Collectors.toList());

		System.out.println("Ordenar Strings per orde alfabètic:\n" + list +"\n");

	}

	public static void sortFirtsE(String[] array) {
		
		List<String> list= Stream.of(array)
				.sorted(Comparator.comparing(s -> s.charAt(0)!='E'))
				.collect(Collectors.toList());
		
		System.out.println("Les cadenes que contenen \"e\" primer, tota la resta en segon lloc:\n" + list +"\n");

	}
	
	public static void changeAto4(String[] array) {
		
		List<String> list= Stream.of(array)
				.map(s->s.replaceAll("(?i)a", "4"))
				.collect(Collectors.toList());
		
		System.out.println("\"Modifica tots els elements de la matriu per canviar els caracters “a” a “4”:\n" + list +"\n");

	}
	
	private static void filterNumbers(String[] array) {
		List<String> list= Stream.of(array)
				.filter(s -> s.matches("[0-9]+"))
				.collect(Collectors.toList());
		
		System.out.println("Mostrar tots els elements que siguin 100% numèrics:\n" + list +"\n");

	}

	public static void operationsWithFunctionalInterface() {
		
		System.out.println("Operacions mitjançant lambdes sorbe una inteficie funcional:\n");
				
		IOperacio sumar = (a,b) ->a+b;
		IOperacio restar = (a,b) ->a-b;
		IOperacio multiplicar = (a,b) ->a*b;
		IOperacio dividir = (a,b) ->a/b;
		
		int a=30;
		int b=5;
		
		System.out.printf("Valors: %d i %d\n", a,b);
		
		System.out.printf("Suma dels valors: %.0f\n", sumar.operacio(30,5));

		System.out.printf("Resta dels valors: %.0f\n", restar.operacio(30,5));
		
		System.out.printf("Multiplicar dels valors: %.0f\n", multiplicar.operacio(30,5));
		
		System.out.printf("Dividir dels valors: %.0f\n", dividir.operacio(30,5));
		
	}
	
	
	
	public static void operationsWithStream(String[] array) {
		
		System.out.println("\nBonus: Operacions mitjançant Stream i lambdes sorbe una array:\n");
			
		List<Integer> list= Stream.of(array)
				.filter(s -> s.matches("[0-9]+"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		
		System.out.println("Array amb només els números:\n" + list +"\n");
		
		
		int suma = list.stream()
				.reduce(0,(a,b)-> a+b);
		
		System.out.println("Suma dels seus valors: " + suma);
		
		int resta = list.stream()
				.reduce(0,(a,b)-> a-b);
		
		System.out.println("Resta dels seus valors: " + resta);
		
		int multiplicacion = list.stream()
				.reduce(1,(a,b)-> a*b);
		
		System.out.println("Multiplicar els seus valors: " + multiplicacion);
		
		double division = list.stream()
				.map(n->(double)n)
				.reduce(1.0,(a,b)-> a/b);
		
		System.out.println("Divisió del primer valor entre els seg: "+ division);
	}
	
}
