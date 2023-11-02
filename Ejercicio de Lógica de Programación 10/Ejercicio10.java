package org.generation.SA_LPDN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio10 {

	/*
	 * Método a partir del cual podemos accerder a el diccionario
	 */
	public static HashMap<String, String> dictionary(){
		HashMap<String, String> dictionary = new HashMap<>();
		
		dictionary.put("tener", "have");
		dictionary.put("poder", "can");
		dictionary.put("pensar", "think");
		dictionary.put("trabajar", "work");
		dictionary.put("tiempo", "time");
		dictionary.put("ojo", "eye");
		dictionary.put("semana", "week");
		dictionary.put("dia", "day");
		dictionary.put("mano", "hand");
		dictionary.put("teclado", "keyboard");
		dictionary.put("vida", "life");
		dictionary.put("nuevo", "new");
		dictionary.put("despues", "after");
		dictionary.put("siempre", "always");
		dictionary.put("cantidad", "amount");
		dictionary.put("atencion", "attention");
		dictionary.put("reina", "queen");
		dictionary.put("hermano", "brother");
		dictionary.put("comprar", "buy");
		dictionary.put("libro", "book");
		
		return dictionary;
	}
	
	
	/*Generador de arrayList de indices aleatorios, donde se asegura que los indices no se repitan*/
	public static ArrayList<Integer> randomIndexGenerator(){
		ArrayList<Integer> randomIndex = new ArrayList<>();
		
		int i = 0;
		while(i < 5) {
			int index = (int) Math.round((Math.random()*19));
			if(!randomIndex.contains(index)) {
				randomIndex.add(index);
				i++;
			}
		}
		
		return randomIndex;
	}
	
	
	/*se extraen las palabras del diccionario de acuerdo a los indices generados en el metodo randomIndexGenerator()*/
	public static void requestWords(ArrayList<Integer> randomIndex) {
		
		ArrayList<String> wordRequestList = new ArrayList<>();
		Object[] wordList = dictionary().keySet().toArray();
		
		for(int j=0; j<5; j++) {
			wordRequestList.add((String) wordList[randomIndex.get(j)]);
		}
		
		System.out.println(wordRequestList);
	}
	
	
	/*
	 * Método que se encarga de verificar los aciertos del usuario, y devolver una calificación
	 */
	public static void checkInput(String[] input) {
		int correctWords = 0;
		int wrongWords = 0;
		for(String word: input) {
			if(dictionary().containsValue(word)) {
				correctWords++;
			} else {
				wrongWords++;
			}
		}
		System.out.println("Acertaste " + correctWords + " palabras, fallaste " + wrongWords + " palabras.");
	}
	
	
	/*
	 * Método main, es el punto de acceso del usuario a nuestra clase
	 */
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		
		System.out.println("ingresa la traducción en ingles de las siguientes palabras\n\t-Las palabras deben estar separadas por comas-\n");
		requestWords(randomIndexGenerator());
		String[] inputWords = scn.nextLine().split(",");
		checkInput(inputWords);
		
		scn.close();
		
	}
}
