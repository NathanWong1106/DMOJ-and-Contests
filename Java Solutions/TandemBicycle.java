import java.util.*;

//CCC '16 S2

public class TandemBicycle {
	
	private static int[] dmoj;
	private static int[] peg;
	
	private static Scanner input =  new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int questionType = input.nextInt();
		int numContestants = input.nextInt();
		
		dmoj = new int[numContestants];
		peg = new int[numContestants];
		
		for (int i = 0; i < numContestants; i++){
			dmoj[i] = input.nextInt();
		}
		
		for (int i = 0; i < numContestants; i++){
			peg[i] = input.nextInt();
		}
		
		//sort lowest to highest
		Arrays.sort(dmoj);
		Arrays.sort(peg);
		
		int totalSpeed = 0;
		if (questionType == 1){
			for (int i = 0; i < numContestants; i++){
				totalSpeed += Math.max(dmoj[i], peg[i]);
			}
		}
		else if (questionType == 2){
			int reversedIndex = dmoj.length - 1;
			for (int i = 0; i < numContestants; i++){
				totalSpeed += Math.max(dmoj[reversedIndex], peg[i]);
				reversedIndex--;
			}
		}
		
		System.out.println(totalSpeed);
	}
}