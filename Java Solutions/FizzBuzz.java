import java.util.Scanner;

//A Classic :)

public class FizzBuzz {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		int num = input.nextInt();
		
		for (int i = 1 ; i <= num; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("fizzbuzz");
			}
			else if (i % 3 == 0) {
				System.out.println("fizz");
			}
			else if (i % 5 == 0) {
				System.out.println("buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}

}
