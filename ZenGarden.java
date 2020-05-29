import java.util.*;

//DMPG '15 S3

public class ZenGarden {

	private static int[] flowers;
	private static int[][] bad;

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		// input
		int numFlowers = input.nextInt();

		flowers = new int[numFlowers];

		for (int i = 0; i < numFlowers; i++) {
			flowers[i] = input.nextInt();
		}

		int numBad = input.nextInt();

		bad = new int[2][numBad];

		for (int i = 0; i < numBad; i++) {
			bad[0][i] = input.nextInt() - 1;
			bad[1][i] = input.nextInt();
		}

		// processing
		determineRemoval();

		System.out.println(determineScore());
	}

	private static int determineScore() {
		int totalScore = 0;

		for (int num : flowers) {
			totalScore += num;
		}

		for (int num = 0; num < bad[0].length; num++) {
			totalScore -= bad[1][num];
		}

		return totalScore;
	}

	private static void determineRemoval() {
		for (int flower = 0; flower < flowers.length - 1; flower++) {
			for (int badFlower = 0; badFlower < bad[0].length; badFlower++) {
				if (flower == bad[0][badFlower]) {
					if (flowers[flower] > bad[1][badFlower] && flowers[flower + 1] > bad[1][badFlower]) {
						break;
					} else {
						if (flowers[flower] < flowers[flower + 1]) {
							flowers[flower] = 0;
							bad[1][badFlower] = 0;
							break;
						} else if (flowers[flower + 1] < flowers[flower]) {
							flowers[flower + 1] = 0;
							bad[1][badFlower] = 0;
							break;
						} else {
							flowers[flower] = 0;
							bad[1][badFlower] = 0;
							break;
						}
					}
				}
			}
		}

	}

}
