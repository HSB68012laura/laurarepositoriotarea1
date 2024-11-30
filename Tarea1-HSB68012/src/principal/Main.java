package principal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int eleccion = -1;
		System.out.println("Programa Main iniciado correctamente por Laura");
		do {
			mostrarMenu();
			eleccion = in.nextInt();
			in = new Scanner(System.in);
			switch (eleccion) {
			case 1:
				int num1, num2;
				System.out.println("Introduzca el primer número entero:");
				num1 = in.nextInt();
				System.out.println("Introduzca el segundo número entero:");
				num2 = in.nextInt();
				if (num1 == num2)
					System.out.println("Los valores introducidos son iguales.");
				else if (num1 > num2)
					System.out.println(
							"El primer valor introducido (" + num1 + ") es mayor que el segundo (" + num2 + ").");
				else
					System.out.println(
							"El segundo valor introducido (" + num2 + ") es mayor que el primero (" + num1 + ").");
				break;

			case 2:
				String cadena;
				boolean valido = false;
				do {
					System.out.println("Introduzca una cadena de caracteres de longitud mayor que 1 y pulse INTRO:");
					cadena = in.nextLine();
					valido = (cadena.length() > 1);
					if (!valido)
						System.out.println(
								"ERROR: La longitud de la cadena ha de ser mayor que 1. Introduzca de nuevo la cadena.");
				} while (!valido);
				char caracter = 0;
				valido = false;
				do {
					in = new Scanner(System.in);
					System.out.println("Introduzca ahora un solo caracter:");
					String aux = in.nextLine();
					valido = (aux.length() == 1);
					if (!valido)
						System.out.println("ERROR: Introduzca un solo caracter. Repita la operación de nuevo.");
					else
						caracter = aux.charAt(0);
				} while (!valido);
				if (cadena.contains(String.valueOf(caracter)))
					System.out.println("La cadena \"" + cadena + "\" SÍ contiene al caracter " + caracter);
				else
					System.out.println("El caracter " + caracter + " NO está contenido en la cadena \"" + cadena + "\".");
				break;
				
			case 3:
				char[] vocales = {'a', 'e', 'i', 'o', 'u'};
//				Random rand = new Random();
//				int random_integer = rand.nextInt(max-min) + min;
				//OTRA manera: 	(int)(Math.random() * ((max - min) + 1)) + min
				int aleatorio2 = (int)(Math.random() * ((4 - 0) + 1)) + 0;
				System.out.println("Se ha generado aleatoriamente la vocal: '"+ vocales[aleatorio2]+"'.");
				break;
				
			case 4:
				LocalDateTime ahora = LocalDateTime.now();
				System.out.println("La fecha y hora actuales son: "+ ahora.format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-YYYY"))+".");
				break;
				
			case 0:
				System.out.println("Ha elegido SALIR. Adiós.");
				break;
			default:
				System.out.println("ERROR: Valor inválido para la opción. Elija de nuevo.");
			}

		} while (eleccion != 0);
		in.close();
		System.out.println("El programa Main finaliza correctamente.");
	}

	private static void mostrarMenu() {
		System.out.println("\nMENU PRINCIPAL");
		System.out.println("Pulse 0 para SALIR y finalizar el programa.\n"
				+ "Pulse 1 para introducir 2 nºs enteros y que se muestre por pantalla un mensaje indicando si un valor es mayor que el otro o si son iguales.\n"
				+ "Pulse 2 para introducir una cadena de caracteres de longitud mayor que 1, junto a otro caracter, y el programa determina si el carácter está incluido en la cadena o no, mostrando un mensaje al usuario.\n"
				+ "Pulse 3 para generar aleatoriamente el valor de una de las 5 vocales y que se muestre por pantalla dicho valor.\n"
				+ "Pulse 4 para mostrar la fecha y hora actual, a través de un objeto java.time.LocalDatetime");
	}

}
