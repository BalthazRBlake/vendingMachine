package vending;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VendingMachine {
	
	private List<Queue<Integer>> buckets = null;
	private Queue<Integer> products = null;
	private Map<Integer, Integer> order = null;
	private Map<Integer, Integer> toBeVended = null;
	
	VendingMachine(){
		this.buckets = new ArrayList<>();
		this.products = new LinkedList<>();
		this.order = new HashMap<>();
		this.toBeVended = new HashMap<>();
	}
	
	public List<Queue<Integer>> getBuckets() {
		return buckets;
	}
	public void setBuckets(List<Queue<Integer>> buckets) {
		this.buckets = buckets;
	}
	public Queue<Integer> getProducts() {
		return products;
	}
	public void setProducts(Queue<Integer> products) {
		this.products = products;
	}
	public Map<Integer, Integer> getOrder() {
		return order;
	}
	public void setOrder(Map<Integer, Integer> order) {
		this.order = order;
	}
	public Map<Integer, Integer> getToBeVended() {
		return toBeVended;
	}
	public void setToBeVended(Map<Integer, Integer> toBeVended) {
		this.toBeVended = toBeVended;
	}
	
	public void excecuteOrder() {
		for(int i = 0; i < buckets.size(); i++) {
			
			if(!buckets.get(i).isEmpty()) {
				int key = buckets.get(i).peek();
				int size;
				
				if(toBeVended.containsKey(key)) {
					
					size = order.get(key);
					size --;
					order.replace(key, size);
					
					if(size == 0) {
						toBeVended.remove(key);
					}
					
					buckets.get(i).poll();
				}
			}
		}
	}
	
	public void createOrder() {
		toBeVended = new HashMap<>();
		for(int i = 0; i < buckets.size(); i++) {
			
			if(!buckets.get(i).isEmpty()) {
				
				int key = buckets.get(i).peek();
				int size = 0;
				
				if(order.containsKey(key)) {
					if( toBeVended.containsKey(key)) {
						size = toBeVended.get(key);
						size ++;
						toBeVended.replace(key, size);
					}else {			
						toBeVended.put(key, 1);
					}
				}
			}
		}
	}
	
	public boolean canBeVended() {
		
		Collection<Integer> orderVals = order.keySet();

		for(int i : orderVals) {

			if(!toBeVended.containsKey(i)) {
				return false;
			}

			if( order.get(i) > toBeVended.get(i) ){
				return false;
			}
		}
		return true;
	}
}
