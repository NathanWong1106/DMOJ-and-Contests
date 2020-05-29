import java.util.ArrayList;
import java.util.Scanner;

//CCC '12 S3

public class AbsolutelyAcidic {

	private static Scanner input = new Scanner(System.in);

	private static int[] readings;
	private static int[] frequencies = new int[1001]; // ignore 0 (1-1000)
	private static int highestFrequency = 1;
	private static int lowerFrequency = 1;
	
	private static ArrayList<Integer> lower = new ArrayList<Integer>();
	private static ArrayList<Integer> higher = new ArrayList<Integer>();

	public static void main(String[] args) {
		int numReadings = input.nextInt();

		readings = new int[numReadings];

		for (int i = 0; i < numReadings; i++) {
			readings[i] = input.nextInt();
		}

		for (int num : readings) {
			frequencies[num] += 1;
		}
		
		for (int i = 1; i < frequencies.length; i++) {
			if (frequencies[i] > highestFrequency) {
				lowerFrequency = highestFrequency;
				highestFrequency = frequencies[i];
			}
			else if (frequencies[i] > lowerFrequency) {
				lowerFrequency = frequencies[i];
			}
		}
		for (int i = 1; i < frequencies.length; i++) {
			if (frequencies[i] == lowerFrequency) {
				lower.add(i);
			}
			if (frequencies[i] == highestFrequency) {
				higher.add(i);

			}
		}
		
		int absValue = 0;
		for (int numLow : lower) {
			for (int numHigh : higher) {
				if (Math.abs(numLow - numHigh) > absValue) {
					absValue = Math.abs(numLow - numHigh);
				}
			}
		}
		
		System.out.println(absValue);
	}
}