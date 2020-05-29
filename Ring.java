import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//ECOO 2020 P4
//What I was working on before time ran out :(
//I may come back and fix it up later

public class Ring {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		int testCases = input.nextInt();
		
		int[] answers = new int[testCases];
		
		for(int test = 0; test < testCases; test++) {
			HashMap <String, Function> funcs = new HashMap<String, Function>();
			int instructions = input.nextInt();
			int x = 0;
			
			for (int i = 0; i < instructions; i++) {
				String in = input.nextLine();
				
				if (in.contains("FUN")) {
					String name = input.next();
					funcs.put(name, new Function());
					String op;
					
					do {
						i++;
						op = input.nextLine();
						funcs.get(name).addOperation(op);
					}while(!op.equals("END"));
						
				}
				else if (in.contains("CALL")) {
					String functionName = in.substring(4);
					
					for(String op : funcs.get(functionName).getOperations()) {
						x = calc(op, x);
					}
				}
				else {
					x = calc(in, x);
				}
			}
			
			answers[test] = x % 1000000007;
		}
		
		for(int answer: answers) {
			System.out.println(answer);
		}
	}
	
	private static int calc(String op, int x) {
		
		if(op.contains("ADD")) {
			x += Integer.parseInt(op.substring(4));
		}
		else if (op.contains("SUB")) {
			x -= Integer.parseInt(op.substring(4));
		}
		else if (op.contains("MULT")) {
			x *= Integer.parseInt(op.substring(5));
		}
		
		
		return x;
		
	}
	
	static class Function {
		ArrayList<String> operations = new ArrayList<String>();
		
		Function(){
			;
		}
		
		void addOperation(String op){
			operations.add(op);
		}
		ArrayList<String> getOperations(){
			return operations;
		}
		
		
	}
}
