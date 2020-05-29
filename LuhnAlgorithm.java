import java.util.Scanner;

//ECOO '13 R1 P2

public class LuhnAlgorithm {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String[] stringArr = new String[5];
		
		for(int testCase = 0; testCase < 5; testCase++) {
			String result = "";
			for(int batch = 0; batch < 5; batch++) {
				
				String number = input.next();
				
				boolean multiply = true;
				boolean add = false;
				int sum = 0;
				
				for (int length = number.length()-1; length >= 0; length--) {
					if(multiply) {
						int numberToMultiply = Integer.parseInt(Character.toString(number.charAt(length)));
						String components = Integer.toString(numberToMultiply * 2);
						
						for(int resultLength = components.length()-1; resultLength >= 0; resultLength--) {
							sum += Integer.parseInt(Character.toString(components.charAt(resultLength)));
						}
						
						multiply = false;
						add = true;
					} else {
						sum += Integer.parseInt(Character.toString(number.charAt(length)));
						multiply = true;
						add = false;
					}
				}
				
				for (int i = 0; i <= 9; i++) {
					if ((sum + i) % 10 == 0) {
						result += Integer.toString(i);
						break;
					}
				}
			}
			
			stringArr[testCase] = result;
		}
		
		for (String result:stringArr) {
			System.out.println(result);
		}
	}

}
