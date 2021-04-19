import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean acabado = false;
		while(!acabado) {
			imprimirMenu();
			int numero = scn.nextInt();
			usarElSwitch(numero);
			if(usarElSwitch(numero) == 9) {
				acabado = true;
				scn.close();
				System.out.println("�Hasta luego amigo!");
			}
		}
	}
	
	/*
	 * Imrpime el men� para elegir que quiere hacer el usuario
	 */
	public static void imprimirMenu() {
		System.out.println("1. Suma de dos matrices. \n2. Producto de un escalar por una matriz. \n3. Producto de dos matrices. \n4. Transponer una matriz. \n5. Diagonal principal de una matriz. \n6. Comprobar si una matriz es sim�trica. \n7. Potencia de una matriz cuadrada. \n8. Resta de dos matrices. \n9. Salir \n");
	}
	
	/*
	 *
	 * @param numero El numero a elegir del men�
	 */
	public static int usarElSwitch(int numero) {
		boolean seguir = true;
		do {
			switch(numero) {
			case 1: 
				seguir = false;
				suma();	
				break;
			case 2: 
				seguir = false;
				multiplicarMatrizPorNumeroEntero();
				break;
			case 3: 
				seguir = false;
				multiplicarMatrizPorUnaMatriz();
				break;
			case 4: 
				seguir = false;
				transponer();
				break;
			case 5: 
				seguir = false;
				diagonalPrincipal();
				break;
			case 6: 
				seguir = false;
				simetrica();
				break;
			case 7: 
				seguir = false;
				potencia();
				break;
			case 8: 
				seguir = false;
				resta();
				break;
			case 9: 
				seguir = false;
				break;
			default: 
				System.out.println("Te has equivocado de n�mero, introduce un n�mero del 1 al 9 \n");
				seguir = false;
			}
		}while(seguir);
		
		return numero;
	}
	
	/*
	 * Suma dos matrices 
	 */
	public static void suma() {
		
		System.out.println("Has elegido la opci�n de sumar matrices. \n");
		
		int matriz1[][] = generarMatriz();
		int matriz2[][] = generarMatriz();
		
		if(matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length) {
			
			//Genera la matriz resultante de la suma
			int resultado[][] = new int[matriz1.length][matriz1[0].length];
			for(int i = 0; i < resultado.length; i++) {
				for(int j = 0; j < resultado[0].length; j++) {
					resultado[i][j] = matriz1[i][j] + matriz2[i][j];
				}
			}
			
			//Imprime la matriz resultante de la suma
			System.out.println("Matriz resultado: ");
			for(int i = 0; i < resultado.length; i++) {
				System.out.println(Arrays.toString(resultado[i]));
			}
		}
		else {
			System.out.println("Las matrices introducidas no son de igual tama�o y por ello no se pueden sumar. Introduce dos matrices de igual tama�o. \n");
		}
	}
	
	/*
	 * Multiplica una matriz por un numero entero.
	 */
	public static void multiplicarMatrizPorNumeroEntero() {
		
		System.out.println("Has elegido la opci�n de multiplicar una matriz por un n�mero entero. \n");
		
		int matriz1[][] = generarMatriz();
		
		System.out.println("�Por qu� n�mero quieres multiplicarla?");
		int numero = scn.nextInt();
		
		//Genera la matriz resultante de la multiplicacion
		int resultado[][] = new int[matriz1.length][matriz1[0].length];
		for(int i = 0; i < resultado.length; i++) {
			for(int j = 0; j < resultado[0].length; j++) {
				resultado[i][j] = matriz1[i][j] * numero;
			}
		}
			
		//Imprime la matriz resultante de la multiplicaci�n
		System.out.println("Matriz resultado: ");
		for(int i = 0; i < resultado.length; i++) {
			System.out.println(Arrays.toString(resultado[i]));
		}
	}
	
	/*
	 * Multiplica una matriz por otra matriz.
	 */
	public static void multiplicarMatrizPorUnaMatriz() {
		
		System.out.println("Has elegido la opci�n de multiplicar matrices. \n");
		
		int matriz1[][] = generarMatriz();
		int matriz2[][] = generarMatriz();
		
		if(matriz1.length == matriz2[0].length) {
			//Genera la matriz resultante de la multiplicaci�n
			int resultado[][] = new int[matriz1.length][matriz2[0].length];
			for(int i = 0; i < matriz2[0].length; i++) {
				for(int j = 0; j < matriz1.length; j++) {
					for(int k = 0; k < matriz1.length; k++) {
						resultado[i][j] += (matriz1[i][k] * matriz2[k][j]);	
					}
				}
			}
				
			//Imprime la matriz resultante de la multiplicaci�n
			System.out.println("Matriz resultado: ");
			for(int i = 0; i < resultado.length; i++) {
				System.out.println(Arrays.toString(resultado[i]));
			}
		}
		else {
			System.out.println("El n�mero de filas de la primera matriz debe ser igual al n�mero de filas de la segunda matriz. \n");
		}
		
	}
	
	/*
	 * Transpone una matriz .
	 */
	public static void transponer() {
		
		System.out.println("Has elegido la opci�n de transponer una matriz. \n");
		
		int matriz1[][] = generarMatriz();
		
		//Genera la matriz resultante de transponer la matriz1
		int resultado[][] = new int[matriz1[0].length][matriz1.length];
		for(int i = 0; i < resultado.length; i++) {
			for(int j = 0; j < resultado[0].length; j++) {
				resultado[i][j] = matriz1[j][i];
			}
		}
			
		//Imprime la matriz resultante de transponer la matriz1
		System.out.println("Matriz resultado: ");
		for(int i = 0; i < resultado.length; i++) {
			System.out.println(Arrays.toString(resultado[i]));
		}
	}
	
	/*
	 * Obtiene la diagonal principal de una matriz.
	 */
	public static void diagonalPrincipal() {
		
		System.out.println("Has elegido la opci�n de obtener la diagonal principal de una matriz. \n");
		
		int matriz1[][] = generarMatriz();
		
		//Condici�n de que la matriz sea cuadrada
		if(matriz1.length == matriz1[0].length){
			//Genera un array con la diagonal principal en �l.
			int resultado[] = new int[matriz1.length];
			for(int i = 0; i < resultado.length; i++) {
				for(int j = 0; j < resultado.length; j++) {
					if(i == j) {
						resultado[i] = matriz1[i][j];
					}	
				}
			}
			//Imprime el array con la diagonal principal de la matriz
			System.out.println("Array resultado: ");
			System.out.println(Arrays.toString(resultado));
		}				
		else {
			System.out.println("La matriz introducida no es cuadrada. Introduce una matriz cuadrada para hallar la diagonal principal");
		}
	}
	
	/*
	 * Comprueba si una matriz es simetrica.
	 */
	public static void simetrica() {
		
		System.out.println("Has elegido la opci�n de matriz simetrica. \n");
		
		int matriz1[][] = generarMatriz();
		int filasPorColumnas = matriz1.length * matriz1[0].length;
		int contador = 0;
		//Condici�n de que la matriz sea simetrica
		if(matriz1.length == matriz1[0].length){
			//Genera un array con la diagonal principal en �l.
			for(int i = 0; i < matriz1.length; i++) {
				for(int j = 0; j < matriz1[0].length; j++) {
					if(matriz1[i][j] == matriz1[j][i]) {
						contador++;
						if(contador == filasPorColumnas) {
							System.out.println("La matriz introducida es simetrica: ");
							//Imprime la matriz sim�trica
							System.out.println("Matriz resultado: ");
							for(int z = 0; z < matriz1.length; z++) {
								System.out.println(Arrays.toString(matriz1[z]));
							}
					}
					}	
				}
			}
			
		}				
		else {
			System.out.println("La matriz introducida no es simetrica. Introduce una matriz sim�trica");
		}
	}
	
	/*
	 * Multiplica una matriz por otra matriz.
	 */
	public static void potencia() {
		
		System.out.println("Has elegido la opci�n de potencia. \n");
		
		int matriz1[][] = generarMatriz();
		
		int resultado[][] = new int[matriz1.length][matriz1[0].length];
		for(int i = 0; i < matriz1[0].length; i++) {
			for(int j = 0; j < matriz1.length; j++) {
				for(int k = 0; k < matriz1.length; k++) {
					resultado[i][j] += (matriz1[i][k] * matriz1[k][j]);	
				}
			}
		}
				
		//Imprime la matriz resultante de la multiplicaci�n
		System.out.println("Matriz resultado: ");
		for(int i = 0; i < resultado.length; i++) {
			System.out.println(Arrays.toString(resultado[i]));
		}		
	}
	
	/*
	 * Resta dos matrices 
	 */
	public static void resta() {
		
		System.out.println("Has elegido la opci�n de restar matrices. \n");
		
		int matriz1[][] = generarMatriz();
		int matriz2[][] = generarMatriz();
		
		if(matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length) {
			
			//Genera la matriz resultante de la resta
			int resultado[][] = new int[matriz1.length][matriz1[0].length];
			for(int i = 0; i < resultado.length; i++) {
				for(int j = 0; j < resultado[0].length; j++) {
					resultado[i][j] = matriz1[i][j] - matriz2[i][j];
				}
			}
			
			//Imprime la matriz resultante de la resta
			System.out.println("Matriz resultado: ");
			for(int i = 0; i < resultado.length; i++) {
				System.out.println(Arrays.toString(resultado[i]));
			}
		}
		else {
			System.out.println("Las matrices introducidas no son de igual tama�o y por ello no se pueden restar. Introduce dos matrices de igual tama�o. \n");
		}
	}
	
	/*
	 * Genera una matriz
	 * @return Devuelve la matriz generada
	 */
	private static int[][] generarMatriz(){
		System.out.println("Filas de la matriz: ");
		int filas = scn.nextInt();
		System.out.println("Columnas de la matriz: ");
		int columnas = scn.nextInt();
		int matriz[][] = new int[filas][columnas];
		
		System.out.println("Introduce valores en la matriz: ");
		try {
			for(int i = 0; i < matriz.length; i++) {
				for(int j = 0; j < matriz[0].length; j++) {
					matriz[i][j] = scn.nextInt();
				}
			}
		}
		catch(java.util.InputMismatchException e){
			System.out.println("Introduce un numero entero.");
		}
		
		return matriz;
	}
}