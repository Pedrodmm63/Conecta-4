package conecta4;

import java.util.Arrays;

public class Tablero {

	private int columnas = 7;
	private int filas = 6;
	private char[][] tablero = new char[filas][columnas];
	private int[] huecosColumnas = new int[7];
	private char turno;
	private boolean esGanador;

	public Tablero() {

		for (int i = 0; i < filas; i++) {

			for (int j = 0; j < columnas; j++) {

				tablero[i][j] = '-';
			}
		}

		for (int i = 0; i < columnas; i++) {
			huecosColumnas[i] = filas - 1;
		}
		turno = 'X';

		esGanador = false;
	}

	public void coloca(int donde) {

		if (donde >= 6) {
			donde = 6;
		}

		if (tablero[huecosColumnas[donde]][donde] == '-') {

			tablero[huecosColumnas[donde]][donde] = turno;
			huecosColumnas[donde]--;
//				GanadorVertical(turno,huecosColumnas[donde], donde);
//			
			esGanador = GanadorVertical(donde, donde);
			esGanador = esGanador || GanadorHorizontal(huecosColumnas[donde]+1, donde);
			esGanador = esGanador || GanadorDiagonal(huecosColumnas[donde]+1, donde);
			turno = (turno == 'X') ? 'O' : 'X';
		}

	}
	public boolean GanadorDiagonal(int fila, int columna) {
		char ficha = tablero[fila][columna];
		int contador = 0;
		int posicion = 0;
		
		int resta = (fila<columna) ? fila : columna;
		
		while(contador <4 && fila < filas & columna < columnas) {
			if(tablero[fila][posicion] == tablero[fila][columna]) {
				contador++;
				fila++;
				columna++;
				
			}
			else contador = 0;
			posicion++;
		}
		
		if(contador == 4) {
			esGanador = true;
		}
		
		
		return esGanador;
	}

	private boolean GanadorHorizontal(int fila, int columna) {
		char ficha = tablero[fila][columna];
		int contador = 0;
		int posicion = 0;
		
		while(contador < 4 && posicion < columnas) {
			if(tablero[fila][posicion] == tablero[fila][columna]) {
				contador++;
				
			}
			else contador = 0;
			posicion++;
		}
		
		if(contador == 4) {
			esGanador = true;
		}
		
		return esGanador;
	}

	public boolean isEsGanador() {
		return esGanador;
	}

//	public void GanadorVertical(char turno, int fila, int columna) {
//		int contador = 0;
//		while (contador != 4 && fila < filas) {
//
//			if (tablero[fila][columna] == turno) {
//
//				contador++;
//
//			}
//			if (contador == 4) {
//				esGanador = true;
//			}
//			fila++;
//		}
//	}

	public boolean GanadorVertical(int fila, int columna) {
		int coincidencia = 0;
		char mirarChar = tablero[fila][columna];

		if (fila <= 2) {
			for (int i = fila + 1; i < fila + 3; i++) {
				if (tablero[i][columna] == mirarChar) {

					coincidencia++;
				}
				
				else coincidencia = 0;
			}
		}

		if (coincidencia == 4) {
			esGanador = true;
		}
		return esGanador;
	}

	@Override
	public String toString() {
		String devolver = "";

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				devolver += tablero[i][j] + " ";
			}
			devolver += "\n";

		}
		devolver += "_ _ _ _ _ _ _  \n";
		for (int i = 0; i < columnas; i++) {
			devolver += i + " ";
		}
		
		if(esGanador) {
			devolver += "\n ya gano alquien";
		}
		return devolver;

	}
}
