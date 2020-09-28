import java.util.HashMap;

//CCC '19 J4
//A completely impractical approach to a simple problem...
import java.util.Scanner;

public class TudorCheeseCake {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		HashMap <Character, Integer> hm = new HashMap<Character, Integer>();
		
		String word = input.next();
		String in = input.next();
		int toBuy = 0;
		
		for(int i = 0; i < in.length(); i++) {
			char character = in.charAt(i);
			
			hm.put(character, hm.getOrDefault(character, 0) + 1);
		}
		
		for(int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);

			if(hm.get(character) != null) {
				if(hm.get(character) > 0) {
					hm.put(character, hm.get(character) - 1);
				} else {
					toBuy++;
				}
			} else {
				toBuy++;
			}
		}
		
		System.out.println(toBuy);
		
	}
	

}
