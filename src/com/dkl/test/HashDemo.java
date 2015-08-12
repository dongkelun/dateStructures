package com.dkl.test;

public class HashDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "helloworld";
		
		System.out.println((1 + s.charAt(2)));
	}
	public static int hash(String key, int tableSize){
		int hashVal = 0;
		for(int i = 0; i < key.length(); i ++){
			hashVal += key.charAt(i);
		}
		
		return hashVal;
	}
}
