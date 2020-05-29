import java.util.*;

//CCC '13 S2

public class BridgeTransport {
	
	private static int[] carWeights;
	private static int numCars;
	private static int bridgeCapacity;
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		bridgeCapacity = input.nextInt();
		numCars = input.nextInt();
		carWeights = new int[numCars];
		
		for (int i = 0; i < numCars; i++) {
			carWeights[i] = input.nextInt();
		}
		
		System.out.println(transport());
		
	}

	private static int transport() {
		int carNum = 0;
		int carOff = 0;
		int weightOnBridge = 0;
		
		while (carNum < numCars) {
			
			if (carNum <= 3) {
				weightOnBridge += carWeights[carNum];
			}
			
			else if (carNum > 3) {
				weightOnBridge -= carWeights[carOff];
				carOff++;
				weightOnBridge += carWeights[carNum];	
			}
			
			if (weightOnBridge <= bridgeCapacity) {
				carNum++;
			}
			else if (weightOnBridge > bridgeCapacity) {
				return carNum;
			}
		}
		return carNum;
	}
}
