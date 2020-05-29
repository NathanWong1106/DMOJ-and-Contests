import java.util.*;

//CCC '01 S2
//probably could be implemented much better honestly....

public class Spirals {

	private static Scanner input = new Scanner(System.in);
	private static boolean up = false;
	private static boolean down = false;
	private static boolean left = true;
	private static boolean right = false;
	private static int num1;
	private static int num2;
	private static int[][] spiralArray;
	private static int row;
	private static int col;
	private static int placeTimes = 1;

	public static void main(String[] args) {
		num1 = input.nextInt();
		num2 = input.nextInt();

		spiralArray = new int[(int) Math.ceil(Math.sqrt(num2 - num1 + 1))][(int) Math
				.ceil(Math.sqrt(num2 - num1 + 1))];
		row = (int) Math.floor(Math.sqrt(num2 - num1) / 2);
		col = (int) Math.floor(Math.sqrt(num2 - num1) / 2);
		spiralArray[row][col] = num1;
		num1++;

		createSpiral();

		for (int[] row : spiralArray) {
			for (int number : row) {
				if (number != 0)
					System.out.print(number + " ");
				else
					System.out.print("");
			}
			System.out.println();
		}
	}

	private static void createSpiral() {
		int linesPlaced = 0;

		while (num1 != num2 + 1) {

			// changing directions
			if (up) {
				up = false;
				left = true;
			} else if (down) {
				down = false;
				right = true;
			} else if (left) {
				left = false;
				down = true;
			} else if (right) {
				right = false;
				up = true;
			}

			for (int i = 1; i <= placeTimes; i++) {
				if (num1 != num2 + 1) {
					if (up) {
						row--;
						spiralArray[row][col] = num1;
						num1++;
					} else if (down) {
						row++;
						spiralArray[row][col] = num1;
						num1++;
					} else if (left) {
						col--;
						spiralArray[row][col] = num1;
						num1++;
					} else if (right) {
						col++;
						spiralArray[row][col] = num1;
						num1++;
					}
				}
			}
			linesPlaced++;

			if (linesPlaced == 2) {
				linesPlaced = 0;
				placeTimes++;
			}
		}

	}

}