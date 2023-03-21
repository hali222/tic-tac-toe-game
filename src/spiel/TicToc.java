package spiel;

import java.util.Scanner;

public class TicToc {

	enum Players {
		P1, P2
	}

	static Players beginPlayer = Players.P1;

	static Players player;

	enum Game_Status {
		P1_WINNER, P2_WINNER, DRAWN, CONTINUE
	}

	enum Symbol {
		X('X'), O('O');

		private char asChar;

		public char getChar() {
			return this.asChar;
		}

		private Symbol(char a) {
			this.asChar = a;
		}
	}

	static Game_Status status = Game_Status.CONTINUE;

	static int countP1Won = 0;
	static int countP2Won = 0;
	static int countDrawn = 0;

	static char[] choice = new char[9];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// inputs = {{1,0,0,1,0,5,1,0,1},{0,1,1,0,1,1,0,1,0}}
		do {
			status = Game_Status.CONTINUE;
			if (player == Players.P1) {
				Scanner sc = new Scanner(System.in);
				int num;
				do {
					System.out.println("Player1, insert your number (1..9): ");
					num = sc.nextInt();
				} while ((choice[num - 1] != 0));
				choice[num - 1] = Symbol.X.getChar();
			} else if (player == Players.P2) {
				Scanner sc = new Scanner(System.in);
				int num;
				do {
					System.out.println("Player2, insert your number (1..9): ");
					num = sc.nextInt();
				} while ((choice[num - 1] != 0));
				choice[num - 1] = Symbol.O.getChar();
			}
			// calcBoard();
			printBoard();
			calcStatus();
			if (status != Game_Status.CONTINUE) {
				gameResult();
			}
			if (status == Game_Status.CONTINUE) {
				if (player == Players.P1)
					player = Players.P2;
				else
					player = Players.P1;
			}
		} while (true);
	}

	public static void printBoard() {

		System.out.println(choice[0] + " | " + choice[1] + " | " + choice[2]);
		System.out.println("---" + "---" + "---");
		System.out.println(choice[3] + " | " + choice[4] + " | " + choice[5]);
		System.out.println("---" + "---" + "---");
		System.out.println(choice[6] + " | " + choice[7] + " | " + choice[8]);
	}

	public static boolean isBoardFull() {
		boolean result = true;
		for (int i = 0; i < 9; i++) {
			if (choice[i] == 0) {
				result = false;
			}
		}
		return result;
	}

	public static void calcStatus() {

		if (player == Players.P1) {
			if (choice[0] == Symbol.X.getChar() && choice[1] == Symbol.X.getChar() && choice[2] == Symbol.X.getChar()) {
				status = Game_Status.P1_WINNER;
			}

			if (choice[3] == Symbol.X.getChar() && choice[4] == Symbol.X.getChar() && choice[5] == Symbol.X.getChar()) {
				status = Game_Status.P1_WINNER;
			}

			if (choice[6] == Symbol.X.getChar() && choice[7] == Symbol.X.getChar() && choice[8] == Symbol.X.getChar()) {
				status = Game_Status.P1_WINNER;
			}

			if (choice[0] == Symbol.X.getChar() && choice[3] == Symbol.X.getChar() && choice[6] == Symbol.X.getChar()) {
				status = Game_Status.P1_WINNER;
			}

			if (choice[1] == Symbol.X.getChar() && choice[4] == Symbol.X.getChar() && choice[7] == Symbol.X.getChar()) {
				status = Game_Status.P1_WINNER;
			}

			if (choice[2] == Symbol.X.getChar() && choice[5] == Symbol.X.getChar() && choice[8] == Symbol.X.getChar()) {
				status = Game_Status.P1_WINNER;
			}

			if (choice[0] == Symbol.X.getChar() && choice[4] == Symbol.X.getChar() && choice[8] == Symbol.X.getChar()) {
				status = Game_Status.P1_WINNER;
			}

			if (choice[2] == Symbol.X.getChar() && choice[4] == Symbol.X.getChar() && choice[6] == Symbol.X.getChar()) {
				status = Game_Status.P1_WINNER;
			}
		} else {
			if (choice[0] == Symbol.O.getChar() && choice[1] == Symbol.O.getChar() && choice[2] == Symbol.O.getChar()) {
				status = Game_Status.P2_WINNER;
			}

			else if (choice[3] == Symbol.O.getChar() && choice[4] == Symbol.O.getChar()
					&& choice[5] == Symbol.O.getChar()) {
				status = Game_Status.P2_WINNER;
			}

			else if (choice[6] == Symbol.O.getChar() && choice[7] == Symbol.O.getChar()
					&& choice[8] == Symbol.O.getChar()) {
				status = Game_Status.P2_WINNER;
			}

			else if (choice[0] == Symbol.O.getChar() && choice[3] == Symbol.O.getChar()
					&& choice[6] == Symbol.O.getChar()) {
				status = Game_Status.P2_WINNER;
			}

			else if (choice[1] == Symbol.O.getChar() && choice[4] == Symbol.O.getChar()
					&& choice[7] == Symbol.O.getChar()) {
				status = Game_Status.P2_WINNER;
			}

			else if (choice[2] == Symbol.O.getChar() && choice[5] == Symbol.O.getChar()
					&& choice[8] == Symbol.O.getChar()) {
				status = Game_Status.P2_WINNER;
			}

			else if (choice[0] == Symbol.O.getChar() && choice[4] == Symbol.O.getChar()
					&& choice[8] == Symbol.O.getChar()) {
				status = Game_Status.P2_WINNER;
			}

			else if (choice[2] == Symbol.O.getChar() && choice[4] == Symbol.O.getChar()
					&& choice[6] == Symbol.O.getChar()) {
				status = Game_Status.P2_WINNER;
			}
		}
		if (status == Game_Status.CONTINUE && isBoardFull()) {
			status = Game_Status.DRAWN;
		}
	}

	public static void gameResult() {

		if (status == Game_Status.P1_WINNER) {
			countP1Won++;
			System.out.println("######################");
			System.out.println("Player1 won!!!");
			System.out.println("######################");
		}
		if (status == Game_Status.P2_WINNER) {
			countP2Won++;
			System.out.println("######################");
			System.out.println("Player2 won!!!");
			System.out.println("######################");
		}
		if (status == Game_Status.DRAWN) {
			countDrawn++;
			System.out.println("######################");
			System.out.println("Game is drawn!!!");
			System.out.println("######################");
		}
		System.out.println("Player1 Won:" + countP1Won + " || Drawn:" + countDrawn + " || Player2 won:" + countP2Won);
		System.out.println("######################");

		if (beginPlayer == Players.P1) {
			beginPlayer = Players.P2;
			player = beginPlayer;

		} else
			beginPlayer = Players.P1;
		player = beginPlayer;

		choice = new char[9];
	}
}