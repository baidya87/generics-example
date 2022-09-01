package com.baidya.sorter;

import java.util.Arrays;
import java.util.List;

class Order<T>{
	T[] elements = null;
	public Order(T[] elements) {
		this.elements = elements;
	}
}

// utility class
class Utility{
	
	public static <T> void sort(Order<T> orders) {
		Arrays.sort(orders.elements);
		for(int i=0; i<orders.elements.length; i++) {
			System.out.printf("%s ", orders.elements[i] );
		}
	}
	
}

public class OrderRunner {
	
	// list of numbers
	static List<Integer> numbers = Arrays.asList(65, 76, 23, 12, 8, 21, 3, 5, 8, 0, 10, 11, 17, 18, 19);
	List<String> words = Arrays.asList("lack", "mock", "idiom", "apple", "ack", "goods","salt", "h1b", "c2o", "carriage", "lion", "kia", "zebra", "fly", "bird");
	
	static Order<Integer> wholeNumbers= new Order<>(new Integer[] {65, 76, 23, 12, 8, 21, 3, 5, 8, 0, 10, 11, 17, 18, 19});
	static Order<String> letters= new Order<>(new String[] {"lack", "mock", "idiom", "apple", "ack", "goods","salt", "h1b", "c2o", "carriage", "lion", "kia", "zebra", "fly", "bird"});
	
	public static void main(String[] args) {
		Utility.sort(wholeNumbers);
	}
}
