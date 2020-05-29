import java.util.*;

//CCC '02 S3

public class Blindfold {

	private static char[][] map;
	private static char[] commands;
	private static char direction;
	private static int row;
	private static int col;
	private static int numMoves;
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		row = input.nextInt();
		col = input.nextInt();
		map = new char[row][col];

		for (int rowCount = 0; rowCount < row; rowCount++) {
			String string = input.next();
			for (int colCount = 0; colCount < col; colCount++) {
				map[rowCount][colCount] = string.charAt(colCount);
			}

		}

		numMoves = input.nextInt();
		commands = new char[numMoves];

		for (int move = 0; move < numMoves; move++) {
			commands[move] = input.next().charAt(0);
		}
		for (int rowCount = 0; rowCount < row; rowCount++) {
			for (int colCount = 0; colCount < col; colCount++) {
				if (map[rowCount][colCount] != 'X') {
					checkPositions(rowCount, colCount);
					System.out.printf("Thing: %d , %d\n", rowCount, colCount);
				}
			}
		}
		
		for (char[] row : map) {
			for (char place : row) {
				System.out.print(place);
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(commands));

	}

	private static void checkPositions(int rowCount, int colCount) {
		for (int directionCheck = 1; directionCheck <= 4; directionCheck++) {

			int commandNum = 0;
			int currentRow = rowCount;
			int currentCol = colCount;

			if (directionCheck == 1) {
				direction = 'U';
			} else if (directionCheck == 2) {
				direction = 'R';
			} else if (directionCheck == 3) {
				direction = 'D';
			} else if (directionCheck == 4) {
				direction = 'L';
			}

			for (char movement : commands) {
				if (movement == 'F') {
					if (direction == 'U') {
						currentRow--;
					} else if (direction == 'R') {
						currentCol++;
					} else if (direction == 'D') {
						currentRow++;
					} else if (direction == 'L') {
						currentCol--;
					}

					if (currentRow < 0 || currentRow >= row || currentCol < 0 || currentCol >= col) {
						break;
					} 
					if (map[rowCount][colCount] == 'X') {
						break;
					}
				} else if (movement == 'R') {
					if (direction == 'U') {
						direction = 'R';
					} else if (direction == 'R') {
						direction = 'D';
					} else if (direction == 'D') {
						direction = 'L';
					} else if (direction == 'L') {
						direction = 'U';
					}
				} else if (movement == 'L') {
					if (direction == 'U') {
						direction = 'L';
					} else if (direction == 'R') {
						direction = 'U';
					} else if (direction == 'D') {
						direction = 'R';
					} else if (direction == 'L') {
						direction = 'D';
					}
				}
			
				commandNum++;
				System.out.printf("%d , %d - %d\n",currentRow, currentCol, commandNum);
				
				if (commandNum == numMoves) {
					System.out.println("here");
					map[rowCount][colCount] = '*';
					break;
				}
			}
		}
	}
}
