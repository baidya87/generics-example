package com.baidya.sorter;

public class TwoElementSorter<T extends Comparable<T>> {

	private T firstElement;
	private T secondElement;
	
	public TwoElementSorter(T element1, T element2){
		if(element1.compareTo(element2)>0) {
			firstElement=element1;
			secondElement=element2;
		}else {
			firstElement=element2;
			secondElement=element1;
		}
	}

	public T getFirstElement() {
		return firstElement;
	}

	public void setFirstElement(T firstElement) {
		this.firstElement = firstElement;
	}

	public T getSecondElement() {
		return secondElement;
	}

	public void setSecondElement(T secondElement) {
		this.secondElement = secondElement;
	}
	
	public void showElement() {
		System.out.println("Descending order-> "+firstElement+" "+secondElement);
	}

}
