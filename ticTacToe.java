package ovning3;

import java.util.Scanner;

public class ticTacToe {
	

	public static void main(String[] args) {						//Här får användaren välja vilja
		Scanner scanner = new Scanner(System.in);					//namn som skall spela. 
		System.out.print("Spelare 1: ");							//
		String player1 = scanner.nextLine();						//
		System.out.print("Spelare 2: ");							//
		String player2 = scanner.nextLine();						//
			
		char[][] gameboard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

		System.out.println("\nVälkomna till Tre-i-Rad " + player1 + " och " + player2
				+ ".\nSkriv en siffra mellan 1-9 för att lägga en bricka.\n");

		printGameboard(gameboard);
		playersPlacement(player1, player2, gameboard);
	}

	private static void playersPlacement(String player1, String player2, char[][] gameboard) {
		Scanner scanner = new Scanner(System.in);
		String winner = null;										//winner få värde senare.
		int draw = 0;												//beroende vilket värde draw får så blir det oavgjort.

		while (true) {
																	//Här är loopen för hela spelet som avgör vem som vinner. 
			moves(gameboard, player1, player1, player2);			//Denna metod avgör vem som spelar och vart man lägger sin bricka.
			printGameboard(gameboard);								//Printar ut det nya resultatet av spelbrädan.
			winner = checkWinner(gameboard, player1, player2);		//Metod som kollar om player1 vunnit.
			if (player1.equals(winner)) {							
				System.out.println(winner + " vann spelet!");
				break;
			}
			draw = checkDraw(gameboard);							//Metod för att se om det blev oavgjort. 
			if (draw == 0) {														//Om det inte finns några whitespaces och 
				System.out.println("\nÄsch då, ingen vann... Försök igen.");		//ingen vinst, då är det oavgjort.
				break;
			}

			moves(gameboard, player2, player1, player2);			//metod för player2.
			printGameboard(gameboard);								
			winner = checkWinner(gameboard, player1, player2);		//metod för att se om player2 har vunnit.
			if (player2.equals(winner)) {							//Om detta stämmer har player2 vunnit.
				System.out.println(winner + " vann spelet!");
				break;
			}
		}
	}

	private static int checkDraw(char[][] gameboard) {				//metod för oavgjort.
		int symbols = 0;

		for (int i = 0; i < gameboard.length; i++) {				//kollar om raderna är upptagna.
			for (int j = 0; j < gameboard.length; j++) {			//kollar om kolumnerna är upptagna. 
				if (gameboard[i][j] == ' ') {
					symbols++;
				}
			}
		}

		return symbols;
	}
	
