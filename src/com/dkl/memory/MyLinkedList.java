package com.dkl.memory;

public class MyLinkedList<T> {

	private static class Node<T>{
		public Node(T x, Node<T> p, Node<T> n){
			data = x;
			prev = p;
			next = n;
		}
		
		public T data;
		public Node<T> prev;
		public Node<T> next;
	}
	public MyLinkedList(){
		clear();
	}
	public void clear(){
		beginMarker = new Node(null, null, null);
		endMarker = new Node(null, beginMarker, null);
		beginMarker.next = endMarker;
		
		theSize = 0;
		modCount++;
	}
	public int size(){
		return theSize;
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	private int theSize;
	private int modCount;
	Node beginMarker;
	Node endMarker;
	
}
