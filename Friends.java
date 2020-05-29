import java.util.*;

//CCC '07 S3

public class Friends {

	private static Scanner input = new Scanner(System.in);
	private static int[][] friends;
	private static ArrayList<Integer> find1 = new ArrayList<Integer>();
	private static ArrayList<Integer> find2 = new ArrayList<Integer>();
	private static int seperation = 0;
	
	public static void main(String[] args) {
		int numStudents = input.nextInt();

		friends = new int[2][numStudents];

		for (int i = 0; i < numStudents; i++) {
			friends[0][i] = input.nextInt();
			friends[1][i] = input.nextInt();
		}

		while (true) {
			int friend1 = input.nextInt();
			int friend2 = input.nextInt();

			if (friend2 == 0)
				break;

			find1.add(friend1);
			find2.add(friend2);
		}

		for (int i = 0; i < find1.size(); i++) {
			findCircle(find1.get(i), find2.get(i));
		}
	}

	private static void findCircle(int friend, Integer friendPair) {
		int currentStudent;

		for (int i = 0; i < friends[0].length; i++) {
			if (friends[0][i] == friend) {
				currentStudent = friends[1][i];
				if (currentStudent == friendPair) {
					System.out.println("Yes " + seperation);
					break;
				} else {
					findSeperation(currentStudent, friend, friendPair);
					break;
				}
			}
		}

	}

	private static void findSeperation(int currentStudent, int friend, Integer friendPair) {
		int nextStudent = currentStudent;
		boolean keepGoing = true;
		
		do {
			
			for (int i = 0; i < friends[0].length; i++) {
				if (friends[0][i] == nextStudent) {
					seperation++;
					nextStudent = friends[1][i];
				}
				
				if (nextStudent == friendPair) {
					System.out.println("Yes " + seperation);
					keepGoing = false;
					seperation = 0;
					break;
				}
				
				else if (seperation == friends[0].length) {
					System.out.println("No");
					keepGoing = false;
					seperation = 0;
					break;
				}
			}
		} while (keepGoing);

	}

}
