import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

//Partial answer to COCI '14 Contest 2 #2
//7/10 test cases passed

public class Utrka {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		HashSet<String> participants = new HashSet<String>();
		HashSet<String> finishers = new HashSet<String>();

		int firstNum = readInt();

		String peeps;

		for (int i = 1; i <= firstNum; i++) {
			peeps = next();

			participants.add(peeps);
		}

		for (int i = 1; i < firstNum; i++) {
			peeps = next();

			finishers.add(peeps);
		}

		Iterator<String> iterator = participants.iterator();


		while (iterator.hasNext()) {

			peeps = iterator.next();

			if (finishers.contains(peeps)) {
				;
			}
			else {
				System.out.println(peeps);
				break;
			}

		}
		
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine().trim());
		}
		return st.nextToken();
	}

}