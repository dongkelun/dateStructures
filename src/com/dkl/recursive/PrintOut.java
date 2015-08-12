package com.dkl.recursive;

public class PrintOut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printOut(10000);
	}
	public static void printOut(int n){
		if(n >= 10){
			printOut(n/10);
		}
		System.out.print(n % 10);
	}
}
