import java.util.Scanner;

//ECOO '12 R2 P1

public class PrimeTime {

	private static char[] arr = { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '.', ',', '!', '?' };
	private static String[] results = new String[5];

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		for (int cases = 0; cases < 5; cases++) {
			int numInput = input.nextInt();
			int[] inputArr = new int[numInput];
			
			for (int i = 0; i < numInput; i++) {
				inputArr[i] = input.nextInt();
			}
			
			findString(inputArr, cases);
		}
		
		for(String str : results) {
			System.out.println(str);
		}

	}

	private static void findString(int[] inputArr, int cases) {
		for (int i = 99999; i < 500000; i += 2) {
			for (int divisor = 2; divisor <= Math.sqrt(i); divisor++) {
				if (i % divisor == 0) {
					break;
				} else {
					boolean numFound = true;
					for (int num : inputArr) {
						if (num % i != 0) {
							numFound = false;
							break;
						}
					}

					if (numFound) {
						for (int index = 0; index < inputArr.length; index++) {
							inputArr[index] /= i;
						}

						String str = "";

						for (int num : inputArr) {
							if (Integer.toString(num).length() == 3) {
								str += arr[num / 100];
								str += arr[num % 100];
							} else {
								str += arr[num / 100];
								str += arr[num % 100];
							}
						}
						results[cases] = str;

						return;
					}
				}
			}
		}
	}
}
