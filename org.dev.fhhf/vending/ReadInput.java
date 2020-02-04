package vending;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ReadInput {
	
	private VendingMachine vendingMachine = new VendingMachine();
	private Scanner scanner = new Scanner(System.in);
	
	public VendingMachine readInput() {
		
		String[] inputRead;
		String[] inBucket = null;
		
		System.out.println("Please enter bucket:");
		inputRead = scanner.nextLine().split(";");
		
		for(String i : inputRead) {
			
			inBucket = new String[i.split(",").length];
			inBucket = i.split(",");
			Queue<Integer> queue = new LinkedList<>();
			vendingMachine.setProducts(queue);
			
			for(int j = 0; j < inBucket.length; j++) {
				vendingMachine.getProducts().add( Integer.parseInt(inBucket[j]) );
			}
			
			vendingMachine.getBuckets().add(vendingMachine.getProducts());
		}

		return vendingMachine;
	}
	
	public VendingMachine readOrder() {
		
		Map<Integer, Integer> order = new HashMap<>();
		vendingMachine.setOrder(order);
		
		String[] inputRead;
		int size = 0;
		
		System.out.println("Please enter order or (q) to exit:");
		inputRead = scanner.nextLine().split(",");
		
		if(inputRead[0].equalsIgnoreCase("q")) {
			vendingMachine.setOrder(null);
			return vendingMachine;
		}
		
		for(String i : inputRead) {
			
			if(vendingMachine.getOrder().containsKey( Integer.parseInt(i) )) {
				size = vendingMachine.getOrder().get( Integer.parseInt(i) );
				size ++;
				vendingMachine.getOrder().replace(Integer.parseInt(i), size);
			}else {			
				vendingMachine.getOrder().put(Integer.parseInt(i), 1);
			}
		}

		return vendingMachine;
	}
}
