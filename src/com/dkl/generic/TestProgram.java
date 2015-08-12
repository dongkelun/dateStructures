package com.dkl.generic;

import java.util.Comparator;

/**
 * 函数对象测试
 * 函数对象：一个没有数据只有一个方法的类
 * findMax函数有两个参数 其中一个是函数，通过将其放在一个对象内部而被传递
 * @author dkl
 *
 */
class CaseInsensitiveCompare implements Comparator<String>{
	public int compare(String lhs, String rhs){
		return lhs.compareToIgnoreCase(rhs);
	}
}
public class TestProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"ZEBRA","alligator","crocodile"};
		System.out.println(findMax(arr,new CaseInsensitiveCompare()));
		System.out.println(fib(70));
	}
	public static <T> 
	T findMax(T[] arr,Comparator<? super T> cmp){
		int maxIndex = 0;
		for(int i = 1; i < arr.length; i++){
			if (cmp.compare(arr[i], arr[maxIndex]) >0){
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}
	public static int fib(int n){
		int[] a = new int[n + 1];
		a[0] = 1;
		a[1] = 1;
		if(n > 1){
			for(int i = 2; i <= n; i++){
				a[i] = a[i-1] + a[i-2];
			}
		}
		return a[n];
	}
}
