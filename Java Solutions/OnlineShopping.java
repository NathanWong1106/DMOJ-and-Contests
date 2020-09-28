import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

//2020 ECOO
//There is probably a much more efficient way to solve this, but objects are what popped into my mind first ¯\_(ツ)_/¯

public class OnlineShopping {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		int testCases = input.nextInt();
		
		int[] answers = new int[testCases];
		
		for (int test = 0; test < testCases; test++) {
			HashMap<String, ArrayList<Store>> hm = new HashMap<String,ArrayList<Store>>();
			HashMap<String, Integer> buy = new HashMap<String, Integer>();
			
			int minPrice = 0;
			int numStores = input.nextInt();
			for(int store = 0; store < numStores; store++) {
				int numItems = input.nextInt();
				
				for (int i = 0; i < numItems; i++) {
					String item = input.next();
					int price = input.nextInt();
					int quantity = input.nextInt();
					
					Store storeObj = new Store(price, quantity);
					
					if(hm.containsKey(item)) {
						hm.get(item).add(storeObj);
					} else {
						hm.put(item, new ArrayList<Store>());
						hm.get(item).add(storeObj);
					}
				}
			
			}
			
			for (Map.Entry<String, ArrayList<Store>> entry : hm.entrySet()) {
				//sort for lowest price
				entry.getValue().sort(Comparator.comparing(Store :: getPrice));
			}
			
			int itemsToBuy = input.nextInt();
			
			for (int item = 0; item < itemsToBuy; item++) {
				String itemName = input.next();
				int number = input.nextInt();
				
				buy.put(itemName, number);
			}
			
			for(Map.Entry<String, Integer> buyEntry : buy.entrySet()) {
				for (Store obj : hm.get(buyEntry.getKey())) {
					if (buyEntry.getValue() > obj.getQuantity()) {
						buyEntry.setValue(buyEntry.getValue() - obj.getQuantity());
						minPrice += obj.getQuantity() * obj.getPrice();
					}
					else {
						minPrice += buyEntry.getValue() * obj.getPrice();
						break;
					}
				}
			}
			
			answers[test] = minPrice;
			
		}
		
		for (int answer : answers) {
			System.out.println(answer);
		}
		
		
	}
	
	
	static class Store {
		int quantity;
		int price;
		
		Store(int price,int quantity){
			this.quantity = quantity;
			this.price = price;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		
		
	}
	
}

