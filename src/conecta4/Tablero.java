package conecta4;

import java.util.Arrays;

public class Tablero {

	private int COLUMNAS = 7;
	private int FILAS = 6;
	private char[][] tablero = new char[FILAS][COLUMNAS];
	private int[] huecosColumnas = new int[7];
	private char turno;
	private boolean esGanador;

	public Tablero() {

		for (int i = 0; i < FILAS; i++) {

			for (int j = 0; j < COLUMNAS; j++) {

				tablero[i][j] = '-';
			}
		}

		for (int i = 0; i < COLUMNAS; i++) {
			huecosColumnas[i] = FILAS - 1;
		}
		turno = 'X';

		esGanador = false;
	}

	public void coloca(int columna) {

		if (columna >= 6) {
			columna = 6;
		}

		if (tablero[huecosColumnas[columna]][columna] == '-') {

			tablero[huecosColumnas[columna]][columna] = turno;
			huecosColumnas[columna]--;
//				GanadorVertical(turno,huecosColumnas[donde], donde);
//			
			esGanador = GanadorVertical(huecosColumnas[columna] + 1, columna);
			esGanador = esGanador || GanadorHorizontal(huecosColumnas[columna] + 1, columna);
			esGanador = esGanador || GanadorDiagonal1(huecosColumnas[columna]+1, columna);
			turno = (turno == 'X') ? 'O' : 'X';
		}

	}

	public boolean GanadorDiagonal1(int fila, int columna) {
		char ficha = tablero[fila][columna];
		int contador = 0;
		int retroceso = (fila < columna) ? fila : columna;
		int i = fila - retroceso;
		int j = columna - retroceso;

		while ((i < FILAS) && (j < COLUMNAS) && (contador < 4)) {
			if (tablero[i][j] == ficha) {
				contador++;
			} else
				contador = 0;
			i++;
			j++;
		}
		boolean devolver = false;
		if (contador == 4) {
			devolver = true;
		}

		return devolver;

	}

	public boolean GanadorDiagonal2(int fila, int columna) {
		int contador = 0;
		
		boolean devolver = false;
		if (contador == 4) {
			devolver = true;
		}
		return devolver;
	}

	public boolean GanadorHorizontal(int fila, int columna) {
		char ficha = tablero[fila][columna];
		int contador = 0;
		int posicion = 0;

		while (contador < 4 && posicion < COLUMNAS) {
			if (tablero[fila][posicion] == tablero[fila][columna]) {
				contador++;

			} else
				contador = 0;
			posicion++;
		}

		boolean devolver = false;
		if (contador == 4) {
			devolver = true;
		}

		return devolver;
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
			for (int i = fila + 1; i <= fila + 3; i++) {
				if (tablero[i][columna] == mirarChar) {

					coincidencia++;
				}

				else
					coincidencia = 0;
			}
		}

		boolean devolver = false;
		if (coincidencia == 3) {
			devolver = true;
		}
		return devolver;
	}

	@Override
	public String toString() {
		String devolver = "";

		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				devolver += tablero[i][j] + " ";
			}
			devolver += "\n";

		}
		devolver += "_ _ _ _ _ _ _  \n";
		for (int i = 0; i < COLUMNAS; i++) {
			devolver += i + " ";
		}

		if (esGanador) {
			devolver += "\n ya ganó alquien";
		}
		return devolver;

	}
}
