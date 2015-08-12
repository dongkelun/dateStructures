package bishi;

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

	/**
	 * 第四题： 考点 链表 题目： 从尾到头打印链表 输入一个链表，从尾到头打印链表每个节点的值。
	 * 擦。。。注意是  从尾到头 
	 */

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
			while (listNode != null) {
				arrayList.add(listNode.val);
				listNode = listNode.next;
			}
		for(int i = arrayList.size() -1;i>=0;i--)
			res.add(arrayList.get(i));
		return res;
	}

	public static void main(String args[]) {
		ListNode listNode = new ListNode(67);
		listNode.next = new ListNode(0);
		listNode.next.next = new ListNode(24);;
		listNode.next.next.next = new ListNode(58);;
		
		ArrayList<Integer> arrayList = printListFromTailToHead(listNode);
		Collections.reverse(arrayList);
		Iterator it = arrayList.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
//		StringBuffer str = new StringBuffer("We Are Happy");
//		System.out.println(listNode.next.next == null);
//		System.out.println(replaceSpace(str));

	}
}
