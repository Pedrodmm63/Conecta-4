package conecta4;

import java.util.Arrays;

public class Tablero {

	private char[][] tablero;
	private int columnas = 7;
	private int filas = 6;
	private int[] donde;

	public Tablero() {
		int [] donde = new int[7];
		char[][] tablero = new char[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				char tablero2 = 7;
				tablero[i][j] = tablero2 ;
			}
		}
	}

	public void coloca(int donde) {

	}

}
