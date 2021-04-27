import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int numero;
		do {
			imprimirMenu();
			numero = scn.nextInt();
			elegirOpcion(numero);
		}
		while(numero != 9);
		scn.close();
		System.out.println();
		System.out.println("�Hasta luego amig@!");
	}

	/*
	 * Elige entre las opciones disponibles
	 * @param numero El numero a elegir del men�
	 */
	public static void elegirOpcion(int numero) {
			switch (numero) {
			case 1:
				System.out.println("Has elegido la opci�n de sumar matrices. \n");
				suma();				
				break;
			case 2:
				System.out.println("Has elegido la opci�n de multiplicar una matriz por un n�mero entero. \n");
				multiplicarMatrizPorNumeroEntero();
				break;
			case 3:
				System.out.println("Has elegido la opci�n de multiplicar matrices. \n");
				multiplicarMatrizPorUnaMatriz();
				break;
			case 4:
				System.out.println("Has elegido la opci�n de transponer una matriz. \n");
				transponer();
				break;
			case 5:
				System.out.println("Has elegido la opci�n de obtener la diagonal principal de una matriz. \n");
				diagonalPrincipal();
				break;
			case 6:
				System.out.println("Has elegido la opci�n de matriz simetrica. \n");
				simetrica();
				break;
			case 7:
				System.out.println("Has elegido la opci�n de potencia. \n");
				potencia();
				break;
			case 8:
				System.out.println("Has elegido la opci�n de restar matrices. \n");
				resta();
				break;
			case 9:
				break;
			default:
				System.out.println("Te has equivocado de n�mero, introduce un n�mero del 1 al 9 \n");
				
			}
	}

	/*
	 * Suma dos matrices
	 */
	public static void suma() {

		int matriz1[][] = generarMatriz();
		int matriz2[][] = generarMatriz();

		// Condicion de que las matrices sean iguales
		if ((matriz1.length == matriz2.length) && (matriz1[0].length == matriz2[0].length)) {

			// Genera la matriz resultante de la suma
			int resultado[][] = new int[matriz1.length][matriz1[0].length];
			for (int i = 0; i < resultado.length; i++) {
				for (int j = 0; j < resultado[0].length; j++) {
					resultado[i][j] = matriz1[i][j] + matriz2[i][j];
				}
			}

			// Imprime la matriz resultante de la suma
			imprimirMatriz(resultado);
		} else {
			System.out.println("Las matrices introducidas no son de igual tama�o y por ello no se pueden sumar. Introduce dos matrices de igual tama�o. \n");
		}
	}

	/*
	 * Multiplica una matriz por un n�mero entero.
	 */
	public static void multiplicarMatrizPorNumeroEntero() {

		int matriz1[][] = generarMatriz();

		System.out.println("�Por qu� n�mero quieres multiplicarla?");
		int numero = scn.nextInt();

		// Genera la matriz resultante de la multiplicacion
		int resultado[][] = new int[matriz1.length][matriz1[0].length];
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[0].length; j++) {
				resultado[i][j] = matriz1[i][j] * numero;
			}
		}

		imprimirMatriz(resultado);
	}

	/*
	 * Multiplica una matriz por otra matriz.
	 */
	public static void multiplicarMatrizPorUnaMatriz() {

		int matriz1[][] = generarMatriz();
		int matriz2[][] = generarMatriz();

		// Comprobacion de que las columnas de la primera sean igual a las filas de la segunda
		if (matriz1[0].length == matriz2.length) {
			
		// Genera la matriz resultante de la multiplicaci�n
		int resultado[][] = multiplicar(matriz1, matriz2);

		imprimirMatriz(resultado);
			
		} else {
			System.out.println(
					"El n�mero de filas de la primera matriz debe ser igual al n�mero de filas de la segunda matriz. \n");
		}
	}

	/*
	 * Transpone una matriz.
	 */
	public static void transponer() {

		int matriz1[][] = generarMatriz();

		// Genera la matriz resultante de transponer la matriz1
		int resultado[][] = new int[matriz1[0].length][matriz1.length];
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[0].length; j++) {
				resultado[i][j] = matriz1[j][i];
			}
		}

		imprimirMatriz(resultado);
	}

	/*
	 * Obtiene la diagonal principal de una matriz.
	 */
	public static void diagonalPrincipal() {

		int matriz1[][] = generarMatriz();

		// Condici�n de que la matriz sea cuadrada
		if (matriz1.length == matriz1[0].length) {
			
			// Genera un array con la diagonal principal en �l.
			int resultado[] = new int[matriz1.length];
			for (int i = 0; i < resultado.length; i++) {
				for (int j = 0; j < resultado.length; j++) {
					if (i == j) {
						resultado[i] = matriz1[i][j];
					}
				}
			}
			// Imprime el array con la diagonal principal de la matriz
			System.out.println("Array resultado: ");
			System.out.println(Arrays.toString(resultado));
		} else {
			System.out.println(
					"La matriz introducida no es cuadrada. Introduce una matriz cuadrada para hallar la diagonal principal");
		}
	}

	/*
	 * Comprueba si una matriz es simetrica.
	 */
	public static void simetrica() {

		int matriz1[][] = generarMatriz();
		int filasPorColumnas = matriz1.length * matriz1[0].length;
		int contador = 0;
		
		// Condici�n de que la matriz sea simetrica
		if (matriz1.length == matriz1[0].length) {
			
			// Genera un array con la diagonal principal en �l.
			for (int i = 0; i < matriz1.length; i++) {
				for (int j = 0; j < matriz1[0].length; j++) {
					if (matriz1[i][j] == matriz1[j][i]) {
						contador++;
						if (contador == filasPorColumnas) {
							System.out.println("La matriz introducida es simetrica: ");
							imprimirMatriz(matriz1);
						}
					}
				}
			}

		} else {
			System.out.println("La matriz introducida no es simetrica. Introduce una matriz sim�trica");
		}
	}

	/*
	 * Eleva la matriz a un numero elegido.
	 */
	public static void potencia() {

		int matriz1[][] = generarMatriz();
		
		System.out.println("A que numero quiere elevarla. \n");
		int elevado = scn.nextInt();
		
		// Condici�n de que la matriz sea cuadrada
		if (matriz1.length == matriz1[0].length) {
			int resultado[][] = matriz1.clone();
			for (int i = 1; i < elevado; i++) {
				resultado = multiplicar(matriz1, resultado);
			}
			// Imprime la matriz resultante de la multiplicaci�n
			imprimirMatriz(resultado);
		
		}
		else {
			System.out.println("La matriz introducida no es cuadrada. Introduce una matriz cuadrada para hallar la matriz resultante");
		
		}
	}

	/*
	 * Resta dos matrices
	 */
	public static void resta() {

		int matriz1[][] = generarMatriz();
		int matriz2[][] = generarMatriz();

		// Condicion de que las matrices sean iguales
		if ((matriz1.length == matriz2.length) && (matriz1[0].length == matriz2[0].length)) {

			// Genera la matriz resultante de la resta
			int resultado[][] = new int[matriz1.length][matriz1[0].length];
			for (int i = 0; i < resultado.length; i++) {
				for (int j = 0; j < resultado[0].length; j++) {
					resultado[i][j] = matriz1[i][j] - matriz2[i][j];
				}
			}

			// Imprime la matriz resultante de la resta
			imprimirMatriz(resultado);
			
		} else {
			System.out.println(
					"Las matrices introducidas no son de igual tama�o y por ello no se pueden restar. Introduce dos matrices de igual tama�o. \n");
		}
	}

	/*
	 * Imrpime el men� para elegir que quiere hacer el usuario
	 */
	private static void imprimirMenu() {
		System.out.println("1. Suma de dos matrices.");
		System.out.println("2. Producto de un escalar por una matriz.");
		System.out.println("3. Producto de dos matrices.");
		System.out.println("4. Transponer una matriz.");
		System.out.println("5. Diagonal principal de una matriz.");
		System.out.println("6. Comprobar si una matriz es sim�trica.");
		System.out.println("7. Potencia de una matriz cuadrada.");
		System.out.println("8. Resta de dos matrices. ");
		System.out.println("9. Salir");
		System.out.println();
	}
	
	/*
	 * Genera una matriz
	 * @return Devuelve la matriz generada
	 */
	private static int[][] generarMatriz() {
		System.out.println("Filas de la matriz: ");
		int filas = scn.nextInt();
		System.out.println("Columnas de la matriz: ");
		int columnas = scn.nextInt();
		int matriz[][] = new int[filas][columnas];

		System.out.println("Introduce valores en la matriz: \n");
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
		System.out.println("Matriz resultado: ");
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(Arrays.toString(matriz[i]));
		}
		System.out.println();
	}
	
	/*
	 * Multiplica dos matrices
	 * @param matriz1[][] matriz a multiplicar
	 * @param matriz2[][] matriz a multiplicar
	 * @return El resultado de la multiplicacion
	 */
	public static int[][] multiplicar(int matriz1[][], int matriz2[][]) {
		
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
}