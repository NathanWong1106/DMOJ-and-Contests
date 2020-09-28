import java.util.*;

//CCC '17 S2

public class Tide {
	
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Integer> high = new ArrayList<Integer>();
	private static ArrayList<Integer> low = new ArrayList<Integer>();
	private static int measurements;
	
	public static void main(String[] args) {
		measurements = input.nextInt();
		
		for (int i = 0; i < measurements; i++) {
			if (i < measurements / 2) {
				high.add(input.nextInt());
			}
			else {
				low.add(input.nextInt());
			}
		}
		
		getOrder();
		printOrder();
	}

	private static void printOrder() {
		Collections.sort(high);
		Collections.sort(low);
		
		int highIndex = 0;
		
		for (int lowIndex = low.size() - 1; lowIndex >= 0; lowIndex--) {
			System.out.print(low.get(lowIndex) + " ");
			
			if (highIndex < high.size()) {
				System.out.print(high.get(highIndex) + " ");
			}
			
			highIndex++;
		}
		
	}

	private static void getOrder() {
		boolean sorted = true;
		
		do {
			sorted = true;
			for (int highTide = 0; highTide < high.size(); highTide++) {
				for (int lowTide = 0; lowTide < low.size(); lowTide++) {
					if (high.get(highTide) < low.get(lowTide)) {
						int highNum = high.get(highTide);
						int lowNum = low.get(lowTide);
						
						high.remove(highTide);
						low.remove(lowTide);
						
						high.add(lowNum);
						low.add(highNum);
						
						sorted = false;
					}
				}
			}
		}while (!sorted);
		
	}

}
