package com.dkl.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/*
 * 
 * 剑指offer：在线编程题目集锦
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 
 * 思路
 * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
 * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
 * 要查找数字比左下角数字小时，上移
 */
public class BiShi {

	/*
	 * 第四题： 考点 数组 题目： 二维数组中的查找
	 * 
	 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
	 * 
	 * 思路 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增， 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
	 * 要查找数字比左下角数字小时，上移
	 */
	public static boolean find(int[][] array, int target) {
		int m = array.length - 1; // 行
		int i = 0; // 列
		while (m >= 0 && i < array[0].length) {
			if (array[m][i] > target)
				m--;
			else if (array[m][i] < target)
				i++;
			else
				return true;
		}
		return false;
	}

	/*
	 * 第四题： 考点 字符串 题目： 替换空格
	 * 
	 * 请实现一个函数，将一个字符串中的空格替换成“%20”。 例如，当字符串为We Are Happy.
	 * 则经过替换之后的字符串为We%20Are%20Happy。
	 */

	public static String replaceSpace(StringBuffer str) {
		String replace = "%20";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				str.deleteCharAt(i);
				str.insert(i, replace);
			}
		}
		return str.toString();

	}

	/*
	 * 第五题： 考点 链表 题目： 从尾到头打印链表 输入一个链表，从尾到头打印链表每个节点的值。 擦。。。注意是 从尾到头
	 */

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		while (listNode != null) {
			arrayList.add(listNode.val);
			listNode = listNode.next;
		}
		for (int i = arrayList.size() - 1; i >= 0; i--)
			res.add(arrayList.get(i));
		return res;
	}

	/*
	 * 第六题： 考点 二叉树 题目 重建二叉树
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
	 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 */
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		if (pre.length != in.length) {
			System.out.println("输入有错");
			return null;
		}
		if (pre.length == 0)
			return null;

		return reConstructBinaryTree(pre, in, 0, pre.length - 1);
	}
	//重建二叉树的中间函数
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in, int left,
			int right) {
		TreeNode treeNode = null;
		int len = right - left + 1;
		if (len <= 0)
			return null;
		if (len == 1)
			return new TreeNode(pre[left]);
		int l = left + 1;											//左子树的起始点，把根节点换到第一位了，所以+1
		int r = right;												//右子树结束
		int rl, lr;													//分别是左子树结束，右子树的开始
		treeNode = new TreeNode(pre[left]);
		int root = findRoot(pre, in, left, right);
		if (root != -1) {
			insert(in, left, root);
			rl = root + 1;
			lr = root;												//移位过后所以不需要 - 1 了

			treeNode.left = reConstructBinaryTree(pre, in, l, lr);
			treeNode.right = reConstructBinaryTree(pre, in, rl, r);
		}
		return treeNode;
	}
	//找中序遍历数组中根节点的下标
	public static int findRoot(int[] pre, int[] in, int left, int right) {
		for (int i = left; i <= right; i++)
			if (pre[left] == in[i]) 
				return i;
		return -1;
	}
	//把中序遍历数组的根节点移位到最左边，其他顺序不变
	private static void insert(int[] a, int left, int right) {
		int temp;
		temp = a[right];
		for (int i = right; i > left; i--) {
			a[i] = a[i-1];
		}
		a[left] = temp;
	}

	public static void main(String args[]) {

		int pre[] = { 1, 2, 3, 4, 5, 6, 7 };
		int in[] = { 3, 2, 4, 1, 6, 5, 7 };
		TreeNode treeNode = reConstructBinaryTree(pre, in);
		System.out.println(treeNode.val);
		System.out.println(treeNode.left.val);
		System.out.println(treeNode.right.val);
		System.out.println(treeNode.right.right.val);
		System.out.println(treeNode.left.right.val);
		System.out.println(treeNode.left.left.val);
		System.out.println(treeNode.right.right.val);
		System.out.println(treeNode.right.left.val);

		// ListNode listNode = new ListNode(67);
		// listNode.next = new ListNode(0);
		// listNode.next.next = new ListNode(24);
		// listNode.next.next.next = new ListNode(58);
		//
		// ArrayList<Integer> arrayList = printListFromTailToHead(listNode);
		// Collections.reverse(arrayList);
		// Iterator it = arrayList.iterator();
		// while (it.hasNext()) {
		// System.out.println(it.next());
		// }

	}
}
