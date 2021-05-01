/*
 * @author Roberto Alarcon Bardon
 * @version 01-05-2021
 */

package CDM1.RobertoAlarcon;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static Scanner scn = new Scanner(System.in);
	private static boolean salir;
	
	public static void main(String[] args) {
		bienvenida();
		int numero;
		do {
			imprimirMenu();
			numero = scn.nextInt();
			elegirOpcion(numero);
		}
		while(numero != 9);
		scn.close();
		System.out.println("\n¡Hasta luego amig@!");
	}

	/*
	 * Elige entre las opciones disponibles
	 * @param numero El numero a elegir del menú
	 */
	public static void elegirOpcion(int numero) {
			switch (numero) {
			case 1:
				System.out.println("\nHas elegido la opción de sumar matrices.");
				suma();				
				break;
			case 2:
				System.out.println("\nHas elegido la opción de multiplicar una matriz por un número entero.");
				multiplicarMatrizPorNumeroEntero();
				break;
			case 3:
				System.out.println("\nHas elegido la opción de multiplicar matrices.");
				multiplicarMatrizPorUnaMatriz();
				break;
			case 4:
				System.out.println("\nHas elegido la opción de transponer una matriz.");
				transponer();
				break;
			case 5:
				System.out.println("\nHas elegido la opción de obtener la diagonal principal de una matriz.");
				diagonalPrincipal();
				break;
			case 6:
				System.out.println("\nHas elegido la opción de matriz simetrica.");
				simetrica();
				break;
			case 7:
				System.out.println("\nHas elegido la opción de potencia.");
				potencia();
				break;
			case 8:
				System.out.println("\nHas elegido la opción de restar matrices.");
				resta();
				break;
			case 9:
				break;
			default:
				System.out.println("\nTe has equivocado de número, introduce un número del 1 al 9.\n");
				
			}
	}

	/*
	 * Suma dos matrices
	 */
	public static void suma() {
		// Inicializa el atributo seguir
		salir = false;
		
		do {
			int matriz1[][] = crearMatriz(1);
			int matriz2[][] = crearMatriz(2);
	
			// Condicion de que las matrices sean iguales en tamaño
			if ((matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length)) { // No consigo hacer que la condicion funcione con el switch
	
				// Introduce numeros a las matrices
				llenarMatriz(matriz1, 1);
				llenarMatriz(matriz2, 2);
				
				// Genera la matriz resultante de la suma
				int resultado[][] = sumarORestarMatrices(matriz1, matriz2, 1);
	
				// Imprime la matriz resultante de la suma
				imprimirMatriz(resultado);
				salir = true;
			} 
			else {
				System.out.println("\nLas matrices introducidas no son de igual tamaño y por ello no se pueden sumar. Introduce dos matrices de igual tamaño.\n");
			}
		}while(!salir); // Que las matrices introducidas cumplan la condicion
	}

	/*
	 * Multiplica una matriz por un número entero.
	 */
	public static void multiplicarMatrizPorNumeroEntero() {
		
		int matriz1[][] = crearMatriz(1);
		llenarMatriz(matriz1, 1);

		System.out.println("\n¿Por qué número quieres multiplicarla?");
		int numero = scn.nextInt();

		// Genera la matriz resultante de la multiplicacion
		int resultado[][] = new int[matriz1.length][matriz1[0].length];
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[0].length; j++) {
				resultado[i][j] = matriz1[i][j] * numero;
			}
		}

		// Imprime la matriz resultante de la multiplicacion por el numero entero
		imprimirMatriz(resultado);
	}

	/*
	 * Multiplica una matriz por otra matriz.
	 */
	public static void multiplicarMatrizPorUnaMatriz() {
		
		// Inicializa el atributo seguir
		salir = false;
				
		do {		
			int matriz1[][] = crearMatriz(1);
			int matriz2[][] = crearMatriz(2);

			// Comprobacion de que las columnas de la primera sean igual a las filas de la segunda
			if (condicionDos(matriz1, matriz2, "multiplicacion")) {
				
				// Introduce numeros a las matrices
				llenarMatriz(matriz1, 1);
				llenarMatriz(matriz2, 2);
				
				// Genera la matriz resultante de la multiplicación
				int resultado[][] = multiplicarMatrices(matriz1, matriz2);
		
				// Imprime la matriz resultante de la multiplicacion de matrices
				imprimirMatriz(resultado);
				salir = true;
			}
			else {
				System.out.println(
						"\nEl número de filas de la primera matriz debe ser igual al número de filas de la segunda matriz. \n");
			}
		}while(!salir); // Que las matrices introducidas cumplan la condicion
	}

	/*
	 * Transpone una matriz.
	 */
	public static void transponer() {

		int matriz1[][] = crearMatriz(1);
		llenarMatriz(matriz1, 1);
		
		// Genera la matriz resultante de transponer la matriz1
		int resultado[][] = new int[matriz1[0].length][matriz1.length];
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[0].length; j++) {
				resultado[i][j] = matriz1[j][i];
			}
		}

		// Imprime la matriz traspuesta
		imprimirMatriz(resultado);
	}

	/*
	 * Obtiene la diagonal principal de una matriz.
	 */
	public static void diagonalPrincipal() {

		// Inicializa el atributo seguir
		salir = false;
				
		do {	
			int matriz1[][] = crearMatriz(1);
	
			// Condición de que la matriz sea cuadrada
			if (condicionUno(matriz1, "diagonal")) {
				
				// Introduce numeros a la matriz
				llenarMatriz(matriz1, 1);
				
				// Genera un array con la diagonal principal en él.
				int resultado[] = new int[matriz1.length];
				for (int i = 0; i < resultado.length; i++) {
					for (int j = 0; j < resultado.length; j++) {
						if (i == j) {
							resultado[i] = matriz1[i][j];
						}
					}
				}
				// Imprime el array con la diagonal principal de la matriz
				System.out.println("\nArray resultado: ");
				System.out.println(Arrays.toString(resultado) + "\n");
				salir = true;
			} 
			else {
				System.out.println(
						"\nLa matriz introducida no es cuadrada. Introduce una matriz cuadrada para hallar la diagonal principal.\n");
			}
		}while(!salir); // Que la matriz introducidas cumplan la condicion
	}

	/*
	 * Comprueba si una matriz es simetrica.
	 */
	public static void simetrica() {

		// Inicializa el atributo seguir
		salir = false;
						
		do {			
			int matriz1[][] = crearMatriz(1);
			int filasPorColumnas = matriz1.length * matriz1[0].length;
			int contador = 0;
		
			// Condición de que la matriz sea cuadrada
			if (condicionUno(matriz1, "simetrica")) {
				
				// Introduce numeros a la matriz
				llenarMatriz(matriz1, 1);
				
				// Aumenta el contador por cada numero que sea igual
				for (int i = 0; i < matriz1.length; i++) {
					for (int j = 0; j < matriz1[0].length; j++) {
						if (matriz1[i][j] == matriz1[j][i]) {
							contador++;							
						}
					}
				}
				
				// Comprueba si la matriz es simetrica
				if (contador == filasPorColumnas) {
					System.out.println("\nLa matriz introducida es simétrica:");
					imprimirMatriz(matriz1);
					salir = true;
				}
				else {
					System.out.println("\nLa matriz introducida no es simétrica.\n");
					salir = true;
				}
	
			} 
			else {
				System.out.println("\nLa matriz introducida no es cuadrada. Introduce una matriz cuadrada.\n");
			}
		}while(!salir); // Que las matrices introducidas cumplan la condicion
	}

	/*
	 * Eleva la matriz a un numero elegido.
	 */
	public static void potencia() {

		// Inicializa el atributo seguir
		salir = false;
						
		do {	
			int matriz1[][] = crearMatriz(1);
			
			// Condición de que la matriz sea cuadrada
			if (condicionUno(matriz1, "potencia")) {
				
				// Introduce numeros a la matriz
				llenarMatriz(matriz1, 1);
				
				System.out.println("\n¿A que numero quiere elevarla?\n");
				int elevado = scn.nextInt();
				
				// Genera la matriz resultante de la potencia
				int resultado[][] = matriz1.clone();
				for (int i = 1; i < elevado; i++) {
					resultado = multiplicarMatrices(matriz1, resultado);
				}
				// Imprime la matriz resultante de la multiplicación
				imprimirMatriz(resultado);
				salir = true;
			
			}
			else {
				System.out.println("\nLa matriz introducida no es cuadrada. Introduce una matriz cuadrada para hallar la matriz resultante\n");
			
			}
		}while(!salir); // Que la matriz introducidas cumplan la condicion
	}

	/*
	 * Resta dos matrices
	 */
	public static void resta() {

		// Inicializa el atributo seguir
		salir = false;
						
		do {	
			int matriz1[][] = crearMatriz(1);
			int matriz2[][] = crearMatriz(2);

			// Condicion de que las matrices sean iguales en tamaño
			if ((matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length)) { // No consigo hacer que la condicion funcione con el switch
	
				// Introduce numeros a las matrices
				llenarMatriz(matriz1, 1);
				llenarMatriz(matriz2, 2);
				
				// Genera la matriz resultante de la resta
				int resultado[][] = sumarORestarMatrices(matriz1, matriz2, -1);
	
				// Imprime la matriz resultante de la resta
				imprimirMatriz(resultado);
				salir = true;
				
			} 
			else {
				System.out.println(
						"\nLas matrices introducidas no son de igual tamaño y por ello no se pueden restar. Introduce dos matrices de igual tamaño. \n");
			}
		}while(!salir); // Que las matrices introducidas cumplan la condicion
	}
	
	/*
	 * Mensaje de explicacion y bienvenida al usuario
	 */
	private static void bienvenida() {
		System.out.println("Bienvenido amig@.");
		System.out.println("Esto es un programa para hacer operaciones con matrices.\n");
	}

	/*
	 * Imrpime el menú para elegir que quiere hacer el usuario
	 */
	private static void imprimirMenu() {
		System.out.println("Seleccione una opcion: \n");
		System.out.println("  1. Suma de dos matrices.");
		System.out.println("  2. Producto de un escalar por una matriz.");
		System.out.println("  3. Producto de dos matrices.");
		System.out.println("  4. Transponer una matriz.");
		System.out.println("  5. Diagonal principal de una matriz.");
		System.out.println("  6. Comprobar si una matriz es simétrica.");
		System.out.println("  7. Potencia de una matriz cuadrada.");
		System.out.println("  8. Resta de dos matrices. ");
		System.out.println("  9. Salir");
		System.out.println();
	}
	
	/*
	 * Crea una matriz
	 * @return Devuelve la matriz creada
	 */
	private static int[][] crearMatriz(int numero) {
		String posicion= "";
	
		if (numero == 1) {
			posicion = "primera";
		}
		else {
			posicion = "segunda";
		}
		
		System.out.println("\nFilas de la " + posicion + " matriz: ");
		int filas = scn.nextInt();
		System.out.println("Columnas de la " + posicion + " matriz: ");
		int columnas = scn.nextInt();
		int matriz[][] = new int[filas][columnas];

		return matriz;
	}
	
	/*
	 * Introduce numeros en una matriz
	 * @return Devuelve la matriz con los numeros introducidos
	 */
	private static int[][] llenarMatriz(int matriz[][], int numero) {
		
		System.out.println("\nIntroduce valores en la " + numero + " matriz:");
		for (int i = 0; i < matriz.length; i++) {
			System.out.println("Estas introduciendo la fila numero " + (i+1));
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = scn.nextInt();
			}
		}
		
		return matriz;
	}

	/*
	 * Imprime una matriz
	 * @param matriz[][] Matriz a imprimir
	 */
	private static void imprimirMatriz(int matriz[][]) {
		System.out.println("\nMatriz resultado: ");
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(Arrays.toString(matriz[i]));
		}
		System.out.println();
	}
	
	/*
	 * Multiplica dos matrices
	 * @param matriz1[][] La primera matriz a multiplicar
	 * @param matriz2[][] La segunda matriz a multiplicar
	 * @return El resultado de la multiplicacion
	 */
	public static int[][] multiplicarMatrices(int matriz1[][], int matriz2[][]) {
		
		int resultado[][] = new int[matriz1.length][matriz2[0].length];
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz2[0].length; j++) {
				for (int k = 0; k < matriz1[0].length; k++) {
					resultado[i][j] += (matriz1[i][k] * matriz2[k][j]);
				}
			}
		}
		return resultado;
	}
	
	/*
	 * Suma dos matrices
	 * @param matriz1[][] La primera matriz a sumar
	 * @param matriz2[][] La segunda matriz a sumar
	 * @param unoOMenosUno El numero que hace que sea suma o resta de matrices
	 * @return El resultado de la suma
	 */
	public static int[][] sumarORestarMatrices(int matriz1[][], int matriz2[][], int unoOMenosno) {
	
		int resultado[][] = new int[matriz1.length][matriz1[0].length];
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[0].length; j++) {
				resultado[i][j] = matriz1[i][j] + (matriz2[i][j] * unoOMenosno);
			}
		}
		return resultado;
	}
	
	/*
	 * Condicion de los metodos diagonal principal, siemtria y potencia
	 * @param matriz1[][] La primera matriz
	 * @param tipo La operacion que se va a hacer
	 * @return Si cumple o no cumple la condicion
	 */
	public static boolean condicionUno(int matriz1[][], String tipo) {
		boolean cumple = false;
		switch(tipo) {
				
			case "diagonal":
			case "simetrica":
			case "potencia":
					cumple = (matriz1.length == matriz1[0].length);
		}
		return cumple;
	}
	
	/*
	 * Condicion de la suma y la resta y multiplicacion de matrices
	 * @param matriz1[][] La primera matriz
	 * @param matriz2[][] La segunda matriz
	 * @param tipo La operacion que se va a hacer
	 * @return Si cumple o no cumple la condicion
	 */
	public static boolean condicionDos(int matriz1[][], int matriz2[][], String tipo) {
		boolean cumple = false;
		switch(tipo) {
			/*case "suma": 
			case "resta":
				cumple = (matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length);
				*/
			case "multiplicacion":
				cumple = matriz1[0].length == matriz2.length;
		}
		return cumple;
	}
	
}