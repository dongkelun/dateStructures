package com.dkl.leetcode;

public class JianDanJuan {

	public static int singleNumber(int[] A) {
		int n = 0;
		for (int i = 0; i < A.length; i++) {
			n = n ^ A[i];
		}

		return n;
	}

	/*
	 * Given a binary tree, find its maximum depth. The maximum depth is the
	 * number of nodes along the longest path from the root node down to the
	 * farthest leaf node.
	 */
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int maxLeftDepth = maxDepth(root.left);
		int maxRightDepth = maxDepth(root.right);

		return Math.max(maxLeftDepth, maxRightDepth) + 1;
	}

	/**
	 * Given two binary trees, write a function to check if they are equal or
	 * not. Two binary trees are considered equal if they are structurally
	 * identical and the nodes have the same value.
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        	return true;
        else if(p == null && q != null)
        	return false;
        else if(p != null && q == null)
        	return false;
        else if(p.val == q.val){
        	return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        else 
        	return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 1, 2, 3, 4, 2, 3, 4, 11 };
		Math.max(1, 2);
		System.out.println(singleNumber(a));

	}

}
