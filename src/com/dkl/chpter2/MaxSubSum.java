package com.dkl.chpter2;

public class MaxSubSum {

	public static int max3(int a, int b ,int c){
		int max = a;
		if(b > max)
			max = b;
		if(c > max)
			max = c;
		return max;
	}
	public static int maxSumRec(int[] a, int left, int right){
		if(left == right)
			if(a[left] >= 0)
				return a[left];
			else return 0;
		int center = (left + right) / 2;
		int maxLeftSum = maxSumRec(a, left, center);
		int maxRightSum = maxSumRec(a, center + 1, right);
		
		int maxLeftBorderSum = 0;
		int leftBorderSum = 0;
		for(int i = center; i >= left; i--){
			leftBorderSum += a[i];
			if(leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}
		int maxRightBorderSum = 0;
		int rightBorderSum = 0;
		for(int i = center + 1; i <= right; i++){
			rightBorderSum += a[i];
			if(rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}
		return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
	}
	public static int maxSubSum3(int a[]){
		return maxSumRec(a, 0, a.length -1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4, -3, 5, -2, -1 ,2 , 6, -2};
		System.out.println(maxSubSum3(a));
	}

}
