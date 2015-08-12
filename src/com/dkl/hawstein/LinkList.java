package com.dkl.hawstein;

class Node{
	int data;
	Node next;
}

public class LinkList {
	private static Node addSinglyLinkedList(Node list1, Node list2){
		Node q1 = list1;
		Node q2 = list2;
		Node ans = null;
		Node p  =null;
		Node pre = null;
		Node q = null;
		boolean highest = false;
		int first = q1.data + q2.data;
		if(first >= 9){
			highest = true;
			ans = new Node();
			pre = new Node();
			pre.data = first % 10;
			ans.next = pre;
			if(first > 9){
				ans.data = 1;
				p = pre;
			}else{
				ans.data = 0;
				p = ans;
			}
		}else{
			ans = new Node();
			ans.data = first % 10;
			p = pre = ans;
		}
		while((q1 = q1.next) != null && (q2 = q2.next) != null){
			q = new Node();
			pre.next = q;
			int num = q1.data + q2.data;
			q.data = num %10;
			if (num >= 9){
				p.data = p.data + 1;
				for(p = p.next; p != q; p = p.next){
					p.data = 0;
				}
			}else{
				p = q;
			}
			pre = q;
		}
		if(highest && ans.data == 0){
			ans = ans.next;
		}
//		if(ans.data > 9){
//			q = new Node();
//			q.data = 1;
//			ans.data = ans.data - 10;
//			q.next = ans;
//			ans = q;
//		}
		return ans;
	}
	private static Node makeLinkedList(int[] data, int n){
		Node head = new Node();
		head.data = data[0];
		Node pre = head;
		Node cur = null;
		 for(int i=1; i<n; ++i){
			 cur = new Node();
			 cur.data = data[i];
			 pre.next = cur;
			 pre = cur;
		    }
		return head;
	}
	public static void main(String[] args){
		int n = 7;
	    int a[] = {
	        2,0,0,0,7,0,1
	    };
	    int b[] = {
	        7,9,9,9,9,9,9
	    };
	    Node list1 = makeLinkedList(a, n);
	    Node list2 = makeLinkedList(b, n);
//	    while(list1 != null){
//	    	System.out.println(list1.data);
//	    	list1 = list1.next;
//	    }
	    Node ans = addSinglyLinkedList(list1, list2);
	    while(ans != null){
    	System.out.print(ans.data);
    	ans = ans.next;
	    }
	    System.out.println();
	    System.out.println(2^2);
	    System.out.println(f(3/2));
	    
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	public static int f(int n){
		if(n < 0){
			return -1000;
		}else if(n == 0){
			return 0;
		}else{
			return 2*f(n - 1) + n*n;
		}
	}
}
