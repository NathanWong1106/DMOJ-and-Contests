import java.util.*;

//CCC '13 S2 
//Fun problem involving stacks

public class GenevaConfection {

	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Character> answer = new ArrayList<Character>();
	private static Stack<Integer> mountainTop = new Stack<Integer>();
	private static Stack<Integer> branch = new Stack<Integer>();
	
	public static void main(String[] args) {
		int numTests = input.nextInt();

		for (int i = 1; i <= numTests; i++) {
			int numCars = input.nextInt();

			for (int car = 1; car <= numCars; car++) {
				mountainTop.push(input.nextInt());
			}

			answer.add(isPossible());
			mountainTop.clear();
			branch.clear();

		}

		for (char possible : answer) {
			System.out.println(possible);
		}

	}

	private static Character isPossible() {
		int num = 1;
		while (true) {
			if (!mountainTop.isEmpty() && mountainTop.peek() == num) { //does the mountain top have the cart
				mountainTop.pop();
				num++;
			}
			else if (!branch.isEmpty() && branch.peek() == num) { // does the branch have the cart
				branch.pop();
				num++;
			}
			else if (!mountainTop.isEmpty() && mountainTop.peek() != num) { // if no to top two then move the mountain top cart to the branch
				branch.push(mountainTop.pop());
			}
			else if (mountainTop.isEmpty() && branch.isEmpty()) { // if both are empty then it is successful
				return 'Y';
			}
			else { // else then you're done
				return 'N';
			}
		}
	}

}