	private static void moves(char[][] gameboard, String user, String player1, String player2) {	//Metod för att lägga sin bricka.
		Scanner scanner = new Scanner(System.in);
		char symbol = ' ';
																	//User avser vilken av player1 eller player2 som spelar. 
		if (user.equals(player1)) {									//Kolla om det är player1 eller player2 som spelar. 
			symbol = 'x';}											//Och ger 'x' eller 'o' beroende vilken spelare det är.
		 else if (user.equals(player2)) {							//
			symbol = 'o';}											//
		
		while (true) {														//loop för att lägga sin bricka. 
			int move = 0;													//loopen breakar efter varje omgång. 
			try {
				move = scanner.nextInt();
				
				if (move < 1 || move > 9) {									//if-sats som kollar om numret är mer eller mindre än 1-9,
					System.out.println("Numret måste vara mellan 1-9.");	//
					continue;}												//om så är fallet börjar loopen om här.
				
				switch (move) {
				case 1:
					if (gameboard[0][0] == 'x' || gameboard[0][0] == 'o') {					//Kollar om rutan är upptagen.
						System.out.println("Ruta 1 är upptagen. Försök en annan siffra.");	
						continue;}															//om upptagen ruta så börjar loopen om här.
					gameboard[0][0] = symbol;												//ger spelarens "symbol"-värde i en ruta. 
					break;
				case 2:
					if (gameboard[0][2] == 'x' || gameboard[0][2] == 'o') {
						System.out.println("Ruta 2 är upptagen. Försök en annan siffra.");
						continue;}
					gameboard[0][2] = symbol;
					break; 
				case 3:
					if (gameboard[0][4] == 'x' || gameboard[0][4] == 'o') {
						System.out.println("Ruta 3 är upptagen. Försök en annan siffra.");
						continue;
					}
					gameboard[0][4] = symbol;
					break;
				case 4:
					if (gameboard[2][0] == 'x' || gameboard[2][0] == 'o') {
						System.out.println("Ruta 4 är upptagen. Försök en annan siffra.");
						continue;
					}
					gameboard[2][0] = symbol;
					break;
				case 5:
					if (gameboard[2][2] == 'x' || gameboard[2][2] == 'o') {
						System.out.println("Ruta 5 är upptagen. Försök en annan siffra.");
						continue;
					}
					gameboard[2][2] = symbol;
					break;
				case 6:
					if (gameboard[2][4] == 'x' || gameboard[2][4] == 'o') {
						System.out.println("Ruta 6 är upptagen. Försök en annan siffra.");
						continue;
					}
					gameboard[2][4] = symbol;
					break;
				case 7:
					if (gameboard[4][0] == 'x' || gameboard[4][0] == 'o') {
						System.out.println("Ruta 7 är upptagen. Försök en annan siffra.");
						continue;
					}
					gameboard[4][0] = symbol;
					break;
				case 8:
					if (gameboard[4][2] == 'x' || gameboard[4][2] == 'o') {
						System.out.println("Ruta 8 är upptagen. Försök en annan siffra.");
						continue;
					}
					gameboard[4][2] = symbol;
					break;
				case 9:
					if (gameboard[4][4] == 'x' || gameboard[4][4] == 'o') {
						System.out.println("Ruta 9 är upptagen. Försök en annan siffra.");
						continue;
					}
					gameboard[4][4] = symbol;
					break;
				default:
					break;
				}
				break;
			} catch (Exception InputMismatchException) {				//detta fångar om något annat än en siffra blivit inmatad. 
				System.out.println("Det måste vara ett nummer!");		//
				scanner.nextLine();										//
				continue;												//loopen börjar om här. 
			}
		}
	}
	
	private static String checkWinner(char[][] gameboard, String player1, String player2) { 	//metod som kollar om någon vunnit.
		String winner = null;

		if (gameboard[0][0] == 'x' && gameboard[0][2] == 'x' && gameboard[0][4] == 'x'			//kollar om player1 vunnit.
				|| gameboard[2][0] == 'x' && gameboard[2][2] == 'x' && gameboard[2][4] == 'x'
				|| gameboard[4][0] == 'x' && gameboard[4][2] == 'x' && gameboard[4][4] == 'x'
				|| gameboard[0][0] == 'x' && gameboard[2][0] == 'x' && gameboard[4][0] == 'x'
				|| gameboard[0][2] == 'x' && gameboard[2][2] == 'x' && gameboard[4][2] == 'x'
				|| gameboard[0][4] == 'x' && gameboard[2][4] == 'x' && gameboard[4][4] == 'x'
				|| gameboard[0][0] == 'x' && gameboard[2][2] == 'x' && gameboard[4][4] == 'x'
				|| gameboard[0][4] == 'x' && gameboard[2][2] == 'x' && gameboard[4][0] == 'x') {

			winner = player1;

		} else if (gameboard[0][0] == 'o' && gameboard[0][2] == 'o' && gameboard[0][4] == 'o'	//kollar om player2 vunnit.
				|| gameboard[2][0] == 'o' && gameboard[2][2] == 'o' && gameboard[2][4] == 'o'
				|| gameboard[4][0] == 'o' && gameboard[4][2] == 'o' && gameboard[4][4] == 'o'
				|| gameboard[0][0] == 'o' && gameboard[2][0] == 'o' && gameboard[4][0] == 'o'
				|| gameboard[0][2] == 'o' && gameboard[2][2] == 'o' && gameboard[4][2] == 'o'
				|| gameboard[0][4] == 'o' && gameboard[2][4] == 'o' && gameboard[4][4] == 'o'
				|| gameboard[0][0] == 'o' && gameboard[2][2] == 'o' && gameboard[4][4] == 'o'
				|| gameboard[0][4] == 'o' && gameboard[2][2] == 'o' && gameboard[4][0] == 'o') {

			winner = player2;
		}

		return winner;																			//returnerar värdet winner som 		
	}																							//player1 eller player2.

	private static void printGameboard(char[][] gameboard) {									//metod som skriver ut spelplanen 
		for (char[] row : gameboard) {															//i consolen. 
			System.out.println(row);
		}
	}

}
