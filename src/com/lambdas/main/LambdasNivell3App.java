package com.lambdas.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.lambdas.FunctionalInterfaces.INumeroPI;
import com.lambdas.domain.Alumne;

public class LambdasNivell3App {
	
	
	public static void main(String[]arg) {
		
		List<Alumne> alumnes = Arrays.asList(
				new Alumne("Pep", 25, "JAVA", 8.5f),
				new Alumne("Marta", 21, "JAVA", 5.7f),
				new Alumne("Silvia", 17, "JAVA", 9.0f),
				new Alumne("Ana", 32, "REACT", 3.5f),
				new Alumne("Marc", 45, "REACT", 5.0f),
				new Alumne("Oscar", 20, "ANGULAR", 4.3f),
				new Alumne("Arnau", 16, "ANGULAR", 7.1f),
				new Alumne("Andreu", 24, "NODE.JS", 8.3f),
				new Alumne("Inma", 26, "PHP", 6.2f),
				new Alumne("Joana", 36, "PHP", 5.3f));

		printNameAndAgent(alumnes); // Mostra per pantalla el nom i l’edat de cada alumne.
		
		filterByInitialLetter(alumnes,'A'); // Filtra la llista per tots els alumnes que el nom comenci per “a”
		
		filterByGrade(alumnes,5); // Filtra i mostra per pantalla els alumnes que tinguin un 5 o mes de nota.
		
		filterByGradeByCourse(alumnes,5,"PHP"); // Filtra i mostra per pantalla els alumnes que tinguin un 5 o més no siguin de PHP.
		
		filterByAgeByCourse(alumnes,18,"JAVA"); // Mostra tots els alumnes que facin JAVA i siguin majors d’edat.

	}
	
	// Mostra per pantalla el nom i l’edat de cada alumne.
	public static void printNameAndAgent(List<Alumne> alumnes) {
		
		System.out.println("Mostra per pantalla el nom i l'edat de cada alumne:\n");
		
		alumnes.stream()
		.forEach(a->System.out.println("Nom: " + a.getName() + "	Edat: " + a.getAge()));
		
	}
	
	// Filtra la llista per tots els alumnes que el nom comenci per “A”
	// Assigna-ho a un altre llista y mostra per pantalla la nova llista (tot amb lambdas) 
	public static void filterByInitialLetter(List<Alumne> alumnes, char letter) {
		
		System.out.println("\nFiltrar tots els alumnes que comencin per A:");
				
		List<Alumne> alumnesFiltre = alumnes.stream()
				.filter(a -> a.getName().charAt(0) == letter )
				.collect(Collectors.toList());
		
		alumnesFiltre.stream()
		.forEach(a->System.out.println("Nom: " + a.getName() + "	Edat: " + a.getAge()));
		
	}

	// Filtra i mostra per pantalla els alumnes que tinguin un 5 o mes de nota.
	public static void filterByGrade(List<Alumne> alumnes,int  grade) {
				
		System.out.println("\nFiltrar tots els alumnes amb un 5 o més:");
		
		alumnes.stream()
				.filter(a -> a.getGrade() >=5)
				.forEach(a->System.out.println("Nom: " + a.getName() + "	Nota: " + a.getGrade()));
		
	}

	// Filtra i mostra per pantalla els alumnes que tinguin un 5 o més no siguin de PHP.
	public static void filterByGradeByCourse(List<Alumne> alumnes, int grade, String course) {
				
		System.out.println("\nFiltrar tots els alumnes amb un 5 o més i no fan PHP:");
		
		alumnes.stream()
				.filter(a -> a.getGrade() >=grade && !a.getCourse().equals(course))
				.forEach(a->System.out.println("Nom: " + a.getName() 
						+ "	Nota: " + a.getGrade()
						+ "	Curs: " + a.getCourse()));

	}

	// Mostra tots els alumnes que facin JAVA i siguin majors d’edat.
	public static void filterByAgeByCourse(List<Alumne> alumnes, int age, String course) {
		
		System.out.println("\nFiltrar tots els alumnes amb més de 18 anys i fan JAVA:");
		
		alumnes.stream()
				.filter(a -> a.getAge() >=age && a.getCourse().equals(course))
				.forEach(a->System.out.println("Nom: " + a.getName() 
						+ "	Edat: " + a.getAge()
						+ "	Curs: " + a.getCourse()));
		
	}

}
