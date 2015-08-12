package com.dkl.chapter3;

public class MyLinkedList<T> implements Iterable<T>{
	private static class Node<T>{
		public Node(T d, Node<T> p, Node<T> n){
			data = d;
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
	public void clear() {
		beginMarker = new Node<T>(null, null, null);
		endMarker = new Node<T>(null, beginMarker, null);
		beginMarker.next = endMarker;
	}
	public int size(){
		return theSize;
	}
	public boolean isEmpty(){
		return size() == 0;
	}
	public boolean add( T x){
		add(size(), x);
		return true;
	}
	public void add(int idx, T x) {
		addBefore(getNode(idx), x);
	}
	public T get(int idx){
		return getNode(idx).data;
	}
	public T set(int idx, T x){
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		T oldVal = getNode(idx).data;
		getNode(idx).data = x;
		return oldVal;
	}
	public T remove(int idx){
		return remove(getNode(idx));
	}
	public T remove(Node<T> p) {
		p.prev.next = p.next;
		p.next.prev = p.prev;
		theSize--;
		modCount++;
		
		return p.data;
	}
	public void addBefore(Node<T> p, T x) {
		Node<T> newNode = new Node(x, p.prev, p);
		p.prev.next = newNode;
		p.prev = newNode;
		
		theSize++;
		modCount++;
	}
	/**
	 * Gets the Node at position idx,which must rang from 0 to size().
	 * @param idx index of node being obtained.
	 * @return internal node corresponding to idx.
	 * throws IndexOfOfBoundsException if idx is not between 0 and size().
	 */
	public Node<T> getNode(int idx) {
		Node<T> p;
		
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		int mid = size() / 2;
		if(idx < mid){
			p = beginMarker;
			for(int i = 0; i <= idx; i++)
				p = p.next;
		}else{
			p = endMarker;
			for(int i = size() - 1; i >= idx; i--)
				p = p.prev;
		}
		return p;
	}
	
	public java.util.Iterator<T> iterator(){
		return new MyLinkedListIterator();
	}
	private class MyLinkedListIterator implements java.util.Iterator<T>{
		private Node<T> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		public boolean hasNext(){
			return current.next != endMarker;
		}
		public T next(){
			if(expectedModCount != modCount)
				throw new java.util.ConcurrentModificationException();
			if( !hasNext())
				throw new java.util.NoSuchElementException();
			
			T nextItem = current.data;
			current = current.next;
			okToRemove = true;
			
			return nextItem;
		}
		public void remove(){
			if(expectedModCount != modCount)
				throw new java.util.ConcurrentModificationException();
			if( !okToRemove )
				throw new IllegalStateException();
		}
	}
	private int theSize;
	private int modCount;
	private Node<T> beginMarker;
	private Node<T> endMarker;
	
	
	
}
