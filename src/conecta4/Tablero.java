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

		if (donde == 6) {
			donde = 6;
		}

		if (tablero[huecosColumnas[donde]][donde] == '-') {

			tablero[huecosColumnas[donde]][donde] = turno;
			huecosColumnas[donde]--;
//				GanadorVertical(turno,huecosColumnas[donde], donde);
//				GanadorVertical(huecosColumnas[donde], donde);
			turno = (turno == 'X') ? 'O' : 'X';
			esGanador = GanadorVertical(donde, donde);
			esGanador = esGanador || GanadorHorizontal(donde, donde);
		}

	}

	private boolean GanadorHorizontal(int fila, int columna) {
		
		int contador = 0;
		int posicion = 0;
		while(contador != 4 && posicion < columna) {
			if(tablero[fila][posicion] == turno) {
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
			}
		}

		if (coincidencia == 3) {
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
