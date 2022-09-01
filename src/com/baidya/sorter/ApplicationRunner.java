package com.baidya.sorter;

public class ApplicationRunner {

	public static void main(String[] args) {
		TwoElementSorter<Integer>elements=new TwoElementSorter<>(3, 4);
		elements.showElement();
	}
}
