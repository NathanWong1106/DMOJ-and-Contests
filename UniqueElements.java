import java.util.*;

//A very simple hashset problem 

public class UniqueElements {
	
	public static void main(String[] args) {
		
		int numList;
		int num;
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		Scanner input = new Scanner(System.in);
		
		numList = input.nextInt();
		
		for (int i = 1; i <= numList; i++) {
			num = input.nextInt();
			hs.add(num);
			
		}
		
		System.out.println(hs.size());
	}

}