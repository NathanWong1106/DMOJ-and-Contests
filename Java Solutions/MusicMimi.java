import java.util.Arrays;
import java.util.Scanner;

//2020 ECOO

public class MusicMimi {
	
	private static String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	private static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int testCases = input.nextInt();
		String[] answers = new String[testCases];
		
		for (int i = 0; i < testCases; i++) {
			String[] arr = new String[4];
			
			for (int j = 0; j < 4; j++) {
				arr[j] = input.next();
			}
			
			answers[i] = findChord(arr);
			
			
		}
		
		for (String answer: answers) {
			System.out.println(answer);
		}
		
		
		
	}

	private static String findChord(String[] arr) {
		//we can go through at most 4 inversions --if none pass return invalid
		for (int i = 0; i < 4; i++) {
			
			
			switch(i) {
				case 0:
					int startingIndex = 0;
					int[] indexes = new int[4];
					for (int index = 0; index < notes.length; index++) {
						if (notes[index].equals(arr[0])) {
							startingIndex = index;
							break;
						}
					}
					
					indexes[0] = startingIndex;
					indexes[1] = FindIndexes(arr[1], startingIndex, startingIndex);
					indexes[2] = FindIndexes(arr[2],indexes[1], indexes[1]% 12);
					indexes[3] = FindIndexes(arr[3], indexes[2], indexes[2]%12);
					
					if (indexes[0] + 4 == indexes[1] && indexes[1] + 3 == indexes[2] && indexes[2] + 3 == indexes[3]) {
						return "root";
					} else {
						String note1 = arr[0];
						String note2 = arr[1];
						String note3 = arr[2];
						String note4 = arr[3];
						
						arr[0] = note2;
						arr[1] = note3;
						arr[2] = note4;
						arr[3] = note1;
					}
					break;
				case 1:
					int startingIndex1 = 0;
					int[] indexes1 = new int[4];
					for (int index = 0; index < notes.length; index++) {
						if (notes[index].equals(arr[0])) {
							startingIndex1 = index;
							break;
						}
					}
					
					indexes1[0] = startingIndex1;
					indexes1[1] = FindIndexes(arr[1], startingIndex1, startingIndex1);
					indexes1[2] = FindIndexes(arr[2], indexes1[1], indexes1[1]% 12);
					indexes1[3] = FindIndexes(arr[3], indexes1[2], indexes1[2]% 12);
					
					if (indexes1[0] + 4 == indexes1[1] && indexes1[1] + 3 == indexes1[2] && indexes1[2] + 3 == indexes1[3]) {
						return "third";
					} else {
						String note1 = arr[0];
						String note2 = arr[1];
						String note3 = arr[2];
						String note4 = arr[3];
						
						arr[0] = note2;
						arr[1] = note3;
						arr[2] = note4;
						arr[3] = note1;
					}
					break;
				case 2:
					int startingIndex2 = 0;
					int[] indexes2 = new int[4];
					for (int index = 0; index < notes.length; index++) {
						if (notes[index].equals(arr[0])) {
							startingIndex2 = index;
							break;
						}
					}
					
					indexes2[0] = startingIndex2;
					indexes2[1] = FindIndexes(arr[1], startingIndex2, startingIndex2);
					indexes2[2] = FindIndexes(arr[2], indexes2[1], indexes2[1]% 12);
					indexes2[3] = FindIndexes(arr[3], indexes2[2], indexes2[2]% 12);
					
					if (indexes2[0] + 4 == indexes2[1] && indexes2[1] + 3 == indexes2[2] && indexes2[2] + 3 == indexes2[3]) {
						return "second";
					} else {
						String note1 = arr[0];
						String note2 = arr[1];
						String note3 = arr[2];
						String note4 = arr[3];
						
						arr[0] = note2;
						arr[1] = note3;
						arr[2] = note4;
						arr[3] = note1;
					}
					break;
				case 3:
					int startingIndex3 = 0;
					int[] indexes3 = new int[4];
					for (int index = 0; index < notes.length; index++) {
						if (notes[index].equals(arr[0])) {
							startingIndex3 = index;
							break;
						}
					}
					
					indexes3[0] = startingIndex3;
					indexes3[1] = FindIndexes(arr[1], startingIndex3, startingIndex3);
					indexes3[2] = FindIndexes(arr[2], indexes3[1], indexes3[1]% 12);
					indexes3[3] = FindIndexes(arr[3], indexes3[2], indexes3[2]% 12);
					
					if (indexes3[0] + 4 == indexes3[1] && indexes3[1] + 3 == indexes3[2] && indexes3[2] + 3 == indexes3[3]) {
						return "first";
					} else {
						String note1 = arr[0];
						String note2 = arr[1];
						String note3 = arr[2];
						String note4 = arr[3];
						
						arr[0] = note2;
						arr[1] = note3;
						arr[2] = note4;
						arr[3] = note1;
					}
					break;
			}
			
		}
		return "invalid";
	}
	
	private static int FindIndexes(String note, int startingIndex, int startIndex) {
		int returnIndex = startingIndex;
		for (int i = startIndex; i < notes.length; i++) {
			if (notes[i].equals(note)) {
				return returnIndex;
			}
			else if(i == notes.length - 1) {
				i = -1;
			}

			returnIndex++;

		}
		return 0;
	}
}
