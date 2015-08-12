package com.dkl.generic;

public class FindMaxDemo {
	/**
	 * 在一个数组中找出最大元的范型static方法
	 * Return max item in arr;
	 * Precondition: arr.length > 0
	 */
	public  static <T extends Comparable<? super T>> T findMax(T[] arr){
		int maxIndex = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i].compareTo(arr[maxIndex]) > 0){
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
