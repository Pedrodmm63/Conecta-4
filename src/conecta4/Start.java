package conecta4;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		Tablero tablero = new Tablero();
		
		while(!tablero.isEsGanador()) {
			int donde = teclado.nextInt();
			tablero.coloca(donde);
			System.out.println(tablero);
				
		}
	}

}
