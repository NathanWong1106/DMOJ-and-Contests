import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Brute force problem solved with an arraylist and a buffered reader?

public class ListMinimumHard {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		ArrayList<String> array = new ArrayList<String>();
		
		int total = nextInt();
		
		for (int i = 0; i < total; i++) {
			array.add(next());
		}
		
		Collections.sort(array);
		
		for (String line : array) {
			System.out.println(line);
		}
		
	}
	
	private static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine().trim());
		}
		
		return st.nextToken();
	}
	
	private static int nextInt() throws IOException{
		return Integer.parseInt(next());
	}
}
