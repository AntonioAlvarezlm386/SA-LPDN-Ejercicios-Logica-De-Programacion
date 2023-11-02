package org.generation.SA_LPDN;

import java.util.Scanner;

public class Ejercicio7 {
	
	
	/*Obtenemos el numero de días de la semana que han pasado desde el lunes 00:00*/
	public static int getCurrentDay(String day) {
		int dayIndex = 0;
		switch(day) {
		case "lunes":
			dayIndex = 0;
			break;
		case "martes":
			dayIndex = 1;
			break;
		case "miercoles":
			dayIndex = 2;
			break;
		case "jueves":
			dayIndex = 3;
			break;
		case "viernes":
			dayIndex = 4;
			break;
		}
		return dayIndex;
	}
	
	/*minutos totales desde el lunes 00:00, hasta el viernes 15:00, menos los minutos que han pasado desde el lunes 00:00*/
	public static int minutesToWeekend(String day, int hour, int minutes) {
		final double MINUTES_PER_WEEK = ((4 * 24 * 60) + (15 * 60));
		
		int currentDay = getCurrentDay(day);
		double minutesPassed = (currentDay * 24 * 60) + (hour * 60) + minutes;
		System.out.println(currentDay);
		
		return (int) ((int)MINUTES_PER_WEEK - minutesPassed);
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Este programa calcula cuantos minutos faltan para el fin de semana");
		
		System.out.println("Ingrese el día de la semana en minusculas: ");
		String currentDay = scanner.nextLine();
		System.out.println("ingrese la hora actual en formato de 24 horas: ");
		int currentHour = scanner.nextInt();
		System.out.println("¿Cuantos minutos han pasado de las " + currentHour + "?");
		int minutes = scanner.nextInt();
		
		System.out.println("Faltan " + minutesToWeekend(currentDay, currentHour, minutes) + " minutos para el fin de semana!");
		scanner.close();
	}

}
