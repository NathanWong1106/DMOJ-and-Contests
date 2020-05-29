import java.util.*;

//CCC '02 S2

public class FractionAction {
	
	private static int num1; 
	private static int num2;
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		num1 = input.nextInt();
		num2 = input.nextInt();
		
		if ((int)(num1/num2) == 0) {
			System.out.println(simplify(num1 % num2));
		}
		else {
			System.out.println(((int)(num1 / num2)) + " " + simplify(num1 % num2));
		}
	}

	private static String simplify(int remainder) {
		if (remainder == 0) {
			return "";
		}
		else {
			for (int testNum = remainder; testNum > 0; testNum --) {
				if (testNum == 1) {
					break;
				}
				else if (remainder % testNum == 0 && num2 % testNum == 0) {
					remainder = (int)(remainder / testNum);
					num2 = (int)(num2 / testNum);
					testNum = remainder;
				}
			}
		}
		return remainder + "/" + num2;
	}

}
