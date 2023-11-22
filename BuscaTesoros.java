package ArraysMultidimensionales;

import java.util.Random;
import java.util.Scanner;

public class BuscaTesoros {

	public static void main(String[] args) throws InterruptedException {

		Random random = new Random();
		Scanner leer = new Scanner(System.in);
		int[][] tablero = new int[4][4];
		String[][] memoria = new String[4][4];
		int i;
		int j;
		int numeroRandom;
		int fila;
		int columna;
		int vidas = 3;
		int opcion;

		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				memoria[i][j] = "[?]";
			}
		}

		System.out.println("========================");
		System.out.println("\r\n"
				+ "  ____                                   _____                                           \r\n"
				+ " | __ )   _   _   ___    ___    __ _    |_   _|   ___   ___    ___    _ __    ___    ___ \r\n"
				+ " |  _ \\  | | | | / __|  / __|  / _` |     | |    / _ \\ / __|  / _ \\  | '__|  / _ \\  / __|\r\n"
				+ " | |_) | | |_| | \\__ \\ | (__  | (_| |     | |   |  __/ \\__ \\ | (_) | | |    | (_) | \\__ \\\r\n"
				+ " |____/   \\__,_| |___/  \\___|  \\__,_|     |_|    \\___| |___/  \\___/  |_|     \\___/  |___/\r\n"
				+ "                                                                                         \r\n" + "");
		System.out.println("========================");
		System.out.println("1 JUGAR");
		System.out.println("2 SALIR");
		opcion = leer.nextInt();
		switch (opcion) {
		case 1:

			System.out.println("========================");
			System.out.println("esta es la nomencaltura:");
			System.out.println("Minas: *");
			System.out.println("tesoro: $");
			System.out.println("Vacio: ' '");
			System.out.println("desconocido: ?");
			System.out.println("========================");

			for (i = 0; i < 4; i++) {
				for (j = 0; j < 4; j++) {
					numeroRandom = random.nextInt(4);
					switch (numeroRandom) {
					case 0:
						tablero[i][j] = 0;
						break;

					case 1:
						tablero[i][j] = 1;
						break;

					case 2:
						tablero[i][j] = 2;
						break;
					}
				}
			}
			System.out.println("========================");
			System.out.print("Generando tablero.");
			Thread.sleep(700);
			System.out.print(".");
			Thread.sleep(700);
			System.out.println(".");
			Thread.sleep(700);
			do {
				System.out.println("========================");
				System.out.println("este es el tablero:");

				System.out.println("   0     1       2       3");
				for (i = 0; i < 4; i++) {
					System.out.print(i + " ");
					for (j = 0; j < 4; j++) {

						System.out.print(memoria[i][j] + "\t");
					}
					System.out.println();
				}
				System.out.println("========================");
				System.out.println("tienes " + vidas + " vidas ");
				if (vidas == 3) {
					System.out.println("( \\/ )  ( \\/ ) ( \\/ ) \r\n" + " \\  /    \\  /   \\  / \r\n"
							+ "  \\/      \\/     \\/");

				}
				if (vidas == 2) {
					System.out.println("( \\/ )  ( \\/ ) \r\n" + " \\  /    \\  /  \r\n" + "  \\/      \\/   ");

				}
				if (vidas == 1) {
					System.out.println("( \\/ )  \r\n" + " \\  /   \r\n" + "  \\/  ");

				}

				System.out.println("========================");

				do {
					System.out.print("Dime la fila: ");
					fila = leer.nextInt();
					if (fila < 0 || fila > 3) {
						System.out.println("NUMERO NO EXISTE");
					}
				} while (fila < 0 || fila > 3);

				do {
					System.out.print("Dime la columna: ");
					columna = leer.nextInt();
					if (columna < 0 || columna > 3) {
						System.out.println("NUMERO NO EXISTE");
					}
				} while (columna < 0 || columna > 3);

				if (tablero[fila][columna] == 0) {
					System.out.println("========================");
					System.out.println("Esta vacio");
					for (i = 0; i < 4; i++) {
						for (j = 0; j < 4; j++) {
							if (i == fila && j == columna) {

								memoria[i][j] = " ";
								if (j < 3) {
									if (tablero[i][j + 1] == 1) {
										System.out.println("hay una mina cerca cuidado");
										continue;
									}
								}
								if (j > 0) {
									if (tablero[i][j - 1] == 1) {
										System.out.println("hay una mina cerca cuidado");
										continue;
									}
								}
								if (i < 3) {
									if (tablero[i + 1][j] == 1) {
										System.out.println("hay una mina cerca cuidado");
										continue;
									}
								}
								if (i > 0) {
									if (tablero[i - 1][j] == 1) {
										System.out.println("hay una mina cerca cuidado");
										continue;
									}
								}
							}

						}
					}

				}

				if (tablero[fila][columna] == 1) {
					System.out.println("========================");
					System.out.println("Era una mina, pierdes una vida");
					tablero[fila][columna] = 0;
					vidas = vidas - 1;

					for (i = 0; i < 4; i++) {

						for (j = 0; j < 4; j++) {
							if (i == fila && j == columna) {

								memoria[i][j] = " *";

							}

						}

					}
				}

				if (tablero[fila][columna] == 2) {
					for (i = 0; i < 4; i++) {

						for (j = 0; j < 4; j++) {
							if (i == fila && j == columna) {

								memoria[i][j] = " $";

							}

						}

					}
					System.out.println("========================");
					System.out.println("   0     1       2       3");
					for (i = 0; i < 4; i++) {
						System.out.print(i + " ");
						for (j = 0; j < 4; j++) {

							System.out.print(memoria[i][j] + "\t");
						}
						System.out.println();
					}
					System.out.println("========================");
					System.out.println("has encontrado el tesoro");
					System.out.println("  __________\r\n" + "        /\\____;;___\\\r\n" + "       | /         /\r\n"
							+ "       `. ())oo() .\r\n" + "        |\\(%()*^^()^\\\r\n" + "       %| |-%-------|\r\n"
							+ "      % \\ | %  ))   |\r\n" + "      %  \\|%________|\r\n" + "  	%%%%  ");
					
					
					break;
					
					
				}
			
			} while (vidas > 0);
			System.out.println("========================");
			System.out.println("       GAME OVER");
			System.out.println("========================");
			System.out.println("pulsa 2 para salir");
					opcion = leer.nextInt();
					if (opcion == 2){
			break;
	}
		case 2:
			
			System.out.println("ADIOS");
			Thread.sleep(700);

		}

	}

}
